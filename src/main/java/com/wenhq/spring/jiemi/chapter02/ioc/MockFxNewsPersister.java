package com.wenhq.spring.jiemi.chapter02.ioc;

public class MockFxNewsPersister implements IFxNewsPersister{

	@Override
	public void save() {
		System.out.println("MockFxNewsPersister save");
		
	}

}
