/**
 * 
 */
package jp.co.netprotections.dto;

import java.util.List;

import javax.validation.Valid;

import lombok.Getter;
import lombok.Setter;

/**
 * @author v.lai
 *
 */
@Getter
// getCheck_data()
@Setter
// setCheck_data(List<CreatureDTO> check_data)
public class RequestParams {
	@Valid
	// バリデーションを行う
	private List<CreatureDTO> check_data;

}
