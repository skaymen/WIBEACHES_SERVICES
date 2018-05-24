package gov.usgs.wim.wdnr.dao;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PercentTypeHandler implements TypeHandler<String> {

    public static final String NONE = "NONE";
    public static final String LOW = "LOW";
    public static final String MOD = "MODERATE";
    public static final String HIGH = "HIGH";

    public static final String N = "None";
    public static final String Z = "0%";
    public static final String L = "1-20%";
    public static final String M = "21-50%";
    public static final String H = ">50%";

    public String convertResult(String dbval) {
        if (dbval == null) return null;
        if (dbval.equals(NONE))
            return N;
        else if (dbval.equals(LOW))
            return L;
        else if (dbval.equals(MOD))
            return M;
        else if (dbval.equals(HIGH))
            return H;
        else
            return null;
    }

    public String convertParam(String val) {
        if (val == null) return null;
        if (val.equalsIgnoreCase(N) || val.equalsIgnoreCase(Z))
            return NONE;
        else if (val.equalsIgnoreCase(L))
            return LOW;
        else if (val.equalsIgnoreCase(M))
            return MOD;
        else if (val.equalsIgnoreCase(H))
            return HIGH;
        else
            return null;
    }

    @Override
    public String getResult(ResultSet arg0, String arg1) throws SQLException {
        return convertResult(arg0.getString(arg1));
    }

    @Override
    public String getResult(ResultSet arg0, int arg1) throws SQLException {
        return convertResult(arg0.getString(arg1));

    }

    @Override
    public String getResult(CallableStatement arg0, int arg1) throws SQLException {
        return convertResult(arg0.getString(arg1));
    }

    @Override
    public void setParameter(PreparedStatement arg0, int arg1, String arg2, JdbcType arg3) throws SQLException {
        arg0.setString(arg1, convertParam(arg2));
    }

}
