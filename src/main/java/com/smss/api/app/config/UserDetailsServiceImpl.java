package com.smss.api.app.config;

import com.smss.api.smssApi.model.auth.Authentication;
import com.smss.api.smssApi.service.AuthenticationService;
import com.smss.api.system.models.UserAssignedRoles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static Logger logger = LogManager.getLogger();

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Authentication auth=null;
        UserAssignedRoles role=null;
            try {
                auth = authenticationService.findByName(s);
            }catch(Exception e){
                e.printStackTrace();
                throw new ConstraintViolationException("Access Denied, Please contact Admin", Collections.emptySet());}
            List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

            GrantedAuthority authority = new SimpleGrantedAuthority("SYSTEM");
            grantList.add(authority);
            authority = new SimpleGrantedAuthority("ADMIN");
            grantList.add(authority);
            UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(auth.getaLoginId(), //
                    auth.getaPwd(), grantList);
            return userDetails;
        }
}
