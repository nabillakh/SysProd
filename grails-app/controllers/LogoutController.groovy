import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

import org.springframework.security.access.annotation.Secured
import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils 

import org.springframework.security.authentication.AccountExpiredException 
import org.springframework.security.authentication.CredentialsExpiredException 
import org.springframework.security.authentication.DisabledException 
import org.springframework.security.authentication.LockedException 
import org.springframework.security.core.context.SecurityContextHolder as SCH 
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter 
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter 


@Secured('IS_AUTHENTICATED_ANONYMOUSLY')
class LogoutController {

	/**
	 * Index action. Redirects to the Spring security logout uri.
	 */
	def index = {
		// TODO  put any pre-logout code here
		redirect uri: SpringSecurityUtils.securityConfig.logout.filterProcessesUrl // '/j_spring_security_logout'
                       
        
	}
}