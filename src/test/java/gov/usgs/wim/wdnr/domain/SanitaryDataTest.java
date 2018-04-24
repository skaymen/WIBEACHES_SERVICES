package gov.usgs.wim.wdnr.domain;

import gov.usgs.wim.wdnr.dao.StringBooleanTypeHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.*;

public class SanitaryDataTest {



    @Test
    public void validationResultsNullTest() {
        SanitaryData sd = new SanitaryData();
        ValidationResults vr = sd.getValidationErrors();
        assertNotNull(vr);
        assertTrue(vr.getValidationErrors().isEmpty());
    }

    @Test
    public void validationResultsTest() {
        SanitaryData sd = new SanitaryData();
        ValidationResults vr2 = new ValidationResults();
        ReflectionTestUtils.setField(sd, "validationErrors", vr2);
        ValidationResults vr = sd.getValidationErrors();
        assertNotNull(vr);
        assertEquals(vr2, vr);
    }

    @Test
    public void setValidationErrorsNullTest() {

        SanitaryData sd = new SanitaryData();
        Set<ConstraintViolation<SanitaryData>> cv = null;
        sd.setValidationErrors(cv);
        ValidationResults vr = (ValidationResults) ReflectionTestUtils.getField(sd, "validationErrors");
        assert(vr.isEmpty());

    }

    @Autowired
    private Validator validator;

    @Test
    public void setValidationErrorsTest() {

        SanitaryData sd = new SanitaryData();
        //TODO: fix this
        Set<ConstraintViolation<SanitaryData>> cv = validator.validate(sd);
        sd.setValidationErrors(cv);
        ValidationResults vr = sd.getValidationErrors();
        assertEquals(ReflectionTestUtils.getField(sd, "validationErrors"), vr);

    }
}
