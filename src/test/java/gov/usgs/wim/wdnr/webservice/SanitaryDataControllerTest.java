package gov.usgs.wim.wdnr.webservice;

import gov.usgs.wim.wdnr.dao.SanitaryDataDao;
import gov.usgs.wim.wdnr.dao.StreamingDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;

public class SanitaryDataControllerTest {

    @Mock
    private SanitaryDataDao sanitaryDataDao;
    private SanitaryDataController controller;
    private MockHttpServletResponse response;
    private MockHttpServletRequest request;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        controller = new SanitaryDataController();
//        response = new MockHttpServletResponse();
//        request = new MockHttpServletRequest();
//        request.addHeader("If-Modified-Since", "Tue, 06 Feb 2018 15:42:28 GMT");
    }

    @Test
    public void getUseridDefaultTest() {
        assertEquals(433, controller.getUserid());
    }

    @Test //is this even possible if we can't mock a private method
    public void getUseridTest() {
        //authentication is null... how to fix?
        Authentication auth = Mockito.mock(Authentication.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(auth);
        SecurityContextHolder.setContext(securityContext);
        Mockito.when(auth.getName()).thenReturn("aName");
        SanitaryDataDao sDao = Mockito.mock(SanitaryDataDao.class);
        Mockito.when(sDao.getUserid(anyString())).thenReturn(500);
        given(sanitaryDataDao.getUserid(anyString())).willReturn(500);
        assertEquals(500, controller.getUserid());
    }

    @Test
    public void


}
