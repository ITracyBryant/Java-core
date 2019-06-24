package wuTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBUtil.ConUtil;
import message.SendMsg;

public class SendMsgTest {
	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		FileWriter writer=new FileWriter("E:/aaa.txt",true);
		writer.write("aaaaa");
		writer.write("bbbbbb");
		writer.flush();
		
		
	}
}
