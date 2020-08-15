/**
 * 
 */
package jp.co.netprotections.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

/**
 * @author v.lai
 *
 */
// Lombokライブラリーのアノテーション
@Getter
// Getterメソッドを定義する
// getName()、getType();
@Setter
// Setterメソッドを定義する
// setName(String name)、setType(String type)
public class CreatureDTO {
	@NotBlank(message = "ブランクしないでください！")
	private String name;
	
	@NotBlank(message = "ブランクしないでください！")
	@Pattern(regexp = "(human|animal)", message = "「human」または「animal」を入力してくだい！")
	// 正規表現でバリデーションを行う
	private String type;
}
