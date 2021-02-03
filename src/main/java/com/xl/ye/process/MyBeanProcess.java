package com.xl.ye.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


public class MyBeanProcess implements BeanFactoryPostProcessor {
    @Override
    /**
    * @Description:
    * @Param: [beanFactory]
    * @return: void
    * @Author: yexl
    * @Date: 2020/3/17
    */
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String [] beans = beanFactory.getBeanDefinitionNames();
        for(String bean:beans) {
            System.out.println("=======" + bean);
        }

    }
}
