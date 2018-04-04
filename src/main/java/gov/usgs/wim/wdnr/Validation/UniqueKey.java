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
        UniqueKeyValidatorForSanitaryData.class
})
@Documented
public @interface UniqueKey {

    String message() default "The Monitor Site and Sample Date Time combination that you have entered already exists in the Beach Health database. Please make sure this record is not a duplicate.";
    Class<?>[] groups() default {};
    public abstract Class<?>[] payload() default {};

    String[] propertyName() default {};
}
