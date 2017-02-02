/*
 * @author Mg Than Htike Aung {@literal <rage.cataclysm@gmail.com@address>}
 * @Since 1.0
 * @See CommonGenericDao
 */
package com.mycom.products.mywebsite.core.dao.config;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.mycom.products.mywebsite.core.bean.BaseBean.TransactionType;
import com.mycom.products.mywebsite.core.bean.config.UserBean;
import com.mycom.products.mywebsite.core.dao.base.CommonGenericDao;
import com.mycom.products.mywebsite.core.dao.base.JoinedSelectableDao;
import com.mycom.products.mywebsite.core.exception.ConsistencyViolationException;
import com.mycom.products.mywebsite.core.exception.DAOException;
import com.mycom.products.mywebsite.core.exception.DuplicatedEntryException;
import com.mycom.products.mywebsite.core.exception.SaveHistoryFailedException;
import com.mycom.products.mywebsite.core.mapper.config.UserMapper;
import com.mycom.products.mywebsite.core.util.FetchMode;

@Repository
public class UserDao implements CommonGenericDao<UserBean>, JoinedSelectableDao<UserBean> {

	@Autowired
	private UserMapper userMapper;

	private Logger daoLogger = Logger.getLogger("daoLogger");

	@Override
	public long insert(UserBean user, long recordRegId) throws DAOException, DuplicatedEntryException {
		try {
			daoLogger.debug("[START] : >>> --- Inserting single 'User' informations ---");
			LocalDateTime now = LocalDateTime.now();
			user.setRecordRegDate(now);
			user.setRecordUpdDate(now);
			user.setRecordRegId(recordRegId);
			user.setRecordUpdId(recordRegId);
			user.setTransactionType(TransactionType.INSERT);
			userMapper.insert(user);
			daoLogger.debug("[HISTORY][START] : $1 --- Save 'User' informations in history after successfully inserted in major table ---");
			userMapper.saveHistory(user);
			daoLogger.debug("[HISTORY][FINISH] : $1 --- Save 'User' informations in history ---");
		} catch (DuplicateKeyException e) {
			String errorMsg = "xxx Insertion process was failed due to Unique Key constraint xxx";
			daoLogger.error(errorMsg, e);
			throw new DuplicatedEntryException(errorMsg, e);
		} catch (SaveHistoryFailedException e) {
			String errorMsg = "xxx Error occured while saving 'User' informations in history for later tracking xxx";
			daoLogger.error(errorMsg, e);
			throw new SaveHistoryFailedException(errorMsg, e.getCause());
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while inserting 'User' data ==> " + user + " xxx";
			daoLogger.error(errorMsg, e);
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Inserting single 'User' informations with new Id # " + user.getId() + " ---");
		return user.getId();
	}

	@Override
	public void insert(List<UserBean> users, long recordRegId) throws DAOException, DuplicatedEntryException {
		daoLogger.debug("[START] : >>> --- Inserting multi 'User' informations ---");
		LocalDateTime now = LocalDateTime.now();
		for (UserBean user : users) {
			user.setRecordRegDate(now);
			user.setRecordUpdDate(now);
			user.setRecordRegId(recordRegId);
			user.setRecordUpdId(recordRegId);
			user.setTransactionType(TransactionType.INSERT);
		}
		try {
			userMapper.insertList(users);
			daoLogger.debug("[HISTORY][START] : $1 --- Save 'User' informations in history after successfully inserted in major table ---");
			userMapper.saveHistoryList(users);
			daoLogger.debug("[HISTORY][FINISH] : $1 --- Save 'User' informations in history ---");
		} catch (DuplicateKeyException e) {
			String errorMsg = "xxx Insertion process was failed due to Unique Key constraint. xxx";
			daoLogger.error(errorMsg, e);
			throw new DuplicatedEntryException(errorMsg, e);
		} catch (SaveHistoryFailedException e) {
			String errorMsg = "xxx Error occured while saving 'User' informations in history for later tracking xxx";
			daoLogger.error(errorMsg, e);
			throw new SaveHistoryFailedException(errorMsg, e.getCause());
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while inserting multi 'User' datas ==> " + users + " xxx";
			daoLogger.error(errorMsg, e);
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Inserting multi 'User' informations ---");
	}

	@Override
	public long update(UserBean user, long recordUpdId) throws DAOException, DuplicatedEntryException {
		long totalEffectedRows = 0;
		daoLogger.debug("[START] : >>> --- Updating single 'User' informations ---");
		try {
			user.setRecordUpdId(recordUpdId);
			daoLogger.debug("[HISTORY][START] : $1 --- Save 'User' informations in history before update on major table ---");
			UserBean oldData = userMapper.selectByPrimaryKey(user.getId(), FetchMode.LAZY);
			if (oldData == null) {
				throw new SaveHistoryFailedException();
			}
			oldData.setTransactionType(TransactionType.UPDATE);
			oldData.setRecordUpdId(recordUpdId);
			userMapper.saveHistory(oldData);
			daoLogger.debug("[HISTORY][FINISH] : $1 --- Save 'User' informations in history ---");
			totalEffectedRows = userMapper.update(user);
		} catch (DuplicateKeyException e) {
			String errorMsg = "xxx Updating process was failed due to Unique Key constraint xxx";
			daoLogger.error(errorMsg, e);
			throw new DuplicatedEntryException(errorMsg, e);
		} catch (SaveHistoryFailedException e) {
			String errorMsg = "xxx Error occured while saving 'User' informations in history for later tracking xxx";
			daoLogger.error(errorMsg, e);
			throw new SaveHistoryFailedException(errorMsg, e.getCause());
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while updating 'User' data ==> " + user + " xxx";
			daoLogger.error(errorMsg, e);
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Updating single 'User' informations with Id # " + user.getId() + " ---");
		return totalEffectedRows;
	}

	@Override
	public void update(List<UserBean> users, long recordUpdId) throws DAOException, DuplicatedEntryException {
		daoLogger.debug("[START] : >>> --- Updating multi 'User' informations ---");
		for (UserBean user : users) {
			try {
				user.setRecordUpdId(recordUpdId);
				daoLogger.debug("[HISTORY][START] : $1 --- Save 'User' informations in history before update on major table ---");
				UserBean oldData = userMapper.selectByPrimaryKey(user.getId(), FetchMode.LAZY);
				if (oldData == null) {
					throw new SaveHistoryFailedException();
				}
				oldData.setTransactionType(TransactionType.UPDATE);
				oldData.setRecordUpdId(recordUpdId);
				userMapper.saveHistory(oldData);
				daoLogger.debug("[HISTORY][FINISH] : $1 --- Save 'User' informations in history ---");
				userMapper.update(user);
			} catch (DuplicateKeyException e) {
				String errorMsg = "xxx Updating process was failed due to Unique Key constraint xxx";
				daoLogger.error(errorMsg, e);
				throw new DuplicatedEntryException(errorMsg, e);
			} catch (SaveHistoryFailedException e) {
				String errorMsg = "xxx Error occured while saving 'User' informations in history for later tracking xxx";
				daoLogger.error(errorMsg, e);
				throw new SaveHistoryFailedException(errorMsg, e.getCause());
			} catch (Exception e) {
				String errorMsg = "xxx Error occured while updating 'User' data ==> " + user + " xxx";
				daoLogger.error(errorMsg, e);
				throw new DAOException(errorMsg, e);
			}
		}
		daoLogger.debug("[FINISH] : <<< --- Updating multi 'User' informations ---");
	}

	@Override
	public long delete(long primaryKey,
			long recordUpdId) throws DAOException, ConsistencyViolationException {
		daoLogger.debug("[START] : >>> --- Deleting single 'User' informations with primaryKey # " + primaryKey + " ---");
		long totalEffectedRows = 0;
		try {
			daoLogger.debug("[HISTORY][START] : $1 --- Save 'User' informations in history before update on major table ---");
			UserBean oldData = userMapper.selectByPrimaryKey(primaryKey, FetchMode.LAZY);
			if (oldData == null) {
				throw new SaveHistoryFailedException();
			}
			oldData.setTransactionType(TransactionType.UPDATE);
			oldData.setRecordUpdId(recordUpdId);
			userMapper.saveHistory(oldData);
			daoLogger.debug("[HISTORY][FINISH] : $1 --- Save 'User' informations in history ---");
			totalEffectedRows = userMapper.deleteByPrimaryKey(primaryKey);
		} catch (DataIntegrityViolationException e) {
			String errorMsg = "xxx Rejected : Deleting process was failed because this entity was connected with other resources.If you try to forcely remove it, entire database will loose consistency xxx";
			daoLogger.error(errorMsg, e);
			throw new ConsistencyViolationException(errorMsg, e);
		} catch (SaveHistoryFailedException e) {
			String errorMsg = "xxx Error occured while saving 'User' informations in history for later tracking xxx";
			daoLogger.error(errorMsg, e);
			throw new SaveHistoryFailedException(errorMsg, e.getCause());
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while deleting 'User' data with primaryKey ==> " + primaryKey + " xxx";
			daoLogger.error(errorMsg, e);
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Deleting single 'User' informations with primaryKey # " + primaryKey + " ---");
		return totalEffectedRows;
	}

	@Override
	public long delete(Map<String, Object> criteria,
			long recordUpdId) throws DAOException, ConsistencyViolationException {
		long totalEffectedRows = 0;
		daoLogger.debug("[START] : >>> --- Deleting 'User' informations with criteria  ---");
		try {
			daoLogger.debug("[HISTORY][START] : $1 --- Save 'User' informations in history before delete on major table ---");
			List<UserBean> users = userMapper.selectMultiRecords(criteria, FetchMode.LAZY);
			if (users == null) {
				throw new SaveHistoryFailedException();
			}
			if (users != null && users.size() > 0) {
				for (UserBean user : users) {
					user.setTransactionType(TransactionType.DELETE);
					user.setRecordUpdId(recordUpdId);
					userMapper.saveHistory(user);
				}
			}
			daoLogger.debug("[HISTORY][FINISH] : $1 --- Save 'User' informations in history ---");
			totalEffectedRows = userMapper.deleteByCriteria(criteria);
		} catch (DataIntegrityViolationException e) {
			String errorMsg = "xxx Rejected : Deleting process was failed because this entity was connected with other resources.If you try to forcely remove it, entire database will loose consistency xxx";
			daoLogger.error(errorMsg, e);
			throw new ConsistencyViolationException(errorMsg, e);
		} catch (SaveHistoryFailedException e) {
			String errorMsg = "xxx Error occured while saving 'User' informations in history for later tracking xxx";
			daoLogger.error(errorMsg, e);
			throw new SaveHistoryFailedException(errorMsg, e.getCause());
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while deleting 'User' data with criteria ==> " + criteria + " xxx";
			daoLogger.error(errorMsg, e);
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Deleting 'User' informations with criteria  ---");
		return totalEffectedRows;
	}

	@Override
	public UserBean select(long primaryKey, FetchMode fetchMode) throws DAOException {
		daoLogger.debug("[START] : >>> --- Fetching 'User' informations with primaryKey # " + primaryKey + " ---");
		UserBean user = new UserBean();
		try {
			user = userMapper.selectByPrimaryKey(primaryKey, fetchMode);
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while fetching single 'User' informations with primaryKey ==> " + primaryKey + " xxx";
			daoLogger.error(errorMsg, e);
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Fetching 'User' informations with primaryKey # " + primaryKey + " ---");
		return user;
	}

	@Override
	public UserBean select(Map<String, Object> criteria, FetchMode fetchMode) throws DAOException {
		daoLogger.debug("[START] : >>> --- Fetching single 'User' informations with criteria ---");
		UserBean user = new UserBean();
		try {
			user = userMapper.selectSingleRecord(criteria, fetchMode);
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while fetching single 'User' informations with criteria ==> " + criteria + " xxx";
			daoLogger.error(errorMsg, e);
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Fetching single 'User' informations with criteria ---");
		return user;
	}

	@Override
	public List<UserBean> selectList(Map<String, Object> criteria, FetchMode fetchMode) throws DAOException {
		daoLogger.debug("[START] : >>> --- Fetching multi 'User' informations with criteria ---");
		List<UserBean> users = null;
		try {
			users = userMapper.selectMultiRecords(criteria, fetchMode);
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while fetching multiple 'User' informations with criteria ==> " + criteria + " xxx";
			daoLogger.error(errorMsg, e);
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Fetching multi 'User' informations with criteria ---");
		return users;
	}

	@Override
	public long selectCounts(Map<String, Object> criteria, FetchMode fetchMode) throws DAOException {
		daoLogger.debug("[START] : >>> --- Fetching 'User' counts with criteria ---");
		long count = 0;
		try {
			count = userMapper.selectCounts(criteria, fetchMode);
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while counting 'User' records with criteria ==> " + criteria + " xxx";
			daoLogger.error(errorMsg, e);
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Fetching 'User' counts with criteria ---");
		return count;
	}

	public UserBean selectAuthenticatedUser(String loginId, String password) throws DAOException {
		daoLogger.debug("[START] : >>> --- Fetching Authenticated 'User' informations ---");
		UserBean user = new UserBean();
		try {
			user = userMapper.selectAuthenticatedUser(loginId, password, FetchMode.EAGER);
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while fetching Authenticated 'User' informations xxx";
			daoLogger.error(errorMsg, e);
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< ---  Fetching Authenticated 'User' informations ---");
		return user;
	}
}
