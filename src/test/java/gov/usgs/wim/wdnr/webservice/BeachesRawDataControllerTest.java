package gov.usgs.wim.wdnr.webservice;

import gov.usgs.wim.wdnr.dao.StreamingDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

public class BeachesRawDataControllerTest {

    @Mock
    private StreamingDao streamingDao;
    private BeachesRawDataController controller;
    private MockHttpServletResponse response;
    private MockHttpServletRequest request;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        controller = new BeachesRawDataController(streamingDao);
        response = new MockHttpServletResponse();
        request = new MockHttpServletRequest();
        request.addHeader("If-Modified-Since", "Tue, 06 Feb 2018 15:42:28 GMT");
    }

    @Test
    public void isNotModifiedNullTest() {
        assertFalse(controller.isNotModified(new ServletWebRequest(request)));
    }

    @Test
    public void isNotModifiedFalseTest() {
        when(streamingDao.getLastUpdate(anyString())).thenReturn(LocalDateTime.now());
        assertFalse(controller.isNotModified(new ServletWebRequest(request)));
    }

    @Test
    public void isNotModifiedTrueTest() {
        when(streamingDao.getLastUpdate(anyString())).thenReturn(LocalDateTime.parse("2017-02-06T15:00:00"));
        assertTrue(controller.isNotModified(new ServletWebRequest(request)));
    }

    @Test
    public void getBeachesRawDataEmptyTest() {
//        do something here...
//        when(controller.isNotModified(new ServletWebRequest(request))).thenReturn(false);
//        doReturn(true).when(controller).isNotModified(new ServletWebRequest(request));
        assertEquals("", controller.getBeachesRawData(response, new ServletWebRequest(request)));
    }

    @Test
    public void getBeachesRawDataStreamingTest() {
        assertNotEquals("", controller.getBeachesRawData(response, new ServletWebRequest(request)));
        //assert streaming?
    }




}
