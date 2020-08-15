/**
 * 
 */
package jp.co.netprotections.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.netprotections.model.dto.CreatureDTO;
import jp.co.netprotections.service.HumanJudgeService;

/**
 * @author v.lai
 *
 */
//WebアプリのControllerを定義する
@Controller
public class HumanJudgeController {
	// HumanJudgeAPIControllerのインスタンスを作成するとき、HumanJudgeServiceのインスタンスを自動で代入する
	@Autowired
	private HumanJudgeService humanJudgeService;
	
	// アクセスパスは「/judge」とHTTPのPOSTメソッドを受けるとき、judgeHumanメソッドを処理する
	@PostMapping(value = "/judge")
	public String judgeHuman(@Validated @ModelAttribute CreatureDTO creature, BindingResult bindingResult, Model model) {
		// @Validated： フォームのデータにバリデーションを行う
		// @ModelAttribute： フォームのリクエスト情報は「creature」オブジェクトに保管します。
		// BindingResult：バリデーションのエラーが発生するとき、エラー内容は「bindingResult」オブジェクトに入れる
		// Model：Viewで利用するデータをセットするためのModelを引数で受け取る
		model.addAttribute("creature", creature);
		// Viewまで渡す情報もmodelに入れる
		if (bindingResult.hasErrors()) {
			// バリデーションのエラーが発生するとき、エラーメッセージが表示する
			return errrorHandling(bindingResult, model);
		}
		// バリデーションには問題がなければ、判定を行う
		return createResponse(creature, model);
	}
	
	// アクセスパスは「/」とHTTPのGETメソッドを受けるとき、「index」メソッドを処理する
	@GetMapping(value = "/")
	public String index(Model model) {
		// Model：Viewで利用するデータをセットするためのModelを引数で受け取る
		model.addAttribute("creature", new CreatureDTO());
		// Viewまで渡す情報をmodelに入れる
		return "index";
		//　Viewでどんなテンプレートをレンダーするのかを指摘する	
		// 今回は「view.html」ファイルです。	
	}
	
	// ーーーーーーーーーーーーープライベートメソッドーーーーーーーーーーーーー
	// バリデーションのエラーが発生するとき、エラーメッセージを定義する
	private String errrorHandling(BindingResult bindingResult, Model model) {
		// bindingResultオブジェクトにバリデーションのエラーに関して、保管している
		if (bindingResult.hasFieldErrors("name")) {
			//もし、エラーの内容に「name」に関すれば、modelに「name」のバリデーションメッセージを入れる
			model.addAttribute("nameErrMsg", "お名前にエラーがあります。修正してください。");
		}
		if (bindingResult.hasFieldErrors("type")) {
			//もし、エラーの内容に「type」に関すれば、modelに「type」のバリデーションメッセージを入れる
			model.addAttribute("typeErrMsg", "タイプにエラーがあります。修正してください。");
		}
		return "index";
		//　Viewで「index」テンプレートをレンダーする	
	}
	
	private String createResponse(CreatureDTO creature, Model model) {
		if (humanJudgeService.checkHuman(creature)) {
			// humanJudgeServiceのcheckHumanメソッドで、受け取った情報に対して、humanかどうかを判定する
			model.addAttribute("result", creature.getName() + "は人間です。");
			// modelに判定結果を入れる
		} else {
			model.addAttribute("result", creature.getName() + "は動物です。");
		}
		return "index.html";
		//　Viewで「index」テンプレートをレンダーする	
	}
}
