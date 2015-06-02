package com.emc.rpsp.vmstructure.constants;


public enum TransferState {
	
	INITIALIZING("Initializing"), 
    ACTIVE("Active"), 
    PAUSED("Paused"),  
	ERROR("Error"), 
	UNKNOWN("Unknown");
		
	private  final String stateVal;
	
	private TransferState(final String state){
		stateVal = state;
	}
	
	public String value() { 
		return stateVal; 
	}
 
    public static TransferState fromValue(String v)
	{
	   return valueOf(v);
	}

}
