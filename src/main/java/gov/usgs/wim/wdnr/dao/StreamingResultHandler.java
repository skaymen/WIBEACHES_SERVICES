package gov.usgs.wim.wdnr.dao;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.usgs.wim.wdnr.transform.ITransformer;

public class StreamingResultHandler implements ResultHandler<Object> {

    private static final Logger LOG = LoggerFactory.getLogger(StreamingResultHandler.class);
    private final ITransformer transformer;

    public StreamingResultHandler(ITransformer transformer) {
        LOG.trace("streaming handler constructed");
        this.transformer = transformer;
    }

    @Override
    public void handleResult(ResultContext<?> context) {
        if (null != context) {
            transformer.write(context.getResultObject());
        }
    }

}