/*
 * @author Mg Than Htike Aung {@literal <rage.cataclysm@gmail.com@address>}
 * @Since 1.0
 * 
 */
package com.mycom.products.springMybatisGenericExample.core.bean.config;

import java.util.List;

import com.mycom.products.springMybatisGenericExample.core.bean.BaseBean;

public class ActionBean extends BaseBean implements java.io.Serializable {
	private static final long serialVersionUID = -7891646684080105708L;
	private String module;
	private String page;
	private String actionName;
	private String displayName;
	private String url;
	private List<Integer> roleIds;
	private List<RoleBean> roles;
	private ActionType actionType;
	private String description;

	public enum ActionType {
		MAIN, SUB;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public List<RoleBean> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleBean> roles) {
		this.roles = roles;
	}

	public List<Integer> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}

	public ActionType getActionType() {
		return actionType;
	}

	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	@Override
	public String toString() {
		return String.format("ActionBean {module=%s, page=%s, actionName=%s, displayName=%s, url=%s, roleIds=%s, roles=%s, actionType=%s, description=%s, ID=%s}", module, page, actionName, displayName, url, roleIds, roles, actionType, description, getId());
	}

}
