package gov.usgs.wim.wdnr.dao;

import gov.usgs.wim.wdnr.webservice.BeachesRawDataController;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//import gov.usgs.wim.wdnr.SurveyFilterParameters;

@Component
public class StreamingDao extends SqlSessionDaoSupport {

    public static final String QUERY_SELECT_ID = ".select";
    public static final String BEACHES_RAW_DATA = "beachesRawData";

    private static final String GET_QUERY = ".getLastUpdate";

    @Autowired
    public StreamingDao(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactory(sqlSessionFactory);
    }

    public void stream(String nameSpace, ResultHandler<?> handler) {
        if (null == handler) {
            throw new IllegalArgumentException("A ResultHandler is required for the StreamingDao.stream");
        }
        getSqlSession().select(nameSpace + QUERY_SELECT_ID, handler);
    }

    public LocalDateTime getLastUpdate(String nameSpace) {
        return getSqlSession().selectOne(nameSpace + GET_QUERY);
    }


}
