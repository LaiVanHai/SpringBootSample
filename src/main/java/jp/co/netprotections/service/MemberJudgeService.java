package jp.co.netprotections.service;

import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJudgeRequestDtoArr;
import jp.co.netprotections.dto.MemberJudgeResponseDtoArr;

public interface MemberJudgeService {
	boolean isValid(MemberJudgeRequestDto dto); // enlistedProprietyの価値を判断する
	boolean checkLimit(MemberJudgeRequestDto dto); // 値の限定をチェックする
	public MemberJudgeResponseDtoArr createResponse(MemberJudgeRequestDtoArr dtoArr); // レスポンスを作成する
}
