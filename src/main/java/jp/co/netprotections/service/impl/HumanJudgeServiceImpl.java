/**
 * 
 */
package jp.co.netprotections.service.impl;

import org.springframework.stereotype.Service;

import jp.co.netprotections.model.dto.CreatureDTO;
import jp.co.netprotections.service.HumanJudgeService;

/**
 * @author v.lai
 *
 */
@Service
public class HumanJudgeServiceImpl implements HumanJudgeService {
	@Override
	public boolean checkHuman(CreatureDTO creatureDTO) {
		if (creatureDTO.getType().equals("human")) {
			return true;
		} 
		return false;
	}
}
