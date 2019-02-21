package com.smss.api.system.daos;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.smss.api.app.database.EmssDB;
import com.smss.api.smssApi.apiclazz.*;
import com.smss.api.system.mapper.*;
import com.smss.api.system.models.*;
import org.reflections.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Transactional
@Repository
public class UserDao {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private EmssDB queries;
    public void insertTeacher(ObjectNode object) throws Exception{

        List<PreviousServiceHistory> prevServiceHistory = null;
        Employee employee = null;
        JoiningInfo joiningInfo = null;
        List<TeacherTrainingReceived> teacherTrainingReceived=null;
        List<TeacherTrainingGiven> teacherTrainingGiven=null;
        List<EducationInfo> qualifications=null;
        List<UserDisabilities> userDisabilities = null;
        List<Achievements> achievements = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.disable(SerializationFeature.WRITE_DATES_WITH_ZONE_ID);

        JsonNode dataNode = objectMapper.valueToTree(object);
        System.out.println(dataNode);
        JsonNode empNode = dataNode.path("employee");
        JsonNode joiningNode = dataNode.path("joining");
        JsonNode educationNodes = dataNode.path("employeeEducation");
        JsonNode achievementNodes = dataNode.path("userAchievements");
        JsonNode trainingReceivedNodes = dataNode.path("trainingReceived");
        JsonNode trainingGivenNodes = dataNode.path("trainingGeven");
        JsonNode previousServiceNodes =  dataNode.path("previousServiceHistory");
        JsonNode physicallyHandicap = dataNode.path("physicalHandicap");
        int userId=0;
        if(empNode != null){
            employee = objectMapper.convertValue(empNode, Employee.class);
            List<Achievements> achievementObj = objectMapper.convertValue(
                    achievementNodes,
                    objectMapper.getTypeFactory().constructCollectionType(
                            List.class, Achievements.class));
            if(employee != null){
                try {
                    userId = createTeacher(employee);
                }catch(Exception e){
                    throw new Exception(e.getMessage());
                }

            }
            if(physicallyHandicap != null && !employee.isU_handicap() && physicallyHandicap.size()>0) {
                userDisabilities = new ArrayList<UserDisabilities>();
                for(int i=0;i< physicallyHandicap.size();i++) {
                    System.out.println(physicallyHandicap.path(i));
                    UserDisabilities userDisability = new UserDisabilities();
                    userDisability.setUd_dcode(physicallyHandicap.path(i).toString().replace("\"",""));
                    userDisability.setUd_oid(employee.getU_org_id());
                    userDisability.setUd_uid(userId);
                    userDisabilities.add(userDisability);
                }

                    insertUserDisabilities(userDisabilities);
            }

             if(joiningNode != null) {
                 joiningInfo = objectMapper.convertValue(joiningNode, JoiningInfo.class);
                        if(joiningInfo != null) {

                            joiningInfo.setU_id(new BigDecimal(userId));
                        }
                        if(!Utils.isEmpty(joiningInfo.toString()))
                    insertUserJoiningDetails(joiningInfo);
             }
             if(achievementNodes != null){
                 achievements = objectMapper.convertValue(
                         achievementNodes,
                         objectMapper.getTypeFactory().constructCollectionType(
                                 List.class, Achievements.class));
                 if(achievements != null) {
                    for(Achievements achieve:achievements) {
                        achieve.setU_uid(new BigDecimal(userId));
                  //      achieve.setU_oid(new BigDecimal("6"));
                    }
                 }
                 if(achievements!=null && achievements.size()>0)
                     insertAchievements(achievements);
             }

try {
    if (trainingReceivedNodes != null) {
        teacherTrainingReceived = objectMapper.convertValue(
                trainingReceivedNodes,
                objectMapper.getTypeFactory().constructCollectionType(
                        List.class, TeacherTrainingReceived.class));

        if (teacherTrainingReceived != null && teacherTrainingReceived.size()>0) {
            for (TeacherTrainingReceived ttr : teacherTrainingReceived) {
                if(Utils.isEmpty(ttr.toString()))
                    continue;
                ttr.setU_uid(new BigDecimal(userId));
                //ttr.setU_oid(new BigDecimal("6"));
            }
            insertUserTrainingInfo(teacherTrainingReceived);
        }
    }
}catch(Exception e){
    System.out.println("training Received ");
e.printStackTrace();
}

try {
    if (trainingGivenNodes != null ) {
        System.out.println(trainingGivenNodes.toString());
        teacherTrainingGiven = objectMapper.convertValue(
                trainingGivenNodes,
                objectMapper.getTypeFactory().constructCollectionType(
                        List.class, TeacherTrainingGiven.class));
        System.out.println(teacherTrainingGiven.size());
        if (teacherTrainingGiven != null && teacherTrainingGiven.size()>0) {
            for (TeacherTrainingGiven ttg : teacherTrainingGiven) {
                ttg.setTg_uid(new BigDecimal(userId));
                //ttg.setTg_oid(new BigDecimal("6"));
            }
            insertTrainingGiven(teacherTrainingGiven);
        }
    }
}catch(Exception e){
    System.out.println("Training given");
    e.printStackTrace();
}
    try {
        if (educationNodes != null) {
            qualifications = objectMapper.convertValue(
                    educationNodes,
                    objectMapper.getTypeFactory().constructCollectionType(
                            List.class, EducationInfo.class));
            if (qualifications != null && qualifications.size()>0) {
                for (EducationInfo edu : qualifications ) {
                    edu.setU_id(new BigDecimal(userId));
                  //  edu.setU_oid(new BigDecimal("6"));
                }
                insertUserEducationInfo(qualifications);
            }

        }
    }catch(Exception e){
        System.out.println("education");
        e.printStackTrace();
    }
    try {
        if (previousServiceNodes != null) {
            prevServiceHistory = objectMapper.convertValue(
                    previousServiceNodes,
                    objectMapper.getTypeFactory().constructCollectionType(
                            List.class, PreviousServiceHistory.class));
            if (prevServiceHistory != null && prevServiceHistory.size()>0) {
                for (PreviousServiceHistory psh : prevServiceHistory) {
                    psh.setU_id(new BigDecimal(userId));
                    //psh.setU_oid(new BigDecimal("6"));
                }
                insertUserPreviousHistory(prevServiceHistory);
            }
        }
    }catch(Exception e){
        System.out.println("previous service history");
        e.printStackTrace();
    }
        }
}

