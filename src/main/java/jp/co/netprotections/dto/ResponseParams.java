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
// getCount(), getResults()
@Setter
// setCount(int count), setResults(List<CreatureDTO> results)
@AllArgsConstructor
//クラスの全てフィルドはコントラクターで定義する
//Response(int count, List<CreatureDTO> results)
public class ResponseParams {
	private int count;
	private List<CreatureDTO> results;
	
}
