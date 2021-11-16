package com.yunus.service;

import com.yunus.dao.EmployeeMapper;
import com.yunus.pojo.domain.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: gaoyunfeng
 * @date: 2019/3/18
 */
@Service
@Slf4j
public class SyncTransaction {


    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 直接使用 synchronized 和 transactional 使用时线程非安全的
     * <p>
     * transactional 是 aop 实现的   1. 开启事务   2. method.invoke(target,args); 3. 提交或者回滚事务
     * 在代理了执行完1 2 步骤后 当前线程还没有提交   其他线程 读取 时  就不会读到为提交的数据 因为 mysql 默认隔离级别为 可重复读
     * 解决办法  --- 在其他方法包装  后 使用
     *
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    public synchronized void increaseMoney(Long id) {
        Employee employee = employeeMapper.selectById(id);
        log.debug(employee.getMoney() + "========================");
        final Integer oldMoney = employee.getMoney();
        log.debug("oldMoney={}", oldMoney);
        employee.setMoney(oldMoney + 1);
        employeeMapper.updateById(employee);
    }
}
