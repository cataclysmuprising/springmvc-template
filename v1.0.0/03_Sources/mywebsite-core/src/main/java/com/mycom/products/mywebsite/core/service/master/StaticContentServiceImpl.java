/*
 * @author Mg Than Htike Aung {@literal <rage.cataclysm@gmail.com@address>}
 * @Since 1.0
 * 
 */
package com.mycom.products.mywebsite.core.service.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.products.mywebsite.core.bean.master.StaticContentBean;
import com.mycom.products.mywebsite.core.dao.master.StaticContentDao;
import com.mycom.products.mywebsite.core.service.base.StandAloneServiceImpl;
import com.mycom.products.mywebsite.core.service.master.api.StaticContentService;

@Service
public class StaticContentServiceImpl extends StandAloneServiceImpl<StaticContentBean>
		implements StaticContentService {

	@Autowired
	public StaticContentServiceImpl(StaticContentDao staticContentDao) {
		super(staticContentDao, staticContentDao);
	}

}
