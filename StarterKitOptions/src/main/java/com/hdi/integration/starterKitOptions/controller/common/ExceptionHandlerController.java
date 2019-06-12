package com.hdi.integration.starterKitOptions.controller.common;

import com.hdi.integration.starterKitOptions.exception.BusinnesException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(BusinnesException.class)
	public ResponseEntity<ApiErrorResponse> businnesExceptionHandler(BusinnesException ex, HttpServletRequest request) {
		ApiErrorResponse response = new ApiErrorResponse(EnumExceptionCode.DATA_INVALID, ex.getMessage(), null);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ObjectError> errors = getErrors(ex);
        ApiErrorResponse response = new ApiErrorResponse(EnumExceptionCode.DATA_INVALID, "", errors);
        return new ResponseEntity<>(response, status);
    }

    private List<ObjectError> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ObjectError(error.getDefaultMessage()))
                .collect(Collectors.toList());
    }
}
