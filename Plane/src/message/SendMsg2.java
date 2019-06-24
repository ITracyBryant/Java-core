package message;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SendMsg2 {
	HttpClient client;
	PostMethod method;
	public SendMsg2() {
		client=new HttpClient();
		method=new PostMethod("http://106.ihuyi.cn/webservice/sms.php?method=Submit");
		method.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");
	}
	public String send_Msg(String number) throws UnsupportedEncodingException, IOException{
		String data=number+"用户您好,您的无人机已飞入禁飞区,请立即返航。";
		NameValuePair[] msg ={
				new NameValuePair("account", "用户名"), //查看用户名是登录用户中心->验证码短信->产品总览->APIID
			    new NameValuePair("password", "密码"),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
			    //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
			    new NameValuePair("mobile", "手机号码"), 
			    new NameValuePair("content", data),
			    };
		method.setRequestBody(msg);
		client.executeMethod(method);
		Header[] headers = method.getResponseHeaders();
		
		String result = new String(method.getResponseBodyAsString().getBytes("gbk")); 
		System.out.println(result); //打印返回消息状态
		method.releaseConnection();
		return result;
		
	}
}
