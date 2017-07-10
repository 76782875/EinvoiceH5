package com.park.einvoice.h5.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.park.einvoice.h5.common.DataChangeTools;
import com.park.einvoice.h5.common.SignTools;
import com.park.einvoice.h5.common.constants.SignKeyConstants;

/**
 * 提供getHeaders()方法的Service
 * @author WangYuefei
 *
 */
public class BaseService {
	protected Map<String, String> getHeaders(String loginparams, String loginUrl) {
    	String time = String.valueOf(System.currentTimeMillis()/1000);
        String projectId = "WYH5";
    	Map<String, String> headers = new HashMap<String, String>(); 
    	Map<String, String> map = DataChangeTools.json2Map(loginparams);
    	String linkparams=DataChangeTools.createLinkString(map);
    	String authorization = SignTools.encrypt(time+loginUrl+"?"+linkparams, SignKeyConstants.keyMap.get(projectId));
    	headers.put("Timestamp",time);  
    	headers.put("Authorization",authorization);  
    	headers.put("Projectid",projectId);  
    	return headers;
	}
}
