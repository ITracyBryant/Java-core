package message;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SendMsg {
	HttpClient client;
	PostMethod method;

	public SendMsg() {
		client = new HttpClient();
		method = new PostMethod("http://gbk.api.smschinese.cn/");
		method.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");
	}

	public String send_Msg(String number) throws UnsupportedEncodingException, IOException {
		String data = number + "用户,您的飞机已经进去禁飞区区域,严重威胁空域安全,请立即驶离.";
		NameValuePair[] msg = { new NameValuePair("Uid", "liuwenhao"), new NameValuePair("Key", "d41d8cd98f00b204e980"),
				new NameValuePair("smsMob", number), new NameValuePair("smsText", data) };
		method.setRequestBody(msg);
		client.executeMethod(method);
		Header[] headers = method.getResponseHeaders();

		String result = new String(method.getResponseBodyAsString().getBytes("gbk"));
		System.out.println(result); // 鎵撳嵃杩斿洖娑堟伅鐘舵��
		method.releaseConnection();
		return result;

	}
}
