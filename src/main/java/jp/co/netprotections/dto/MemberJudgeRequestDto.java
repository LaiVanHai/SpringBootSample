package jp.co.netprotections.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberJudgeRequestDto {
	
	//リクエストの属性
	private String memberName;
	private int eventPlanning;
	private int cogitation;
	private int coodination;
	private int programmingAbility;
	private int infrastructureKnowledge;
	
}
