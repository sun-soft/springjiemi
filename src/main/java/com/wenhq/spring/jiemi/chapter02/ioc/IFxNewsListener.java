package com.wenhq.spring.jiemi.chapter02.ioc;

public interface IFxNewsListener {
	
	String[] getAvailableNewsIds();
	FxNewsBean getNews(String id);

}
