/*
 * @author Mg Than Htike Aung {@literal <rage.cataclysm@gmail.com@address>}
 * @Since 1.0
 * 
 */
package com.mycom.products.mywebsite.core.serviceTest;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.mycom.products.mywebsite.core.bean.BaseBean;

@Transactional
@ContextConfiguration(locations = { "classpath:spring-test-context.xml" })
public class BaseServiceTest extends AbstractTransactionalTestNGSpringContextTests {
	protected Logger logger = Logger.getLogger("stdout");
	protected static final int TEST_CREATE_USER_ID = 10009;
	protected static final int TEST_UPDATE_USER_ID = 90001;

	@BeforeMethod
	public void beforeMethod(Method method) {
		logger.info("***** SERVICE-TEST : Testing method '" + method.getName() + "' has started. *****");
	}

	@AfterMethod
	public void afterMethod(Method method) {
		logger.info("----- SERVICE-TEST : Testing method '" + method.getName() + "' has finished. -----");
	}

	protected <T extends BaseBean> void showEntriesOfCollection(Collection<T> collection) {
		if (collection != null) {
			Iterator<?> iterator = collection.iterator();
			while (iterator.hasNext()) {
				Object obj = iterator.next();
				logger.info(" >>> " + obj.toString());
			}
		}
	}
}