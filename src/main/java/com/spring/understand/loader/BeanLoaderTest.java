package com.spring.understand.loader;

import com.spring.understand.pojo.Car;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by liudeyu on 2019/10/18.
 */
public class BeanLoaderTest {


    public static void main(String[] argv) throws IOException {
        ResourcePatternResolver resourcePatternResolver = new ClassPathXmlApplicationContext();
        Resource[] resources = resourcePatternResolver.getResources("classpath:**.xml");
        Arrays.stream(resources).forEach(resource -> {
            DefaultListableBeanFactory defaultListableBeanFactory=new DefaultListableBeanFactory();
            XmlBeanDefinitionReader xmlBeanDefinitionReader=new XmlBeanDefinitionReader(defaultListableBeanFactory);
            xmlBeanDefinitionReader.loadBeanDefinitions(resource);
            Car car1=defaultListableBeanFactory.getBean("car1",Car.class);
            System.out.println(car1);
            
        });

    }

}
