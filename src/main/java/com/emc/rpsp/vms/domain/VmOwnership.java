package com.emc.rpsp.vms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.emc.rpsp.accounts.domain.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by morand3 on 4/26/2015.
 */
@Entity
@Table(name = "T_VMOWNERSHIP")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class VmOwnership {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String vmId;
	
	@Size(min = 0, max = 100)
	@Column(name = "vm_name", length = 100)
	private String vmName;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Account account;

	
	
	public VmOwnership(String vmId) {
		this.vmId = vmId;
	}

	public VmOwnership() {
	}

	public long getId() {
		return id;
	}

	public String getVmId() {
		return vmId;
	}

	public void setVmId(String vmId) {
		this.vmId = vmId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVmName() {
		return vmName;
	}

	public void setVmName(String vmName) {
		this.vmName = vmName;
	}


	
	
	
}
