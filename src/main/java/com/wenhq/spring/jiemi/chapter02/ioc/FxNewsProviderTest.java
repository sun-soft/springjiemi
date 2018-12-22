package com.wenhq.spring.jiemi.chapter02.ioc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FxNewsProviderTest {

	private FxNewsProvider fxNewsProvider;
	
	@Before
	public void setUp() {
		fxNewsProvider = new FxNewsProvider(new MockFxNewsPersister(), new MockFxNewsListener());
	}
	
	@After
	public void tearDown() {
		fxNewsProvider = null;
	}
	
	@Test
	public void testGetAndPersistNews() {
		fxNewsProvider.getAndPersistNews();
		
	}
}
