package com.emc.rpsp.fal;

/**
 * Created by morand3 on 12/24/2014.
 */
public class VmData {
	private String vmName;
	private String vmState;
	private boolean isLocal;

	public VmData(String vmName, String vmState, boolean isLocal) {
		this.vmName = vmName;
		this.vmState = vmState;
		this.isLocal = isLocal;
	}

	public String getVmName() {
		return vmName;
	}

	public String getVmState() {
		return vmState;
	}

	public boolean isLocal() {
		return isLocal;
	}
}
