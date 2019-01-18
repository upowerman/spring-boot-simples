package com.yunus.jta;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;

import javax.sql.XAConnection;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JTADemo {

    public void test3() {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setURL("jdbc:mysql://localhost:3306/test");
        try {
            XAConnection xaConnection = mysqlXADataSource.getXAConnection("root", "");
            Connection connection = xaConnection.getConnection();
            Statement statement = connection.createStatement();
            // xa resource
            XAResource xaResource = xaConnection.getXAResource();
            // 定义xid
            Xid myXid = new MyXid(0, new byte[]{0x01}, new byte[]{0x02});
            // 开启全局事务
            xaResource.start(myXid, XAResource.TMNOFLAGS);
            // 执行sql
            statement.execute("insert into t_teacher values(3,'zhangsan')");
            // 结束全局事务
            xaResource.end(myXid, XAResource.TMSUCCESS);
            //分段提交中的第一段 prepare
            int prepare = xaResource.prepare(myXid);
            if (prepare == xaResource.XA_OK) {
                // 提交
                xaResource.commit(myXid, false);
            } else {
                xaResource.rollback(myXid);
            }
        } catch (SQLException e) {
            // xaResource  定义为全局 发生异常是rollback
            e.printStackTrace();
        } catch (XAException e) {
            e.printStackTrace();
        }
    }

    class MyXid implements Xid {

        int formatId;
        byte globalTransactionId[];
        byte branchQualifier[];

        public MyXid() {

        }

        public MyXid(int formatId, byte[] globalTransactionId, byte[] branchQualifier) {
            this.formatId = formatId;
            this.globalTransactionId = globalTransactionId;
            this.branchQualifier = branchQualifier;
        }

        @Override
        public int getFormatId() {
            return this.formatId;
        }

        @Override
        public byte[] getGlobalTransactionId() {
            return this.globalTransactionId;
        }

        @Override
        public byte[] getBranchQualifier() {
            return this.branchQualifier;
        }
    }
}
