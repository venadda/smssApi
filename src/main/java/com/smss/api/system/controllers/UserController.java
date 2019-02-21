package com.smss.api.system.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.smss.api.smssApi.apiclazz.*;
import com.smss.api.smssApi.model.user.Userphoto;
import com.smss.api.system.exception.InsufficientDataException;
import com.smss.api.system.exception.NoDataFoundException;
import com.smss.api.system.models.*;
import com.smss.api.system.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.prefs.NodeChangeEvent;

@CrossOrigin
@ControllerAdvice
@RestController
@RequestMapping("/smss/user")
public class UserController {
    private static Logger logger = LogManager.getLogger();
    @Autowired
    private UserService userService;

    @PostMapping("/getTeacherDetails")
    private ResponseEntity<TeacherDetails> getTeacherDetails(@RequestBody EmployeeParam emp){
        TeacherDetails teacherDetails=null;
        try {
            teacherDetails = userService.getTeacherDetails(emp);
        }catch(Exception e){e.printStackTrace();}
        return new ResponseEntity(teacherDetails,HttpStatus.OK);
    }
    @PostMapping("/getOrgUserByName")
    private ResponseEntity<List<Employee>> getOrgUserByName(@RequestBody EmployeeParam emp)  {
        List<Employee> empdata = null;
        try{
            if(Utils.isEmpty(emp.toString())){
                throw new InsufficientDataException();
            }
            empdata = userService.getOrgUserByName(emp);
            if(Utils.isEmpty(empdata.toArray()))
            {
                throw new NoDataFoundException();
            }

        }catch (Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());
        }
        return new ResponseEntity(empdata, HttpStatus.OK);
        }
    @PostMapping("/allUser")
    private ResponseEntity<List<Employee>> allUser(@RequestBody EmployeeParam emp)  {
        List<Employee> empdata = null;
        try{
            byte[] photo = getDefaultPhoto();
            empdata =userService.allUser(emp);
            for(Employee lemp:empdata){
                if(Objects.isNull(lemp.getU_photo()))
                    lemp.setU_photo(photo);
            }
            if(Utils.isEmpty(empdata.toArray())) {
                throw new NoDataFoundException("No Record Found");
            }
            }catch(Exception e) {
            e.printStackTrace();
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }

        return new ResponseEntity(empdata, HttpStatus.OK);
    }

    @PostMapping("/allRoles")
    private ResponseEntity<List<Roles>> getAllRoles(){
        List<Roles> roles = new ArrayList<Roles>();
        try{
            roles = userService.getAllRoles();

        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());
        }
        return new ResponseEntity(roles,HttpStatus.OK);
    }

    @PostMapping("/insertteacher")
    private ResponseEntity<String> insertTeacher(@RequestBody ObjectNode object ){
         /*ObjectMapper objectMapper = new ObjectMapper();
        JsonNode newNode = objectMapper.valueToTree(object);

        System.out.println(newNode);
        JsonNode achievements = newNode.path("userAchievements");
        System.out.println(achievements);*/
         try {
             userService.insertTeacher(object);
         }catch(Exception e){
             e.printStackTrace();
             logger.error(e.getMessage());
         }
        return new ResponseEntity(null);
    }

    @PostMapping("/allUserByRole")
    private ResponseEntity<List<Employee>> allUserByRole(@RequestBody EmployeeParam emp)  {
        List<Employee> empdata = null;
        try{
            System.out.println(emp);
            byte[] photo = getDefaultPhoto();
            empdata =userService.allUserByRole(emp);
            System.out.println(empdata.toString());
            for(Employee lemp:empdata){
                if(Objects.isNull(lemp.getU_photo()))
                    lemp.setU_photo(photo);
            }
            if(Utils.isEmpty(empdata.toArray())) {
                throw new NoDataFoundException("No Record Found");
            }
        }catch(Exception e) {
            e.printStackTrace();
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }

        return new ResponseEntity(empdata, HttpStatus.OK);
    }
    @PostMapping("/insertUser")
    private ResponseEntity<String> insertUser(@RequestBody Employee emp) {

        try {
            System.out.println("testing");
            if (userService.insertUser(emp))
                return new ResponseEntity(true, HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        //  Employee emp = objectMapper.readValue(values.get("emp").toString(), Employee.class);
       // Audit action = objectMapper.readValue(values.get("action").toString(),Audit.class);

        /*try{
            if(Utils.isEmpty(emp.toString())){
                throw new InsufficientDataException("Insufficient details");
            }
            empdata = userService.insertUser(emp,action);
            if(Utils.isEmpty(empdata.toArray())){
                throw new NoDataFoundException("No Record Found");
            }
        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }*/
        return new ResponseEntity(true, HttpStatus.OK);
    }


    @PostMapping("/updateUser")
    private ResponseEntity<Boolean> updateUser(@RequestBody Employee emp) {
        try {
            System.out.println("testing");
            if (userService.updateUser(emp))
                return new ResponseEntity(true, HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        /*ObjectMapper objectMapper = new ObjectMapper();
        Employee emp = objectMapper.readValue(values.get("emp").toString(), Employee.class);
        Audit action = objectMapper.readValue(values.get("action").toString(), Audit.class);
        try{
            empdata = userService.updateUser(emp,action);
            if(Utils.isEmpty(emp.toString())){
                throw new InsufficientDataException("Insufficient details");
            }
            if(Utils.isEmpty(empdata.toArray())){
                throw new NoDataFoundException("No Record Found");
            }
        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }*/
        return new ResponseEntity(true, HttpStatus.OK);
    }
    @PostMapping("/deleteUser")
    private ResponseEntity<List<Employee>> deleteUser(@RequestBody  ObjectNode values) {
        List<Employee> empdata = null;
        /*ObjectMapper objectMapper = new ObjectMapper();
        EmployeeParam emp = objectMapper.readValue(values.get("emp").toString(), EmployeeParam.class);
        ActionParam action = objectMapper.readValue(values.get("action").toString(), ActionParam.class);
        try{
            if(Utils.isEmpty(emp.toString())){
                throw new InsufficientDataException();
            }
            empdata = userService.deleteUser(emp);
            if(Utils.isEmpty(empdata.toArray())){
                throw new NoDataFoundException();
            }
        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }*/
        return new ResponseEntity(empdata, HttpStatus.OK);
    }
    @PostMapping("/updateBulkUser")
    private ResponseEntity<List<Employee>> updateBulkUser(@RequestBody ObjectNode values) {
        List<Employee> empdata = null;
        /*ObjectMapper objectMapper = new ObjectMapper();
        List<Employee> emps = objectMapper.readValue(values.get("emps").toString(), new TypeReference<List<Employee>>(){});
        ActionParam action = objectMapper.readValue(values.get("action").toString(), ActionParam.class);
        try{
            if(Utils.isEmpty(emps.toArray())){
                throw new InsufficientDataException();
            }
            empdata = userService.updateBulkUser(emps);
            if(Utils.isEmpty(empdata.toArray())){
                throw new NoDataFoundException();
            }
        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }*/
        return new ResponseEntity(empdata, HttpStatus.OK);
    }

    @PostMapping("/insertBulkUser")
    private ResponseEntity<List<Employee>> insertBulkUser(@RequestBody ObjectNode values) {
        ObjectMapper objectMapper = new ObjectMapper();
        /*List<Employee> emps = objectMapper.readValue(values.get("emps").toString(), new TypeReference<List<Employee>>(){});
        ActionParam action = objectMapper.readValue(values.get("action").toString(), ActionParam.class);
        List<Employee> empdata = null;
        try{
                if(Utils.isEmpty(emps.toArray())){
                    throw new InsufficientDataException();
                }
                empdata = userService.insertBulkUser(emps);
                if(Utils.isEmpty(empdata.toArray())){
                    throw new NoDataFoundException();
                }
        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }*/
        return new ResponseEntity(null, HttpStatus.OK);
    }
    @PostMapping("/orgUserById")
    private ResponseEntity<List<Employee>> orgUserById(@RequestBody EmployeeParam emp) {
        List<Employee> empdata = null;
        try{
            if(Utils.isEmpty(emp.toString())){
                throw new InsufficientDataException();
            }
            empdata = userService.orgUserById(emp);
            if(Utils.isEmpty(empdata.toArray())){
                throw new NoDataFoundException();
            }

        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(empdata, HttpStatus.OK);
    }
    @PostMapping("/orgUserByEmailId")
    private ResponseEntity<List<Employee>> orgUserByEmailId(@RequestBody EmployeeParam emp) {
        List<Employee> empdata = null;
        try{
            if(Utils.isEmpty(emp.toString())){
                throw new InsufficientDataException();
            }
            empdata = userService.orgUserByEmailId(emp);
            if(Utils.isEmpty(empdata.toArray())){
                throw new NoDataFoundException();
            }
        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(empdata, HttpStatus.OK);
    }
    @PostMapping("/orgUserByName")
    private ResponseEntity<List<Employee>> orgUserByName(@RequestBody EmployeeParam emp) {
        List<Employee> empdata = null;
        try{
            if(Utils.isEmpty(emp.toString())){

                throw new InsufficientDataException();
            }
            empdata = userService.getOrgUserByName(emp);
            if(Utils.isEmpty(empdata.toArray())){
                throw new NoDataFoundException();
            }
        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(empdata, HttpStatus.OK);
    }


    @PostMapping("/insertUserPhoto")
    private ResponseEntity<List<Userphoto>> insertUserPhoto(){
        List<Userphoto> userphoto = null;
        try{

        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(userphoto, HttpStatus.OK);
    }
    @PostMapping("/updateUserPhoto")
    private ResponseEntity<List<Userphoto>> updateUserPhoto(){
        List<Userphoto> userphoto = null;
        try{
    }catch(Exception e){
        logger.debug(e.getMessage());
        throw new ConstraintViolationException("Error", Collections.emptySet());

    }
        return new ResponseEntity(userphoto, HttpStatus.OK);
    }
    @PostMapping("/userPhotoById")
    private ResponseEntity<List<Userphoto>> userPhotoById(){
        List<Userphoto> userphoto = null;
        try{

        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(userphoto, HttpStatus.OK);
    }
    @PostMapping("/deleteUserPhoto")
    private ResponseEntity<List<Userphoto>> deleteUserPhoto(){
        List<Userphoto> userphoto = null;
        try{

        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(userphoto, HttpStatus.OK);
    }
    @PostMapping("/getAllOthers")
    private ResponseEntity<List<Others>> getAllOthers(@RequestBody EmployeeParam other) {
        List<Others> others = null;
        try{
            if(Utils.isEmpty(other.toString())){
                throw new InsufficientDataException();
            }
            others = userService.getAllOthers(other);
            if(Utils.isEmpty(others.toArray())){
                throw new NoDataFoundException();
            }
        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(others, HttpStatus.OK);
    }
    @PostMapping("/insertOthers")
    private ResponseEntity<List<Others>> insertOthers(@RequestBody ObjectNode values) {
        List<Others> others = null;
       /* ObjectMapper objectMapper = new ObjectMapper();
        Others other = objectMapper.readValue(values.get("others").toString(), Others.class);
        ActionParam action = objectMapper.readValue(values.get("action").toString(), ActionParam.class);
        try{
            if(Utils.isEmpty(other.toString())){
                throw new InsufficientDataException();
            }

            others = userService.insertOthers(other);
            if(Utils.isEmpty(others.toArray())){
                throw new NoDataFoundException();
            }
        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }*/
        return new ResponseEntity(others, HttpStatus.OK);   }


        @PostMapping("/updateOthers")
        private ResponseEntity<List<Others>> updateOthers(@RequestBody ObjectNode values) {
        List<Others> others = null;
        /*ObjectMapper objectMapper = new ObjectMapper();
        Others other = objectMapper.readValue(values.get("others").toString(), Others.class);
        ActionParam action = objectMapper.readValue(values.get("action").toString(), ActionParam.class);
        try{
            if(Utils.isEmpty(other.toString())){
                throw new InsufficientDataException();
            }
            others = userService.updateOthers(other);
            if(Utils.isEmpty(others.toArray())){
                throw new NoDataFoundException();
            }
        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }*/
        return new ResponseEntity(others, HttpStatus.OK);
    }
    @PostMapping("/getOthersById")
    private ResponseEntity<List<Others>> getOthersById(@RequestBody EmployeeParam param) {
        List<Others> others = null;
        try{
            if(Utils.isEmpty(param.toString())){
                throw new InsufficientDataException();
            }
            others = userService.getOthersById(param);
            if(Utils.isEmpty(others.toArray())){
                throw new NoDataFoundException();
            }
        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(others, HttpStatus.OK);
    }
    @PostMapping("/deleteOthers")
    private ResponseEntity<List<Others>> deleteOthers(@RequestBody ObjectNode values) {
        List<Others> others = null;
        /*ObjectMapper objectMapper = new ObjectMapper();
        EmployeeParam param = objectMapper.readValue(values.get("param").toString(), EmployeeParam.class);
        ActionParam action = objectMapper.readValue(values.get("action").toString(), ActionParam.class);
        try{
            if(Utils.isEmpty(param.toString())){
                throw new InsufficientDataException();
            }
            others = userService.deleteOthers(param);
            if(Utils.isEmpty(others.toArray())){
                throw new NoDataFoundException();
            }
        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }*/
        return new ResponseEntity(others, HttpStatus.OK);
    }

    @PostMapping("/getUserAssignedRolesByUserId")
    private ResponseEntity<List<UserRoles>> UserAssignedRolesByUserId(@RequestBody RoleParams params) {
        List<UserRoles> empdata = null;
        try{

        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return null;//new ResponseEntity(userService.UserAssignedRolesByUserId(params), HttpStatus.OK);
    }

    @PostMapping("/getAllUserAndRoles")
    private ResponseEntity<List<UserRoles>> allUserAndRoles(@RequestBody RoleParams params) {
        List<UserRoles> empdata = null;
        try{

        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return null;//new ResponseEntity(userService.allUserAndRoles(params), HttpStatus.OK);
    }
    @PostMapping("/getAssignRolesToUser")
    private ResponseEntity<List<UserRoles>> assignRolesToUser(@RequestBody OrgUserRoles roles ) {
        List<UserRoles> empdata = null;
        try{

        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return null;//new ResponseEntity(userService.assignRolesToUser(roles), HttpStatus.OK);
          }
    /* user modules */

    @PostMapping("/getUserAssignedModulesById")
    private ResponseEntity<List<SystemUserModules>> userAssignedModulesById(@RequestBody  SysUserPermissionParams param)  {

        try{

        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return null;//new ResponseEntity(userService.userAssignedModulesById(param), HttpStatus.OK);
    }
    @PostMapping("/getInsertUserModule")
    private ResponseEntity<List<SystemUserModules>> insertUserModule(@RequestBody ObjectNode values)  {

        /*ObjectMapper objectMapper = new ObjectMapper();
        Usermodule module = objectMapper.readValue(values.get("module").toString(), Usermodule.class);
        ActionParam action = objectMapper.readValue(values.get("action").toString(), ActionParam.class);
        try{

        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }*/
        return null;//new ResponseEntity(userService.insertUserModule(module), HttpStatus.OK);
    }
    @PostMapping("/getUpdateUserModule")
    private ResponseEntity<List<SystemUserModules>> updateUserModule(@RequestBody ObjectNode values) {
        /*ObjectMapper objectMapper = new ObjectMapper();
        Usermodule module = objectMapper.readValue(values.get("module").toString(), Usermodule.class);
        ActionParam action = objectMapper.readValue(values.get("action").toString(), ActionParam.class);
        try{

        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }*/
        return null;// new ResponseEntity(userService.updateUserModule(module), HttpStatus.OK);
    }
    @PostMapping("/auditDetailsByDateRange")
    private ResponseEntity<List<Audit>>  auditDetailsByDateRange(@RequestBody AuditParam param){
        List<Audit> empdata = null;
        try{

        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return null;//new ResponseEntity(userService.auditDetailsByDateRange(param), HttpStatus.OK);
    }
    @PostMapping("/auditDetailsByDate")
    private ResponseEntity<List<Audit>>  auditDetailsByDate(@RequestBody AuditParam param){
        try{

        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        System.out.println(param.toString());
        return null;//new ResponseEntity(userService.auditDetailsByDate(param), HttpStatus.OK);
    }
    @PostMapping("/auditDetailsByCurrentDate")
    private ResponseEntity<List<Audit>>  auditDetailsByCurrentDate(@RequestBody AuditParam param){
        try{

        }catch(Exception e){
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return null;//new ResponseEntity(userService.auditDetailsByCurrentDate(param), HttpStatus.OK);
    }
    @PostMapping("/allGenerics")
    private ResponseEntity<List<Generics>>  allGenerics(){
        List<Generics> generics = null;
        try{
            generics = userService.allGenerics();
            if(Utils.isEmpty(generics.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(generics, HttpStatus.OK);
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

/*============================================================================================================*/
    /* previous history */
    /* education history*/
    /* achievement history*/
    /* training given */
    /* training received*/

    @PostMapping("/insertUserJoiningDetails")
    public ResponseEntity<List<JoiningInfo>> insertUserJoiningDetails(@RequestBody JoiningInfo joinings) throws Exception {
        List<JoiningInfo> joining = null;
        try{
            joining = userService.insertUserJoiningDetails(joinings);

            if(Utils.isEmpty(joining.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(joining,HttpStatus.OK);


    }
    @PostMapping("/updateUserJoiningDetails")
    public ResponseEntity<List<JoiningInfo>> updateUserJoiningDetails(@RequestBody List<JoiningInfo> joinings)throws Exception {
        List<JoiningInfo> joining = null;
        try{
            joining = userService.updateUserJoiningDetails(joinings);
            if(Utils.isEmpty(joining.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(joining,HttpStatus.OK);
    }

    @PostMapping("/deleteUserJoiningDetails")
    public ResponseEntity<List<JoiningInfo>> deleteUserJoiningDetails(@RequestBody List<JoiningInfo> joinings)throws Exception {
        List<JoiningInfo> joining = null;
        try{
            joining = userService.deleteUserJoiningDetails(joinings);
            if(Utils.isEmpty(joining.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(joining,HttpStatus.OK);


    }
    @PostMapping("/userJoiningDetailsById")
    public ResponseEntity<List<JoiningInfo>> userJoiningDetailsById(@RequestBody JoiningInfo joining)throws Exception {
        List<JoiningInfo> joinings = null;
        try{
            joinings = userService.userJoiningDetailsById(joining);
            if(Utils.isEmpty(joinings.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(joinings,HttpStatus.OK);

    }
    @PostMapping("/userActiveJoiningDetails")
    public ResponseEntity<List<JoiningInfo>> userActiveJoiningDetails(@RequestBody JoiningInfo joinings)throws Exception {
        List<JoiningInfo> joining = null;
        try{
            joining = userService.userActiveJoiningDetails(joinings);
            if(Utils.isEmpty(joining.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(joining,HttpStatus.OK);


    }
    @PostMapping("/insertUserTrainingInfo")
    public ResponseEntity<List<TeacherTrainingReceived>> insertUserTrainingInfo(@RequestBody List<TeacherTrainingReceived> trainings)throws Exception {
        List<TeacherTrainingReceived> training = null;
        try{
            training = userService.insertUserTrainingInfo(trainings);
            if(Utils.isEmpty(training.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(training,HttpStatus.OK);


    }
    @PostMapping("/updateUserTrainingInfo")
    public ResponseEntity<List<TeacherTrainingReceived>> updateUserTrainingInfo(@RequestBody List<TeacherTrainingReceived> trainings)throws Exception {
        List<TeacherTrainingReceived> training = null;
        try{
            training = userService.updateUserTrainingInfo(trainings);
            if(Utils.isEmpty(training.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(training,HttpStatus.OK);


    }
    @PostMapping("/deleteUserTrainingInfo")
    public ResponseEntity<List<TeacherTrainingReceived>> deleteUserTrainingInfo(@RequestBody List<TeacherTrainingReceived> trainings)throws Exception {
        List<TeacherTrainingReceived> training = null;
        try{
            training = userService.deleteUserTrainingInfo(trainings);
            if(Utils.isEmpty(training.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(training,HttpStatus.OK);

    }
    @PostMapping("/userTrainingInfoById")
    public ResponseEntity<List<TeacherTrainingReceived>> userTrainingInfoById(@RequestBody TeacherTrainingReceived training)throws Exception {
        List<TeacherTrainingReceived> trainings = null;
        try{
            trainings = userService.userTrainingInfoById(training);
            if(Utils.isEmpty(trainings.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(trainings,HttpStatus.OK);

    }

    /*public  insertUserHistory() {
        return insertUserHistory;
    }

    public String updateUserHistory() {
        return updateUserHistory;
    }

    public String deleteUserHistory() {
        return deleteUserHistory;
    }

    public String userHistoryById() {
        return userHistoryById;
    }
*/
    @PostMapping("/insertUserPreviousHistory")
    public ResponseEntity<List<PreviousServiceHistory>> insertUserPreviousHistory(@RequestBody List<PreviousServiceHistory> histories)throws Exception {
        List<PreviousServiceHistory> history = null;
        try{
            history = userService.insertUserPreviousHistory(histories);
            if(Utils.isEmpty(history.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(history,HttpStatus.OK);

    }
    @PostMapping("/updateUserPreviousHistory")
    public ResponseEntity<List<PreviousServiceHistory>> updateUserPreviousHistory(@RequestBody List<PreviousServiceHistory> histories)throws Exception {
        List<PreviousServiceHistory> history = null;
        try{
            history = userService.updateUserPreviousHistory(histories);
            if(Utils.isEmpty(history.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(history,HttpStatus.OK);


    }
    @PostMapping("/deleteUserPreviousHistory")
    public ResponseEntity<List<PreviousServiceHistory>> deleteUserPreviousHistory(@RequestBody List<PreviousServiceHistory> histories)throws Exception {
        List<PreviousServiceHistory> history = null;
        try{
            history = userService.deleteUserPreviousHistory(histories);
            if(Utils.isEmpty(history.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(history,HttpStatus.OK);

    }
    @PostMapping("/userPreviousHistoryById")
    public ResponseEntity<List<PreviousServiceHistory>> userPreviousHistoryById(@RequestBody PreviousServiceHistory history)throws Exception {
        List<PreviousServiceHistory> histories = null;
        try{
            histories = userService.userPreviousHistoryById(history);
            if(Utils.isEmpty(histories.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(history,HttpStatus.OK);


    }
    @PostMapping("/insertUserEducationInfo")
    public ResponseEntity<List<EducationInfo>> insertUserEducationInfo(@RequestBody List<EducationInfo> educations)throws Exception {

        List<EducationInfo> education = null;
        try{
            education = userService.insertUserEducationInfo(educations);
            if(Utils.isEmpty(education.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(education,HttpStatus.OK);

    }
    @PostMapping("/updateUserEducationInfo")
    public ResponseEntity<List<EducationInfo>> updateUserEducationInfo(@RequestBody List<EducationInfo> educations)throws Exception {
        List<EducationInfo> education = null;
        try{
            education = userService.updateUserEducationInfo(educations);
            if(Utils.isEmpty(education.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(education,HttpStatus.OK);

    }
    @PostMapping("/deleteUserEducationInfo")
    public ResponseEntity<List<EducationInfo>> deleteUserEducationInfo(@RequestBody List<EducationInfo> educations)throws Exception {
        List<EducationInfo> education = null;
        try{
            education = userService.deleteUserEducationInfo(educations);
            if(Utils.isEmpty(education.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(education,HttpStatus.OK);

    }
    @PostMapping("/userEducationInfoById")
    public ResponseEntity<List<EducationInfo>> userEducationInfoById(@RequestBody EducationInfo education)throws Exception {
        List<EducationInfo> educations = null;
        try{
            educations = userService.userEducationInfoById(education);
            if(Utils.isEmpty(educations.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(educations,HttpStatus.OK);

    }
    @PostMapping("/insertTrainingGiven")
    public ResponseEntity<List<TeacherTrainingGiven>> insertTrainingGiven(@RequestBody List<TeacherTrainingGiven> trainings)throws Exception {
        List<TeacherTrainingGiven> training = null;
        try{
            training = userService.insertTrainingGiven(trainings);
            if(Utils.isEmpty(training.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(training,HttpStatus.OK);

    }
    @PostMapping("/deleteTrainingGiven")
    public ResponseEntity<List<TeacherTrainingGiven>> deleteTrainingGiven(@RequestBody List<TeacherTrainingGiven> trainings)throws Exception {
        List<TeacherTrainingGiven> training = null;
        try{
            training = userService.deleteTrainingGiven(trainings);
            if(Utils.isEmpty(training.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(training,HttpStatus.OK);

    }
    @PostMapping("/updateTrainingGiven")
    public ResponseEntity<List<TeacherTrainingGiven>> updateTrainingGiven(@RequestBody List<TeacherTrainingGiven> trainings) throws Exception{
        List<TeacherTrainingGiven> training = null;
        try{
            training = userService.updateTrainingGiven(trainings);
            if(Utils.isEmpty(training.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(training,HttpStatus.OK);


    }
    @PostMapping("/trainingGevenById")
    public ResponseEntity<List<TeacherTrainingGiven>> trainingGevenById(@RequestBody TeacherTrainingGiven training) throws Exception{

        List<TeacherTrainingGiven> trainings = null;
        try{
            trainings = userService.trainingGevenById(training);
            if(Utils.isEmpty(trainings.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(trainings,HttpStatus.OK);



    }
    @PostMapping("/insertAchievements")
    public ResponseEntity<List<Achievements>> insertAchievements(@RequestBody List<Achievements> achievements) throws Exception{

        List<Achievements> achievement = null;
        try{
            achievement = userService.insertAchievements(achievements);
            if(Utils.isEmpty(achievement.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(achievement,HttpStatus.OK);
   }
    @PostMapping("/deleteAchievements")
    public ResponseEntity<List<Achievements>> deleteAchievements(@RequestBody List<Achievements> achievements) throws Exception{
        List<Achievements> achievement = null;
        try{
            achievement = userService.deleteAchievements(achievements);
            if(Utils.isEmpty(achievement.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(achievement,HttpStatus.OK);

    }
    @PostMapping("/updateAchievements")

    public ResponseEntity<List<Achievements>> updateAchievements(@RequestBody List<Achievements> achievements) throws Exception{
        List<Achievements> achievement = null;
        try{
            achievement = userService.updateAchievements(achievements);
            if(Utils.isEmpty(achievement.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(achievement,HttpStatus.OK);


    }
    @PostMapping("/achievementsById")
    public ResponseEntity<List<Achievements>> achievementsById(@RequestBody Achievements achievement) throws Exception{
        List<Achievements> achievements = null;
        try{
            achievements = userService.achievementsById(achievement);
            if(Utils.isEmpty(achievements.toArray()))
                throw new NoDataFoundException();
        }catch(Exception e){
            e.printStackTrace();
            logger.debug(e.getMessage());
            logger.info(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());

        }
        return new ResponseEntity(achievements,HttpStatus.OK);


    }
    @PostMapping("/insertUserDisabilities")
    public ResponseEntity<List<UserDisabilities>> insertUserDisabilities(@RequestBody List<UserDisabilities> disabilities){
        List<UserDisabilities> userDisabilities = null;
        try {
            userDisabilities = userService.insertUserDisabilities(disabilities);
        }catch(Exception e){
            logger.error(e.getMessage());
            throw new ConstraintViolationException("Error",Collections.emptySet());
        }
        return new ResponseEntity<>(userDisabilities,HttpStatus.OK);
    }
    @PostMapping("/updateUserDisabilities")
    public ResponseEntity<List<UserDisabilities>> updateUserDisabilities(@RequestBody List<UserDisabilities> disabilities){
        List<UserDisabilities> userDisabilities = null;
        try {
            userDisabilities = userService.updateUserDisabilities(disabilities);
        }catch(Exception e){
            logger.error(e.getMessage());
            throw new ConstraintViolationException("Error",Collections.emptySet());
        }
        return new ResponseEntity<>(userDisabilities,HttpStatus.OK);
    }
    @PostMapping("/deleteUserDisabilities")
    public ResponseEntity<List<UserDisabilities>> deleteUserDisabilities(@RequestBody List<UserDisabilities> disabilities){
        List<UserDisabilities> userDisabilities = null;
        try {
            userDisabilities = userService.deleteDisabilities(disabilities);
        }catch(Exception e){
            logger.error(e.getMessage());
            throw new ConstraintViolationException("Error",Collections.emptySet());
        }
        return new ResponseEntity<>(userDisabilities,HttpStatus.OK);
    }
    @PostMapping("/getUserDisabilitiesById")
    public ResponseEntity<List<UserDisabilities>> getUserDisabilitiesById(@RequestBody UserDisabilities disability){
        List<UserDisabilities> userDisabilities = null;
        try {
            userDisabilities = userService.getUserDisabilitiesById(disability);
        }catch(Exception e){
            logger.error(e.getMessage());
            throw new ConstraintViolationException("Error",Collections.emptySet());
        }
        return new ResponseEntity<>(userDisabilities,HttpStatus.OK);
    }
    @PostMapping("/userAdmissionRequest")
    public ResponseEntity<String> userAdmissionRequest(@RequestBody StudentAdmission admission){
        String registrationno = "";
        try{
            registrationno = userService.userAdmissionRequest(admission);
        }catch(Exception e){
            e.printStackTrace();
            registrationno="";
        }
        return new ResponseEntity(registrationno,HttpStatus.OK);
    }
    @PostMapping("/insertStudentEnrollment")
    public ResponseEntity<List<StudentAdmission>> insertStudentEnrollment(@RequestBody StudentAdmission admission){
        List<StudentAdmission> admissions = null;

        try{
            admissions = userService.insertStudentEnrollment(admission);
        }catch(Exception e){
            e.printStackTrace();
            admissions=null;
        }
        return new ResponseEntity(admissions,HttpStatus.OK);
    }
    @PostMapping("/getEnrolledStudentByCourse")
    public ResponseEntity<List<StudentAdmission>> getEnrolledStudentByCourse(@RequestBody StudentAdmission admission){
        List<StudentAdmission> admissions = new ArrayList<StudentAdmission>();
        try{
            admissions = userService.getEnrolledStudentByCourse(admission);
        }catch(Exception e){

        }
        return new ResponseEntity(admissions,HttpStatus.OK);
    }

    @PostMapping("/getEnrolledStudentById")
    public ResponseEntity<List<StudentAdmission>> getEnrolledStudentById(@RequestBody StudentAdmission admission) {
        List<StudentAdmission> admissions = new ArrayList<StudentAdmission>();
        try{
            admissions = userService.getEnrolledStudentById(admission);
        }catch(Exception e){

        }
        return new ResponseEntity(admissions,HttpStatus.OK);
    }
    @PostMapping("/getEnrolledStudentList")
    public ResponseEntity<List<StudentAdmission>> getEnrolledStudentList(@RequestBody StudentAdmission admission){
        System.out.println(admission.toString());
        List<StudentAdmission> admissions = new ArrayList<StudentAdmission>();
        try{
            admissions = userService.getEnrolledStudentList(admission);
        }catch(Exception e){

        }
        return new ResponseEntity(admissions,HttpStatus.OK);
    }
    @PostMapping("/insertStudent")
    public ResponseEntity<List<Student>> insertStudent(@RequestBody Student student) {
        List<Student> students = new ArrayList<Student>();
        try{
            students = userService.insertStudent(student);

        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(students,HttpStatus.OK);
    }

    @PostMapping("/studentsListByClass")
    public ResponseEntity<List<Student>> studentsListByClass(@RequestBody Student student){
        List<Student> students = new ArrayList<Student>();
        try{
            students = userService.studentsListByClass(student);
            for(Student stud:students) {
                if (stud.getS_photo() == null || Utils.isEmpty(stud.getS_photo().toString()))
                    stud.setS_photo(getDefaultPhoto());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(students,HttpStatus.OK);
    }
    @PostMapping("/parentSearchByNameAndContact")
    public ResponseEntity<List<Parent>> getParentSearchByNameAndContact(@RequestBody Parent parent){
        List<Parent> parents = new ArrayList<Parent>();
        try{
            parents = userService.getParentSearchByNameAndContact(parent);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(parents,HttpStatus.OK);
    }

    @PostMapping("/insertAdmissions")
    public ResponseEntity<List<AdmissionYears>> insertAdmissionsYear(@RequestBody  AdmissionYears admission){
        List<AdmissionYears> admissions = new ArrayList<AdmissionYears>();
        try{
            admissions = userService.insertAdmissionsYear(admission);
        }catch(Exception e){
            return new ResponseEntity(null,HttpStatus.OK);
        }
        return new ResponseEntity(admissions,HttpStatus.OK);
    }

    @PostMapping("/updateAdmissions")
    public ResponseEntity<List<AdmissionYears>> updateAdmissionsYear(@RequestBody AdmissionYears admission){
        List<AdmissionYears> admissions = new ArrayList<AdmissionYears>();
        try{
            admissions = userService.updateAdmissionsYear(admission);
        }catch(Exception e){
            return new ResponseEntity(null,HttpStatus.OK);
        }
        return new ResponseEntity(admissions,HttpStatus.OK);
    }
    @PostMapping("/deleteAdmissions")
    public ResponseEntity<List<AdmissionYears>> deleteAdmissionsYear(@RequestBody AdmissionYears admission){
        List<AdmissionYears> admissions = new ArrayList<AdmissionYears>();
        try{
            admissions = userService.deleteAdmissionsYear(admission);
        }catch(Exception e){
            return new ResponseEntity(null,HttpStatus.OK);
        }
        return new ResponseEntity(admissions,HttpStatus.OK);
    }
    @PostMapping("/getAllAdmissionYears")
    public ResponseEntity<List<AdmissionYears>> getAllAdmissionYears(@RequestBody AdmissionYears admission) {
        List<AdmissionYears> admissions = new ArrayList<AdmissionYears>();
        try{
            admissions = userService.getAllAdmissionYears(admission);
        }catch(Exception e){
            return new ResponseEntity(null,HttpStatus.OK);
        }
        return new ResponseEntity(admissions,HttpStatus.OK);
    }
    @PostMapping("/getActiveAdmissionYear")
    public ResponseEntity<List<AdmissionYears>> getActiveAdmissionYear(@RequestBody AdmissionYears admission){
            System.out.println(admission.toString());
        List<AdmissionYears> admissions = new ArrayList<AdmissionYears>();
        try{
            admissions = userService.getActiveAdmissionYear(admission);
        }catch(Exception e){
            return new ResponseEntity(null,HttpStatus.OK);
        }
        return new ResponseEntity(admissions,HttpStatus.OK);
    }



}


