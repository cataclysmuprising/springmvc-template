/*
 * @author Mg Than Htike Aung {@literal <rage.cataclysm@gmail.com@address>}
 * @Since 1.0
 * 
 */
package com.mycom.products.springMybatisGenericExample.core.dao.config;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.mycom.products.springMybatisGenericExample.core.bean.BaseBean.TransactionType;
import com.mycom.products.springMybatisGenericExample.core.bean.config.LoginHistoryBean;
import com.mycom.products.springMybatisGenericExample.core.dao.api.InsertableDao;
import com.mycom.products.springMybatisGenericExample.core.dao.api.JoinedSelectableDao;
import com.mycom.products.springMybatisGenericExample.core.exception.DAOException;
import com.mycom.products.springMybatisGenericExample.core.exception.DuplicatedEntryException;
import com.mycom.products.springMybatisGenericExample.core.mapper.config.LoginHistoryMapper;
import com.mycom.products.springMybatisGenericExample.core.util.FetchMode;

@Repository
public class LoginHistoryDao implements InsertableDao<LoginHistoryBean>, JoinedSelectableDao<LoginHistoryBean> {

	@Autowired
	private LoginHistoryMapper loginHistoryMapper;
	private Logger daoLogger = Logger.getLogger("daoLogger");

	@Override
	@CacheEvict(value = "ConfigurationCache.LoginHistory", allEntries = true)
	public long insert(LoginHistoryBean loginHistory, long recordRegId) throws DAOException, DuplicatedEntryException {
		try {
			daoLogger.debug("[START] : >>> --- Inserting single 'LoginHistory' informations ---");
			LocalDateTime now = LocalDateTime.now();
			loginHistory.setRecordRegDate(now);
			loginHistory.setRecordUpdDate(now);
			loginHistory.setRecordRegId(recordRegId);
			loginHistory.setRecordUpdId(recordRegId);
			loginHistory.setTransactionType(TransactionType.INSERT);
			loginHistoryMapper.insert(loginHistory);
		} catch (DuplicateKeyException e) {
			String errorMsg = "xxx Insertion process was failed due to Unique Key constraint xxx";
			throw new DuplicatedEntryException(errorMsg, e);
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while inserting 'LoginHistory' data ==> " + loginHistory + " xxx";
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Inserting single 'LoginHistory' informations with new Id # " + loginHistory.getId() + " ---");
		return loginHistory.getId();
	}

	@Override
	@CacheEvict(value = "ConfigurationCache.LoginHistory", allEntries = true)
	public void insert(List<LoginHistoryBean> loginHistories,
			long recordRegId) throws DAOException, DuplicatedEntryException {
		daoLogger.debug("[START] : >>> --- Inserting multi 'LoginHistory' informations ---");
		LocalDateTime now = LocalDateTime.now();
		for (LoginHistoryBean loginHistory : loginHistories) {
			loginHistory.setRecordRegDate(now);
			loginHistory.setRecordUpdDate(now);
			loginHistory.setRecordRegId(recordRegId);
			loginHistory.setRecordUpdId(recordRegId);
			loginHistory.setTransactionType(TransactionType.INSERT);
		}
		try {
			loginHistoryMapper.insertList(loginHistories);
		} catch (DuplicateKeyException e) {
			String errorMsg = "xxx Insertion process was failed due to Unique Key constraint. xxx";
			throw new DuplicatedEntryException(errorMsg, e);
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while inserting multi 'LoginHistory' datas ==> " + loginHistories + " xxx";
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Inserting multi 'LoginHistory' informations ---");
	}

	@Override
	@Cacheable(value = "ConfigurationCache.LoginHistory")
	public LoginHistoryBean select(long primaryKey, FetchMode fetchMode) throws DAOException {
		daoLogger.debug("[START] : >>> --- Fetching 'LoginHistory' informations with primaryKey # " + primaryKey + " ---");
		LoginHistoryBean loginHistory = new LoginHistoryBean();
		try {
			loginHistory = loginHistoryMapper.selectByPrimaryKey(primaryKey, fetchMode);
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while fetching single 'LoginHistory' informations with primaryKey ==> " + primaryKey + " xxx";
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Fetching 'LoginHistory' informations with primaryKey # " + primaryKey + " ---");
		return loginHistory;
	}

	@Override
	@Cacheable(value = "ConfigurationCache.LoginHistory")
	public LoginHistoryBean select(Map<String, Object> criteria, FetchMode fetchMode) throws DAOException {
		daoLogger.debug("[START] : >>> --- Fetching single 'LoginHistory' informations with criteria ---");
		LoginHistoryBean loginHistory = new LoginHistoryBean();
		try {
			loginHistory = loginHistoryMapper.selectSingleRecord(criteria, fetchMode);
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while fetching single 'LoginHistory' informations with criteria ==> " + criteria + " xxx";
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Fetching single 'LoginHistory' informations with criteria ---");
		return loginHistory;
	}

	@Override
	@Cacheable(value = "ConfigurationCache.LoginHistory")
	public List<LoginHistoryBean> selectList(Map<String, Object> criteria, FetchMode fetchMode) throws DAOException {
		daoLogger.debug("[START] : >>> --- Fetching multi 'LoginHistory' informations with criteria ---");
		List<LoginHistoryBean> loginHistorys = null;
		try {
			loginHistorys = loginHistoryMapper.selectMultiRecords(criteria, fetchMode);
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while fetching multiple 'LoginHistory' informations with criteria ==> " + criteria + " xxx";
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Fetching multi 'LoginHistory' informations with criteria ---");
		return loginHistorys;
	}

	@Override
	@Cacheable(value = "ConfigurationCache.LoginHistory")
	public long selectCounts(Map<String, Object> criteria, FetchMode fetchMode) throws DAOException {
		daoLogger.debug("[START] : >>> --- Fetching 'LoginHistory' counts with criteria ---");
		long count = 0;
		try {
			count = loginHistoryMapper.selectCounts(criteria, fetchMode);
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while counting 'LoginHistory' records with criteria ==> " + criteria + " xxx";
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Fetching 'LoginHistory' counts with criteria ---");
		return count;
	}
}
