package jp.co.netprotections.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJudgeRequestDtoArr;
import jp.co.netprotections.dto.MemberJudgeResponseDto;
import jp.co.netprotections.dto.MemberJudgeResponseDtoArr;
import jp.co.netprotections.service.MemberJudgeService;

@Service
public class MemberJudgeServiceImpl implements MemberJudgeService {

	@Override
	// enlistedProprietyの価値を判断する
	public boolean isValid(MemberJudgeRequestDto dto) {
		int totalPoint = dto.getCogitation() + dto.getEventPlanning() + dto.getCoodination()
				+ dto.getProgrammingAbility() + dto.getInfrastructureKnowledge(); // 合計点
		if (totalPoint < 10) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	// 値の限定をチェックする
	public boolean checkLimit(MemberJudgeRequestDto dto) {
		String name = dto.getMemberName();
		if (name == null) {
			return false;
		} else {
			if (name.trim().length() == 0) {
				return false;
			}
		}
		if (dto.getCogitation() > 5 || dto.getCoodination() > 5 || dto.getEventPlanning() > 5
				|| dto.getInfrastructureKnowledge() > 5 || dto.getProgrammingAbility() > 5) {
			return false;
		}
		if (dto.getCogitation() < 1 || dto.getCoodination() < 1 || dto.getEventPlanning() < 1
				|| dto.getInfrastructureKnowledge() < 1 || dto.getProgrammingAbility() < 1) {
			return false;
		}
		return true;
	};

	@Override
	// Controllerから呼び掛させるクラス
	public MemberJudgeResponseDtoArr createResponse(MemberJudgeRequestDtoArr dtoArr) {
		MemberJudgeResponseDtoArr responseArr = new MemberJudgeResponseDtoArr();// レスポンスの価値
		List<MemberJudgeRequestDto> listMem = dtoArr.getMemberCandidatesList();// リクエストを受けた
		List<MemberJudgeResponseDto> resList = new ArrayList<MemberJudgeResponseDto>(); // リストの素子
		if (listMem == null) {
			return responseArr;
		}
		for (int i = 0; i < listMem.size(); i++) {
			MemberJudgeResponseDto response = new MemberJudgeResponseDto();
			MemberJudgeRequestDto currentItem = listMem.get(i);
			response.setMemberName(listMem.get(i).getMemberName());
			if (!this.checkLimit(currentItem)) {
				response.setMemberName(null);
				response.setEnlistedPropriety(false);
			} else {
				// 価値の限定を違反する時レスポンスが空くになる
				if (this.isValid(currentItem)) {
					response.setEnlistedPropriety(true);
				} else {
					response.setEnlistedPropriety(false);
				}
			}
			resList.add(response);
		}
		responseArr.setJudgedCandidatesResultList(resList);

		return responseArr;
	}
}
