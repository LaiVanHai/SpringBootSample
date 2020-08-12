/**
 * 
 */
package jp.co.netprotections.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import jp.co.netprotections.dto.ErrorResponse;
import jp.co.netprotections.dto.Request;
import jp.co.netprotections.dto.Response;
import jp.co.netprotections.service.HumanJudgeService;

/**
 * @author v.lai
 *
 */
@RestController
@RequestMapping("/api/v1")
@Validated
public class HumanJudgeAPIController {
	@Autowired
	private HumanJudgeService humanJudgeService; 
	
	@RequestMapping(value = "/judge", method = RequestMethod.POST ) // ②
	public Response judgeHuman(@Valid @RequestBody Request requestBody, BindingResult bindingResult) {
		// 判別結果を入れるリストを作成。
		return humanJudgeService.checkHuman(requestBody);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Server Error", details);
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Validation Failed", details);
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}
}
