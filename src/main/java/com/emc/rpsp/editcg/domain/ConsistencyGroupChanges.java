package com.emc.rpsp.editcg.domain;

import com.emc.rpsp.vmstructure.domain.ConsistencyGroup;

public class ConsistencyGroupChanges {
	
	private ConsistencyGroup originalConsistencyGroup;
	private ConsistencyGroup currentConsistencyGroup;
	
	public ConsistencyGroupChanges() {
		super();
	}

	public ConsistencyGroup getOriginalConsistencyGroup() {
		return originalConsistencyGroup;
	}

	public void setOriginalConsistencyGroup(
			ConsistencyGroup originalConsistencyGroup) {
		this.originalConsistencyGroup = originalConsistencyGroup;
	}

	public ConsistencyGroup getCurrentConsistencyGroup() {
		return currentConsistencyGroup;
	}

	public void setCurrentConsistencyGroup(ConsistencyGroup currentConsistencyGroup) {
		this.currentConsistencyGroup = currentConsistencyGroup;
	}

	@Override
	public String toString() {
		return "ConsistencyGroupChanges [originalConsistencyGroup="
				+ originalConsistencyGroup + ", currentConsistencyGroup="
				+ currentConsistencyGroup + "]";
	}
	
	
}
