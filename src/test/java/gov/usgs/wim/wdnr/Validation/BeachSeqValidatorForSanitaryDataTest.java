package gov.usgs.wim.wdnr.Validation;

import gov.usgs.wim.wdnr.dao.SanitaryDataDao;
import gov.usgs.wim.wdnr.domain.SanitaryData;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.validation.ConstraintValidatorContext;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class BeachSeqValidatorForSanitaryDataTest {

    @Mock
    protected SanitaryDataDao sanitaryDataDao;
    @Mock
    private BeachSeqValidatorForSanitaryData bs;
    @Mock
    private SanitaryData value;
    @Mock
    private ConstraintValidatorContext context;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        bs = new BeachSeqValidatorForSanitaryData();
    }

    @Test
    public void isValidTrueTest() {
        assertTrue(bs.isValid(null, null));
    }

    @Test
    public void isValidFalseTest() {
        bs.isValid(value, context);
        given(value.getBeachSeq()).willReturn("");
        verify(value.getBeachSeq());
    }


}
