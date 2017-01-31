/*
 * @author Mg Than Htike Aung {@literal <rage.cataclysm@gmail.com@address>}
 * @Since 1.0
 * 
 */
package com.mycom.products.mywebsite.core.dao.base;

import java.util.List;
import java.util.Map;

import com.mycom.products.mywebsite.core.bean.BaseBean;
import com.mycom.products.mywebsite.core.exception.ConsistencyViolationException;
import com.mycom.products.mywebsite.core.exception.DAOException;
import com.mycom.products.mywebsite.core.exception.DuplicatedEntryException;
import com.mycom.products.mywebsite.core.util.FetchMode;

public interface XGenericDao<T extends BaseBean> {

	public void insert(T record, long recordRegId) throws DuplicatedEntryException, DAOException;

	public void insert(List<T> records, long recordRegId) throws DuplicatedEntryException, DAOException;

	public void insert(long key1, long key2, long recordRegId) throws DuplicatedEntryException, DAOException;

	public long delete(long key1, long key2, long recordUpdId) throws ConsistencyViolationException, DAOException;

	public long delete(Map<String, Object> criteria,
			long recordUpdId) throws ConsistencyViolationException, DAOException;

	public void merge(long mainKey, List<Integer> relatedKeys,
			long recordUpdId) throws DuplicatedEntryException, ConsistencyViolationException, DAOException;

	public List<Integer> selectByKey1(long key1) throws DAOException;

	public List<Integer> selectByKey2(long key2) throws DAOException;

	public T select(long key1, long key2, FetchMode fetchMode) throws DAOException;

	public List<T> selectList(Map<String, Object> criteria, FetchMode fetchMode) throws DAOException;

	public long selectCounts(Map<String, Object> criteria) throws DAOException;

}
