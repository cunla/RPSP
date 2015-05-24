package com.emc.rpsp.accounts.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.users.domain.User;
import com.emc.rpsp.vms.domain.VmOwnership;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@ManyToOne(fetch = FetchType.EAGER)
	private SystemSettings systemSettings;
	
	
	
	
	
	
	public Account() {
		super();
		vms = new LinkedList<>();
		users = new LinkedList<>();		
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
	
	
	public SystemSettings getSystemSettings() {
		return systemSettings;
	}



	public void setSystemSettings(SystemSettings systemSettings) {
		this.systemSettings = systemSettings;
	}
	
	public void addVm(VmOwnership vmOwnership){
		vms.add(vmOwnership);
	}
	
	public void addUser(User user){
		users.add(user);
	}


	

/*	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Account user = (Account) o;

		if (!id.equals(user.id)) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}*/




	@Override
	public String toString() {
		return "Account{" + "id='" + id + '\'' + ", name='" + name
		        + '\'' + ", label='" + label + "}";
	}
}
