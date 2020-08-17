/**
 * 
 */
package jp.co.netprotections.service.impl;

import org.springframework.stereotype.Service;

import jp.co.netprotections.dto.CreatureDTO;
import jp.co.netprotections.service.HumanJudgeService;

/**
 * @author v.lai
 *
 */
@Service
// Serviceを定義する
public class HumanJudgeServiceImpl implements HumanJudgeService {
	@Override
	public boolean checkHuman(CreatureDTO creatureDTO) {
		if (creatureDTO.getType().equals("human")) {
		// もし、typeは「human」ならTrueが返却する
			return true;
		}
		return false;
	}
}
