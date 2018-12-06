package it.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.beans.Profit;
import it.jdbc.JdbcConn;

public class Service {
	private Connection conn;
	private Statement st, st1, st2;
	private ResultSet rs, rs1, rs2;
	private String sql;
	private List<Profit> list;
	private Profit pro;

	public List<Profit> getProfit() {
		list = new ArrayList<Profit>();
		conn = JdbcConn.getConn();
		try {
			st = (Statement) conn.createStatement();
			sql = "SELECT g.goods_name goodsname,g.goods_id goodsid,g.cost_price costprice,g.selling_price sellingprice "
					+ "FROM goodslist g,trading_information t " + "WHERE g.goods_id = t.trading_goods_id "
					+ "GROUP BY g.goods_name,g.goods_id,g.cost_price,g.selling_price";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				pro = new Profit();// 初始化，避免数据覆盖

				pro.setGoodsId(rs.getInt("goodsid"));
				pro.setGoodsName(rs.getString("goodsname"));
				pro.setCostPrice(rs.getInt("costprice"));
				pro.setSellingPrice(rs.getInt("sellingprice"));

				st1 = (Statement) conn.createStatement();
				sql = "select sum(trading_number) tradingnum from trading_information where trading_goods_id = "
						+ pro.getGoodsId();
				rs1 = st1.executeQuery(sql);
				if (rs1.next())
					pro.setTradingNum(rs1.getInt("tradingnum"));

				st2 = (Statement) conn.createStatement();
				sql = "select count(*) times from trading_information t where t.trading_goods_id = " + pro.getGoodsId();
				rs2 = st2.executeQuery(sql);
				if (rs2.next())
					pro.setTimes(rs2.getInt("times"));

				pro.setProfit((pro.getSellingPrice() - pro.getCostPrice()) * pro.getTradingNum());

				list.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
