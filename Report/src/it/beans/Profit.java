package it.beans;

public class Profit {
	// 商品名称
	private String goodsName;
	// 商品id
	private int goodsId;
	// 成本价
	private int costPrice;
	// 售价
	private int sellingPrice;
	// 卖出数量
	private int tradingNum;
	// 交易笔数
	private int times;
	// 利润
	private int profit;

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(int costPrice) {
		this.costPrice = costPrice;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(int sellongPrice) {
		this.sellingPrice = sellongPrice;
	}

	public int getTradingNum() {
		return tradingNum;
	}

	public void setTradingNum(int tradingNum) {
		this.tradingNum = tradingNum;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

}
