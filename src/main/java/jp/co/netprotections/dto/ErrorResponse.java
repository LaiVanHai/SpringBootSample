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
public class ErrorResponse {

	private String message;

	// Specific errors in API request processing
	private List<String> details;

}
