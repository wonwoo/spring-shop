package me.wonwoo.security;

import lombok.extern.slf4j.Slf4j;
import me.wonwoo.core.domain.Account;
import me.wonwoo.core.repository.AccountRepository;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by wonwoolee on 2017. 5. 16..
 */

@Configuration
@EnableOAuth2Sso
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/").permitAll()
        .anyRequest().authenticated()
        .and()
        .csrf()
        .and()
        .formLogin()
        .loginPage("/login")
        .permitAll()
        .and()
        .logout()
        .logoutSuccessUrl("/")
        .permitAll()
        .and()
        .headers()
        .frameOptions().sameOrigin();
  }

  @Bean
  public AuthoritiesExtractor authoritiesExtractor() {
    return map -> {
      String id = (String) map.get("id");
      if ("1160584070720672".contains(id)) {
        return AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER,ROLE_ADMIN");
      } else {
        return AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
      }
    };
  }

  @Bean
  public PrincipalExtractor principalExtractor(AccountRepository accountRepository) {
    return map -> {
      String facebookLogin = (String) map.get("id");
      Account loginUser = accountRepository.findByLoginId(facebookLogin);
      if (loginUser == null) {
        logger.info("Initialize user with facebook id {}", facebookLogin);
        accountRepository.save(new Account(facebookLogin, (String) map.get("name"), null, null));
      }
      return loginUser;
    };
  }
}