package unq.tpi.desapp.webservice.restExceptionHandler;

import org.springframework.http.HttpStatus;

public class ValidationError extends ApiError {
    ValidationError(HttpStatus status) {
        super(status);
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String field;
}
