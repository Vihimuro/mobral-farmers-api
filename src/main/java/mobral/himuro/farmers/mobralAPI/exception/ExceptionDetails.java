package mobral.himuro.farmers.mobralAPI.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
public class ExceptionDetails {
    protected String title;
    protected Integer status;
    protected String details;
    protected String developerMessage;
    protected LocalDateTime timestamp;
}
