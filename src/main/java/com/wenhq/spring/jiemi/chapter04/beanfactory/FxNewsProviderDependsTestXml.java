package com.wenhq.spring.jiemi.chapter04.beanfactory;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.wenhq.spring.jiemi.chapter02.ioc.FxNewsProvider;

public class FxNewsProviderDependsTestXml {
	private String xmlFile = "classpath:com/wenhq/spring/jiemi/chapter04/beanfactory/dependsBeans.xml";

	@Test
	public void testGetAndPersistNews() {
		DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
		BeanFactory container = (BeanFactory) this.bingViaXML(beanRegistry);
		FxNewsProvider provider = container.getBean(FxNewsProvider.class);
		provider.getAndPersistNews();

	}

	private BeanFactory bingViaXML(BeanDefinitionRegistry registry) {
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
		reader.loadBeanDefinitions(xmlFile);
		return (BeanFactory) registry;
	}
}
