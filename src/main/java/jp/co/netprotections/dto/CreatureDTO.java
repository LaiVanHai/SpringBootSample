/**
 * 
 */
package jp.co.netprotections.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author v.lai
 *
 */
// Lombokライブラリーのアノテーション
//@Getter
// Getterメソッドを定義する
// getName()、getType();
//@Setter
// Setterメソッドを定義する
// setName(String name)、setType(String type)
public class CreatureDTO {
	@NotBlank(message = "ブランクしないでください！")
	private String name;

	@Pattern(regexp = "(human|animal)", message = "「human」または「animal」を入力してくだい！")
	// 正規表現でバリデーションを行う
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
