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
// getCount(), getResults()
@Setter
// setCount(int count), setResults(List<CreatureDTO> results)
@AllArgsConstructor
//クラスの全てフィルドはコントラクターで定義する
//Response(int count, List<CreatureDTO> results)
public class Response {
	private int count;
	private List<CreatureDTO> results;
	
}
