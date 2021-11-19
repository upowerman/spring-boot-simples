DROP TABLE IF EXISTS `basic_good_info`;
CREATE TABLE `basic_good_info`
(
    `BGI_ID`    int(11) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
    `BGI_NAME`  varchar(20)   DEFAULT NULL COMMENT '商品名称',
    `BGI_PRICE` decimal(8, 2) DEFAULT NULL COMMENT '单价',
    `BGI_UNIT`  varchar(10)   DEFAULT NULL COMMENT '单位',
    PRIMARY KEY (`BGI_ID`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8 COMMENT ='商品基本信息';