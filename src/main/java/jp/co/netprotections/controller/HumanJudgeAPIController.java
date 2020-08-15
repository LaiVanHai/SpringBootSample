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

import jp.co.netprotections.model.dto.CreatureDTO;
import jp.co.netprotections.model.entities.ErrorResponse;
import jp.co.netprotections.model.entities.Request;
import jp.co.netprotections.model.entities.Response;
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

	@RequestMapping(value = "/judge", method = RequestMethod.POST) // ②
	public Response judgeHuman(@Valid @RequestBody Request requestBody, BindingResult bindingResult) {
		List<CreatureDTO> resultList = new ArrayList<CreatureDTO>();
		List<CreatureDTO> creatureArr = requestBody.getCheck_data();
		int humanCount = 0;

		for (int i = 0; i < creatureArr.size(); ++i) {
			CreatureDTO currenCreature = creatureArr.get(i);
			if (humanJudgeService.checkHuman(currenCreature)) {
				humanCount++;
				resultList.add(currenCreature);
			}
		}

		Response response = new Response(humanCount, resultList);

		return response;
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
