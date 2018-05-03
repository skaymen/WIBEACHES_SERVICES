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

import javax.validation.Validator;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;

public class SanitaryDataControllerTest {

    @Mock
    private SanitaryDataDao sanitaryDataDao;
    @Mock
    private Validator validator;
    @Mock
    private Authentication auth;
    @Mock
    private SecurityContext securityContext;
    private SanitaryDataController controller;
//    private MockHttpServletResponse response;
//    private MockHttpServletRequest request;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        controller = new SanitaryDataController(sanitaryDataDao, validator);
//        response = new MockHttpServletResponse();
//        request = new MockHttpServletRequest();
//        request.addHeader("If-Modified-Since", "Tue, 06 Feb 2018 15:42:28 GMT");
    }

    @Test
    public void getUseridDefaultTest() {
        assertEquals(433, controller.getUserid());
    }

    @Test
    public void getUseridTest() {
        Mockito.when(securityContext.getAuthentication()).thenReturn(auth);
        SecurityContextHolder.setContext(securityContext);
        Mockito.when(auth.getName()).thenReturn("aName");
        given(sanitaryDataDao.getUserid(anyString())).willReturn(500);
        assertEquals(500, controller.getUserid());
    }

//    @Test
//    public void


}
