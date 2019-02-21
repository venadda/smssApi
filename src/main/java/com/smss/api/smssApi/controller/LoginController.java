package com.smss.api.smssApi.controller;

import com.smss.api.app.config.EncrytedPasswordUtils;
import com.smss.api.app.config.UserDetailsServiceImpl;
import com.smss.api.app.constants.Messages;
import com.smss.api.smssApi.apiclazz.LoginParams;
import com.smss.api.smssApi.dto.user.UserDTO;
import com.smss.api.smssApi.model.auth.Authentication;

import com.smss.api.smssApi.service.AuthenticationService;
import com.smss.api.system.models.UserAssignedRoles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;
import java.util.Collections;

@ControllerAdvice
@CrossOrigin
@RestController
@RequestMapping("/smss/login")
public class LoginController {

    private static Logger logger = LogManager.getLogger();

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @GetMapping("/principal")
    public Principal user(Principal principal) {
        return principal;
    }

    @GetMapping(path = "/test")
    public ResponseEntity<String> getStatus() {
        return new ResponseEntity<>("{\"result\":\"hello\"}", HttpStatus.OK);
    }


    @PostMapping("/signin")
    public ResponseEntity<UserDTO> findByName(@RequestBody LoginParams login) {
        if (Utils.isEmpty(login.getPassword()) || Utils.isEmpty(login.getLoginId())) {
            logger.error("Insufficient login Details"+login.toString());
            throw new ConstraintViolationException("User Id and password should not blank", Collections.emptySet());
        }
        UserDetails userdetails = userDetailsService.loadUserByUsername(login.getLoginId());

        Authentication auth = null;
        UserAssignedRoles role = null;
        try {
            byte[] photo = getDefaultPhoto();
            auth = authenticationService.findByName(login.getLoginId());

            /*if (auth.getaPhoto() == null || auth.getaPhoto().length < 1) {
                auth.setaPhoto(photo);

            }*/


            if (auth != null) {
                if (EncrytedPasswordUtils.checkPwd(login.getPassword(), auth.getaPwd())) {
                    System.out.println(auth.getSystem());
                    if (auth.getSystem().equals(Messages.SYSTEM)) {
                        try {
                            auth=authenticationService.findSystemUserPhoto(login.getLoginId());
                             if (auth.getaPhoto() == null || auth.getaPhoto().length < 1) {
                                auth.setaPhoto(photo);

                             }
                            System.out.println("testing");
                            role = authenticationService.getSystemUserAssignedRoles(auth.getaUserId(), auth.getaOrgId());
                        }catch(Exception e){
                            e.printStackTrace();
                            logger.info("login failed "+login.toString());
                            throw new ConstraintViolationException("Login Failed, Please contact Admin", Collections.emptySet());
                        }
                    } else if( auth.getSystem().equals(Messages.ADMIN)){

                    }else if(auth.getSystem().equals(Messages.MANAGEMENT)){

                    }else if(auth.getSystem().equals(Messages.STAFF)){
                        try {
                            auth=authenticationService.findSystemUserPhoto(login.getLoginId());
                            if (auth.getaPhoto() == null || auth.getaPhoto().length < 1) {
                                auth.setaPhoto(photo);

                            }
                            role = authenticationService.getUserAssignedRoles(auth.getaUserId(), auth.getaOrgId());
                        }catch(Exception e){
                            logger.info("login failed "+login.toString());
                            throw new ConstraintViolationException("Login Failed, Please contact Admin", Collections.emptySet());
                        }
                    }else if(auth.getSystem().equals(Messages.OTHERS)){

                    }else if(auth.getSystem().equals(Messages.PARENT)){

                    }else if(auth.getSystem().equals(Messages.STUDENT)){

                    }else{

                        logger.info("Login failed "+"Role not defined");
                        throw new ConstraintViolationException("Access Denied, Please contact Admin", Collections.emptySet());
                    }
                } else {
                    logger.info("Login failed "+"Role not defined");
                    throw new ConstraintViolationException("Access Denied, Please contact Admin", Collections.emptySet());
                }
            }

            return new ResponseEntity<>(mapperUser(auth, role), HttpStatus.OK);
        } catch (Exception e) {
            throw new ConstraintViolationException("Login Failed, Please contact Admin", Collections.emptySet());
        }

    }


    private UserDTO mapperUser(Authentication auth, UserAssignedRoles role) {
        UserDTO userObj = new UserDTO();
        userObj.setAaccountStatus(auth.isaAccountStatus());
        userObj.setAactiveInd(auth.isaActiveInd());
        userObj.setAemailId(auth.getaEmailId());
        userObj.setAfirstName(auth.getaFirstName());
        userObj.setAid(auth.getaId());
        userObj.setAlastLoggedIn(auth.getaLastLoggedIn());
        userObj.setAlastName(auth.getaLastName());
        userObj.setAloginCount(auth.getaLoginCount());
        userObj.setAloginId(auth.getaLoginId());
        userObj.setAorgId(auth.getaOrgId());
        userObj.setApwd(auth.getaPwd());
        userObj.setAtype(auth.getaType());
        userObj.setAuserId(auth.getaUserId());
        userObj.setRactiveInd(role.isR_active_ind());
        userObj.setRdesc(role.getR_desc());
        userObj.setRid(role.getR_id());
        userObj.setRtitle(role.getR_title());
        userObj.setPhoto(auth.getaPhoto());
        return userObj;

    }

    public byte[] getDefaultPhoto() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("images/photo/default.jpg").getFile());

        if (file.exists()) {
            try {
                return Files.readAllBytes(file.toPath());
            } catch (IOException ioe) {
                logger.error("Default image not found");
                return null;
            }
        }
        return null;
    }

}