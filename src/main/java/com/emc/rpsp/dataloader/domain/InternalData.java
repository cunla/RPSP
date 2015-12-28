package com.emc.rpsp.dataloader.domain;

import java.util.List;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.packages.domain.PackageDefinition;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.users.domain.User;
import com.emc.rpsp.vms.domain.VmOwnership;

public class InternalData {
	
	private List<SystemSettings> systems = null;
	private List<PackageDefinition> packages = null;
	private List<Account> tenants = null;
	private List<User> users = null;
	private List<VmOwnership> vms = null;
	
	public InternalData() {
		super();
	}

	public List<SystemSettings> getSystems() {
		return systems;
	}

	public void setSystems(List<SystemSettings> systems) {
		this.systems = systems;
	}

	public List<PackageDefinition> getPackages() {
		return packages;
	}

	public void setPackages(List<PackageDefinition> packages) {
		this.packages = packages;
	}

	public List<Account> getTenants() {
		return tenants;
	}

	public void setTenants(List<Account> tenants) {
		this.tenants = tenants;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<VmOwnership> getVms() {
		return vms;
	}

	public void setVms(List<VmOwnership> vms) {
		this.vms = vms;
	}
	
	

}
