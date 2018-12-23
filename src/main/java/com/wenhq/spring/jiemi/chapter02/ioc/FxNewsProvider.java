package com.wenhq.spring.jiemi.chapter02.ioc;

public class FxNewsProvider {
	private String myName = "myName";

	private IFxNewsPersister fxNewsPersister;
	private IFxNewsListener fxNewsListener;

	public void getAndPersistNews() {
		System.out.println("FxNewsProvider getAndPersistNews");
		fxNewsListener.getAvailableNewsIds();
		fxNewsPersister.save();
	}

	public FxNewsProvider() {
		super();
	}


	public FxNewsProvider(IFxNewsPersister fxNewsPersister, IFxNewsListener fxNewsListener) {
		super();
		this.fxNewsPersister = fxNewsPersister;
		this.fxNewsListener = fxNewsListener;
	}


	public IFxNewsPersister getFxNewsPersister() {
		return fxNewsPersister;
	}

	public void setFxNewsPersister(IFxNewsPersister fxNewsPersister) {
		this.fxNewsPersister = fxNewsPersister;
	}

	public IFxNewsListener getFxNewsListener() {
		return fxNewsListener;
	}

	public void setFxNewsListener(IFxNewsListener fxNewsListener) {
		this.fxNewsListener = fxNewsListener;
	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}
	

}
