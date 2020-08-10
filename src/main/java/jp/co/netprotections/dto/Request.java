/**
 * 
 */
package jp.co.netprotections.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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
	private List<CreatureDTO> check_data = new ArrayList<CreatureDTO>();
}
