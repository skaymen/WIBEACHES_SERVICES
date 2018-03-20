package gov.usgs.wim.wdnr.webservice;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import gov.usgs.wim.wdnr.domain.ValidationResults;
import gov.usgs.wim.wdnr.domain.ValidatorResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import gov.usgs.wim.wdnr.dao.SanitaryDataDao;
import gov.usgs.wim.wdnr.domain.SanitaryData;
import gov.usgs.wim.wdnr.domain.Views;
import io.swagger.annotations.Api;

@Api(tags={"Sanitary Data"})
@RestController
@RequestMapping("/sanitaryData")
public class SanitaryDataController {

    @Autowired
    private SanitaryDataDao sDao;
    @Autowired
    private Validator validator;

    private static final Logger log = LoggerFactory.getLogger(SanitaryDataController.class);


    public static final String UNKNOWN_USERNAME = "unknown ";


//    @PreAuthorize("hasPermission(#sd, null)")
    @PostMapping()
    @JsonView(Views.Response.class)
    public List<SanitaryData> createSanitaryData(@RequestBody List<SanitaryData> sd, HttpServletResponse response) throws IOException {
        int userid = getUserid();
//        sd.setCreatedBy(getUsername());//?
//        sd.setUpdatedBy(getUsername());//?
        boolean noErrors = true;
        for (int i = 0; i < sd.size(); i++) {
            Set<ConstraintViolation<SanitaryData>> errors = validator.validate(sd.get(i));
            sd.get(i).setValidationErrors(errors);
            if (!errors.isEmpty()) {
                noErrors = false;
//            return sDao.getById(newId);
            } else {
                response.setStatus(400);
//
            }
        }
        if (noErrors) {
            for (int i = 0; i < sd.size(); i++) {
                log.debug("id before = " + sd.get(i).getIdNo());
                sd.get(i).setSamplerSeq(userid);
                sd.get(i).setDataEntrySeq(userid);
                try {
                    sDao.create(sd.get(i));
                } catch (Exception e) {
                    if (e.getMessage().contains("BEACHHEALTH_DATA.SD2009_F_UK")) {
                        ValidatorResult error = new ValidatorResult("x", "y", "z");
                        List<ValidatorResult> l = new ArrayList<>();
                        l.add(error);
                        ValidationResults result = new ValidationResults();
                        result.setValidationErrors(l);
                        Set<ConstraintViolation<SanitaryData>> inValidationErrors;
                        log.debug("unique constraint combo" + e.getMessage());
                    }
                    else
                        log.debug("something else: " + e.getMessage());
                    log.debug("ya");
                }
                response.setStatus(HttpStatus.CREATED.value());
            }
        }

        return sd;
    }


    protected int getUserid() {
        int userid = 433;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null != authentication && !(authentication instanceof AnonymousAuthenticationToken)) {
            String username = authentication.getName();
            log.debug(username);
            //call our to table to get user id
            // through new dao method
            userid = sDao.getUserid(username);
        }
        return userid;
    }

}