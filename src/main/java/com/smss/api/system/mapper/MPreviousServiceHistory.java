package com.smss.api.system.mapper;

import com.smss.api.system.models.CourseCategory;
import com.smss.api.system.models.PreviousServiceHistory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MPreviousServiceHistory implements ResultSetExtractor<List<PreviousServiceHistory>> {
    @Override
    public List<PreviousServiceHistory> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<PreviousServiceHistory> servicehistory = new ArrayList<PreviousServiceHistory>();
        while(rs.next()){
            PreviousServiceHistory shist = new PreviousServiceHistory();

            shist.setU_sh(rs.getInt("u_sh"));
            shist.setU_id(rs.getBigDecimal("U_id"));
            shist.setU_oid(rs.getBigDecimal("u_oid"));
            shist.setU_organization(rs.getString("u_organization"));
            shist.setU_designation(rs.getString("u_designation"));
            shist.setU_department(rs.getString("u_department"));
            shist.setU_from_date(rs.getDate("u_from_date"));
            shist.setU_to_date(rs.getDate("u_to_date"));
            shist.setU_exp_in_years(rs.getString("u_exp_in_years"));
            shist.setU_sub_cls_taught(rs.getString("u_sub_cls_taught"));
            shist.setU_reason_to_leave(rs.getString("u_reason_to_leave"));
            shist.setU_comment(rs.getString("u_comment"));
            shist.setU_attachment(rs.getBytes("u_attachment"));
            servicehistory.add(shist);
        }
        return servicehistory;
    }
}
