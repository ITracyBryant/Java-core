--
--注意使用的mysql不是oracle
--建表语句，只会用到两张表，所以只建两个表
CREATE TABLE `goodslist` (
  `GOODS_ID` varchar(255) NOT NULL COMMENT '商品id',
  `GOODS_NAME` varchar(255) DEFAULT NULL COMMENT '商品名',
  `COST_PRICE` int(11) DEFAULT NULL COMMENT '成本价',
  `SELLING_PRICE` int(11) DEFAULT NULL COMMENT '售价',
  `MANUFACTURER` varchar(255) DEFAULT NULL COMMENT '制造商'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `trading_information` (
  `TRADING_ID` int(11) NOT NULL COMMENT '交易id',
  `TRADING_GOODS_ID` int(11) NOT NULL COMMENT '交易商品id',
  `TRADING_USER_ID` int(11) NOT NULL COMMENT '买家id',
  `TRADING_NUMBER` int(11) DEFAULT NULL COMMENT '交易数量'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--插入数据sql

insert into GOODSLIST values("11","遐想pad",750,1100,"xiaxiang");
insert into GOODSLIST values("9","酷为pad",700,1500,"kuwei");
insert into GOODSLIST values("15","棒槌pad",1200,3100,"bangchui");
insert into GOODSLIST values("6","华派手机",1200,1800,"huapai");
insert into GOODSLIST values("7","华派pad",800,1400,"huapai");
insert into GOODSLIST values("13","助兴pad",900,1700,"zhuxing");
insert into GOODSLIST values("10","遐想手机",800,1100,"xiaxiang");
insert into GOODSLIST values("8","酷为手机",650,1100,"kuwei");
insert into GOODSLIST values("12","助兴手机",900,1600,"zhuxing");
insert into GOODSLIST values("14","棒槌手机",3100,1300,"bangchui");

insert into trading_information values(1,11,1,2);
insert into trading_information values(2,13,2,2);
insert into trading_information values(3,14,3,1);
insert into trading_information values(4,10,4,1);
insert into trading_information values(5,9,5,3);
insert into trading_information values(6,12,6,1);
insert into trading_information values(7,6,7,2);
insert into trading_information values(8,6,8,2);
insert into trading_information values(9,6,9,2);
insert into trading_information values(10,6,10,1);
insert into trading_information values(11,8,11,3);
insert into trading_information values(12,8,12,4);
insert into trading_information values(13,7,13,4);
insert into trading_information values(14,15,14,1);
insert into trading_information values(15,15,15,3);