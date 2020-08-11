/**
 * 
 */
package jp.co.netprotections.dto;

import java.util.List;

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
