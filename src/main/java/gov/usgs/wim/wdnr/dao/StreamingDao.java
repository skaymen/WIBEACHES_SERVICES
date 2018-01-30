package gov.usgs.wim.wdnr.dao;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import gov.usgs.wim.wdnr.SurveyFilterParameters;

@Component
public class StreamingDao extends SqlSessionDaoSupport {

    public static final String QUERY_SELECT_ID = ".select";
    public static final String BEACHES_RAW_DATA = "beachesRawData";

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


}
