/*
 * @author Mg Than Htike Aung {@literal <rage.cataclysm@gmail.com@address>}
 * @Since 1.0
 * 
 */
package com.mycom.products.springMybatisGenericExample.core.dao.config;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.mycom.products.springMybatisGenericExample.core.bean.config.UserRoleBean;
import com.mycom.products.springMybatisGenericExample.core.dao.api.XGenericDao;
import com.mycom.products.springMybatisGenericExample.core.exception.ConsistencyViolationException;
import com.mycom.products.springMybatisGenericExample.core.exception.DAOException;
import com.mycom.products.springMybatisGenericExample.core.exception.DuplicatedEntryException;
import com.mycom.products.springMybatisGenericExample.core.mapper.config.UserRoleMapper;
import com.mycom.products.springMybatisGenericExample.core.util.FetchMode;

@Repository
public class UserRoleDao implements XGenericDao<UserRoleBean> {

	@Autowired
	private UserRoleMapper userRoleMapper;
	private Logger daoLogger = Logger.getLogger("daoLogger");

	@Override
	@CacheEvict(value = "ConfigurationCache.UserRole", allEntries = true)
	public void insert(UserRoleBean userRole, long recordRegId) throws DAOException, DuplicatedEntryException {
		try {
			daoLogger.debug("[START] : >>> --- Inserting single 'UserRole' informations ---");
			LocalDateTime now = LocalDateTime.now();
			userRole.setRecordRegDate(now);
			userRole.setRecordUpdDate(now);
			userRole.setRecordRegId(recordRegId);
			userRole.setRecordUpdId(recordRegId);
			userRoleMapper.insert(userRole);
		} catch (DuplicateKeyException e) {
			String errorMsg = "xxx Insertion process was failed due to Unique Key constraint xxx";
			throw new DuplicatedEntryException(errorMsg, e);
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while inserting 'UserRole' data ==> " + userRole + " xxx";
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Inserting single 'UserRole' informations ---");
	}

	@Override
	@CacheEvict(value = "ConfigurationCache.UserRole", allEntries = true)
	public void insert(List<UserRoleBean> userRoles, long recordRegId) throws DAOException, DuplicatedEntryException {
		daoLogger.debug("[START] : >>> --- Inserting multi 'UserRole' informations ---");
		LocalDateTime now = LocalDateTime.now();
		for (UserRoleBean userRole : userRoles) {
			userRole.setRecordRegDate(now);
			userRole.setRecordUpdDate(now);
			userRole.setRecordRegId(recordRegId);
			userRole.setRecordUpdId(recordRegId);
		}
		try {
			userRoleMapper.insertList(userRoles);
		} catch (DuplicateKeyException e) {
			String errorMsg = "xxx Insertion process was failed due to Unique Key constraint. xxx";
			throw new DuplicatedEntryException(errorMsg, e);
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while inserting 'UserRole' datas ==> " + userRoles + " xxx";
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Inserting multi 'UserRole' informations ---");
	}

	@Override
	@CacheEvict(value = "ConfigurationCache.UserRole", allEntries = true)
	public void insert(long userId, long roleId, long recordRegId) throws DuplicatedEntryException, DAOException {
		daoLogger.debug("[START] : >>> --- Inserting single 'UserRole' informations ---");
		try {
			userRoleMapper.insertWithRelatedKeys(userId, roleId, recordRegId);
		} catch (DuplicateKeyException e) {
			String errorMsg = "xxx Insertion process was failed due to Unique Key constraint xxx";
			throw new DuplicatedEntryException(errorMsg, e);
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while inserting 'UserRole' data ==> userId = " + userId + " , roleId = " + roleId + " xxx";
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Inserting single 'UserRole' informations ---");
	}

	@Override
	@CacheEvict(value = "ConfigurationCache.UserRole", allEntries = true)
	public long delete(long userId, long roleId,
			long recordUpdId) throws ConsistencyViolationException, DAOException {
		daoLogger.debug("[START] : >>> --- Deleting single 'UserRole' informations with ==> userId " + userId + " , roleId = " + roleId + " ---");
		long effectedRows = 0;
		try {
			effectedRows = userRoleMapper.deleteByKeys(userId, roleId);
		} catch (DataIntegrityViolationException e) {
			String errorMsg = "xxx Rejected : Deleting process was failed because this entity was connected with other resources.If you try to forcely remove it, entire database will loose consistency xxx";
			throw new ConsistencyViolationException(errorMsg, e);
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while deleting 'UserRole' data with ==> userId = " + userId + " , roleId = " + roleId + " xxx";
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Deleting single 'UserRole' informations with ==> userId " + userId + " , roleId = " + roleId + " ---");
		return effectedRows;
	}

	@Override
	@CacheEvict(value = "ConfigurationCache.UserRole", allEntries = true)
	public long delete(Map<String, Object> criteria,
			long recordUpdId) throws ConsistencyViolationException, DAOException {
		daoLogger.debug("[START] : >>> --- Deleting 'UserRole' informations with criteria  ---");
		long effectedRows = 0;
		try {
			effectedRows = userRoleMapper.deleteByCriteria(criteria);
		} catch (DataIntegrityViolationException e) {
			String errorMsg = "xxx Rejected : Deleting process was failed because this entity was connected with other resources.If you try to forcely remove it, entire database will loose consistency xxx";
			throw new ConsistencyViolationException(errorMsg, e);
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while deleting 'UserRole' data with criteria ==> " + criteria + " xxx";
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Deleting 'UserRole' informations with criteria  ---");
		return effectedRows;
	}

	@Override
	@CacheEvict(value = "ConfigurationCache.UserRole", allEntries = true)
	public void merge(long userId, List<Long> roleIds,
			long recordUpdId) throws DuplicatedEntryException, ConsistencyViolationException, DAOException {
		daoLogger.debug("[START] : >>> --- Merging  'UserRole' informations for userId # =" + userId + " with related roleIds =" + roleIds + " ---");
		List<Long> insertIds = new ArrayList<>();
		List<Long> removeIds = new ArrayList<>();
		daoLogger.debug("[START] : $1 --- Fetching old related roleIds for userId # " + userId + " ---");
		List<Long> oldRelatedActions = selectByKey1(userId);
		daoLogger.debug("[FINISH] : $1 --- Fetching old related roleIds for userId # " + userId + " ==> " + oldRelatedActions + " ---");
		if (oldRelatedActions != null && oldRelatedActions.size() > 0) {
			for (Long roleId : roleIds) {
				if (!oldRelatedActions.contains(roleId)) {
					insertIds.add(roleId);
				}
			}

			for (Long roleId : oldRelatedActions) {
				if (!roleIds.contains(roleId)) {
					removeIds.add(roleId);
				}
			}
		} else {
			insertIds = roleIds;
		}
		if (removeIds.size() > 0) {
			daoLogger.debug("[START] : $2 --- Removing  related roleIds " + removeIds + "  for userId # " + userId + " these have been no longer used  ---");
			HashMap<String, Object> criteria = new HashMap<>();
			criteria.put("roleIds", removeIds);
			userRoleMapper.deleteByCriteria(criteria);
			daoLogger.debug("[FINISH] : $2 --- Removing  related roleIds " + removeIds + "  for userId # " + userId + " these have been no longer used  ---");
		}

		if (insertIds.size() > 0) {
			daoLogger.debug("[START] : $3 --- Inserting newly selected roleIds " + insertIds + "  for userId # " + userId + " ---");
			List<UserRoleBean> userRoles = new ArrayList<>();
			for (Long roleId : insertIds) {
				UserRoleBean userRole = new UserRoleBean(userId, roleId);
				userRoles.add(userRole);
			}
			LocalDateTime now = LocalDateTime.now();
			for (UserRoleBean userRole : userRoles) {
				userRole.setRecordRegDate(now);
				userRole.setRecordUpdDate(now);
				userRole.setRecordRegId(recordUpdId);
				userRole.setRecordUpdId(recordUpdId);
			}
			userRoleMapper.insertList(userRoles);
			daoLogger.debug("[FINISH] : $3 --- Inserting newly selected roleIds " + insertIds + " for userId # " + userId + " ---");
		}

		daoLogger.debug("[FINISH] : <<< --- Merging 'UserRole' informations for userId # =" + userId + " with related roleIds =" + roleIds.toString() + " ---");

	}

	@Override
	@Cacheable(value = "ConfigurationCache.UserRole")
	public List<Long> selectByKey1(long key1) throws DAOException {
		daoLogger.debug("[START] : >>> --- Fetching related roleIds with userId # " + key1 + " ---");
		List<Long> roleIds = null;
		try {
			Map<String, Object> criteria = new HashMap<>();
			criteria.put("userId", key1);
			roleIds = userRoleMapper.selectRelatedKeys(criteria);
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while fetching related 'Action' keys with userId ==> " + key1 + " xxx";
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Fetching related roleIds with userId # " + key1 + " ---");
		return roleIds;
	}

	@Override
	@Cacheable(value = "ConfigurationCache.UserRole")
	public List<Long> selectByKey2(long key2) throws DAOException {
		daoLogger.debug("[START] : >>> --- Fetching related userIds with roleId # " + key2 + " ---");
		List<Long> userIds = null;
		try {
			Map<String, Object> criteria = new HashMap<>();
			criteria.put("roleId", key2);
			userIds = userRoleMapper.selectRelatedKeys(criteria);
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while fetching related 'Role' keys with roleId ==> " + key2 + " xxx";
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Fetching related userIds with roleId # " + key2 + " ---");
		return userIds;
	}

	@Override
	@Cacheable(value = "ConfigurationCache.UserRole")
	public UserRoleBean select(long userId, long roleId, FetchMode fetchMode) throws DAOException {
		daoLogger.debug("[START] : >>> --- Fetching single 'UserRole' informations with ==> userId = " + userId + " , roleId = " + roleId + " ---");
		UserRoleBean userRole = null;
		try {
			// Noticed : we don't allow for filtering from joined
			// tables.FetchMode is just only for eager or lazy loading
			userRole = userRoleMapper.selectByKeys(userId, roleId, fetchMode);
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while fetching single 'UserRole' informations with ==> userId = " + userId + " , roleId = " + roleId + " xxx";
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Fetching single 'UserRole' informations with ==> userId = " + userId + " , roleId = " + roleId + " ---");
		return userRole;
	}

	@Override
	@Cacheable(value = "ConfigurationCache.UserRole")
	public List<UserRoleBean> selectList(Map<String, Object> criteria, FetchMode fetchMode) throws DAOException {
		daoLogger.debug("[START] : >>> --- Fetching multi 'UserRole' informations with criteria ---");
		List<UserRoleBean> results = null;
		try {
			// Noticed : we don't allow for filtering from joined
			// tables.FetchMode is just only for eager or lazy loading
			results = userRoleMapper.selectMultiRecords(criteria, fetchMode);
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while fetching multiple 'UserRole' informations with criteria ==> " + criteria + " xxx";
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Fetching multi 'UserRole' informations with criteria ---");
		return results;
	}

	@Override
	@Cacheable(value = "ConfigurationCache.UserRole")
	public long selectCounts(Map<String, Object> criteria) throws DAOException {
		daoLogger.debug("[START] : >>> --- Fetching 'UserRole' counts with criteria ---");
		long count = 0;
		try {
			// we don't allow for filtering from joined tables
			count = userRoleMapper.selectCounts(criteria, null);
		} catch (Exception e) {
			String errorMsg = "xxx Error occured while counting 'UserRole' records with criteria ==> " + criteria + " xxx";
			throw new DAOException(errorMsg, e);
		}
		daoLogger.debug("[FINISH] : <<< --- Fetching 'UserRole' counts with criteria ---");
		return count;
	}
}
