/**
 * 
 */
package jp.co.netprotections.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.netprotections.dto.Request;
import jp.co.netprotections.dto.Response;
import jp.co.netprotections.service.HumanJudgeService;

/**
 * @author v.lai
 *
 */
@RestController
@RequestMapping("/api/v1")
public class HumanJudgeAPIController {
	@Autowired
	private HumanJudgeService humanJudgeService; 
	
	@RequestMapping(value = "/judge", method = RequestMethod.POST ) // ②
	// ③judgeHumanメソッドについて
	public Response judgeHuman(@RequestBody @Validated Request requestBody) {
		// 判別結果を入れるリストを作成。
		return humanJudgeService.checkHuman(requestBody);
	}
}
