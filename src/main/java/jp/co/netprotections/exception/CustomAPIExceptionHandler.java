/**
 * 
 */
package jp.co.netprotections.exception;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jp.co.netprotections.dto.ErrorResponse;

/**
 * @author v.lai
 *
 */
@RestControllerAdvice
public class CustomAPIExceptionHandler extends ResponseEntityExceptionHandler {
//	@ExceptionHandler(Exception.class)
//	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
//		List<String> details = new ArrayList<>();
//		details.add(ex.getLocalizedMessage());
//		ErrorResponse error = new ErrorResponse("Server Error", details);
//		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//
//	@ExceptionHandler(ConstraintViolationException.class)
//	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
//		List<String> details = new ArrayList<>();
//		details.add(ex.getLocalizedMessage());
//		ErrorResponse error = new ErrorResponse("Validation Failed", details);
//		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
//	}

}
