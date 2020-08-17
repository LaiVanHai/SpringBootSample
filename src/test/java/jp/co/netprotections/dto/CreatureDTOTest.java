/**
 * 
 */
package jp.co.netprotections.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import jp.co.netprotections.dto.CreatureDTO;

/**
 * @author v.lai
 *
 */
@SpringBootTest
// クラスが付けたアノテーション「@SpringBootApplication」を探して、全てBeanをロードして、テストコンテナーに入れる
public class CreatureDTOTest {
	@Autowired
	private Validator validator;
	// バリデーションを行うオブジェクト
	
	private CreatureDTO creatureDto = new CreatureDTO();
	// テストオブジェクトを用意する
	private BindingResult bindingResult = new BindException(creatureDto, "CreatureDTO");
	// creatureDtoにエラーが発生するとき、エラー内容は「bindingResult」の中に保管する
	
	@Test
	public void testGetName() {
		//　テストの準備
		creatureDto.setName("test");
		// テストデータを収得
		String name = creatureDto.getName();
		// 収得した結果と期待値を比較
		assertEquals("test", name);
	}
	
	@Test
	public void testGetType() {
		creatureDto.setType("human");
		String type = creatureDto.getType();
		assertEquals("human", type);
	}
	
	@Test
	public void testSpaceValidationName() {
		creatureDto.setName("   ");
		validator.validate(creatureDto, bindingResult);
		//　テストケースを使い回すために、別のメソッドを呼び出す
		blankValidationName(bindingResult);
	}
	
	@Test
	public void testTabValidationName() {
		creatureDto.setName("\t\n");
		validator.validate(creatureDto, bindingResult);
		blankValidationName(bindingResult);
	}
	
	@Test
	public void testEmptyValidationName() {
		creatureDto.setName("");
		creatureDto.setType("human");
		validator.validate(creatureDto, bindingResult);
		blankValidationName(bindingResult);
	}
	
	@Test
	public void testSpaceValidationType() {
		creatureDto.setType("   ");
		validator.validate(creatureDto, bindingResult);
		blankValidationType(bindingResult);
	}
	
	@Test
	public void testRandomValidationType() {
		creatureDto.setType("human111");
		validator.validate(creatureDto, bindingResult);
		blankValidationType(bindingResult);
	}
	
	private void blankValidationName(BindingResult bindingResult) {
		assertEquals(bindingResult.getFieldError("name").getDefaultMessage(), "ブランクしないでください！");
	}
	
	private void blankValidationType(BindingResult bindingResult) {
		assertEquals(bindingResult.getFieldError("type").getDefaultMessage(), "「human」または「animal」を入力してくだい！");
	}
}
