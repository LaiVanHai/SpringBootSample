package jp.co.netprotections.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import jp.co.netprotections.dto.ErrorResponse;
import jp.co.netprotections.dto.MemberJudgeRequestDtoArr;
import jp.co.netprotections.dto.MemberJudgeResponseDtoArr;
import jp.co.netprotections.service.MemberJudgeService;

@RestController
@RequestMapping("/api/v1")
public class MemberJudgeController {
	@Autowired
	private MemberJudgeService memberJudgeService; // ロジックを処理する価値

	@RequestMapping(value = "/check", method = RequestMethod.POST, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public MemberJudgeResponseDtoArr execute(@RequestBody MemberJudgeRequestDtoArr dtoArr, BindingResult bindingResult) {
		return memberJudgeService.createResponse(dtoArr);
	}
	
	@RequestMapping(value = "/check")
	public String anyRequest() {
		return "ようこそ！！！";
	}
	
	// 以下の部分はエラーのハンドリングです
	@ExceptionHandler(ConstraintViolationException.class)
	//　バリデーションのエラーに対して、このメソッドを処理する
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Validation Failed", details);
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	//　他の例外はこのメソッドを処理する
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Server Error", details);
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
