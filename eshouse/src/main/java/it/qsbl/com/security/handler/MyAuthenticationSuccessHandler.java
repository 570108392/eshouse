/**
 * 
 */
package it.qsbl.com.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zhailiang
 *
 */
@Component
public class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private static  final  String USER_INDEX = "/protal/information";
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ObjectMapper objectMapper;


	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		logger.info("登录成功");
		if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_COM"))){
		    super.setTargetUrlParameter(USER_INDEX);
		    super.setDefaultTargetUrl(USER_INDEX);
        }
		if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
		    super.setTargetUrlParameter("/login/success");
		    super.setDefaultTargetUrl("/login/success");
        }
			super.setTargetUrlParameter(USER_INDEX);
			super.setDefaultTargetUrl(USER_INDEX);

		super.onAuthenticationSuccess(request,response,authentication);
	}

}
