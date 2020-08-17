/**
 * 
 */
package jp.co.netprotections.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import jp.co.netprotections.dto.CreatureDTO;
import jp.co.netprotections.service.HumanJudgeService;

/**
 * @author v.lai
 *
 */
@RunWith(SpringRunner.class)
// SpringとJUnit
// HumanJudgeAPIControllerTestを実行するとき、新しいコンテナーが作られる
@WebMvcTest(HumanJudgeAPIController.class)
// Tomcatサーバーが起動しなくても、Controllerのコードもテストすることができる
// @WebMvcTest(テストControllerクラス)
public class HumanJudgeAPIControllerTest {
	@Autowired
	private MockMvc mockMvc;
	// リクエストをモックする

	@MockBean
	// Beanをモックする
	// 実際HumanJudgeServiceインスタンスを作成しない
	private HumanJudgeService humanJudgeService;

	@Before
	public void setUp() {
		Mockito.when(humanJudgeService.checkHuman(any(CreatureDTO.class))).thenReturn(true);
		// checkHumanメソッドでは受けるパラメータはCreatureDTOクラスのインスタンス
		// インプットの内容を気にせず、いつも「true」が返却する
	}

	@Test
	public void testNormalResponse() throws Exception {
		String requestBody = "{\"check_data\" : [{\"name\": \"test_name\", \"type\": \"human\"}]}";
		// リクエストパラメーターを作成する
		String expectedJson = "{count: 1, results: [{name: test_name, type: human}]}";
		// 期待結果のJSONを文字列で作成
		mockMvc.perform(post("/api/v1/judge").contentType(MediaType.APPLICATION_JSON).content(requestBody))
			    .andExpect(status().isOk()) // レスポンスのステータスコードをチェック
				.andExpect(content().json(expectedJson)); // レスポンスのJSONをチェック
	}

}
