package com.smss.api.system.mapper;

import com.smss.api.system.models.Achievements;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MAchievements implements ResultSetExtractor<List<Achievements>> {

    @Override
    public List<Achievements> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Achievements> achieves = new ArrayList<Achievements>();
        while(rs.next()){
            Achievements achieve = new Achievements();
            achieve.setU_achievement(rs.getString("u_achievement"));
            achieve.setU_category(rs.getString("u_category"));
            achieve.setU_date(rs.getDate("u_date"));
            achieve.setU_id(rs.getInt("u_id"));
            achieve.setU_leavel(rs.getString("u_leavel"));
            achieve.setU_oid(rs.getBigDecimal("u_oid"));
            achieve.setU_rank(rs.getString("u_rank"));
            achieve.setU_sponsor(rs.getString("u_sponsor"));
            achieve.setU_remark(rs.getString("u_remark"));
            achieve.setU_uid(rs.getBigDecimal("u_uid"));
            achieves.add(achieve);
        }
        return achieves;
    }
}
