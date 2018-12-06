<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.text.*,java.util.*,it.beans.Profit" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>原生态JAVA生成报表</title>

<style type="text/css">
table.hovertable{
	font-family: verdana, arial, sans-serif;
	font-size: 13px;
	color: #333333;
	border-with: 1px;
	border-color: #999999;
	border-collapse: collapse;
}

table.hovertable th{
	background-color: #c3dde0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}

table.hovertable tr {
	background-color: #d4e3e5;
}

table.hovertable td{
	border-with: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
	text-align: center;
}
</style>

<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
	String strDate = sdf.format(new Date());
%>

</head>
<body>
<center>
	<h2><%=strDate %>销售报表</h2>
	<hr>
	<form action="ShowReport" method="post">
		<input type="submit" value="生成报表"> 
	</form>
	<br>
	<%
	List<Profit> list = (List<Profit>)request.getSession().getAttribute("profit");
	
	if(list != null && list.size() > 0){
		int sum=0;
		String ht = "<table class=\"hovertable\">"
			+"<tr>"
			+"	<th colspan=\"5\">利润表</th>"
			+"	</tr>"
			+"	<tr>"
			+"	<th>序号</th>"
			+"	<th>商品名称</th>"
			+"	<th>卖出数量</th>"
			+"	<th>交易笔数</th>"
			+"	<th>盈利额</th>"
			+"</tr>";
        for(int i=0; i<list.size(); i++){
        	Profit pro = list.get(i);
        	sum += pro.getProfit();
        	ht += 	 "<tr onmouseover=\"this.style.backgroundColor='#ffff66';\" onmouseout=\"this.style.backgroundColor='#d4e3e5';\">"
					+"	<td>" + (i+1) +"</td>"
					+"	<td>" + pro.getGoodsName() +"</td>"
					+"	<td>" + pro.getTradingNum()+ "</td>"
					+"	<td>" + pro.getTimes() + "</td>"
					+"	<td>" + pro.getProfit() + "</td>"
					+"</tr>";
        }
        ht += "<tr>"
        	 +"<td colspan='4'>总利润</td>"
        	 +"<td>" + sum + "</td>"
        	 +"</tr>"
        	 +"	</table>";
        out.println(ht);
	}
	%>
</center>
</body>
</html>