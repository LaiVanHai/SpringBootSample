package jp.co.netprotections.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberJudgeResponseDto {
	//レスポンスの属性	
	private String memberName;
	private boolean isEnlistedPropriety;
}
