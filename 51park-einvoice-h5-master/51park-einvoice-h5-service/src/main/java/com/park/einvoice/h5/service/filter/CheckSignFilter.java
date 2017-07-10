package com.park.einvoice.h5.service.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.park.einvoice.h5.common.ResultTools;
import com.park.einvoice.h5.common.SignTools;
import com.park.einvoice.h5.common.constants.CodeConstants;
/**
 * 签名校验
 * @author wupanjun
 *
 */
public class CheckSignFilter implements Filter {
	/**   
	* 需要排除的页面   
	*/      
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response =(HttpServletResponse)resp;
		response.setContentType("text/html; charset=UTF-8");
		
        String url = request.getRequestURI();
        /** 欢迎页*/
        if (url.endsWith("/EinvoiceH5/")) {
        		chain.doFilter(request, response); 
			return;
		}
        String projectid=request.getHeader("Projectid");
        if (StringUtils.isBlank(projectid)) {
        	response.getWriter().print(ResultTools.setResponse(CodeConstants.参数为空.getCode()));
        	return;
		}
        boolean verify =false;
        /**
         *  采用projectid的密钥验签  
         */
        verify =SignTools.verifySign(request);
        if (verify) {
       		chain.doFilter(request,response);
       		return;
       	}else {
       		response.getWriter().print(ResultTools.setResponse(CodeConstants.签名验证失败.getCode()));
       		return;
       	}  
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
