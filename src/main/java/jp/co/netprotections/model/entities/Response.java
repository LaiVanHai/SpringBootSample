/**
 * 
 */
package jp.co.netprotections.model.entities;

import java.util.List;

import jp.co.netprotections.model.dto.CreatureDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author v.lai
 *
 */
@Getter
@Setter
@AllArgsConstructor
public class Response {
	private int count;
	private List<CreatureDTO> results;
	
}
