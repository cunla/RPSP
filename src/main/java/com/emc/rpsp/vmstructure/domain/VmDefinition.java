package com.emc.rpsp.vmstructure.domain;

import com.emc.rpsp.accounts.domain.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class VmDefinition {

    private String id;
    private String name;
    private boolean isCritical;
    private int sequenceNumber;
    @JsonIgnore
    private Account account;

    public VmDefinition(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public boolean isCritical() {
		return isCritical;
	}

	public void setCritical(boolean isCritical) {
		this.isCritical = isCritical;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
    
    

}
