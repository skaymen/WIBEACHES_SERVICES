package gov.usgs.wim.wdnr.webservice;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.ResultHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.usgs.wim.wdnr.dao.StreamingDao;
import gov.usgs.wim.wdnr.dao.StreamingResultHandler;
import gov.usgs.wim.wdnr.swagger.SwaggerConfig;
import gov.usgs.wim.wdnr.transform.MapToJsonTransformer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.context.request.WebRequest;

@Api(tags={SwaggerConfig.BEACHES_RAW_DATA_TAG_NAME})
@RestController
@RequestMapping(value="beachesrawdata", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BeachesRawDataController {
    private static final Logger LOG = LoggerFactory.getLogger(BeachesRawDataController.class);

    protected StreamingDao streamingDao;

    @Autowired
    public BeachesRawDataController(final StreamingDao streamingDao) {
        this.streamingDao = streamingDao;
    }

    @ApiOperation(value="Return Effort Visit Raw Data matching the POSTed criteria.")
    @GetMapping()
    public void getBeachesRawData(HttpServletResponse response, WebRequest webRequest) {
        if (!isNotModified(webRequest) ) {
            try (MapToJsonTransformer transformer = new MapToJsonTransformer(response)) {
                LOG.trace("start streaming");
                response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                ResultHandler<?> handler = new StreamingResultHandler(transformer);
                streamingDao.stream(StreamingDao.BEACHES_RAW_DATA, handler);
                transformer.end();
                LOG.trace("done streaming");
            } catch (Exception e) {
                LOG.error(e.getLocalizedMessage());
                try {
                    response.sendError(HttpStatus.BAD_REQUEST.value(), e.getLocalizedMessage());
                } catch (IOException verybad) {
                    LOG.error("Couldn't send back bad request:" + verybad.getLocalizedMessage());
                }
            }
        }
    }

    protected boolean isNotModified(WebRequest webRequest) {
        LocalDateTime lastUpdatedUtc = streamingDao.getLastUpdate(StreamingDao.BEACHES_RAW_DATA);
        if (null != lastUpdatedUtc) {
            return webRequest.checkNotModified(lastUpdatedUtc.toInstant(ZoneOffset.UTC).toEpochMilli());
        } else {
            return false;
        }
    }

}
