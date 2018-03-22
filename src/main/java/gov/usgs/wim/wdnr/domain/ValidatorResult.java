package gov.usgs.wim.wdnr.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidatorResult {

    private static final Logger log = LoggerFactory.getLogger(ValidatorResult.class);


    @JsonView(Views.Response.class)
    private String field;
    @JsonView(Views.Response.class)
    private String message;

    public ValidatorResult (final String inField, final String inMessage, final String inValue) {
        field = inField;
        message = inMessage;
    }

    public String getField() {
        return field;
    }

    public void setField(final String inField) {
        try {
            field = SanitaryData.class.getField(inField).getAnnotation(JsonAlias.class).value().toString();
            log.debug("\n\n\n\n\n field: " + field + "\n\n\n\n\n");

        } catch (Exception e) {
            field = inField;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String inMessage) {
        message = inMessage;
    }

    @Override
    @JsonIgnore
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Field:").append(getField()).append(" - ");
        sb.append("Message:").append(getMessage()).append(" - ");
        return sb.toString();
    }

}
