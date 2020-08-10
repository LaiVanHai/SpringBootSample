/**
 * 
 */
package jp.co.netprotections.service;

import jp.co.netprotections.dto.Request;
import jp.co.netprotections.dto.Response;

/**
 * @author v.lai
 *
 */
public interface HumanJudgeService {
	public Response checkHuman(Request requestBody); // レスポンスを作成する
}
