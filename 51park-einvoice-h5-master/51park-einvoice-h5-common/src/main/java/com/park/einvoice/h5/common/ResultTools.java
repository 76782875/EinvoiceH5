package com.park.einvoice.h5.common;

import java.util.HashMap;
import java.util.Map;
import com.park.einvoice.h5.common.constants.CodeConstants;




public class ResultTools {
	
	private static final String CODE ="code";
	private static final String MSG ="msg";
	private static final String DATA ="data";

	/**
	 * 返回
	 * @return
	 */
	public static String setResponse(String code){
		
		Map<String, String> map =new HashMap<String, String>();
		map.put(CODE,code);
		map.put(MSG, CodeConstants.getName(code));
		return DataChangeTools.bean2gson(map);	
	}
	/**
	 * 
	 * @param code 
	 * @param object
	 * @return
	 */
	public static String setObjectResponse(String code,Object data){
		Map<String, Object> map =new HashMap<String, Object>();
		map.put(CODE, code);
		map.put(MSG,  CodeConstants.getName(code));
		map.put(DATA, data);
		return DataChangeTools.bean2gson(map);	
	}
	
}
