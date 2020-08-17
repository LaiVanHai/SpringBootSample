/**
 * 
 */
package jp.co.netprotections.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import jp.co.netprotections.dto.CreatureDTO;
import jp.co.netprotections.service.impl.HumanJudgeServiceImpl;

/**
 * @author v.lai
 *
 */
public class HumanJudgeServiceImplTest {
	// モックオブジェクトを作成
	CreatureDTO human = Mockito.mock(CreatureDTO.class);
	CreatureDTO animal = Mockito.mock(CreatureDTO.class);
	
	// テストオブジェクト
	HumanJudgeService humanJudgeService = new HumanJudgeServiceImpl();
	
	@Before
	// テスクケースを実行する前に、このメソッドを先に実施する
	public void setUp() {
		// 返却結果をスタブする
		Mockito.when(human.getType()).thenReturn("human");
		Mockito.when(animal.getType()).thenReturn("aminal");
	}
	
	@Test
	public void checkHumanIsTrue() {
		boolean checkResult = humanJudgeService.checkHuman(human);
		assertTrue(checkResult);
	}
	
	@Test
	public void checkHumanIsFalse() {
		boolean checkResult = humanJudgeService.checkHuman(animal);
		assertFalse(checkResult);
	}

}
