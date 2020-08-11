/**
 * 
 */
package jp.co.netprotections.dto;

import javax.validation.Valid;
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
@Valid
public class CreatureDTO {
	@NotBlank
	private String name;
	@NotBlank
	@Pattern(regexp = "(human|animal)", message = "「human」または「animal」を入力してくだい！")
	private String type;
}
