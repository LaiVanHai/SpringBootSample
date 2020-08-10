/**
 * 
 */
package jp.co.netprotections.dto;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author v.lai
 *
 */
@Getter
@Setter
@RequiredArgsConstructor
public class Response {
	private final int count;
	private final List<CreatureDTO> results;
	private List<ErrorResponse> errors;
}
