package gov.usgs.wim.wdnr.spring;

import java.util.LinkedHashMap;

import javax.sql.DataSource;

import gov.usgs.wim.wdnr.dao.*;
import gov.usgs.wim.wdnr.domain.SanitaryData;
import org.apache.ibatis.type.TypeAliasRegistry;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class MybatisConfig {

    public static final String MYBATIS_MAPPERS = "mybatis/*.xml";
    public static final String LINKED_HASH_MAP_ALIAS = "LinkedHashMap";

    @Autowired
    DataSource dataSource;

    @Bean
    public org.apache.ibatis.session.Configuration mybatisConfig() {
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
        config.setCallSettersOnNulls(true);
        config.setCacheEnabled(false);
        config.setLazyLoadingEnabled(false);
        config.setAggressiveLazyLoading(false);
        registerTypeHandlers(config.getTypeHandlerRegistry());
        registerAliases(config.getTypeAliasRegistry());

        return config;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setConfiguration(mybatisConfig());
        sqlSessionFactory.setDataSource(dataSource);
        Resource[] mappers = new PathMatchingResourcePatternResolver().getResources(MYBATIS_MAPPERS);
        sqlSessionFactory.setMapperLocations(mappers);
        return sqlSessionFactory;
    }

    private void registerAliases(TypeAliasRegistry registry) {
        registry.registerAlias(LINKED_HASH_MAP_ALIAS, LinkedHashMap.class);
        registry.registerAlias("SanitaryData", SanitaryData.class);
        registry.registerAlias("EstActFlagTypeHandler", EstActFlagTypeHandler.class);
        registry.registerAlias("EcoliSampleTypeHandler", EcoliSampleTypeHandler.class);
        registry.registerAlias("StringBooleanYNTypeHandler", StringBooleanYNTypeHandler.class);
        registry.registerAlias("PercentTypeHandler", PercentTypeHandler.class);
        registry.registerAlias("AllCapsTypeHandler", AllCapsTypeHandler.class);
        registry.registerAlias("WeatherDescTypeHandler", WeatherDescTypeHandler.class);
        registry.registerAlias("UnitsTypeHandler", UnitsTypeHandler.class);
    }

    private void registerTypeHandlers(TypeHandlerRegistry registry) {
        registry.register(Boolean.class, StringBooleanTypeHandler.class);
    }

}