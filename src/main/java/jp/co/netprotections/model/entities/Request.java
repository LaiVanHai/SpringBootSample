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
@Setter
public class Request {
	@Valid
	private List<CreatureDTO> check_data;

}
