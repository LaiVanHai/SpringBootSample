package jp.co.netprotections.dto;

import java.util.ArrayList;
import java.util.List;

public class MemberJudgeResponseDtoArr {
	//レスポンスのフォーム
	private List<MemberJudgeResponseDto> judgedCandidatesResultList = new ArrayList<MemberJudgeResponseDto>();

	public List<MemberJudgeResponseDto> getJudgedCandidatesResultList() {
		return judgedCandidatesResultList;
	}

	public void setJudgedCandidatesResultList(List<MemberJudgeResponseDto> judgedCandidatesResultList) {
		this.judgedCandidatesResultList = judgedCandidatesResultList;
	}

}
