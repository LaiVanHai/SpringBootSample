/**
 * 
 */
package jp.co.netprotections.dto;

import java.util.List;

import javax.validation.Valid;

/**
 * @author v.lai
 *
 */
//@Getter
// getCheck_data()
//@Setter
// setCheck_data(List<CreatureDTO> check_data)
public class RequestParams {
	@Valid
	// バリデーションを行う
	private List<CreatureDTO> check_data;

	public List<CreatureDTO> getCheck_data() {
		return check_data;
	}

	public void setCheck_data(List<CreatureDTO> check_data) {
		this.check_data = check_data;
	}

}
