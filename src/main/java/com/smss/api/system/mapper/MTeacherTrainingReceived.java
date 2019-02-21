package com.smss.api.system.mapper;

import com.smss.api.system.models.TeacherTrainingReceived;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MTeacherTrainingReceived implements ResultSetExtractor<List<TeacherTrainingReceived>> {
    @Override
    public List<TeacherTrainingReceived> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<TeacherTrainingReceived> receiveds = new ArrayList<TeacherTrainingReceived>();
        while(rs.next()){

            TeacherTrainingReceived rec = new TeacherTrainingReceived();
            rec.setU_attachement(rs.getBytes("u_attachement"));
            rec.setU_comment(rs.getString("u_comment"));
            rec.setU_from_date(rs.getDate("u_from_date"));
            rec.setU_id(rs.getInt("u_id"));
            rec.setU_institute_name(rs.getString("u_institute_name"));
            rec.setU_oid(rs.getBigDecimal("u_oid"));
            rec.setU_sponsored_by(rs.getString("u_sponsored_by"));
            rec.setU_to_date(rs.getDate("u_to_date"));
            rec.setU_topic_name(rs.getString("u_topic_name"));
            rec.setU_uid(rs.getBigDecimal("u_uid"));
            rec.setU_training_type(rs.getString("u_training_type"));
            receiveds.add(rec);
        }
        return receiveds;
    }
}
