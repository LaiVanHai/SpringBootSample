/**
 * 
 */
package jp.co.netprotections.model.entities;

import java.util.List;

import javax.validation.Valid;

import jp.co.netprotections.model.dto.CreatureDTO;
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
public class Request {
	@Valid
	// バリデーションを行う
	private List<CreatureDTO> check_data;

}
