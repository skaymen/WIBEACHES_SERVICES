package gov.usgs.wim.wdnr.dao;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitsTypeHandler implements TypeHandler<String> {

    public String convert(String val) {
        if (val.equals("MPH"))
            val = "mph";
        if (val.equals("FT"))
            val = "Ft";
        return val;

    }

    @Override
    public String getResult(ResultSet arg0, String arg1) throws SQLException {
        return arg0.getString(arg1);
    }

    @Override
    public String getResult(ResultSet arg0, int arg1) throws SQLException {
        return arg0.getString(arg1);

    }

    @Override
    public String getResult(CallableStatement arg0, int arg1) throws SQLException {
        return arg0.getString(arg1);
    }

    @Override
    public void setParameter(PreparedStatement arg0, int arg1, String arg2, JdbcType arg3) throws SQLException {
        arg0.setString(arg1, convert(arg2));
    }
}
