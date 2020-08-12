/**
 * 
 */
package jp.co.netprotections.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

/**
 * @author v.lai
 *
 */
@Getter
@Setter
public class CreatureDTO {
	@NotBlank(message = "ブランクしないでください！")
	private String name;
	@NotBlank(message = "ブランクしないでください！")
	@Pattern(regexp = "(human|animal)", message = "「human」または「animal」を入力してくだい！")
	private String type;
}
