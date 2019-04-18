package com.dhu.springtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext(
                new String[] { "file:C:\\Users\\HP\\IdeaProjects\\SpringMVC\\src\\main\\webapp\\WEB-INF\\applicationContext.xml" });

        ProductService s = (ProductService) context.getBean("s");
        s.doSomeService();

    }
}