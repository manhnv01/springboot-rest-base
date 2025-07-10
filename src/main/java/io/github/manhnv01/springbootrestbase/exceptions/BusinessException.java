package io.github.manhnv01.springbootrestbase.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class BusinessException extends RuntimeException {
    HttpStatus status;
    String messageCode;

    public BusinessException(HttpStatus status, ExceptionMessage message) {
        super(message.val);
        this.status = status;
        messageCode = message.toString();
    }
}
