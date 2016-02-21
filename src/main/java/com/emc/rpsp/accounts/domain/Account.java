package com.emc.rpsp.accounts.domain;

import com.emc.rpsp.packages.domain.PackageDefinition;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.users.domain.User;
import com.emc.rpsp.vms.domain.VmOwnership;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	
	@Transient
	@JsonProperty
	private List<Long> packageIds = new LinkedList<Long>();
	
	@Transient
	@JsonProperty
	private List<String> packageNames = new LinkedList<String>();
	

	@JsonIgnore
	@JoinTable(name = "T_ACCOUNT_PACKAGES")
	@ManyToMany(targetEntity = com.emc.rpsp.packages.domain.PackageDefinition.class, fetch = FetchType.LAZY)
	private List<PackageDefinition> packageDefinition;

	@JsonIgnore
	@Column
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<VmOwnership> vms;

	@JsonIgnore
	@Column
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<User> users;



	public Account() {
		super();
		vms = new LinkedList<>();
		users = new LinkedList<>();
		packageDefinition = new LinkedList<>();
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

	@JsonIgnore
	public List<PackageDefinition> getPackages() {
		return packageDefinition;
	}

	@JsonIgnore
	public void setPackages(List<PackageDefinition> packages) {
		this.packageDefinition = packages;
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
	
	public void addPackage(PackageDefinition packageDefinition) {
		this.packageDefinition.add(packageDefinition);
	}

	public void addVm(VmOwnership vmOwnership) {
		vms.add(vmOwnership);
	}

	public void addUser(User user) {
		users.add(user);
	}

	public List<Long> getPackageIds() {
		return packageIds;
	}

	public void setPackageIds(List<Long> packageIds) {
		this.packageIds = packageIds;
	}	
	
	public List<String> getPackageNames() {
		return packageNames;
	}

	public void setPackageNames(List<String> packageNames) {
		this.packageNames = packageNames;
	}

	public void setAdditionalValues(){
		if(packageDefinition != null){
			for(PackageDefinition currPackagedDefinition : packageDefinition){
				packageIds.add(currPackagedDefinition.getId());
				packageNames.add(currPackagedDefinition.getName());
			}
		}
	}

	

	@Override
	public String toString() {
		return "Account{" + "id='" + id + '\'' + ", name='" + name + '\''
				+ ", label='" + label + "}";
	}
}
