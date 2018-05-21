package gov.usgs.wim.wdnr.webservice;

import gov.usgs.wim.wdnr.dao.SanitaryDataDao;
import gov.usgs.wim.wdnr.dao.StreamingDao;
import gov.usgs.wim.wdnr.domain.SanitaryData;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

public class SanitaryDataControllerTest {

    @Mock
    private SanitaryDataDao sanitaryDataDao;
    @Mock
    private Validator validator;
    @Mock
    private Authentication auth;
    @Mock
    private SecurityContext securityContext;
    @Mock
    private List<SanitaryData> sd;
    @Mock
    private Set<ConstraintViolation<SanitaryData>> errors;
    @Mock
    private SanitaryData san;



    private SanitaryDataController controller;

    @Mock
    private MockHttpServletResponse response;
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

    @Test //TODO not sure how to make the size of sd > 0
    public void createSanitaryDataNoErrorsTest() throws IOException {
//        sd.add(san);
//        controller.createSanitaryData(sd, response);
//        verify(sd).get(anyInt()).setSamplerSeq(anyInt());
//        verify(sd).get(anyInt()).setDataEntrySeq(anyInt());
//        verify(sanitaryDataDao).create(sd.get(anyInt()));
//        verify(response).setStatus(anyInt());
        assertEquals(sd, controller.createSanitaryData(sd, response));
    }

//    @Test //TODO not sure how to make this actually return errors
//    public void createSanitaryDataErrorsTest() throws IOException {
//        given(validator.validate(sd.get(anyInt()))).willReturn(errors);
//        controller.createSanitaryData(sd, response);
//        verify(validator).validate(sd.get(anyInt()));
//        verify(response).setStatus(anyInt());
//    }


}
