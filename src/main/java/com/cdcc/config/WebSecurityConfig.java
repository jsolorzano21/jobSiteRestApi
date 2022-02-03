package com.cdcc.config;

import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.cdcc.services.MongoUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserDetailsService userDetailsService = mongoUserDetails();
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().disable().csrf().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers("/api/financialUserInformation").permitAll().antMatchers("/api/financialUpdateQuarterData").permitAll()
				.antMatchers("/api/financialActualRevenue").permitAll().antMatchers("/api/projectSiteListInformation").permitAll()
				.antMatchers("/api/financialDivisions").permitAll().antMatchers("/api/financialYearlyQuarterLabel").permitAll()
				.antMatchers("/api/financialActualBudgetData").permitAll().antMatchers("/api/financialResultsData/").permitAll()
				.antMatchers("/api/projectSiteListInformation/liveViewLogin/*").permitAll().antMatchers("/api/projectSiteListUpdateItem/*").permitAll()
				.antMatchers("/api/projectSiteListPublishItem/*").permitAll()
				.antMatchers("/api/financialResultsData/division/*").permitAll().antMatchers("/api/financialUpdateQuarterData/*").permitAll()
				.antMatchers("/api/financialManagementAdjustmentData/yearQuarter/*/*").permitAll().antMatchers("/api/financialUpdateYearThreeReportExecAdj").permitAll()
				.antMatchers("/api/financialUpdateYearThreeReportExecAdj/*").permitAll().antMatchers("/api/financialManagementAdjustmentData").permitAll()
				.antMatchers("/api/financialManagementAdjustmentData/").permitAll().antMatchers("/api/financialUpdateYearThreeReport").permitAll().antMatchers("/api/financialUpdateYearThreeReport/*").permitAll()
				.antMatchers("/api/auth/login").permitAll().antMatchers("/api/auth/register").permitAll().anyRequest()
				.authenticated().and().csrf().disable().exceptionHandling()
				.authenticationEntryPoint(unauthorizedEntryPoint()).and().apply(new JwtConfigurer(jwtTokenProvider));
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("http://localhost:3000","https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com", "https://projectadmin.carrolldaniel.com"));
		config.setAllowedHeaders(Arrays.asList("Content-Type","Origin","*"));
		config.setAllowedMethods(Arrays.asList("Get","put","post","delete"));
		config.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}

	@Bean
	public PasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public AuthenticationEntryPoint unauthorizedEntryPoint() {
		return (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
				"Unauthorized");
	}

	@Bean
	public UserDetailsService mongoUserDetails() {
		return new MongoUserDetailsService();
	}
}