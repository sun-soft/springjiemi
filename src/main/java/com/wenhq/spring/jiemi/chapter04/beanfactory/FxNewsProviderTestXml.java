package com.wenhq.spring.jiemi.chapter04.beanfactory;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.wenhq.spring.jiemi.chapter02.ioc.FxNewsProvider;
import com.wenhq.spring.jiemi.chapter02.ioc.IFxNewsPersister;

public class FxNewsProviderTestXml {
	private String xmlFile = "classpath:com/wenhq/spring/jiemi/chapter04/beanfactory/beans.xml";

	@Test
	public void testGetAndPersistNews() {
		DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
		BeanFactory container = (BeanFactory) this.bingViaXML(beanRegistry);
		IFxNewsPersister fxNewsPersister = container.getBean(IFxNewsPersister.class);
		fxNewsPersister.save();
		System.out.println("fxNewsPersister is " + fxNewsPersister.getClass());
		
		FxNewsProvider provider = container.getBean(FxNewsProvider.class);
		provider.getAndPersistNews();		//没能自动注入会报空指针

	}

	private BeanFactory bingViaXML(BeanDefinitionRegistry registry) {
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
		reader.loadBeanDefinitions(xmlFile);
		return (BeanFactory) registry;
	}
}
