package com.emc.rpsp.mgmt;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by morand3 on 5/13/2015.
 */
public class VmDataFetcher {
	private static final long CACHE_TIME = 1000*60*10; //10mins cache
	//Map vmId => VmData cache
	private static Map<String, VmData> cache = new HashMap<>();


	public VmData getVmData(String vmId){
		VmData res = cache.get(vmId);
		if(null!=res &&(System.currentTimeMillis() - res.getTime() < CACHE_TIME)){
			return res;
		}
		//TODO get data
		return null;
	}

}
