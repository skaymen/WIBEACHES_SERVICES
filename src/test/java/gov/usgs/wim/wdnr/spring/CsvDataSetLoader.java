package gov.usgs.wim.wdnr.spring;

import org.springframework.core.io.Resource;

import com.github.springtestdbunit.dataset.AbstractDataSetLoader;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.csv.CsvURLDataSet;

public class CsvDataSetLoader extends AbstractDataSetLoader {

	@Override
	protected IDataSet createDataSet(Resource resource) throws Exception {
		ReplacementDataSet replacementDataSet = new ReplacementDataSet(new CsvURLDataSet(resource.getURL()));
		return replacementDataSet;
	}

}