    public TeacherDetails getUserDetails(EmployeeParam emp) throws Exception{
        Map<String,String> result = new HashMap<String,String>();

        List<Employee> employees = orgUserById(emp);

        Achievements achievement = new Achievements();
        achievement.setU_oid(new BigDecimal(emp.getOrgId()));
        achievement.setU_uid(new BigDecimal(emp.getUserId()));
        List<Achievements> achievements = achievementsById(achievement);

        PreviousServiceHistory phs = new PreviousServiceHistory();
        phs.setU_oid(new BigDecimal(emp.getOrgId()));
        phs.setU_id(new BigDecimal(emp.getUserId()));
        List<PreviousServiceHistory> previousServiceHistories = userPreviousHistoryById(phs);

        TeacherTrainingReceived treceived = new TeacherTrainingReceived();
        treceived.setU_oid(new BigDecimal(emp.getOrgId()));
        treceived.setU_uid(new BigDecimal(emp.getUserId()));
        List<TeacherTrainingReceived> trainingReceived = userTrainingInfoById(treceived);

        TeacherTrainingGiven tg = new TeacherTrainingGiven();
        tg.setTg_oid(new BigDecimal(emp.getOrgId()));
        tg.setTg_uid(new BigDecimal(emp.getUserId()));
        List<TeacherTrainingGiven> trainingGiven = trainingGevenById(tg);

        EducationInfo qualification = new EducationInfo();
        qualification.setU_oid(new BigDecimal(emp.getOrgId()));
        qualification.setU_id(new BigDecimal(emp.getUserId()));
        List<EducationInfo> qualifications = userEducationInfoById(qualification);

        JoiningInfo joiningInfo = new JoiningInfo();
            joiningInfo.setU_oid(new BigDecimal(emp.getOrgId()));
            joiningInfo.setU_id(new BigDecimal(emp.getUserId()));

            List<JoiningInfo> joiningInfos = userJoiningDetailsById(joiningInfo);

        UserDisabilities disability = new UserDisabilities();
        disability.setUd_uid(emp.getUserId());
        disability.setUd_oid(emp.getOrgId());
        List<UserDisabilities> disabilities = getUserDisabilitiesById(disability);

        /*ObjectMapper mapper = new ObjectMapper();

        String empString = mapper.writeValueAsString(employees);
        String achieveString = mapper.writeValueAsString(achievements);
        String joininfoString = mapper.writeValueAsString(joiningInfos);
        String educationString = mapper.writeValueAsString(qualifications);
        String trainingRecString = mapper.writeValueAsString(trainingReceived);
        String trainingGivenString = mapper.writeValueAsString(trainingGiven);*/
        TeacherDetails teacherDetails = new TeacherDetails();
        teacherDetails.setAchievements(achievements);
        teacherDetails.setDisabilities(disabilities);
        teacherDetails.setEmployees(employees);
        teacherDetails.setJoiningInfos(joiningInfos);
        teacherDetails.setPreviousServiceHistories(previousServiceHistories);
        teacherDetails.setQualifications(qualifications);
        teacherDetails.setTrainingGiven(trainingGiven);
        teacherDetails.setTrainingReceived(trainingReceived);

        /*System.out.println(empString);
        System.out.println(achieveString);
        System.out.println(joininfoString);
        System.out.println(educationString);
        System.out.println(trainingRecString);
        System.out.println(trainingGivenString);*/

        return teacherDetails;
    }
    public List<Employee> getOrgUserByName(EmployeeParam emp)  throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("u_name", emp.getUname());
        source.addValue("u_org_id", emp.getOrgId());
        return jdbcTemplate.query(queries.getOrgUserByName(), source, new MEmployee());
    }

    public List<Employee> allUser(EmployeeParam emp)  throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("u_org_id", emp.getOrgId());
        return jdbcTemplate.query(queries.getAllUser(), source, new MEmployee());
    }

    public List<Employee> allUserByRole(EmployeeParam emp)  throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("u_org_id", emp.getOrgId());
        source.addValue("roles", emp.getRoles());
        //source.addValue("roles", StringUtils.join(emp.getRoles(),","));
        System.out.println(queries.getAllUserAndRoles());
        return jdbcTemplate.query(queries.getAllUserByRole(), source, new MEmployee());
    }

    public int createTeacher(Employee emp) throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        MapSqlParameterSource auditSource = new MapSqlParameterSource();
        employeeMapper(source, emp);
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(queries.getInsertUser(), source,holder);
        long generatedValue = holder.getKey().longValue();
        emp.setU_id(Integer.parseInt(String.valueOf(generatedValue)));
        MapSqlParameterSource photoinsert = new MapSqlParameterSource();

        photoinsert.addValue("u_id",emp.getU_id());
        photoinsert.addValue("u_photo",emp.getU_photo());
        photoinsert.addValue("u_org_id",emp.getU_org_id());
        try {
            jdbcTemplate.update(queries.getInsertUserPhoto(), photoinsert);
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Insert Photo failed");
        }
        MapSqlParameterSource userRoleInsert = new MapSqlParameterSource();

        userRoleInsert.addValue("ur_uid",emp.getU_id());
        userRoleInsert.addValue("ur_role",emp.getU_role());
        userRoleInsert.addValue("ur_active_ind",emp.isUr_active_ind());
        userRoleInsert.addValue("ur_org_id",emp.getU_org_id());
        userRoleInsert.addValue("ur_desg",emp.getU_desg());
        userRoleInsert.addValue("ur_branch",emp.getU_branchid());

        jdbcTemplate.update(queries.getAssignRolesToUser(),userRoleInsert);
        //actionMapper(auditSource, action, objectMapper.writeValueAsString(emp));
        //jdbcTemplate.update(queries.getInsertAudit(),auditSource);
        return Integer.parseInt(String.valueOf(generatedValue));
    }

    public boolean insertUser(Employee emp) throws Exception {
        MapSqlParameterSource source = new MapSqlParameterSource();
        MapSqlParameterSource auditSource = new MapSqlParameterSource();
        employeeMapper(source, emp);
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(queries.getInsertUser(), source,holder);
        long generatedValue = holder.getKey().longValue();
        emp.setU_id(Integer.parseInt(String.valueOf(generatedValue)));
        MapSqlParameterSource photoinsert = new MapSqlParameterSource();

        photoinsert.addValue("u_id",emp.getU_id());
        photoinsert.addValue("u_photo",emp.getU_photo());
        photoinsert.addValue("u_org_id",emp.getU_org_id());
try {
    jdbcTemplate.update(queries.getInsertUserPhoto(), photoinsert);
}catch(Exception e){
    e.printStackTrace();
    return false;
}
        MapSqlParameterSource userRoleInsert = new MapSqlParameterSource();

        userRoleInsert.addValue("ur_uid",emp.getU_id());
        userRoleInsert.addValue("ur_role",emp.getU_role());
        userRoleInsert.addValue("ur_active_ind",emp.isUr_active_ind());
        userRoleInsert.addValue("ur_org_id",emp.getU_org_id());
        userRoleInsert.addValue("ur_desg",emp.getU_desg());
        userRoleInsert.addValue("ur_branch",emp.getU_branchid());

        jdbcTemplate.update(queries.getAssignRolesToUser(),userRoleInsert);
        //actionMapper(auditSource, action, objectMapper.writeValueAsString(emp));
        //jdbcTemplate.update(queries.getInsertAudit(),auditSource);
        return true;
    }

    public boolean updateUser(Employee emp)   throws Exception {
        MapSqlParameterSource source = new MapSqlParameterSource();
        MapSqlParameterSource auditSource = new MapSqlParameterSource();
        employeeMapper(source, emp);
        jdbcTemplate.update(queries.getUpdateUser(), source);
        MapSqlParameterSource photoinsert = new MapSqlParameterSource();
        photoinsert.addValue("u_id",emp.getU_id());
        photoinsert.addValue("u_photo",emp.getU_photo());
        photoinsert.addValue("u_org_id",emp.getU_org_id());
        try {
            List<UserPhoto> photos = userPhotoById(emp);
            if(Utils.isEmpty(photos.toArray()))
                jdbcTemplate.update(queries.getInsertUserPhoto(),photoinsert);
            else
            jdbcTemplate.update(queries.getUpdateUserPhoto(), photoinsert);
        }catch(Exception e){
            e.printStackTrace();
        }
        MapSqlParameterSource userRoleUpdate = new MapSqlParameterSource();

        userRoleUpdate.addValue("ur_uid",emp.getU_id());
        userRoleUpdate.addValue("ur_role",emp.getU_role());
        userRoleUpdate.addValue("ur_active_ind",emp.isUr_active_ind());
        userRoleUpdate.addValue("ur_org_id",emp.getU_org_id());
        userRoleUpdate.addValue("ur_desg",emp.getU_desg());
        userRoleUpdate.addValue("ur_branch",emp.getU_branchid());

        jdbcTemplate.update(queries.getUpdateUserAssignedRoles(),userRoleUpdate);
        return true;
        //actionMapper(auditSource, action, objectMapper.writeValueAsString(emp));
        //jdbcTemplate.update(queries.getInsertAudit(),auditSource);
       /* ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);
        MapSqlParameterSource source = new MapSqlParameterSource();
        employeeMapper(source, emp);
        MapSqlParameterSource psource = new MapSqlParameterSource();
        psource.addValue("u_id", emp.getU_id());
        psource.addValue("u_org_id", emp.getU_org_id());
        List<Employee> currentEmp = jdbcTemplate.query(queries.getOrgUserById(), psource,new MEmployee() );
        jdbcTemplate.update(queries.getUpdateUser(), source);
        psource = new MapSqlParameterSource();
        actionMapper(psource,action , objectMapper.writeValueAsString(currentEmp));
        jdbcTemplate.update(queries.getInsertAudit(), psource);
        return jdbcTemplate.query(queries.getAllUser(), source, new MEmployee());*/
    }

    public List<Employee> deleteUser(EmployeeParam emp)  throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("u_org_id", emp.getOrgId());
        source.addValue("u_id", emp.getUserId());
        jdbcTemplate.update(queries.getDeleteUser(), source);
        return jdbcTemplate.query(queries.getAllUser(), source, new MEmployee());
    }

    public List<Employee> orgUserById(EmployeeParam emp)  throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("u_org_id", emp.getOrgId());
        source.addValue("u_id", emp.getUserId());

        return jdbcTemplate.query(queries.getOrgUserById(), source, new MEmployee());
    }

    public List<Employee> orgUserByEmailId(EmployeeParam emp)  throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("u_org_id", emp.getOrgId());
        source.addValue("u_email_id", emp.getEmail());

        return jdbcTemplate.query(queries.getOrgUserByEmailId(), source, new MEmployee());
    }

    public List<Employee> insertBulkUsers(List<Employee> emps)  throws Exception{
        List<Map<String, Object>> batchUpdateValues = new ArrayList<>(emps.size());
        MapSqlParameterSource source = null;
        for (Employee emp : emps) {
            source = new MapSqlParameterSource();
            employeeMapper(source, emp);
            batchUpdateValues.add(source.getValues());
        }
        jdbcTemplate.batchUpdate(queries.getInsertUser(), batchUpdateValues.toArray(new Map[emps.size()]));
        return jdbcTemplate.query(queries.getAllUser(), new MapSqlParameterSource("u_org_id", emps.get(0).getU_org_id()), new MEmployee());
    }

    public List<Employee> updateBulkUsers(List<Employee> emps)  throws Exception{
        List<Map<String, Object>> batchUpdateValues = new ArrayList<>(emps.size());
        MapSqlParameterSource source = null;
        for (Employee emp : emps) {
            source = new MapSqlParameterSource();
            employeeMapper(source, emp);
            batchUpdateValues.add(source.getValues());
        }
        jdbcTemplate.batchUpdate(queries.getUpdateUser(), batchUpdateValues.toArray(new Map[emps.size()]));
        return jdbcTemplate.query(queries.getAllUser(), new MapSqlParameterSource("u_org_id", emps.get(0).getU_org_id()), new MEmployee());
    }

    private void employeeMapper(MapSqlParameterSource source, Employee emp)  throws Exception{

        source.addValue("u_id", emp.getU_id());
        source.addValue("u_org_id", emp.getU_org_id());
        source.addValue("u_first_name", emp.getU_first_name());
        source.addValue("u_middle_name", emp.getU_middle_name());
        source.addValue("u_last_name", emp.getU_last_name());
        source.addValue("u_dob", emp.getU_dob());
        source.addValue("u_nativity", emp.getU_nativity());
        source.addValue("u_nationality", emp.getU_nationality());
        source.addValue("u_religion", emp.getU_religion());
        source.addValue("u_caste", emp.getU_caste());
        source.addValue("u_subcaste", emp.getU_subcaste());
        source.addValue("u_father_name", emp.getU_father_name());
        source.addValue("u_mother_name", emp.getU_mother_name());
        source.addValue("u_guardian_name", emp.getU_guardian_name());
        source.addValue("u_guardian_relation", emp.getU_guardian_relation());
        source.addValue("u_caddress", emp.getU_caddress());
        source.addValue("u_clocation", emp.getU_clocation());
        source.addValue("u_cstreet", emp.getU_cstreet());
        source.addValue("u_ccity", emp.getU_ccity());
        source.addValue("u_cstate", emp.getU_cstate());
        source.addValue("u_cdistrict", emp.getU_cdistrict());
        source.addValue("u_cmandal", emp.getU_cmandal());
        source.addValue("u_czipcode", emp.getU_czipcode());
        source.addValue("u_paddress", emp.getU_paddress());
        source.addValue("u_plocation", emp.getU_plocation());
        source.addValue("u_pstreet", emp.getU_pstreet());
        source.addValue("u_pcity", emp.getU_pcity());
        source.addValue("u_pstate", emp.getU_pstate());
        source.addValue("u_pdistrict", emp.getU_pdistrict());
        source.addValue("u_pmandal", emp.getU_pmandal());
        source.addValue("u_pzipcode", emp.getU_pzipcode());
        source.addValue("u_pcontact_no", emp.getU_pcontact_no());
        source.addValue("u_scontact_no", emp.getU_scontact_no());
        source.addValue("u_econtact_no", emp.getU_econtact_no());
        source.addValue("u_mcontact_no", emp.getU_mcontact_no());
        source.addValue("u_fcontact_no", emp.getU_fcontact_no());
        source.addValue("u_gcontact_no", emp.getU_gcontact_no());
        source.addValue("u_active_ind", emp.isU_active_ind()?1:0);
        source.addValue("u_email_id", emp.getU_email_id());
        source.addValue("u_alt_email_id", emp.getU_alt_email_id());
        source.addValue("u_social_security_Id", emp.getU_social_security_Id());
        source.addValue("u_social_security_name", emp.getU_social_security_name());
        source.addValue("u_refno", emp.getU_refno());
        source.addValue("u_mother_tongue", emp.getU_mother_tongue());
        source.addValue("u_ethnic_group", emp.getU_ethnic_group());
        source.addValue("u_ethnic_designation", emp.getU_ethnic_designation());
        source.addValue("u_decile_group", emp.getU_decile_group());
        source.addValue("u_tenure", emp.getU_tenure());
        source.addValue("u_branchid", emp.getU_branchid());
        source.addValue("u_gender", emp.getU_gender());
        source.addValue("u_height", emp.getU_height());
        source.addValue("u_weight", emp.getU_weight());
        source.addValue("u_blood_group", emp.getU_blood_group());
        source.addValue("u_disease", emp.isU_disease());
        source.addValue("u_formal_soldier", emp.isU_formal_soldier());
        source.addValue("u_handicap", emp.isU_handicap());
        source.addValue("u_panno", emp.getU_panno());
        source.addValue("u_pfuid", emp.getU_pfuid());
        source.addValue("u_certificate", emp.isU_certificate());
        source.addValue("u_cert_name", emp.getU_cert_name());
        source.addValue("u_cert_grade", emp.getU_cert_grade());
        source.addValue("u_cert_type", emp.getU_cert_type());
        source.addValue("u_bestTeacher",emp.isU_bestTeacher());
        source.addValue("u_btdesc", emp.getU_btdesc());
        source.addValue("u_achievement", emp.isU_achievement());
        source.addValue("u_marital_status", emp.isU_marital_status());
        source.addValue("u_spouse_name", emp.getU_spouse_name());
        source.addValue("u_spouse_contact_no", emp.getU_spouse_contact_no());
        source.addValue("u_spouse_working", emp.isU_spouse_working());
        source.addValue("u_children", emp.getU_children());
        source.addValue("u_child_sons", emp.getU_child_sons());
        source.addValue("u_child_girls", emp.getU_child_girls());
        source.addValue("u_f_ref_name", emp.getU_f_ref_name());
        source.addValue("u_f_ref_contact_no", emp.getU_f_ref_contact_no());
        source.addValue("u_f_ref_address", emp.getU_f_ref_address());
        source.addValue("u_f_ref_desc", emp.getU_f_ref_desc());
        source.addValue("u_f_ref_aadharno", emp.getU_f_ref_aadharno());
        source.addValue("u_s_ref_name", emp.getU_s_ref_name());
        source.addValue("u_s_ref_contact_no", emp.getU_s_ref_contact_no());
        source.addValue("u_s_ref_address", emp.getU_s_ref_address());
        source.addValue("u_s_ref_desc", emp.getU_s_ref_desc());
        source.addValue("u_s_ref_aadharno", emp.getU_s_ref_aadharno());


    }

    private void actionMapper(MapSqlParameterSource source, Audit action, String object) throws Exception{
        source.addValue("data", object);
        source.addValue("id", null);
        source.addValue("orgid", action.getOrgid());
        source.addValue("action_type", action.getAction_type());
        source.addValue("action_by",action.getAction_by());
        source.addValue("user_name",action.getUser_name());
        source.addValue("view_name", action.getUser_name());
        source.addValue("action_date",new Date());

    }

    public List<UserPhoto> insertUserPhoto() throws Exception {
        return null;
    }

    public List<UserPhoto> updateUserPhoto() throws Exception {
        return null;
    }

    public List<UserPhoto> userPhotoById(Employee emp) throws Exception {
        MapSqlParameterSource photo = new MapSqlParameterSource();
        photo.addValue("u_id",emp.getU_id());
        photo.addValue("u_photo",emp.getU_photo());
        photo.addValue("u_org_id",emp.getU_org_id());

        return jdbcTemplate.query(queries.getUserPhotoById(), photo, new MUserPhoto());
    }

    public List<UserPhoto> deleteUserPhoto() throws Exception {
        return null;
    }

    public List<Others> getAllOthers(EmployeeParam other)  throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("o_org_id", other.getOrgId());
        source.addValue("o_id", other.getUserId());
        return jdbcTemplate.query(queries.getGetAllOthers(), source, new MOthers());
    }

    public List<Others> insertOthers(Others others)  throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        OthersMapper(source, others);
        jdbcTemplate.update(queries.getInsertOthers(), source);
        return jdbcTemplate.query(queries.getGetAllOthers(), source, new MOthers());
    }

    public List<Others> updateOthers(Others others)  throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        OthersMapper(source, others);
        jdbcTemplate.update(queries.getUpdateOthers(), source);
        return jdbcTemplate.query(queries.getGetAllOthers(), source, new MOthers());
    }

    public List<Others> getOthersById(EmployeeParam param)  throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("o_org_id", param.getOrgId());
        source.addValue("o_id", param.getUserId());
        return jdbcTemplate.query(queries.getGetOthersById(), source, new MOthers());
    }

    public List<Others> deleteOthers(EmployeeParam param)  throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("o_org_id", param.getOrgId());
        source.addValue("o_id", param.getUserId());
        jdbcTemplate.update(queries.getDeleteOthers(), source);
        return jdbcTemplate.query(queries.getGetAllOthers(), source, new MOthers());
    }


    private void OthersMapper(MapSqlParameterSource source, Others others)  throws Exception{
        source.addValue("o_id", others.getO_id());
        source.addValue("o_first_name", others.getO_first_name());
        source.addValue("o_last_name", others.getO_last_name());
        source.addValue("o_middle_name", others.getO_middle_name());
        source.addValue("o_email_id", others.getO_email_id());
        source.addValue("o_pcontact_no", others.getO_pcontact_no());
        source.addValue("o_scontact_no", others.getO_scontact_no());
        source.addValue("o_address", others.getO_address());
        source.addValue("o_location", others.getO_location());
        source.addValue("o_street", others.getO_street());
        source.addValue("o_state", others.getO_state());
        source.addValue("o_city", others.getO_city());
        source.addValue("o_country", others.getO_country());
        source.addValue("o_zipcode", others.getO_zipcode());
        source.addValue("o_active_ind", others.getO_active_ind());
        source.addValue("o_purpose", others.getO_purpose());
        source.addValue("o_comment", others.getO_comment());
        source.addValue("o_remark", others.getO_remark());
        source.addValue("o_org_id", others.getO_org_id());
        source.addValue("o_suffix", others.getO_suffix());
        source.addValue("o_no_visits", others.getO_no_visits());

    }


    public List<UserRoles> UserAssignedRolesByUserId(RoleParams params)  throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("ur_org_id", params.getUrOrgId());
        source.addValue("ur_uid", params.getrUserId());
        List<UserRoles> roles = jdbcTemplate.query(queries.getUserAssignedRolesByUserId(), source, new MUserRoles());
        System.out.println(roles.toString());
        return roles;
    }

    public List<UserRoles> allUserAndRoles(RoleParams params)  throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("u_org_id", params.getUrOrgId());
        return jdbcTemplate.query(queries.getAllUserAndRoles(), source, new MUserRoles());
    }

    public List<UserRoles> assignRolesToUser(OrgUserRoles roles)  throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("ur_id", roles.getUr_id());
        source.addValue("ur_org_id", roles.getUr_org_id());
        source.addValue("ur_role", roles.getUr_role());
        source.addValue("ur_active_ind", roles.isUr_active_ind());
        source.addValue("ur_uid", roles.getUr_uid());
        jdbcTemplate.update(queries.getAssignRolesToUser(), source);
        source = new MapSqlParameterSource();
        source.addValue("u_org_id", roles.getUr_org_id());
        return jdbcTemplate.query(queries.getAllUserAndRoles(), source, new MUserRoles());
    }

    /*------------------------------------------------------------------------------*/

    public List<SystemUserModules> userAssignedModulesById(SysUserPermissionParams param) throws Exception {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("userid", param.getUserid());
        source.addValue("orgid", param.getOrgid());
        System.out.println(source.toString());
        System.out.println(param.toString());
        System.out.println(queries.getUserAssignedModulesById());
        return jdbcTemplate.query(queries.getUserAssignedModulesById(), source, new MSystemUserModules());
    }

    public List<SystemUserModules> insertUserModule(Usermodule module)  throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("mid", module.getMid());
        source.addValue("id", module.getUmid());
        source.addValue("userid", module.getUserid());
        source.addValue("uview", module.getUview());
        source.addValue("uedit", module.getUedit());
        source.addValue("udelete", module.getUdelete());
        source.addValue("orgid", module.getOrgid());
        jdbcTemplate.update(queries.getInsertUserModule(), source);
        return jdbcTemplate.query(queries.getUserAssignedModulesById(), source, new MSystemUserModules());
    }

    public List<SystemUserModules> updateUserModule(Usermodule module) throws Exception {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("mid", module.getMid());
        source.addValue("id", module.getUmid());
        source.addValue("userid", module.getUserid());
        source.addValue("uview", module.getUview());
        source.addValue("uedit", module.getUedit());
        source.addValue("udelete", module.getUdelete());
        source.addValue("orgid", module.getOrgid());
        jdbcTemplate.update(queries.getUpdateUserModule(), source);
        return jdbcTemplate.query(queries.getUserAssignedModulesById(), source, new MSystemUserModules());
    }
    /*-------------------------------audit ----------------------------*/
    private void insertAudit(Audit audit)  throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id", audit.getId());
        source.addValue("action_by",audit.getAction_by() );
        source.addValue("action_type", audit.getAction_type());
        source.addValue("data", audit.getData());
        source.addValue("orgid", audit.getOrgid());
        source.addValue("user_name", audit.getUser_name());
        source.addValue("view_name", audit.getView_name());
        jdbcTemplate.update(queries.getInsertAudit(),source);
    }
    public List<Audit>  auditDetailsByCurrentDate(AuditParam param) throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("orgid", param.getOrgid());
        source.addValue("action_date", param.getAuditDate());
        return jdbcTemplate.query(queries.getAuditDetailsByCurrentDate(), source, new MAudit());
    }

    public List<Audit>  auditDetailsByDate(AuditParam param) throws Exception{
        System.out.println(param.toString());
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("orgid", param.getOrgid());
        source.addValue("action_date", param.getAuditDate());
        return jdbcTemplate.query(queries.getAuditDetailsByCurrentDate(), source, new MAudit());
    }

    public List<Audit>  auditDetailsByDateRange(AuditParam param) throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("orgid", param.getOrgid());
        source.addValue("action_date", param.getAuditDate());
        source.addValue("toDate", param.getToDate());
        return jdbcTemplate.query(queries.getAuditDetailsByCurrentDate(), source, new MAudit());
    }

    public List<Generics>  allGenerics() throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        return jdbcTemplate.query(queries.getAllgenerics(), source, new MGenerics());
    }

    public List<Roles> getAllRoles() throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        return jdbcTemplate.query(queries.getGetAllRoles(),source,new MRoles());
    }

    /* previous history */
    /* education history*/
    /* achievement history*/
    /* training given */
    /* training received*/


    public List<JoiningInfo> insertUserJoiningDetails(JoiningInfo joining) throws Exception {

                MapSqlParameterSource source = new MapSqlParameterSource();
                source.addValue("u_jid", joining.getU_jid());
                source.addValue("u_oid", joining.getU_oid());
                source.addValue("u_id", joining.getU_id());
                source.addValue("u_doj", joining.getU_doj());
                source.addValue("u_desg", joining.getU_desg());
                source.addValue("u_department", joining.getU_department());
                source.addValue("u_category", joining.getU_category());
                source.addValue("u_doa", joining.getU_doa());
                source.addValue("u_order_no", joining.getU_order_no());
                source.addValue("u_init_off_name", joining.getU_init_off_name());
                source.addValue("u_recruitment_mode", joining.getU_recruitment_mode());
                source.addValue("u_dor", joining.getU_dor());
                source.addValue("u_comment", joining.getU_comment());
                source.addValue("u_active_ind", joining.isU_active_ind());
            if(  joining.getU_jid()==0) {

                GeneratedKeyHolder holder = new GeneratedKeyHolder();
                jdbcTemplate.update(queries.getInsertUserJoiningDetails(), source, holder);
            }else {
                jdbcTemplate.update(queries.getUpdateUserJoiningDetails(),source);
            }


        return jdbcTemplate.query(queries.getUserJoiningDetailsById(),source,new MJoiningInfo());

    }

    public List<JoiningInfo> updateUserJoiningDetails(List<JoiningInfo> joinings)throws Exception {

        for(JoiningInfo joining:joinings) {
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("u_jid", joining.getU_jid());
            source.addValue("u_oid", joining.getU_oid());
            source.addValue("u_id", joining.getU_id());
            source.addValue("u_doj", joining.getU_doj());
            source.addValue("u_desg", joining.getU_desg());
            source.addValue("u_department", joining.getU_department());
            source.addValue("u_category", joining.getU_category());
            source.addValue("u_doa", joining.getU_doa());
            source.addValue("u_order_no", joining.getU_order_no());
            source.addValue("u_init_off_name", joining.getU_init_off_name());
            source.addValue("u_recruitment_mode", joining.getU_recruitment_mode());
            source.addValue("u_dor", joining.getU_dor());
            source.addValue("u_comment", joining.getU_comment());
            source.addValue("u_active_ind", joining.isU_active_ind());
            if(joining.getU_jid()!=0) {

                GeneratedKeyHolder holder = new GeneratedKeyHolder();
                jdbcTemplate.update(queries.getInsertUserJoiningDetails(), source, holder);
            }else {
                jdbcTemplate.update(queries.getUpdateUserJoiningDetails(),source);
            }
        }
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("u_oid", joinings.get(0).getU_oid());
        source.addValue("u_id", joinings.get(0).getU_id());

        return jdbcTemplate.query(queries.getUserJoiningDetailsById(),source,new MJoiningInfo());

    }


    public List<JoiningInfo> deleteUserJoiningDetails(List<JoiningInfo> joinings)throws Exception {
        for(JoiningInfo joining:joinings) {
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("u_jid", joining.getU_jid());
            source.addValue("u_oid", joining.getU_oid());
            source.addValue("u_id", joining.getU_id());
            source.addValue("u_doj", joining.getU_doj());
            source.addValue("u_desg", joining.getU_desg());
            source.addValue("u_department", joining.getU_department());
            source.addValue("u_category", joining.getU_category());
            source.addValue("u_doa", joining.getU_doa());
            source.addValue("u_order_no", joining.getU_order_no());
            source.addValue("u_init_off_name", joining.getU_init_off_name());
            source.addValue("u_recruitment_mode", joining.getU_recruitment_mode());
            source.addValue("u_dor", joining.getU_dor());
            source.addValue("u_comment", joining.getU_comment());
            source.addValue("u_active_ind", joining.isU_active_ind());
            if(joining.getU_jid()!=0) {
                  jdbcTemplate.update(queries.getDeleteUserJoiningDetails(), source);
            }
        }
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("u_oid", joinings.get(0).getU_oid());
        source.addValue("u_id", joinings.get(0).getU_id());

        return jdbcTemplate.query(queries.getUserJoiningDetailsById(),source,new MJoiningInfo());

    }

    public List<JoiningInfo> userJoiningDetailsById(JoiningInfo joining)throws Exception {
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("u_oid", joining.getU_oid());
            source.addValue("u_id", joining.getU_id());

                return jdbcTemplate.query(queries.getUserJoiningDetailsById(),source,new MJoiningInfo());

    }

    public List<JoiningInfo> userActiveJoiningDetails(JoiningInfo joining)throws Exception {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("u_oid", joining.getU_oid());
        source.addValue("u_id", joining.getU_id());

        return jdbcTemplate.query(queries.getUserActiveJoiningDetails(),source,new MJoiningInfo());

    }

    public List<TeacherTrainingReceived> insertUserTrainingInfo(List<TeacherTrainingReceived> trainings)throws Exception {
        for(TeacherTrainingReceived training:trainings) {
            System.out.println(training.toString());
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("u_id", training.getU_id());
            source.addValue("u_uid", training.getU_uid());
            source.addValue("u_oid", training.getU_oid());
            source.addValue("u_training_type", training.getU_training_type());
            source.addValue("u_topic_name", training.getU_topic_name());
            source.addValue("u_institute_name", training.getU_institute_name());
            source.addValue("u_sponsored_by", training.getU_sponsored_by());
            source.addValue("u_from_date", training.getU_from_date());
            source.addValue("u_to_date", training.getU_to_date());
            source.addValue("u_comment", training.getU_comment());
            source.addValue("u_attachement", training.getU_attachement());
                if(training.getU_id()==0){
                    jdbcTemplate.update(queries.getInsertUserTrainingInfo(), source);

                }
                else{
                    jdbcTemplate.update(queries.getUpdateUserTrainingInfo(),source);
                }

        }
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("u_uid", trainings.get(0).getU_uid());
        source.addValue("u_oid", trainings.get(0).getU_oid());
        return jdbcTemplate.query(queries.getUserTrainingInfoById(),source,new MTeacherTrainingReceived());
    }

    public List<TeacherTrainingReceived> updateUserTrainingInfo(List<TeacherTrainingReceived> trainings)throws Exception {
        for(TeacherTrainingReceived training:trainings) {
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("u_id", training.getU_id());
            source.addValue("u_uid", training.getU_uid());
            source.addValue("u_oid", training.getU_oid());
            source.addValue("u_training_type", training.getU_training_type());
            source.addValue("u_topic_name", training.getU_topic_name());
            source.addValue("u_institute_name", training.getU_institute_name());
            source.addValue("u_sponsored_by", training.getU_sponsored_by());
            source.addValue("u_from_date", training.getU_from_date());
            source.addValue("u_to_date", training.getU_to_date());
            source.addValue("u_comment", training.getU_comment());
            source.addValue("u_attachement", training.getU_attachement());
            if(training.getU_id()==0){
                jdbcTemplate.update(queries.getInsertUserTrainingInfo(), source);

            }
            else{
                jdbcTemplate.update(queries.getUpdateUserTrainingInfo(),source);
            }

        }
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("u_uid", trainings.get(0).getU_uid());
        source.addValue("u_oid", trainings.get(0).getU_oid());

        return jdbcTemplate.query(queries.getUserTrainingInfoById(),source,new MTeacherTrainingReceived());
    }

    public List<TeacherTrainingReceived> deleteUserTrainingInfo(List<TeacherTrainingReceived> trainings)throws Exception {
        for(TeacherTrainingReceived training:trainings) {
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("u_id", training.getU_id());
            source.addValue("u_uid", training.getU_uid());
            source.addValue("u_oid", training.getU_oid());
            source.addValue("u_training_type", training.getU_training_type());
            source.addValue("u_topic_name", training.getU_topic_name());
            source.addValue("u_institute_name", training.getU_institute_name());
            source.addValue("u_sponsored_by", training.getU_sponsored_by());
            source.addValue("u_from_date", training.getU_from_date());
            source.addValue("u_to_date", training.getU_to_date());
            source.addValue("u_comment", training.getU_comment());
            source.addValue("u_attachement", training.getU_attachement());
            if(training.getU_id()!=0){
                jdbcTemplate.update(queries.getDeleteUserTrainingInfo(), source);

            }


        }
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("u_uid", trainings.get(0).getU_uid());
        source.addValue("u_oid", trainings.get(0).getU_oid());

        return jdbcTemplate.query(queries.getUserTrainingInfoById(),source,new MTeacherTrainingReceived());
    }

    public List<TeacherTrainingReceived> userTrainingInfoById(TeacherTrainingReceived training)throws Exception {
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("u_id", training.getU_id());
            source.addValue("u_uid", training.getU_uid());
            source.addValue("u_oid", training.getU_oid());
            source.addValue("u_training_type", training.getU_training_type());
            source.addValue("u_topic_name", training.getU_topic_name());
            source.addValue("u_institute_name", training.getU_institute_name());
            source.addValue("u_sponsored_by", training.getU_sponsored_by());
            source.addValue("u_from_date", training.getU_from_date());
            source.addValue("u_to_date", training.getU_to_date());
            source.addValue("u_comment", training.getU_comment());
            source.addValue("u_attachement", training.getU_attachement());

        return jdbcTemplate.query(queries.getUserTrainingInfoById(),source,new MTeacherTrainingReceived());

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
    public List<PreviousServiceHistory> insertUserPreviousHistory(List<PreviousServiceHistory> histories)throws Exception {
        for(PreviousServiceHistory history:histories) {
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("u_sh",history.getU_sh());
            source.addValue("u_id",history.getU_id());
            source.addValue("u_oid",history.getU_oid());
            source.addValue("u_organization",history.getU_organization());
            source.addValue("u_designation",history.getU_designation());
            source.addValue("u_department",history.getU_department());
            source.addValue("u_from_date",history.getU_from_date());
            source.addValue("u_to_date",history.getU_to_date());
            source.addValue("u_exp_in_years",history.getU_exp_in_years());
            source.addValue("u_sub_cls_taught",history.getU_sub_cls_taught());
            source.addValue("u_reason_to_leave",history.getU_reason_to_leave());
            source.addValue("u_comment",history.getU_comment());
            source.addValue("u_attachment",history.getU_attachment());
            if(history.getU_sh()==0){
                jdbcTemplate.update(queries.getInsertPreviousHistory(),source);
            }else {
                jdbcTemplate.update(queries.getUpdateUserPreviousHistory(),source);
            }
        }
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("u_sh",histories.get(0).getU_sh());
        source.addValue("u_id",histories.get(0).getU_id());
        source.addValue("u_oid",histories.get(0).getU_oid());

        return jdbcTemplate.query(queries.getUserPreviousHistoryById(),source,new MPreviousServiceHistory());

    }

    public List<PreviousServiceHistory> updateUserPreviousHistory(List<PreviousServiceHistory> histories)throws Exception {
        for(PreviousServiceHistory history:histories) {
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("u_sh",history.getU_sh());
            source.addValue("u_id",history.getU_id());
            source.addValue("u_oid",history.getU_oid());
            source.addValue("u_organization",history.getU_organization());
            source.addValue("u_designation",history.getU_designation());
            source.addValue("u_department",history.getU_department());
            source.addValue("u_from_date",history.getU_from_date());
            source.addValue("u_to_date",history.getU_to_date());
            source.addValue("u_exp_in_years",history.getU_exp_in_years());
            source.addValue("u_sub_cls_taught",history.getU_sub_cls_taught());
            source.addValue("u_reason_to_leave",history.getU_reason_to_leave());
            source.addValue("u_comment",history.getU_comment());
            source.addValue("u_attachment",history.getU_attachment());
            if(history.getU_id().intValue()==0){
                jdbcTemplate.update(queries.getInsertPreviousHistory(),source);
            }else {
                jdbcTemplate.update(queries.getUpdateUserPreviousHistory(),source);
            }
        }
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("u_sh",histories.get(0).getU_sh());
        source.addValue("u_id",histories.get(0).getU_id());
        source.addValue("u_oid",histories.get(0).getU_oid());

        return jdbcTemplate.query(queries.getUserPreviousHistoryById(),source,new MPreviousServiceHistory());

    }

    public List<PreviousServiceHistory> deleteUserPreviousHistory(List<PreviousServiceHistory> histories)throws Exception {
        for(PreviousServiceHistory history:histories) {
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("u_sh",history.getU_sh());
            source.addValue("u_id",history.getU_id());
            source.addValue("u_oid",history.getU_oid());
            source.addValue("u_organization",history.getU_organization());
            source.addValue("u_designation",history.getU_designation());
            source.addValue("u_department",history.getU_department());
            source.addValue("u_from_date",history.getU_from_date());
            source.addValue("u_to_date",history.getU_to_date());
            source.addValue("u_exp_in_years",history.getU_exp_in_years());
            source.addValue("u_sub_cls_taught",history.getU_sub_cls_taught());
            source.addValue("u_reason_to_leave",history.getU_reason_to_leave());
            source.addValue("u_comment",history.getU_comment());
            source.addValue("u_attachment",history.getU_attachment());
            if(history.getU_id().intValue()!=0){
                jdbcTemplate.update(queries.getDeleteUserPreviousHistory(),source);
            }
        }
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("u_sh",histories.get(0).getU_sh());
        source.addValue("u_id",histories.get(0).getU_id());
        source.addValue("u_oid",histories.get(0).getU_oid());

        return jdbcTemplate.query(queries.getUserPreviousHistoryById(),source,new MPreviousServiceHistory());

    }

    public List<PreviousServiceHistory> userPreviousHistoryById(PreviousServiceHistory history)throws Exception {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("u_sh",history.getU_sh());
        source.addValue("u_id",history.getU_id());
        source.addValue("u_oid",history.getU_oid());

        return jdbcTemplate.query(queries.getUserPreviousHistoryById(),source,new MPreviousServiceHistory());
    }

    public List<EducationInfo> insertUserEducationInfo(List<EducationInfo> educations)throws Exception {
        for(EducationInfo education: educations){
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("u_eid",education.getU_eid());
            source.addValue("u_oid",education.getU_oid());
            source.addValue("u_course",education.getU_course());
            source.addValue("u_organization",education.getU_organization());
            source.addValue("u_marks",education.getU_marks());
            source.addValue("u_year",education.getU_year());
            source.addValue("u_medium",education.getU_medium());
            source.addValue("u_grade",education.getU_grade());
            source.addValue("u_id",education.getU_id());
            source.addValue("u_edu_type",education.getU_edu_type());
            source.addValue("u_subjects",education.getU_subjects());
            source.addValue("u_comment",education.getU_comment());
            source.addValue("u_attachment",education.getU_attachment());
            System.out.println(education.toString());
            if(education.getU_eid()==null || education.getU_eid().intValue()==0)
                jdbcTemplate.update(queries.getInsertUserEducationInfo(),source);
            else
                jdbcTemplate.update(queries.getUpdateUserEducationInfo(),source);
        }
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("u_id",educations.get(0).getU_id());
        source.addValue("u_oid",educations.get(0).getU_oid());

        return jdbcTemplate.query(queries.getUserEducationInfoById(),source,new MEducationInfo());
    }

    public List<EducationInfo> updateUserEducationInfo(List<EducationInfo> educations)throws Exception {
        for(EducationInfo education: educations){
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("u_eid",education.getU_eid());
            source.addValue("u_oid",education.getU_oid());
            source.addValue("u_course",education.getU_course());
            source.addValue("u_organization",education.getU_organization());
            source.addValue("u_marks",education.getU_marks());
            source.addValue("u_year",education.getU_year());
            source.addValue("u_medium",education.getU_medium());
            source.addValue("u_grade",education.getU_grade());
            source.addValue("u_id",education.getU_id());
            source.addValue("u_edu_type",education.getU_edu_type());
            source.addValue("u_subjects",education.getU_subjects());
            source.addValue("u_comment",education.getU_comment());
            source.addValue("u_attachment",education.getU_attachment());
            if(education.getU_eid().intValue()==0)
                jdbcTemplate.update(queries.getInsertUserEducationInfo(),source);
            else
                jdbcTemplate.update(queries.getUpdateUserEducationInfo(),source);
        }
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("u_id",educations.get(0).getU_id());
        source.addValue("u_oid",educations.get(0).getU_oid());

        return jdbcTemplate.query(queries.getUserEducationInfoById(),source,new MEducationInfo());
    }

    public List<EducationInfo> deleteUserEducationInfo(List<EducationInfo> educations)throws Exception {
        for(EducationInfo education: educations){
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("u_eid",education.getU_eid());
            source.addValue("u_oid",education.getU_oid());
            source.addValue("u_course",education.getU_course());
            source.addValue("u_organization",education.getU_organization());
            source.addValue("u_marks",education.getU_marks());
            source.addValue("u_year",education.getU_year());
            source.addValue("u_medium",education.getU_medium());
            source.addValue("u_grade",education.getU_grade());
            source.addValue("u_id",education.getU_id());
            source.addValue("u_edu_type",education.getU_edu_type());
            source.addValue("u_subjects",education.getU_subjects());
            source.addValue("u_comment",education.getU_comment());
            source.addValue("u_attachment",education.getU_attachment());
            if(education.getU_eid().intValue()!=0)
                jdbcTemplate.update(queries.getDeleteUserEducationInfo(),source);

        }
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("u_id",educations.get(0).getU_id());
        source.addValue("u_oid",educations.get(0).getU_oid());

        return jdbcTemplate.query(queries.getUserEducationInfoById(),source,new MEducationInfo());
    }

    public List<EducationInfo> userEducationInfoById(EducationInfo education)throws Exception {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("u_id",education.getU_id());
        source.addValue("u_oid",education.getU_oid());

        return jdbcTemplate.query(queries.getUserEducationInfoById(),source,new MEducationInfo());
    }

    public List<TeacherTrainingGiven> insertTrainingGiven(List<TeacherTrainingGiven> trainings)throws Exception {
        for(TeacherTrainingGiven training:trainings) {
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("tg_id",training.getTg_id());
            source.addValue("tg_uid",training.getTg_uid());
            source.addValue("tg_oid",training.getTg_oid());
            source.addValue("tg_ayid",training.getTg_ayid());
            source.addValue("tg_trainingname",training.getTg_trainingname());
            source.addValue("tg_givenas",training.getTg_givenas());
            source.addValue("tg_days",training.getTg_days());
            source.addValue("tg_remarks",training.getTg_remarks());
            source.addValue("tg_comment",training.getTg_comment());
            if(training.getTg_id()==0){
                jdbcTemplate.update(queries.getInsertTrainingGiven(),source);
            }
            else{
                jdbcTemplate.update(queries.getUpdateTrainingGiven(),source);
            }
        }
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("tg_id",trainings.get(0).getTg_id());
        source.addValue("tg_uid",trainings.get(0).getTg_uid());
        source.addValue("tg_oid",trainings.get(0).getTg_oid());

        return jdbcTemplate.query(queries.getTrainingGevenById(),source,new MTeacherTrainingGiven());
    }

    public List<TeacherTrainingGiven> deleteTrainingGiven(List<TeacherTrainingGiven> trainings)throws Exception {
        for(TeacherTrainingGiven training:trainings) {
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("tg_id",training.getTg_id());
            source.addValue("tg_uid",training.getTg_uid());
            source.addValue("tg_oid",training.getTg_oid());
            source.addValue("tg_ayid",training.getTg_ayid());
            source.addValue("tg_trainingname",training.getTg_trainingname());
            source.addValue("tg_givenas",training.getTg_givenas());
            source.addValue("tg_days",training.getTg_days());
            source.addValue("tg_remarks",training.getTg_remarks());
            source.addValue("tg_comment",training.getTg_comment());
            if(training.getTg_id()!=0){
                jdbcTemplate.update(queries.getDeleteTrainingGiven(),source);
            }

        }
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("tg_id",trainings.get(0).getTg_id());
        source.addValue("tg_uid",trainings.get(0).getTg_uid());
        source.addValue("tg_oid",trainings.get(0).getTg_oid());

        return jdbcTemplate.query(queries.getTrainingGevenById(),source,new MTeacherTrainingGiven());
    }

    public List<TeacherTrainingGiven> updateTrainingGiven(List<TeacherTrainingGiven> trainings) throws Exception{
        for(TeacherTrainingGiven training:trainings) {
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("tg_id",training.getTg_id());
            source.addValue("tg_uid",training.getTg_uid());
            source.addValue("tg_oid",training.getTg_oid());
            source.addValue("tg_ayid",training.getTg_ayid());
            source.addValue("tg_trainingname",training.getTg_trainingname());
            source.addValue("tg_givenas",training.getTg_givenas());
            source.addValue("tg_days",training.getTg_days());
            source.addValue("tg_remarks",training.getTg_remarks());
            source.addValue("tg_comment",training.getTg_comment());
            if(training.getTg_id()==0){
                jdbcTemplate.update(queries.getInsertTrainingGiven(),source);
            }
            else{
                jdbcTemplate.update(queries.getUpdateTrainingGiven(),source);
            }
        }
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("tg_id",trainings.get(0).getTg_id());
        source.addValue("tg_uid",trainings.get(0).getTg_uid());
        source.addValue("tg_oid",trainings.get(0).getTg_oid());

        return jdbcTemplate.query(queries.getTrainingGevenById(),source,new MTeacherTrainingGiven());
    }

    public List<TeacherTrainingGiven> trainingGevenById(TeacherTrainingGiven training) throws Exception{


        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("tg_id",training.getTg_id());
        source.addValue("tg_uid",training.getTg_uid());
        source.addValue("tg_oid",training.getTg_oid());

        return jdbcTemplate.query(queries.getTrainingGevenById(),source,new MTeacherTrainingGiven());
    }

    public List<Achievements> insertAchievements(List<Achievements> achieves) throws Exception{
        for(Achievements achieve:achieves) {
                MapSqlParameterSource source = new MapSqlParameterSource();
                source.addValue("u_id",achieve.getU_id());
                source.addValue("u_uid",achieve.getU_uid());
                source.addValue("u_oid",achieve.getU_oid());
                source.addValue("u_category",achieve.getU_category());
                source.addValue("u_achievement",achieve.getU_achievement());
                source.addValue("u_leavel",achieve.getU_leavel());
                source.addValue("u_rank",achieve.getU_rank());
                source.addValue("u_date",achieve.getU_date());
                source.addValue("u_sponsor",achieve.getU_sponsor());
                source.addValue("u_remark",achieve.getU_remark());
                if(achieve.getU_id()==0){
                    jdbcTemplate.update(queries.getInsertAchievements(),source);
                }
                else{
                    jdbcTemplate.update(queries.getUpdateAchievements(),source);
                }
            }
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("u_id",achieves.get(0).getU_id());
            source.addValue("u_uid",achieves.get(0).getU_uid());
            source.addValue("u_oid",achieves.get(0).getU_oid());

            return jdbcTemplate.query(queries.getAchievementsById(),source,new MAchievements());
        }

    public List<Achievements> deleteAchievements(List<Achievements> achieves) throws Exception{
        for(Achievements achieve:achieves) {
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("u_id",achieve.getU_id());
            source.addValue("u_uid",achieve.getU_uid());
            source.addValue("u_oid",achieve.getU_oid());
            source.addValue("u_category",achieve.getU_category());
            source.addValue("u_achievement",achieve.getU_achievement());
            source.addValue("u_leavel",achieve.getU_leavel());
            source.addValue("u_rank",achieve.getU_rank());
            source.addValue("u_date",achieve.getU_date());
            source.addValue("u_sponsor",achieve.getU_sponsor());
            source.addValue("u_remark",achieve.getU_remark());
            if(achieve.getU_id()!=0){
                jdbcTemplate.update(queries.getDeleteAchievements(),source);
            }

        }
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("u_id",achieves.get(0).getU_id());
        source.addValue("u_uid",achieves.get(0).getU_uid());
        source.addValue("u_oid",achieves.get(0).getU_oid());

        return jdbcTemplate.query(queries.getAchievementsById(),source,new MAchievements());
    }

    public List<Achievements> updateAchievements(List<Achievements> achieves) throws Exception{
        for(Achievements achieve:achieves) {
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("u_id",achieve.getU_id());
            source.addValue("u_uid",achieve.getU_uid());
            source.addValue("u_oid",achieve.getU_oid());
            source.addValue("u_category",achieve.getU_category());
            source.addValue("u_achievement",achieve.getU_achievement());
            source.addValue("u_leavel",achieve.getU_leavel());
            source.addValue("u_rank",achieve.getU_rank());
            source.addValue("u_date",achieve.getU_date());
            source.addValue("u_sponsor",achieve.getU_sponsor());
            source.addValue("u_remark",achieve.getU_remark());
            if(achieve.getU_id()==0){
                jdbcTemplate.update(queries.getInsertAchievements(),source);
            }
            else{
                jdbcTemplate.update(queries.getUpdateAchievements(),source);
            }
        }
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("u_id",achieves.get(0).getU_id());
        source.addValue("u_uid",achieves.get(0).getU_uid());
        source.addValue("u_oid",achieves.get(0).getU_oid());

        return jdbcTemplate.query(queries.getAchievementsById(),source,new MAchievements());
    }

    public List<Achievements> achievementsById(Achievements achieve) throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("u_id",achieve.getU_id());
        source.addValue("u_uid",achieve.getU_uid());
        source.addValue("u_oid",achieve.getU_oid());

        return jdbcTemplate.query(queries.getAchievementsById(),source,new MAchievements());
    }

    public List<UserDisabilities> insertUserDisabilities(List<UserDisabilities> disabilities) throws Exception{
        System.out.println(disabilities.size());
        for(UserDisabilities disability:disabilities) {
            MapSqlParameterSource source = new MapSqlParameterSource();

            source.addValue("ud_did", disability.getUd_did());
            source.addValue("ud_did", disability.getUd_did());
            source.addValue("ud_uid", disability.getUd_uid());
            source.addValue("ud_oid", disability.getUd_oid());
            source.addValue("ud_dcode", disability.getUd_dcode());

                jdbcTemplate.update(queries.getInsertDisabilities(), source);

        }
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("ud_oid",disabilities.get(0).getUd_oid());
        source.addValue("ud_uid",disabilities.get(0).getUd_uid());
        return jdbcTemplate.query(queries.getUserDisabilitiesById(),source,new MUserDisabilities());

    }

    public List<UserDisabilities> updateUserDisabilities(List<UserDisabilities> disabilities) throws Exception{
        deleteDisabilities(disabilities);
        for(UserDisabilities disability:disabilities) {
            MapSqlParameterSource source = new MapSqlParameterSource();

            source.addValue("ud_did", disability.getUd_did());
            source.addValue("ud_did", disability.getUd_did());
            source.addValue("ud_uid", disability.getUd_uid());
            source.addValue("ud_oid", disability.getUd_oid());
            source.addValue("ud_dcode", disability.getUd_dcode());
            if(disability.getUd_did() ==0) {
                jdbcTemplate.update(queries.getInsertDisabilities(), source);
            }else{
                jdbcTemplate.update(queries.getUpdateDisabilities(), source);
            }
        }
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("ud_oid",disabilities.get(0).getUd_oid());
        source.addValue("ud_uid",disabilities.get(0).getUd_uid());
        return jdbcTemplate.query(queries.getUserDisabilitiesById(),source,new MUserDisabilities());

    }

    public List<UserDisabilities> deleteDisabilities(List<UserDisabilities> disabilities) throws Exception {
        for(UserDisabilities disability:disabilities) {
            MapSqlParameterSource source = new MapSqlParameterSource();

            source.addValue("ud_did", disability.getUd_did());
            source.addValue("ud_did", disability.getUd_did());
            source.addValue("ud_uid", disability.getUd_uid());
            source.addValue("ud_oid", disability.getUd_oid());
            source.addValue("ud_dcode", disability.getUd_dcode());
            if(disability.getUd_did() !=0) {
                jdbcTemplate.update(queries.getDeleteDisabilities(), source);
            }
        }
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("ud_oid",disabilities.get(0).getUd_oid());
        source.addValue("ud_uid",disabilities.get(0).getUd_uid());
        return jdbcTemplate.query(queries.getUserDisabilitiesById(),source,new MUserDisabilities());

    }

    public List<UserDisabilities> getUserDisabilitiesById(UserDisabilities disability) throws Exception {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("ud_oid",disability.getUd_oid());
        source.addValue("ud_uid",disability.getUd_uid());
        return jdbcTemplate.query(queries.getUserDisabilitiesById(),source,new MUserDisabilities());

    }

    public String userAdmissionRequest(StudentAdmission admission) throws Exception {
            List<StudentAdmission> admissions = insertStudentEnrollment(admission);
        GeneratedKeyHolder holder = new GeneratedKeyHolder();

        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("s_id",admission.getS_id());
        source.addValue("s_oid",admission.getS_oid());
        source.addValue("s_bid",admission.getS_bid());
        source.addValue("s_first_name",admission.getS_first_name());
        source.addValue("s_middle_name",admission.getS_middle_name());
        source.addValue("s_last_name",admission.getS_last_name());
        source.addValue("s_dob",admission.getS_dob());
        source.addValue("s_nativity",admission.getS_nativity());
        source.addValue("s_nationality",admission.getS_nationality());
        source.addValue("s_religion",admission.getS_religion());
        source.addValue("s_caste",admission.getS_caste());
        source.addValue("s_subcaste",admission.getS_subcaste());
        source.addValue("s_father_name",admission.getS_father_name());
        source.addValue("s_mother_name",admission.getS_mother_name());
        source.addValue("s_guadian_name",admission.getS_guadian_name());
        source.addValue("s_guadian_relationship",admission.getS_guadian_relationship());
        source.addValue("s_address",admission.getS_address());
        source.addValue("s_location",admission.getS_location());
        source.addValue("s_street",admission.getS_street());
        source.addValue("s_city",admission.getS_city());
        source.addValue("s_state",admission.getS_state());
        source.addValue("s_country",admission.getS_country());
        source.addValue("s_zipcode",admission.getS_zipcode());
        source.addValue("s_mandal",admission.getS_mandal());
        source.addValue("s_district",admission.getS_district());
        source.addValue("s_pcontactno",admission.getS_pcontactno());
        source.addValue("s_scontactno",admission.getS_scontactno());
        source.addValue("s_gender",admission.getS_gender());
        source.addValue("s_created_date",admission.getS_created_date());
        source.addValue("s_date_enrolled",admission.getS_date_enrolled());
        source.addValue("s_applied_for",admission.getS_applied_for());
        source.addValue("s_status_of_application",admission.getS_status_of_application());
        source.addValue("s_processed_By",admission.getS_processed_By());
        source.addValue("s_approved_by",admission.getS_approved_by());
        source.addValue("s_remark",admission.getS_remark());
        source.addValue("s_updated_date",admission.getS_updated_date());
        source.addValue("s_updated_by",admission.getS_updated_by());
        source.addValue("s_active_ind",admission.isS_active_ind());
        source.addValue("s_application_status",admission.getS_application_status());
        source.addValue("s_doa",admission.getS_doa());
        source.addValue("s_coursename",admission.getS_coursename());
        source.addValue("s_admission_year",admission.getS_admission_year());
        source.addValue("s_admission_for",admission.getS_admission_for());
        source.addValue("s_email_id",admission.getS_email_id());
        if(admission.getS_id()==0) {
            jdbcTemplate.update(queries.getInsertStudentEnrollment(), source, holder);
            long generatedValue = holder.getKey().longValue();
            admission.setS_id(holder.getKey().intValue());
        }
        else{
            jdbcTemplate.update(queries.getUpdateStudentEnrolled(),source);
        }
        return String.valueOf(admission.getS_id());
    }
    public List<StudentAdmission> insertStudentEnrollment(StudentAdmission admission) throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("s_id",admission.getS_id());
        source.addValue("s_oid",admission.getS_oid());
        source.addValue("s_bid",admission.getS_bid());
        source.addValue("s_first_name",admission.getS_first_name());
        source.addValue("s_middle_name",admission.getS_middle_name());
        source.addValue("s_last_name",admission.getS_last_name());
        source.addValue("s_dob",admission.getS_dob());
        source.addValue("s_nativity",admission.getS_nativity());
        source.addValue("s_nationality",admission.getS_nationality());
        source.addValue("s_religion",admission.getS_religion());
        source.addValue("s_caste",admission.getS_caste());
        source.addValue("s_subcaste",admission.getS_subcaste());
        source.addValue("s_father_name",admission.getS_father_name());
        source.addValue("s_mother_name",admission.getS_mother_name());
        source.addValue("s_guadian_name",admission.getS_guadian_name());
        source.addValue("s_guadian_relationship",admission.getS_guadian_relationship());
        source.addValue("s_address",admission.getS_address());
        source.addValue("s_location",admission.getS_location());
        source.addValue("s_street",admission.getS_street());
        source.addValue("s_city",admission.getS_city());
        source.addValue("s_state",admission.getS_state());
        source.addValue("s_country",admission.getS_country());
        source.addValue("s_zipcode",admission.getS_zipcode());
        source.addValue("s_mandal",admission.getS_mandal());
        source.addValue("s_district",admission.getS_district());
        source.addValue("s_pcontactno",admission.getS_pcontactno());
        source.addValue("s_scontactno",admission.getS_scontactno());
        source.addValue("s_gender",admission.getS_gender());
        source.addValue("s_created_date",admission.getS_created_date());
        source.addValue("s_date_enrolled",admission.getS_date_enrolled());
        source.addValue("s_applied_for",admission.getS_applied_for());
        source.addValue("s_status_of_application",admission.getS_status_of_application());
        source.addValue("s_processed_By",admission.getS_processed_By());
        source.addValue("s_approved_by",admission.getS_approved_by());
        source.addValue("s_remark",admission.getS_remark());
        source.addValue("s_updated_date",admission.getS_updated_date());
        source.addValue("s_updated_by",admission.getS_updated_by());
        source.addValue("s_active_ind",admission.isS_active_ind());
        source.addValue("s_application_status",admission.getS_application_status());
        source.addValue("s_doa",admission.getS_doa());
        source.addValue("s_coursename",admission.getS_coursename());
        source.addValue("s_admission_year",admission.getS_admission_year());
        source.addValue("s_admission_for",admission.getS_admission_for());
        source.addValue("s_email_id",admission.getS_email_id());
        if(admission.getS_id()==0) {
            jdbcTemplate.update(queries.getInsertStudentEnrollment(), source);
        }else{
            jdbcTemplate.update(queries.getUpdateStudentEnrolled(),source);
        }
        return jdbcTemplate.query(queries.getEnrolledStudentList(),source,new MStudentAdmission());

    }

    public List<StudentAdmission> getEnrolledStudentList(StudentAdmission admission) throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("s_id",admission.getS_id());
        source.addValue("s_oid",admission.getS_oid());
        source.addValue("s_bid",admission.getS_bid());
        source.addValue("s_first_name",admission.getS_first_name());
        source.addValue("s_middle_name",admission.getS_middle_name());
        source.addValue("s_last_name",admission.getS_last_name());
        source.addValue("s_dob",admission.getS_dob());
        source.addValue("s_nativity",admission.getS_nativity());
        source.addValue("s_nationality",admission.getS_nationality());
        source.addValue("s_religion",admission.getS_religion());
        source.addValue("s_caste",admission.getS_caste());
        source.addValue("s_subcaste",admission.getS_subcaste());
        source.addValue("s_father_name",admission.getS_father_name());
        source.addValue("s_mother_name",admission.getS_mother_name());
        source.addValue("s_guadian_name",admission.getS_guadian_name());
        source.addValue("s_guadian_relationship",admission.getS_guadian_relationship());
        source.addValue("s_address",admission.getS_address());
        source.addValue("s_location",admission.getS_location());
        source.addValue("s_street",admission.getS_street());
        source.addValue("s_city",admission.getS_city());
        source.addValue("s_state",admission.getS_state());
        source.addValue("s_country",admission.getS_country());
        source.addValue("s_zipcode",admission.getS_zipcode());
        source.addValue("s_mandal",admission.getS_mandal());
        source.addValue("s_district",admission.getS_district());
        source.addValue("s_pcontactno",admission.getS_pcontactno());
        source.addValue("s_scontactno",admission.getS_scontactno());
        source.addValue("s_gender",admission.getS_gender());
        source.addValue("s_created_date",admission.getS_created_date());
        source.addValue("s_date_enrolled",admission.getS_date_enrolled());
        source.addValue("s_applied_for",admission.getS_applied_for());
        source.addValue("s_status_of_application",admission.getS_status_of_application());
        source.addValue("s_processed_By",admission.getS_processed_By());
        source.addValue("s_approved_by",admission.getS_approved_by());
        source.addValue("s_remark",admission.getS_remark());
        source.addValue("s_updated_date",admission.getS_updated_date());
        source.addValue("s_updated_by",admission.getS_updated_by());
        source.addValue("s_active_ind",admission.isS_active_ind());
        source.addValue("s_application_status",admission.getS_application_status());
        source.addValue("s_doa",admission.getS_doa());
        source.addValue("s_coursename",admission.getS_coursename());
        source.addValue("s_admission_year",admission.getS_admission_year());
        source.addValue("s_admission_for",admission.getS_admission_for());
        source.addValue("s_email_id",admission.getS_email_id());
        System.out.println(queries.getEnrolledStudentList());
        System.out.println(jdbcTemplate.query(queries.getEnrolledStudentList(),source,new MStudentAdmission()));
        return jdbcTemplate.query(queries.getEnrolledStudentList(),source,new MStudentAdmission());

    }

    public List<StudentAdmission> getEnrolledStudentById(StudentAdmission admission) throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("s_id",admission.getS_id());
        source.addValue("s_oid",admission.getS_oid());
        source.addValue("s_bid",admission.getS_bid());
        source.addValue("s_first_name",admission.getS_first_name());
        source.addValue("s_middle_name",admission.getS_middle_name());
        source.addValue("s_last_name",admission.getS_last_name());
        source.addValue("s_dob",admission.getS_dob());
        source.addValue("s_nativity",admission.getS_nativity());
        source.addValue("s_nationality",admission.getS_nationality());
        source.addValue("s_religion",admission.getS_religion());
        source.addValue("s_caste",admission.getS_caste());
        source.addValue("s_subcaste",admission.getS_subcaste());
        source.addValue("s_father_name",admission.getS_father_name());
        source.addValue("s_mother_name",admission.getS_mother_name());
        source.addValue("s_guadian_name",admission.getS_guadian_name());
        source.addValue("s_guadian_relationship",admission.getS_guadian_relationship());
        source.addValue("s_address",admission.getS_address());
        source.addValue("s_location",admission.getS_location());
        source.addValue("s_street",admission.getS_street());
        source.addValue("s_city",admission.getS_city());
        source.addValue("s_state",admission.getS_state());
        source.addValue("s_country",admission.getS_country());
        source.addValue("s_zipcode",admission.getS_zipcode());
        source.addValue("s_mandal",admission.getS_mandal());
        source.addValue("s_district",admission.getS_district());
        source.addValue("s_pcontactno",admission.getS_pcontactno());
        source.addValue("s_scontactno",admission.getS_scontactno());
        source.addValue("s_gender",admission.getS_gender());
        source.addValue("s_created_date",admission.getS_created_date());
        source.addValue("s_date_enrolled",admission.getS_date_enrolled());
        source.addValue("s_applied_for",admission.getS_applied_for());
        source.addValue("s_status_of_application",admission.getS_status_of_application());
        source.addValue("s_processed_By",admission.getS_processed_By());
        source.addValue("s_approved_by",admission.getS_approved_by());
        source.addValue("s_remark",admission.getS_remark());
        source.addValue("s_updated_date",admission.getS_updated_date());
        source.addValue("s_updated_by",admission.getS_updated_by());
        source.addValue("s_active_ind",admission.isS_active_ind());
        source.addValue("s_application_status",admission.getS_application_status());
        source.addValue("s_doa",admission.getS_doa());
        source.addValue("s_coursename",admission.getS_coursename());
        source.addValue("s_admission_year",admission.getS_admission_year());
        source.addValue("s_admission_for",admission.getS_admission_for());
        source.addValue("s_email_id",admission.getS_email_id());
        return jdbcTemplate.query(queries.getEnrolledStudentById(),source,new MStudentAdmission());

    }
    public List<StudentAdmission> getEnrolledStudentByCourse(StudentAdmission admission) throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("s_id",admission.getS_id());
        source.addValue("s_oid",admission.getS_oid());
        source.addValue("s_bid",admission.getS_bid());
        source.addValue("s_first_name",admission.getS_first_name());
        source.addValue("s_middle_name",admission.getS_middle_name());
        source.addValue("s_last_name",admission.getS_last_name());
        source.addValue("s_dob",admission.getS_dob());
        source.addValue("s_nativity",admission.getS_nativity());
        source.addValue("s_nationality",admission.getS_nationality());
        source.addValue("s_religion",admission.getS_religion());
        source.addValue("s_caste",admission.getS_caste());
        source.addValue("s_subcaste",admission.getS_subcaste());
        source.addValue("s_father_name",admission.getS_father_name());
        source.addValue("s_mother_name",admission.getS_mother_name());
        source.addValue("s_guadian_name",admission.getS_guadian_name());
        source.addValue("s_guadian_relationship",admission.getS_guadian_relationship());
        source.addValue("s_address",admission.getS_address());
        source.addValue("s_location",admission.getS_location());
        source.addValue("s_street",admission.getS_street());
        source.addValue("s_city",admission.getS_city());
        source.addValue("s_state",admission.getS_state());
        source.addValue("s_country",admission.getS_country());
        source.addValue("s_zipcode",admission.getS_zipcode());
        source.addValue("s_mandal",admission.getS_mandal());
        source.addValue("s_district",admission.getS_district());
        source.addValue("s_pcontactno",admission.getS_pcontactno());
        source.addValue("s_scontactno",admission.getS_scontactno());
        source.addValue("s_gender",admission.getS_gender());
        source.addValue("s_created_date",admission.getS_created_date());
        source.addValue("s_date_enrolled",admission.getS_date_enrolled());
        source.addValue("s_applied_for",admission.getS_applied_for());
        source.addValue("s_status_of_application",admission.getS_status_of_application());
        source.addValue("s_processed_By",admission.getS_processed_By());
        source.addValue("s_approved_by",admission.getS_approved_by());
        source.addValue("s_remark",admission.getS_remark());
        source.addValue("s_updated_date",admission.getS_updated_date());
        source.addValue("s_updated_by",admission.getS_updated_by());
        source.addValue("s_active_ind",admission.isS_active_ind());
        source.addValue("s_application_status",admission.getS_application_status());
        source.addValue("s_doa",admission.getS_doa());
        source.addValue("s_coursename",admission.getS_coursename());
        source.addValue("s_admission_year",admission.getS_admission_year());
        source.addValue("s_admission_for",admission.getS_admission_for());
        source.addValue("s_email_id",admission.getS_email_id());
        return jdbcTemplate.query(queries.getEnrolledStudentByCourse(),source,new MStudentAdmission());

    }

    public List<Student> insertStudent(Student student)throws Exception {
        MapSqlParameterSource source = new MapSqlParameterSource();
        MapSqlParameterSource studentSource = new MapSqlParameterSource();
        MapSqlParameterSource parentSource = new MapSqlParameterSource();
        MapSqlParameterSource studentClsSecSource = new MapSqlParameterSource();
        MapSqlParameterSource stdDisabilitiesSource = new MapSqlParameterSource();
        sourceMap(student,source);
        studentParentSourceMap(student,parentSource);
        if(student.getParent().getP_id() == 0) {
            List<Parent> checkparents = getParentSearchByNameAndContact(student.getParent());
            if (checkparents != null && checkparents.size() > 0) {
                throw new Exception("Duplicate Parent Details");
            }
        }

        if( student.getParent().getP_id()==0) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(queries.getInsertParent(), parentSource, keyHolder);
            student.setS_pid(Integer.parseInt(keyHolder.getKey().toString()));
        }
        else{
            jdbcTemplate.update(queries.getUpdateParent(), parentSource);
        }
        studentSourceMap(student,studentSource);
        if(student.getS_id()==null ) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(queries.getInsertStudent(), studentSource, keyHolder);
            student.setS_id(new BigDecimal(keyHolder.getKey().toString()));
        }else{
            student.getStudentClsSec().setS_sid(student.getS_id().intValue());
            jdbcTemplate.update(queries.getUpdateStudent(), studentSource);
        }

        studentClsSecSourceMap(student, studentClsSecSource);
        if(student.getStudentClsSec().getS_scsid()==0) {
            jdbcTemplate.update(queries.getInsertStudentClassSection(), studentClsSecSource);
        }else{
            jdbcTemplate.update(queries.getUpdateStudentClassSection(), studentClsSecSource);
        }
        for(StudentAcademicHistory academicHistory:student.getAcademic()) {
            MapSqlParameterSource academicSource = new MapSqlParameterSource();
            academicHistory.setS_id(student.getS_id());
            studentAcademicHistorySourceMap(academicHistory, academicSource);

            if (academicHistory.getS_sahid() == null) {
                jdbcTemplate.update(queries.getInsertStudentAcademicHistory(), academicSource);
            } else {
                jdbcTemplate.update(queries.getUpdateStudentAcademicHistory(), academicSource);
            }
        }
        if(student.isS_physically_handicap() && student.getHandicaplist() != null){
            for(String disability:student.getHandicaplist()){
                stdDisabilitiesSource = new MapSqlParameterSource();
                stdDisabilitiesSource.addValue("ud_did",student.getS_bid());
                stdDisabilitiesSource.addValue("ud_uid",student.getS_id());
                stdDisabilitiesSource.addValue("ud_oid",student.getS_oid());
                stdDisabilitiesSource.addValue("ud_dcode",disability);
                jdbcTemplate.update(queries.getDeleteStudentDisabilities(),stdDisabilitiesSource);
                jdbcTemplate.update(queries.getInsertStudentDisabilities(),stdDisabilitiesSource);
            }
        }
        List<Student>  students = jdbcTemplate.query(queries.getStudentByClass(),source,new MStudent());

        return students;
    }
    public List<Student> studentsListByClass(Student student) throws Exception {
        System.out.println("calling student list by class");
        System.out.println(student.toString());
        MapSqlParameterSource studentSource = new MapSqlParameterSource();
        MapSqlParameterSource disabilitySource = new MapSqlParameterSource();
        studentSourceMap(student,studentSource);
        student.getStudentClsSec().setS_bid(student.getS_bid());
        student.getStudentClsSec().setS_oid(student.getS_oid());
        studentClsSecSourceMap(student,studentSource);
        System.out.println(studentSource.getValues());
        List<Student> students = jdbcTemplate.query(queries.getStudentsListByClass(),studentSource,new MStudentList());
        System.out.println(students.size());
        for(Student std:students) {
            List<StudentAcademicHistory> academics = null;
            StudentAcademicHistory acad = new StudentAcademicHistory();
            acad.setS_oid(std.getS_oid().intValue());
            acad.setS_id(std.getS_id() == null?null:std.getS_id());
            acad.setS_bid(std.getS_bid().intValue());
            studentAcademicHistorySourceMap(acad,studentSource);

            academics = jdbcTemplate.query(queries.getStudentAcademicHistoryById(), studentSource, new MStudentAcademicHistory());
            std.setAcademic(academics);

            if(std.isS_physically_handicap()) {
                disabilitySource = new MapSqlParameterSource();
                disabilitySource.addValue("ud_uid",std.getS_id());
                disabilitySource.addValue("ud_oid",std.getS_oid());
                List<UserDisabilities> disabilities = jdbcTemplate.query(queries.getUserStudentDisabilitiesById(),disabilitySource,new MUserDisabilities());
                List<String> ud = new ArrayList<String>();
                for (UserDisabilities d:disabilities){
                    ud.add(d.getUd_dcode());
                }
                std.setHandicaplist(ud.stream().toArray(String[]::new));
            }


        }


        return students;

    }
    private void sourceMap(Student student,MapSqlParameterSource source) throws Exception {
        studentSourceMap(student,source);
        studentParentSourceMap(student,source);
        studentClsSecSourceMap(student, source);

    }
    private void studentSourceMap(Student student,MapSqlParameterSource source) throws Exception{
        source.addValue("s_id",student.getS_id());
        source.addValue("s_admission_no",student.getS_admission_no());
        source.addValue("s_roll_no",student.getS_roll_no());
        source.addValue("s_oid",student.getS_oid());
        source.addValue("s_bid",student.getS_bid());
        source.addValue("s_first_name",student.getS_first_name());
        source.addValue("s_middle_name",student.getS_middle_name());
        source.addValue("s_last_name",student.getS_last_name());
        source.addValue("s_dob",student.getS_dob());
        source.addValue("s_nativity",student.getS_nativity());
        source.addValue("s_nationality",student.getS_nationality());
        source.addValue("s_religion",student.getS_religion());
        source.addValue("s_caste",student.getS_caste());
        source.addValue("s_subcaste",student.getS_subcaste());
        source.addValue("s_bp_village",student.getS_bp_village());
        source.addValue("s_bp_taluka",student.getS_bp_taluka());
        source.addValue("s_bp_district",student.getS_bp_district());
        source.addValue("s_bp_state",student.getS_bp_state());
        source.addValue("s_current_address",student.getS_current_address());
        source.addValue("s_current_location",student.getS_current_location());
        source.addValue("s_current_street",student.getS_current_street());
        source.addValue("s_current_city",student.getS_current_city());
        source.addValue("s_current_state",student.getS_current_state());
        source.addValue("s_current_country",student.getS_current_country());
        source.addValue("s_current_zipcode",student.getS_current_zipcode());
        source.addValue("s_current_mandal",student.getS_current_mandal());
        source.addValue("s_current_district",student.getS_current_district());
        source.addValue("s_pcontactno",student.getS_pcontactno());
        source.addValue("s_scontactno",student.getS_scontactno());
        source.addValue("s_econtactno",student.getS_econtactno());
        source.addValue("s_present_address",student.getS_present_address());
        source.addValue("s_present_location",student.getS_present_location());
        source.addValue("s_present_street",student.getS_present_street());
        source.addValue("s_present_city",student.getS_present_city());
        source.addValue("s_present_state",student.getS_present_state());
        source.addValue("s_present_country",student.getS_present_country());
        source.addValue("s_present_zipcode",student.getS_present_zipcode());
        source.addValue("s_present_mandal",student.getS_present_mandal());
        source.addValue("s_present_district",student.getS_present_district());
        source.addValue("s_gender",student.getS_gender());
        source.addValue("s_created_date",student.getS_created_date());
        source.addValue("s_date_joined",student.getS_date_joined());
        source.addValue("s_created_By",student.getS_created_By());
        source.addValue("s_approved_by",student.getS_approved_by());
        source.addValue("s_remark",student.getS_remark());
        source.addValue("s_updated_date",student.getS_updated_date());
        source.addValue("s_updated_by",student.getS_updated_by());
        source.addValue("s_active_ind",student.isS_active_ind());
        source.addValue("s_mother_tongue",student.getS_mother_tongue());
        source.addValue("s_height",student.getS_height());
        source.addValue("s_weight",student.getS_weight());
        source.addValue("s_bloodgroup",student.getS_bloodgroup());
        source.addValue("s_physically_handicap",student.isS_physically_handicap());
        source.addValue("s_isOrphan",student.isS_isOrphan());
        source.addValue("s_aadharno",student.getS_aadharno());
        source.addValue("s_photo",student.getS_photo());
        source.addValue("s_pid",student.getS_pid());


    }
    private void studentParentSourceMap(Student student,MapSqlParameterSource source) throws Exception{
        source.addValue("p_id", student.getParent().getP_id());
        source.addValue("p_father_name",student.getParent().getP_father_name());
        source.addValue("p_mother_name",student.getParent().getP_mother_name());
        source.addValue("p_guardian_name",student.getParent().getP_guardian_name());
        source.addValue("p_email_id",student.getParent().getP_email_id());
        source.addValue("p_father_contactno",student.getParent().getP_father_contactno());
        source.addValue("p_mother_contactno",student.getParent().getP_mother_contactno());
        source.addValue("p_guardian_contactno",student.getParent().getP_guardian_contactno());
        source.addValue("p_address",student.getParent().getP_address());
        source.addValue("p_location",student.getParent().getP_location());
        source.addValue("p_street",student.getParent().getP_street());
        source.addValue("p_state",student.getParent().getP_state());
        source.addValue("p_city",student.getParent().getP_city());
        source.addValue("p_country",student.getParent().getP_country());
        source.addValue("p_zipcode",student.getParent().getP_zipcode());
        source.addValue("p_active_ind",student.getParent().isP_active_ind());
        source.addValue("p_oid",student.getS_oid());
        source.addValue("p_father_profission",student.getParent().getP_father_profission());
        source.addValue("p_mother_profission",student.getParent().getP_mother_profission());
        source.addValue("p_guardian_profission",student.getParent().getP_guardian_profission());
        source.addValue("p_father_qualification",student.getParent().getP_father_qualification());
        source.addValue("p_mother_qualification",student.getParent().getP_mother_qualification());
        source.addValue("p_guardian_qualification",student.getParent().getP_mother_qualification());
        source.addValue("p_father_income",student.getParent().getP_father_income());
        source.addValue("p_mother_income",student.getParent().getP_mother_income());
        source.addValue("p_guardian_income",student.getParent().getP_guardian_income());
        source.addValue("p_father_aadhar_no",student.getParent().getP_father_aadhar_no());
        source.addValue("p_mother_aadhar_no",student.getParent().getP_mother_aadhar_no());
        source.addValue("p_guardian_aadhar_no",student.getParent().getP_guardian_aadhar_no());
        source.addValue("p_student_id",student.getS_id());


    }
    private void studentClsSecSourceMap(Student student,MapSqlParameterSource source) throws Exception{

        source.addValue("s_scsid",student.getStudentClsSec().getS_scsid());
        source.addValue("s_sid",student.getS_id());
        source.addValue("s_clsid",student.getStudentClsSec().getS_clsid());
        source.addValue("s_cls_code",student.getStudentClsSec().getS_cls_code());
        source.addValue("s_ayid",student.getStudentClsSec().getS_ayid());
        source.addValue("s_oid",student.getStudentClsSec().getS_oid());
        source.addValue("s_bid",student.getStudentClsSec().getS_bid());
        source.addValue("s_active_ind",student.getStudentClsSec().isS_active_ind());

    }
    private void studentAcademicHistorySourceMap(StudentAcademicHistory academic,MapSqlParameterSource source) throws Exception{
        source.addValue("s_sahid",academic.getS_sahid());
        source.addValue("s_id",academic.getS_id());
        source.addValue("s_courseName",academic.getS_courseName());
        source.addValue("s_organization",academic.getS_organization());
        source.addValue("s_marks",academic.getS_marks());
        source.addValue("s_year",academic.getS_year());
        source.addValue("s_grade",academic.getS_grade());
        source.addValue("s_stream",academic.getS_stream());
        source.addValue("s_comment",academic.getS_comment());
        source.addValue("s_attachment",academic.getS_attachment());
        source.addValue("s_oid",academic.getS_oid());
        source.addValue("s_bid",academic.getS_bid());

    }

    public List<Parent> getParentSearchByNameAndContact(Parent parent){
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("p_father_name",parent.getP_father_name());
        source.addValue("p_mother_name",parent.getP_mother_name());
        source.addValue("p_guardian_name",parent.getP_guardian_name());
        source.addValue("p_father_contactno",parent.getP_father_contactno());
        source.addValue("p_mother_contactno",parent.getP_mother_contactno());
        source.addValue("p_guardian_contactno",parent.getP_guardian_contactno());
        source.addValue("p_email_id",parent.getP_email_id());
        return jdbcTemplate.query(queries.getParentSearchByNameAndContact(),source,new MParent());

    }
    public List<AdmissionYears> insertAdmissionsYear(AdmissionYears admission) throws Exception{
        System.out.println(admission.toString());
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("ay_id",admission.getAy_id());
        source.addValue("ay_oid",admission.getAy_oid());
        source.addValue("ay_bid",admission.getAy_bid());
        source.addValue("ay_year",admission.getAy_year());
        source.addValue("ay_desc",admission.getAy_desc());
        source.addValue("ay_active_ind",admission.isAy_active_ind());
        if(admission.getAy_id()==0){
            jdbcTemplate.update(queries.getAdmissionYearInsert(),source);
        }
        else{
            jdbcTemplate.update(queries.getAdmissionYearUpdate(),source);
        }
        return jdbcTemplate.query(queries.getAdmissionYearGetAll(),source,new MAdmissionYears());
    }
    public List<AdmissionYears> updateAdmissionsYear(AdmissionYears admission) throws Exception{
        List<AdmissionYears> admissions = new ArrayList<AdmissionYears>();
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("ay_id",admission.getAy_id());
        source.addValue("ay_oid",admission.getAy_oid());
        source.addValue("ay_bid",admission.getAy_bid());
        source.addValue("ay_year",admission.getAy_year());
        source.addValue("ay_desc",admission.getAy_desc());
        source.addValue("ay_active_ind",admission.isAy_active_ind());
        if(admission.getAy_id()==0){
            jdbcTemplate.update(queries.getAdmissionYearInsert(),source);
        }
        else{
            jdbcTemplate.update(queries.getAdmissionYearUpdate(),source);
        }
        return jdbcTemplate.query(queries.getAdmissionYearGetAll(),source,new MAdmissionYears());
    }
    public List<AdmissionYears> deleteAdmissionsYear(AdmissionYears admission) throws Exception{
        System.out.println(admission.toString());
        List<AdmissionYears> admissions = new ArrayList<AdmissionYears>();
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("ay_id",admission.getAy_id());
        source.addValue("ay_oid",admission.getAy_oid());
        source.addValue("ay_bid",admission.getAy_bid());
        source.addValue("ay_year",admission.getAy_year());
        source.addValue("ay_desc",admission.getAy_desc());
        source.addValue("ay_active_ind",admission.isAy_active_ind());
        if(admission.getAy_id()!=0){
            jdbcTemplate.update(queries.getAdmissionYearDelete(),source);
        }
        return jdbcTemplate.query(queries.getAdmissionYearGetAll(),source,new MAdmissionYears());
    }
    public List<AdmissionYears> getAllAdmissionYears(AdmissionYears admission) throws Exception{
        List<AdmissionYears> admissions = new ArrayList<AdmissionYears>();
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("ay_id",admission.getAy_id());
        source.addValue("ay_oid",admission.getAy_oid());
        source.addValue("ay_bid",admission.getAy_bid());
        source.addValue("ay_year",admission.getAy_year());
        source.addValue("ay_desc",admission.getAy_desc());
        source.addValue("ay_active_ind",admission.isAy_active_ind());

        return jdbcTemplate.query(queries.getAdmissionYearGetAll(),source,new MAdmissionYears());
    }
    public List<AdmissionYears> getActiveAdmissionYear(AdmissionYears admission) throws Exception{
        List<AdmissionYears> admissions = new ArrayList<AdmissionYears>();
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("ay_id",admission.getAy_id());
        source.addValue("ay_oid",admission.getAy_oid());
        source.addValue("ay_bid",admission.getAy_bid());
        source.addValue("ay_year",admission.getAy_year());
        source.addValue("ay_desc",admission.getAy_desc());
        source.addValue("ay_active_ind",admission.isAy_active_ind());

        return jdbcTemplate.query(queries.getAdmissionYearGetActiveYear(),source,new MAdmissionYears());
    }

    }