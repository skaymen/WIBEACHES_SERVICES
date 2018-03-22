package gov.usgs.wim.wdnr.Validation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy={
        MonitorSiteValidatorForSanitaryData.class
})
@Documented
public @interface MonitorSite {

    String message() default "The beach sequence - monitor site sequence combination does not exist in the Beach Health database.";
    Class<?>[] groups() default {};
    public abstract Class<?>[] payload() default {};

    String[] propertyName() default {};
}