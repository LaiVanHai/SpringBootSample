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
	public String judgeHuman(@ModelAttribute @Validated CreatureDTO creature, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("creature", creature);
			if (bindingResult.hasFieldErrors("name")) {
				model.addAttribute("nameErrMsg", "お名前にエラーがあります。修正してください。");
			}

			if (bindingResult.hasFieldErrors("type")) {
				model.addAttribute("typeErrMsg", "タイプにエラーがあります。修正してください。");
			}

			return "index.html";
		}
		model.addAttribute("creature", creature);
		if (creature.getType().equals("human")) {
			model.addAttribute("result", creature.getName() + "は人間です。");
		} else {
			model.addAttribute("result", creature.getName() + "は動物です。");
		}
		return "index.html";
	}

	@GetMapping(value = "/") // ②
	public String index(Model model) {
		model.addAttribute("creature", new CreatureDTO());
		return "index";
	}
}
