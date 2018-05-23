package gov.usgs.wim.wdnr.Validation;

import gov.usgs.wim.wdnr.dao.SanitaryDataDao;
import gov.usgs.wim.wdnr.domain.SanitaryData;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.reflect.Whitebox;

import javax.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.BDDMockito.given;

public class UniqueKeyValidatorForSanitaryDataTest {

    @Mock
    protected SanitaryDataDao dao;

    private UniqueKeyValidatorForSanitaryData ukv;

    @Mock
    private SanitaryData value;
    @Mock
    private ConstraintValidatorContext context;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ukv = new UniqueKeyValidatorForSanitaryData();
        Whitebox.setInternalState(ukv, "dao", dao);
    }

    @Test
    public void isValidTrueTest() {
        assertTrue(ukv.isValid(null, null));
    }

    @Test
    public void isValidFalseTest() {
        given(value.getBeachSeq()).willReturn("2");
        given(value.getSampleDateTime()).willReturn(LocalDateTime.now());
        assertFalse(ukv.isValid(value, context));

    }

}
