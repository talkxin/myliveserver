package com.mylive.action;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.mylive.base.BaseAction;
import com.mylive.common.SHA1;

public class WeChatAction extends BaseAction {

	// 自定义 token
	private String TOKEN = "11111111111";

	/**
	 * 返回token值
	 * 
	 * @return
	 */
	public String getToKen() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		// 微信加密签名
		String signature = request.getParameter("signature"); // 随机字符串
		String echostr = request.getParameter("echostr"); // 时间戳
		String timestamp = request.getParameter("timestamp"); // 随机数
		String nonce = request.getParameter("nonce");
		String[] str = { TOKEN, timestamp, nonce };
		Arrays.sort(str); // 字典序排序
		String bigStr = str[0] + str[1] + str[2]; // SHA1加密
		String digest = new SHA1().getDigestOfString(bigStr.getBytes())
				.toLowerCase();
		// 确认请求来至微信
		if (digest.equals(signature)) {
			try {
				response.getWriter().print(echostr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
