package com.smss.api.system.mapper;

import com.smss.api.system.models.FeeHeaders;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MFeeHeaders implements ResultSetExtractor<List<FeeHeaders>> {

    @Override
    public List<FeeHeaders> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<FeeHeaders> headers = new ArrayList<FeeHeaders>();
        while(rs.next()) {
            FeeHeaders header = new FeeHeaders();
            header.setFh_fee_title(rs.getString("fh_fee_title"));
            header.setFh_id(rs.getInt("fh_id"));
            header.setFh_oid(rs.getInt("fh_oid"));
            headers.add(header);

        }
        return headers;
    }
}
