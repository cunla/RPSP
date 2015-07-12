package com.emc.rpsp.accounts.domain;

import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.users.domain.User;
import com.emc.rpsp.vms.domain.VmOwnership;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Entity
@Table(name = "T_ACCOUNT")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Account implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Size(min = 0, max = 100)
	@Column(name = "name", length = 100)
	private String name;

	@Size(min = 0, max = 100)
	@Column(name = "label", length = 100)
	private String label;

	@JsonIgnore
	@Column
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<VmOwnership> vms;

	@JsonIgnore
	@Column
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<User> users;

	@JsonIgnore
	@Column
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<AccountConfig> accountConfigs;

	@JsonIgnore
	@JoinTable(name = "T_ACCOUNT_SYSTEMS")
	@ManyToMany(targetEntity = com.emc.rpsp.rpsystems.SystemSettings.class, fetch = FetchType.LAZY)
	private List<SystemSettings> systemSettings;

	public Account() {
		super();
		vms = new LinkedList<>();
		users = new LinkedList<>();
		systemSettings = new LinkedList<>();
		accountConfigs = new LinkedList<AccountConfig>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<VmOwnership> getVms() {
		return vms;
	}

	public void setVms(List<VmOwnership> vms) {
		this.vms = vms;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<SystemSettings> getSystemSettings() {
		return systemSettings;
	}

	public void setSystemSettings(List<SystemSettings> systemSettings) {
		this.systemSettings = systemSettings;
	}

	public List<AccountConfig> getAccountConfigs() {
		return accountConfigs;
	}

	public Map<Long, AccountConfig> getAccountConfigsMap() {
		Map<Long, AccountConfig> accountConfigsMap = accountConfigs
				.stream()
				.collect(
						Collectors.toMap(AccountConfig::getClusterId, (p) -> p));
		return accountConfigsMap;
	}

	public void setAccountConfigs(List<AccountConfig> accountConfigs) {
		this.accountConfigs = accountConfigs;
	}

	public void addVm(VmOwnership vmOwnership) {
		vms.add(vmOwnership);
	}

	public void addUser(User user) {
		users.add(user);
	}

	public void addAccountConfig(AccountConfig accountConfig) {
		accountConfigs.add(accountConfig);
	}

	public void addSystem(SystemSettings systemSettings) {
		this.systemSettings.add(systemSettings);
	}

	@Override
	public String toString() {
		return "Account{" + "id='" + id + '\'' + ", name='" + name + '\''
				+ ", label='" + label + "}";
	}
}
