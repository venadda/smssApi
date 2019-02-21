package com.smss.api.system.mapper;

import com.smss.api.system.models.TrainingInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MUserTrainingInfo implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        TrainingInfo training = new TrainingInfo();
        Blob file = rs.getBlob("u_attachment");
        training.setU_attachement(file.getBytes(1, (int) file.length()));
        training.setU_comment(rs.getString("u_comment"));
        training.setU_fromdate(rs.getDate("u_fromdate"));
        training.setU_id(rs.getBigDecimal("u_id"));
        training.setU_institutename(rs.getString("u_institutename"));
        training.setU_sponsoredBy(rs.getString("u_sponsoredBy"));
        training.setU_todate(rs.getDate("u_todate"));
        training.setU_topicname(rs.getString("u_topicname"));
        training.setU_trainingtype(rs.getString("u_trainingtype"));

        return training;
    }
}
