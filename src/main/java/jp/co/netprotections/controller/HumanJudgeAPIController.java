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
// APIのControllerを定義
// Beanを定義する
@RequestMapping("/api/v1")
// メソッドを定義しないので、このパス「/api/v1」に対して、HTTPのメソッドに関わらず、HumanJudgeAPIControllerクラスで処理を行う
@Validated
// リクエストのパラメーターにバリデーションを行う　
public class HumanJudgeAPIController {
	// HumanJudgeAPIControllerのインスタンスを作成するとき、HumanJudgeServiceのインスタンスを自動で代入する
	@Autowired
	private HumanJudgeService humanJudgeService;

	// アクセスパスは「/api/v1/judge」とHTTPのPOSTメソッドを受けるとき、judgeHumanメソッドを処理する
	// 同じ意味：	@PostMapping(value = "/judge")
	@RequestMapping(value = "/judge", method = RequestMethod.POST)
	public Response judgeHuman(@Valid @RequestBody Request requestBody, BindingResult bindingResult) {
		// @RequestBody：リクエストのパラメーターを受けます。
		// パラメーターの形は「Request」クラスに定義しています。リクエストのパラメータ内容は「requestBody」に保管します。
		// @Valid：リクエストのパラメーターにバリデーションを行う
		// BindingResult：バリデーションのエラーが発生するとき、エラー内容は「bindingResult」オブジェクトに入れる
		List<CreatureDTO> resultList = new ArrayList<CreatureDTO>();
		// humanの情報を保管する配列
		List<CreatureDTO> creatureArr = requestBody.getCheck_data();
		// リクエストパラメータから、check_dataの情報を収得する
		int humanCount = 0;
		// humanの数を保管する変数

		for (int i = 0; i < creatureArr.size(); i++) {
			// creatureArr.size():配列のサイズ
			CreatureDTO currenCreature = creatureArr.get(i);
			// creatureArr配列から、「i」位置にデーターを読み込む
			if (humanJudgeService.checkHuman(currenCreature)) {
				// humanJudgeServiceのcheckHumanメソッドで、受け取った情報に対して、humanかどうかを判定する
				// humanの場合:「true」が返却する
				// humanに以外：「false」が返却する
				humanCount++;
				// humanの数をインクリメント
				resultList.add(currenCreature);
				// humanの情報はレスポンスの配列に入れる
			}
		}
		// APIのレスポンスを返却する
		return new Response(humanCount, resultList);
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
