package com.wenhq.spring.jiemi.chapter02.ioc;

public class MockFxNewsListener implements IFxNewsListener {

	@Override
	public String[] getAvailableNewsIds() {
		System.out.println("MockFxNewsListener getAvailableNewsIds");
		return null;
	}

	@Override
	public FxNewsBean getNews(String id) {
		System.out.println("MockFxNewsListener getNews");
		return null;
	}

}
