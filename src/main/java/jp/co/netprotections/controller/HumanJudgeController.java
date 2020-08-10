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

import jp.co.netprotections.dto.CreatureDTO;
import jp.co.netprotections.service.HumanJudgeService;

/**
 * @author v.lai
 *
 */
@Controller
public class HumanJudgeController {
	@Autowired
	private HumanJudgeService humanJudgeService;

	@PostMapping(value = "/judge")
	// ③judgeHumanメソッドについて
	public String judgeHuman(@ModelAttribute @Validated CreatureDTO creature, BindingResult result, Model model) {
		System.out.print("----->" + creature.getName());
		System.out.print("----->" + creature.getType());
		if (result.hasErrors()) {
			model.addAttribute("creature", creature);

			model.addAttribute("nameErrMsg", "名前にエラーがあります。修正してください。");
			return "index.html";
		}
		creature.setName("Hai");
		model.addAttribute("creature", creature);
		return "index.html";
	}

	@GetMapping(value = "/") // ②
	public String index(Model model) {
		model.addAttribute("creature", new CreatureDTO());
		return "index";
	}
}
