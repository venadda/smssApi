package com.smss.api.system.controllers;


import com.smss.api.smssApi.apiclazz.SysUserPermissionParams;
import com.smss.api.smssApi.model.user.Userphoto;
import com.smss.api.system.exception.NoDataFoundException;
import com.smss.api.system.models.*;
import com.smss.api.system.services.SystemUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintViolationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@ControllerAdvice
@RestController
@CrossOrigin
@RequestMapping("/smss/system")
public class SystemController {
    private static Logger logger = LogManager.getLogger();

    @Autowired
    private SystemUserService systemUserService;
    /*
    @PostMapping("/findAllroles")
    List<Role> findAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles;
    }

    @PostMapping("/findAllUserRoles")
    List<UserRole> findAllUserRoles() {
        Optional<List<UserRole>> roles = userRoleRepository.findAllUserRoles(1);
        return roles.get();
    }*/

    @PostMapping("/findAllSystemUser")
    public ResponseEntity<List<SystemUser>> findAllSystemUser()  {
        List<SystemUser> users = null;
        try {
            users = systemUserService.getSystemUsers();
                if(Utils.isEmpty(users.toArray())){
                    throw new NoDataFoundException();
                }
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());
        }
        return new ResponseEntity(users, HttpStatus.OK);
    }
    @PostMapping("/findAllSystemUserDetails")
    public ResponseEntity<List<SystemUserDetails>> findAllSystemUserDetails() {
        List<SystemUserDetails> users = null;
        try{
            users = systemUserService.getSystemUserDetails();
            if(Utils.isEmpty(users.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());
        }
        return new ResponseEntity(users,HttpStatus.OK);

    }
    @PostMapping("/findAllUserDetails")
    public ResponseEntity<List<EmployeeDetails>> findAllUserDetails(@RequestBody SystemUserDetails userdetails ) {
        List<EmployeeDetails> users = null;
        try{
            users = systemUserService.getAllUserDetails(userdetails);
            if(Utils.isEmpty(users.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());
        }
        return new ResponseEntity(users,HttpStatus.OK);

    }
    @PostMapping("/findAllBranchUserDetails")
    public ResponseEntity<List<Employee>> findAllBranchUserDetails(@RequestBody Employee userdetails ) {
        List<Employee> users = null;
        try{
            users = systemUserService.getAllBranchUserDetails(userdetails);
            if(Utils.isEmpty(users.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());
        }
        return new ResponseEntity(users,HttpStatus.OK);

    }
    @PostMapping("/getUserAssignedModules")
    public ResponseEntity<List<SystemUserModules>> findSystemUserPermission(@RequestBody SysUserPermissionParams param) {
        System.out.println(param.toString());
        List<SystemUserModules> modules = null;
        try {
            modules = systemUserService.getUserAssignedModules(param.getUserid());
            if (Utils.isEmpty(modules.toArray()))
                throw new NoDataFoundException();
        } catch (Exception e) {
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());
        }

        return new ResponseEntity(modules, HttpStatus.OK);
    }
    @PostMapping("/organizationInsertUser")
    public ResponseEntity<List<Employee>> organizationInsertUser(@RequestBody Employee emp){
        List<Employee> employees = new ArrayList<Employee>();
        try{
            employees = systemUserService.getInsertUserDetails(emp);
            if(Utils.isEmpty(employees.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());
        }
        return new ResponseEntity<>(employees,HttpStatus.OK);

    }

    @PostMapping("/branchInsertUser")
    public ResponseEntity<List<Employee>> branchInsertUser(@RequestBody Employee emp){
        List<Employee> employees = new ArrayList<Employee>();
        try{
            employees = systemUserService.getInsertBranchUserDetails(emp);
            if(Utils.isEmpty(employees.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());
        }
        return new ResponseEntity<>(employees,HttpStatus.OK);

    }

    @PostMapping("/updateUser")
    public ResponseEntity<List<EmployeeDetails>> updateUser(@RequestBody Employee emp){
        List<EmployeeDetails> employees = new ArrayList<EmployeeDetails>();
        try{
            employees = systemUserService.getUpdateUserDetails(emp);
            if(Utils.isEmpty(employees.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());
        }
        return new ResponseEntity<>(employees,HttpStatus.OK);

    }

    @PostMapping("/branchUpdateUser")
    public ResponseEntity<List<EmployeeDetails>> branchUpdateUser(@RequestBody Employee emp){
        List<EmployeeDetails> employees = new ArrayList<EmployeeDetails>();
        try{
            employees = systemUserService.getUpdateBranchUserDetails(emp);
            if(Utils.isEmpty(employees.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());
        }
        return new ResponseEntity<>(employees,HttpStatus.OK);

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
    @PostMapping(value = "/getUserDummyPhoto")
    public ResponseEntity<UserPhoto> getUserDummyPhoto()  {
        UserPhoto uphoto = new UserPhoto();
        byte[] photo = null;
        try {
             photo = getDefaultPhoto();
             if(Utils.isEmpty(photo.toString()))
                throw new NoDataFoundException();
                uphoto.setU_photo(photo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug(e.getMessage());
           throw  new ConstraintViolationException("Error", Collections.emptySet());
        }
        return new ResponseEntity<>(uphoto,HttpStatus.OK);
    }

    /*@PostMapping(value = "/insertUserPhoto")
    public void insertUserPhoto(@RequestParam("file") MultipartFile file, @RequestParam("id") int id,
                                @RequestParam("uid") int userid, @RequestParam("uorgid") int orgid) {
        try {
            Userphoto photo = new Userphoto();
            photo.setUId(userid);
            photo.setUOrgId(orgid);
            photo.setUPhoto(file.getBytes());
            userPhotoRepository.save(photo);
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }*/

    /*@PostMapping("/getUserAssignedModules")
    public List<UserModuleDTO> getUserAssignedModules(@RequestBody int userid) {
        List<SystemUserModules> usermodule = sysUserPermissionRepository.findSystemUserPermission(param.getUserid(), param.getOrgid());
        List<UserModuleDTO> umodules = new ArrayList<UserModuleDTO>();
        for (Object[] obj : usermodule) {
            Usermodule obj1 = (Usermodule) obj[0];
            Module obj2 = (Module) obj[1];
            UserModuleDTO umodule = new UserModuleDTO();
            umodule.setDelete(obj1.getDelete());
            umodule.setDesc(obj2.getDesc());
            umodule.setEdit(obj1.getEdit());
            umodule.setId(obj1.getMid());
            umodule.setKeys(obj2.getKeys());
            umodule.setMid(obj1.getMid());
            umodule.setName(obj2.getName());
            umodule.setOrgid(obj1.getOrgid());
            umodule.setUmid(obj1.getUmid());
            umodule.setUserid(obj1.getUserid());
            umodule.setUview(obj1.getUview());
            umodule.setView(obj2.getView());
            umodules.add(umodule);
            System.out.println(obj1.getUview() + "\n" + obj2.getDesc());
        }
        System.out.println(usermodule.toString());
        return umodules;
    }

    @PostMapping("/findSystemUserType")
    public List<Usertype> findSystemUserType() {
        Optional<List<Usertype>> sysusertype = userTypeRepository.getSystemUserType();
        return sysusertype.get();
    }

    @PostMapping("/findUserType")
    public List<Usertype> findUserType() {
        Optional<List<Usertype>> usertypes = userTypeRepository.getUserType();
        return usertypes.get();
    }

    //,consumes ={"multipart/form-data"}
    @CrossOrigin
    @PostMapping(value = "/insertUserPhoto")
    public void insertUserPhoto(@RequestParam("file") MultipartFile file, @RequestParam("id") int id,
                                @RequestParam("uid") int userid, @RequestParam("uorgid") int orgid) {
        try {
            Userphoto photo = new Userphoto();
            photo.setUId(userid);
            photo.setUOrgId(orgid);
            photo.setUPhoto(file.getBytes());
            userPhotoRepository.save(photo);
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    @PostMapping(value = "/getUserProfile")
    public UserphotoDTO insertUserPhoto() {
        Optional<Userphoto> userphotos = userPhotoRepository.findPhotoById(1, 1);
        if (userphotos.isPresent()) {
            UserphotoDTO userphoto = new UserphotoDTO();
            userphoto.setId(userphotos.get().getId());
            userphoto.setUId(userphotos.get().getUId());
            userphoto.setUOrgId(userphotos.get().getUOrgId());
            userphoto.setUPhoto(userphotos.get().getUPhoto());
            return userphoto;
        } else {
            return null;
        }

    }*/

}
