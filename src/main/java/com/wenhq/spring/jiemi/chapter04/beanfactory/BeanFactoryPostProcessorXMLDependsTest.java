package com.wenhq.spring.jiemi.chapter04.beanfactory;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.wenhq.spring.jiemi.chapter02.ioc.FxNewsProvider;

public class BeanFactoryPostProcessorXMLDependsTest {
	private String xmlFile = "com/wenhq/spring/jiemi/chapter04/beanfactory/dependsBeans.xml";

	@Test
	public void testGetAndPersistNews() {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		this.bingViaXML(beanFactory);
		PropertyPlaceholderConfigurer property = new PropertyPlaceholderConfigurer();
		property.setLocation(new ClassPathResource("com/wenhq/spring/jiemi/chapter04/beanfactory/placeholder.properties"));
		property.postProcessBeanFactory(beanFactory);
		property.setOrder(5);
		PropertyOverrideConfigurer property2 = new PropertyOverrideConfigurer();
		property2.setLocation(new ClassPathResource("com/wenhq/spring/jiemi/chapter04/beanfactory/placeholder2.properties"));
		property2.postProcessBeanFactory(beanFactory);
		property2.setOrder(2);
		FxNewsProvider provider = beanFactory.getBean(FxNewsProvider.class);
		provider.getAndPersistNews();
		System.out.println("myNmae = " + provider.getMyName());
	}

	private BeanFactory bingViaXML(BeanDefinitionRegistry registry) {
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
		reader.loadBeanDefinitions(xmlFile);
		return (BeanFactory) registry;
	}
}
