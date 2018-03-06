package gov.usgs.wim.wdnr.spring;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@Import(MybatisConfig.class)
public class TestSpringConfig {

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabase db = new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.HSQL)
				.addScript("testData/dbCreate.sql")
				.build();
		return db;
//		DriverManagerDataSource ds = new DriverManagerDataSource();
//		ds.setDriverClassName("org.hsqldb.jdbcDriver");
//		ds.setUrl("jdbc:hsqldb:mem:paging");
//		ds.setUsername("sa");
//		ds.setPassword("");
//		return ds;
	}

}
