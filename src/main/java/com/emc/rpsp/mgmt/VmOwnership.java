package com.emc.rpsp.mgmt;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

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
	private Long accountId;

	@Column
	private String vmId;

	public VmOwnership(Long accountId, String vmId) {
		this.accountId=accountId;
		this.vmId=vmId;
	}

	public VmOwnership(){}

	public long getId() {
		return id;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getVmId() {
		return vmId;
	}

	public void setVmId(String vmId) {
		this.vmId = vmId;
	}
}
