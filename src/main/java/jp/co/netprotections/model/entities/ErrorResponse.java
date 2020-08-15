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
// getMessage()、getDetails()
@Setter
// setMessage(String msg)、setDetails(List<String> listDetail)
@AllArgsConstructor
// クラスの全てフィルドはコントラクターで定義する
// ErrorResponse(String message, List<String> details)
public class ErrorResponse {
	private String message;
	private List<String> details;

}
