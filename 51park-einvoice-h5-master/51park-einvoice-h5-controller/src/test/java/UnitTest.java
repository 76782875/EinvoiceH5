import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.park.einvoice.h5.common.DataChangeTools;
import com.park.einvoice.h5.common.HttpTools;
import com.park.einvoice.h5.common.SignTools;

public class UnitTest {
	
	@Test
	public void testInvMain(){
		String loginUrl = "http://localhost:8081/EinvoiceH5/invmain/get";
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("tradeNo", "16010100050335790");
		String loginparams = DataChangeTools.bean2gson(map);
		Map<String,String> headers = getHeaders(loginparams,loginUrl);
		String result=HttpTools.HttpClientPost(loginUrl, loginparams, headers);
		System.out.println(result);
	}
	
	private Map<String, String> getHeaders(String loginparams, String loginUrl) {
    	String time = String.valueOf(System.currentTimeMillis()/1000);
        //String projectId = "saas";
        String projectId = "test";
    	Map<String, String> headers = new HashMap<String, String>(); 
    	Map<String, String> map = DataChangeTools.json2Map(loginparams);
    	System.out.println(map);
    	String linkparams=DataChangeTools.createLinkString(map);
    	System.out.println("加密之前："+time+loginUrl+"?"+linkparams);
    	String authorization = SignTools.encrypt(time+loginUrl+"?"+linkparams, "8257f71fc72d9e63911a052871fc4bed");
    	System.out.println("加密之后：" + authorization);
    	headers.put("Timestamp",time);  
    	headers.put("Authorization",authorization);  
    	headers.put("Projectid",projectId);  
    	return headers;
	}
}
