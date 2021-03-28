package com.tx.spring;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 事务的属性：
 *      - propagation: 事务的传播行为
 *          事务的传播行为：一个方法被另一个开启了事务的方法调用时，当前方法是使用原来的事务还是开启一个新的事务
 *          - Propagation.Required:默认值，方法B用REQUIRED修饰，方法A调用方法B，如果方法A当前没有事务，
 *              方法B就新建一个事务，如果方法A有事务，方法B就加入到这个事务中。一般的选择（默认值）
 *          - Propagation.Requires_New: 将原来的事务挂起，开启一个新事务
 *              方法B用REQUIRES_NEW修饰，方法A调用方法B，不管方法A上有没有事务方法B都新建一个事务，在该事务执行
 *      - isolation: 事物的隔离级别
 *          - Isolation.RepeatableRead:可重复度，MySQL默认隔离级别
 *          - Isolation.ReadCommitted: 读已提交，Oracle默认隔离级别
 *
 */
public class Propagation {

     @Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRES_NEW,isolation = Isolation.REPEATABLE_READ)
    public void purchase(){}
}
