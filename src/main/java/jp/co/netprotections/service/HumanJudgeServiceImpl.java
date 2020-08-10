/**
 * 
 */
package jp.co.netprotections.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.netprotections.dto.CreatureDTO;
import jp.co.netprotections.dto.Request;
import jp.co.netprotections.dto.Response;

/**
 * @author v.lai
 *
 */
@Service
public class HumanJudgeServiceImpl implements HumanJudgeService {
	@Override
	public Response checkHuman(Request requestBody) {
		List<CreatureDTO> resultList = new ArrayList<CreatureDTO>();

		List<CreatureDTO> creature = requestBody.getCheck_data();

		int humanCount = 0;

		// ④人間かどうかを判別する処理
		for (int i = 0; i < creature.size(); ++i) {
			if (creature.get(i).getType().equals("human")) {
				humanCount++;
				resultList.add(creature.get(i));
			}
		}

		Response response = new Response(humanCount, resultList);

		return response;
	}
}
