package com.tx.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScope {

    // 创建IOC容器
    ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

    @Test
    public void test1() {
        Book book1 =(Book) context.getBean("book");
        Book book2 =(Book) context.getBean("book");
        System.out.println(book1 == book2);
    }
}
