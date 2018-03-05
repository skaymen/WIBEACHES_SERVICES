package gov.usgs.wim.wdnr.dao;

import static org.junit.Assert.assertEquals;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

import gov.usgs.wim.wdnr.spring.CsvDataSetLoader;
import gov.usgs.wim.wdnr.spring.TestSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestSpringConfig.class})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
	DbUnitTestExecutionListener.class })
@DbUnitConfiguration(dataSetLoader = CsvDataSetLoader.class)
public class StreamingDaoIT {

	@Autowired
	SqlSessionFactory sqlSessionFactory;
	StreamingDao streamingDao;

	@Before
	public void setUp() {
		streamingDao = new StreamingDao(sqlSessionFactory);
	}

	@Test
	@DatabaseSetup("classpath:/testData/lastUpdate/fromBeachesRaw/")
	public void testLastUpdate() {
		assertEquals("1990-10-12T13:01:01", streamingDao.getLastUpdate(StreamingDao.BEACHES_RAW_DATA).toString());
	}

}
