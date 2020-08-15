/**
 * 
 */
package jp.co.netprotections.model.entities;

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
	private List<String> details;

}
