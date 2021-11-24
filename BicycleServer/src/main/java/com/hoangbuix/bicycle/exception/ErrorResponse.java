package com.hoangbuix.bicycle.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class ErrorResponse {
    private HttpStatus status;
    private String message;
}
