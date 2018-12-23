package com.wenhq.spring.jiemi.chapter04.beanfactory;

import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

import com.wenhq.spring.jiemi.chapter02.ioc.FxNewsProvider;
import com.wenhq.spring.jiemi.chapter02.ioc.MockFxNewsListener;
import com.wenhq.spring.jiemi.chapter02.ioc.MockFxNewsPersister;

public class FxNewsProviderTestCode {

	@Test
	public void testGetAndPersistNews() {
		DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
		BeanFactory container = (BeanFactory) this.bingViaCode(beanRegistry);
		FxNewsProvider provider = container.getBean(FxNewsProvider.class);
		provider.getAndPersistNews();

	}

	private BeanFactory bingViaCode(BeanDefinitionRegistry registry) {
		// 定义bean
		AbstractBeanDefinition newsProvider = new RootBeanDefinition(FxNewsProvider.class);
		BeanDefinition fxNewsListener = new RootBeanDefinition(MockFxNewsListener.class);
		BeanDefinition fxNewsPersister = new RootBeanDefinition(MockFxNewsPersister.class);
		// 将Bean注册到容器
		registry.registerBeanDefinition("newsProvider", newsProvider);
		registry.registerBeanDefinition("fxNewsListener", fxNewsListener);
		registry.registerBeanDefinition("fxNewsPersister", fxNewsPersister);
		// 通过构造注入
		/*
		 * ConstructorArgumentValues argValues = new ConstructorArgumentValues();
		 * argValues.addIndexedArgumentValue(0, fxNewsPersister);
		 * argValues.addIndexedArgumentValue(1, fxNewsListener);
		 * newsProvider.setConstructorArgumentValues(argValues);
		 */ // 通过set方式注入
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("fxNewsListener", fxNewsListener));
		propertyValues.addPropertyValue(new PropertyValue("fxNewsPersister", fxNewsPersister));
		newsProvider.setPropertyValues(propertyValues);

		return (BeanFactory) registry;
	}
}
