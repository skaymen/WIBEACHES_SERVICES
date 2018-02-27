package gov.usgs.wim.wdnr.webservice;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;

import gov.usgs.wim.wdnr.dao.SanitaryDataDao;
import gov.usgs.wim.wdnr.dao.StreamingDao;
import gov.usgs.wim.wdnr.domain.SanitaryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(tags={"Legacy Monitoring Locations"})
@RestController
@RequestMapping("/monitoringLocations")
public class SanitaryDataController {

    @Autowired
    private SanitaryDataDao sDao;
//    @Autowired
//    private Validator validator;

    public static final String UNKNOWN_USERNAME = "unknown ";
//    public static final String USER_ID = "john";
//    public static final String FAVORITES = "this one";
//    public static final String COUNTY = "Dane";

    @PreAuthorize("hasPermission(#sd, null)")
    @PostMapping()
    public SanitaryData createSanitaryData(@RequestBody SanitaryData sd, HttpServletResponse response) throws IOException {
//        sd.setCreatedBy(getUsername());//?
//        sd.setUpdatedBy(getUsername());//?
//        if (validator.validate(sd).isEmpty()) {
            BigInteger newId = sDao.create(sd); //? //add this method to new dao, similar to ML but only with create at this point

            response.setStatus(HttpStatus.CREATED.value());
            return null;
//            return sDao.getById(newId); //? //ONLY NEEDED IF we are going to echo back data-- Ask Alice
//        }
//        else {
//            response.sendError(406, "Invalid data submitted to CRU.");
//            return null;
//        }
    }


    protected String getUsername() { //ask alice if we are going to get username / save any of this information
        String username = UNKNOWN_USERNAME;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null != authentication && !(authentication instanceof AnonymousAuthenticationToken)) {
            username= authentication.getName();
        }
        return username;
    }

}