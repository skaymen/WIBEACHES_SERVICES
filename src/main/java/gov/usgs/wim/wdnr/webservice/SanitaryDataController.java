package gov.usgs.wim.wdnr.webservice;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;

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
    private StreamingDao sDao;
    @Autowired
    private Validator validator;

    public static final String UNKNOWN_USERNAME = "unknown ";
    public static final String USER_ID = "john";
    public static final String FAVORITES = "this one";
    public static final String COUNTY = "Dane";

//    @GetMapping()
//    public SanitaryData getBeachesRawData(
//            @RequestParam(name = USER_ID) String userId,
//            @RequestParam(name = FAVORITES) String favorites,
//            HttpServletResponse response) {
//        Map<String, Object> params = new HashMap<>();
//        params.put(USER_ID, userId);
//        params.put(FAVORITES, favorites);
//        SanitaryData brd = sDao.getByAK(params);
//        if (null == brd) {
//            response.setStatus(HttpStatus.NOT_FOUND.value());
//        }
//        return brd;
//    }
//
//    @GetMapping("/{id}")
//    public MonitoringLocation getMonitoringLocation(@PathVariable("id") String id, HttpServletResponse response) {
//        MonitoringLocation ml = mLDao.getById(NumberUtils.parseNumber(id, BigInteger.class));
//        if (null == ml) {
//            response.setStatus(HttpStatus.NOT_FOUND.value());
//        }
//        return ml;
//    }

    @PreAuthorize("hasPermission(#sd, null)")
    @PostMapping()
    public SanitaryData createSanitaryData(@RequestBody SanitaryData sd, HttpServletResponse response) throws IOException {
        sd.setCreatedBy(getUsername());//?
        sd.setUpdatedBy(getUsername());//?
        if (validator.validate(sd).isEmpty()) {
            BigInteger newId = sDao.create(sd); //?

            response.setStatus(HttpStatus.CREATED.value());
            return sDao.getById(newId); //?
        } else {
            response.sendError(406, "Invalid data submitted to CRU.");
            return null;
        }
    }

    @PreAuthorize("hasPermission(#sd, null)")
    @PutMapping("/{id}")
    public SanitaryData updateMonitoringLocation(@PathVariable("id") String id, @RequestBody SanitaryData sd,
                                                       HttpServletResponse response) throws IOException {
        BigInteger idInt = NumberUtils.parseNumber(id, BigInteger.class);

        if (null == sDao.getById(idInt)) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        }
        else {
            sd.setId(idInt);
            sdsetUpdatedBy(getUsername());
            if (validator.validate(sd).isEmpty()) {
                sDao.update(sd);
            } else {
                response.sendError(406, "Invalid data submitted to CRU.");
                return null;
            }
        }
        return sDao.getById(idInt);
    }


    protected String getUsername() {
        String username = UNKNOWN_USERNAME;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null != authentication && !(authentication instanceof AnonymousAuthenticationToken)) {
            username= authentication.getName();
        }
        return username;
    }

}