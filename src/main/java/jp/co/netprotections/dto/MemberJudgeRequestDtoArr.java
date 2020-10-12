package jp.co.netprotections.dto;

import java.util.ArrayList;
import java.util.List;

public class MemberJudgeRequestDtoArr {
	// リクエストフォーム

	private List<MemberJudgeRequestDto> memberCandidatesList = new ArrayList<MemberJudgeRequestDto>();

	public List<MemberJudgeRequestDto> getMemberCandidatesList() {
		return memberCandidatesList;
	}

	public void setMemberCandidatesList(List<MemberJudgeRequestDto> memberCandidatesList) {
		this.memberCandidatesList = memberCandidatesList;
	}

}
