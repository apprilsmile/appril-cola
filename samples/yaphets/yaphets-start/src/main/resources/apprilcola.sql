--渠道相关
drop table if exists `crm_channel_info`;
CREATE TABLE `crm_channel_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `global_id` varchar(50) NOT NULL DEFAULT '' COMMENT '全局id',
  `channel_name` varchar(100) NOT NULL DEFAULT '' COMMENT '渠道名称',
  `short_name` varchar(100) NOT NULL DEFAULT '' COMMENT '渠道简称',
  `mode_type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '渠道类型模式： 1公司 2个人',
  `tag_type` varchar(500) NOT NULL DEFAULT '' COMMENT '渠道类型标签,  json字符串[{code, name,sub_type:{code, name}},{code,name,sub_type:{code, name}},{code,name,sub_type:{code, name}}]',
  `business_scope` varchar(500) NOT NULL DEFAULT '' COMMENT '经营范围json。3=轻卡，4=重卡。数据格式 [{code:,title:}]',
  `province_code` varchar(32) NOT NULL DEFAULT '' COMMENT '省code',
  `city_code` varchar(32) NOT NULL DEFAULT '' COMMENT '城市code',
  `address` varchar(2000) NOT NULL DEFAULT '' COMMENT '详细地址, json字段， 含有经、纬度，省、市名称， 详细地址等',
  `risk_info` varchar(200) NOT NULL DEFAULT '' COMMENT '风控信息，json字符串',
  `registered` tinyint(2) NOT NULL DEFAULT '0' COMMENT '备案状态：0否，1是',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '合作状态:  1->cold, 2->warm,3->hot',
  `extend` varchar(2000) NOT NULL DEFAULT '' COMMENT '扩展信息,json字符串',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本',
  `credit_code`  varchar(100) NOT NULL DEFAULT '' COMMENT '统一社会信用代码',
  `esdate` varchar(50) NOT NULL DEFAULT '' COMMENT '注册日期（成立日期）',
  `deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  `spl_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '经销商ID',
  `lnk_comp_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '挂靠公司ID',
  `supp_lnk_prj_typ_cd` varchar(200) NOT NULL DEFAULT '' COMMENT '可支持的挂靠类型 [{"001","新车"},{"002","二手车"}]',
  `source_type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '渠道来源：0：无，1：自主创建',
  `creator` varchar(50) NOT NULL DEFAULT 'system' COMMENT '创建人工号-姓名',
  `creation_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(50) NOT NULL DEFAULT 'system' COMMENT '修改人工号-姓名',
  `modified_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='渠道信息表';

INSERT INTO `crm_channel_info`(`id`, `global_id`, `channel_name`, `short_name`, `mode_type`, `tag_type`, `business_scope`, `province_code`, `city_code`, `address`, `risk_info`, `registered`, `status`, `extend`, `version`, `credit_code`, `esdate`, `deleted`, `spl_id`, `lnk_comp_id`, `supp_lnk_prj_typ_cd`, `source_type`, `creator`, `creation_time`, `modifier`, `modified_time`) VALUES (6680, '1394138892689207297', '北京新能源汽车技术创新中心有限公司', NULL, 1, '[{\"code\":\"10000\",\"name\":\"一级经销商\",\"subType\":[]}]', '[{\"3\":\"轻卡\"}]', 'null', 'null', '{\"registered\":{\"cityCode\":\"null\",\"cityName\":\"\",\"fullAddress\":\"北京市北京经济技术开发区荣华中路10号1幢A座1705\",\"provinceCode\":\"null\",\"provinceName\":\"\"}}', '{\"riskFlag\":0}', 1, NULL, NULL, 1, '91110302MA0191990R', '2017-11-27 00:00:00', 0, 200720119004858, 0, '', 0, '18991454344-陌上归舟', '2020-07-20 12:13:19', NULL, '2021-05-17 11:53:08');
INSERT INTO `crm_channel_info`(`id`, `global_id`, `channel_name`, `short_name`, `mode_type`, `tag_type`, `business_scope`, `province_code`, `city_code`, `address`, `risk_info`, `registered`, `status`, `extend`, `version`, `credit_code`, `esdate`, `deleted`, `spl_id`, `lnk_comp_id`, `supp_lnk_prj_typ_cd`, `source_type`, `creator`, `creation_time`, `modifier`, `modified_time`) VALUES (6687, '1394138899521728513', '神州数码软件有限公司', NULL, 1, '[{\"code\":\"10050\",\"name\":\"物流公司\",\"subType\":[{\"code\":\"2\",\"name\":\"3PL\"}]},{\"code\":\"10000\",\"name\":\"一级经销商\",\"subType\":[]}]', '[{\"3\":\"轻卡\"}]', '0033', '00330010', '{\"registered\":{\"cityCode\":\"00330010\",\"cityName\":\"海淀区\",\"fullAddress\":\"北京市海淀区上地九街9号9号1层101号\",\"provinceCode\":\"0033\",\"provinceName\":\"北京市\"}}', '{\"riskFlag\":0}', 0, NULL, '[{\"code\":\"carNum\",\"title\":\"车辆台数\",\"unit\":\"\",\"type\":1,\"valueRanges\":null,\"sortIndex\":0,\"validMaxLength\":0,\"value\":\"66\",\"param\":\"param0\",\"isRequired\":true,\"placeholder\":\"请输入车辆台数\",\"requiredMessage\":\"请输入车辆台数\"},{\"code\":\"carType\",\"title\":\"车辆类型\",\"unit\":\"\",\"type\":35,\"valueRanges\":[{\"title\":\"牵引车\",\"code\":\"1\",\"isChoice\":true,\"isClick\":false},{\"title\":\"自卸车\",\"code\":\"2\",\"isChoice\":true,\"isClick\":false},{\"title\":\"载货车\",\"code\":\"3\",\"isChoice\":false,\"isClick\":false},{\"title\":\"工程车\",\"code\":\"4\",\"isChoice\":false,\"isClick\":false},{\"title\":\"专用车\",\"code\":\"5\",\"isChoice\":true,\"isClick\":false},{\"title\":\"挂车\",\"code\":\"6\",\"isChoice\":false,\"isClick\":false},{\"title\":\"搅拌车\",\"code\":\"7\",\"isChoice\":false,\"isClick\":false}],\"sortIndex\":0,\"validMaxLength\":0,\"value\":\"1,2,5\",\"param\":\"param1\",\"isRequired\":true,\"placeholder\":\"请选择车辆类型\",\"requiredMessage\":\"请选择车辆类型\"},{\"code\":\"whetheTransportWithoutCar\",\"title\":\"是否无车承运\",\"unit\":\"\",\"type\":3,\"valueRanges\":[{\"title\":\"是\",\"code\":\"1\",\"isChoice\":false},{\"title\":\"否\",\"code\":\"0\",\"isChoice\":true}],\"sortIndex\":0,\"validMaxLength\":0,\"value\":\"0\",\"param\":\"param2\",\"isRequired\":true,\"placeholder\":\"请选择是否无车承运\",\"requiredMessage\":\"请选择是否无车承运\"}]', 1, '91110108735130180K', '2002-03-28 00:00:00', 0, 200902119005062, 0, '', 0, '19333333333-俞孟', '2020-09-02 11:02:20', '1003150-王世鸿', '2021-06-21 17:01:45');
INSERT INTO `crm_channel_info`(`id`, `global_id`, `channel_name`, `short_name`, `mode_type`, `tag_type`, `business_scope`, `province_code`, `city_code`, `address`, `risk_info`, `registered`, `status`, `extend`, `version`, `credit_code`, `esdate`, `deleted`, `spl_id`, `lnk_comp_id`, `supp_lnk_prj_typ_cd`, `source_type`, `creator`, `creation_time`, `modifier`, `modified_time`) VALUES (6689, '1394138901220421634', '软通动力技术服务有限公司', NULL, 1, '[{\"code\":\"10000\",\"name\":\"一级经销商\",\"subType\":[]}]', '[{\"3\":\"轻卡\"}]', '0032', '00320004', '{\"registered\":{\"cityCode\":\"00320004\",\"cityName\":\"武汉市\",\"fullAddress\":\"武汉市东湖新技术开发区高新大道999号未来科技城龙山创新园一期A9区3栋3层\",\"provinceCode\":\"0032\",\"provinceName\":\"湖北省\"}}', '{\"riskFlag\":0}', 0, NULL, NULL, 1, '9142010005202811XC', '2012-09-07 00:00:00', 0, 200902119005067, 0, '', 0, '19999999994-拉拉', '2020-09-02 17:20:53', NULL, '2021-05-17 11:53:11');
INSERT INTO `crm_channel_info`(`id`, `global_id`, `channel_name`, `short_name`, `mode_type`, `tag_type`, `business_scope`, `province_code`, `city_code`, `address`, `risk_info`, `registered`, `status`, `extend`, `version`, `credit_code`, `esdate`, `deleted`, `spl_id`, `lnk_comp_id`, `supp_lnk_prj_typ_cd`, `source_type`, `creator`, `creation_time`, `modifier`, `modified_time`) VALUES (6690, '1394138902126391297', '东软集团股份有限公司', NULL, 1, '[{\"code\":\"10000\",\"name\":\"一级经销商\",\"subType\":[]}]', '[{\"3\":\"轻卡\"}]', '0010', '00100001', '{\"registered\":{\"cityCode\":\"00100001\",\"cityName\":\"沈阳市\",\"fullAddress\":\"沈阳市浑南新区新秀街2号\",\"provinceCode\":\"0010\",\"provinceName\":\"辽宁省\"}}', '{\"riskFlag\":0}', 0, NULL, NULL, 1, '91210100604608172K', '1991-06-17 00:00:00', 0, 200902119005068, 0, '', 0, '19999999994-拉拉', '2020-09-02 17:25:50', NULL, '2021-05-17 11:53:11');
INSERT INTO `crm_channel_info`(`id`, `global_id`, `channel_name`, `short_name`, `mode_type`, `tag_type`, `business_scope`, `province_code`, `city_code`, `address`, `risk_info`, `registered`, `status`, `extend`, `version`, `credit_code`, `esdate`, `deleted`, `spl_id`, `lnk_comp_id`, `supp_lnk_prj_typ_cd`, `source_type`, `creator`, `creation_time`, `modifier`, `modified_time`) VALUES (6691, '1394138903028166657', '文思海辉技术有限公司', NULL, 1, '[{\"code\":\"10000\",\"name\":\"一级经销商\",\"subType\":[]}]', '[{\"3\":\"轻卡\"}]', '0033', '00330010', '{\"registered\":{\"cityCode\":\"00330010\",\"cityName\":\"海淀区\",\"fullAddress\":\"北京市海淀区西小口路66号东升科技园C区4号楼502室\",\"provinceCode\":\"0033\",\"provinceName\":\"北京市\"}}', '{\"riskFlag\":0}', 0, NULL, NULL, 1, '9111010876420170XR', '2004-07-02 00:00:00', 0, 200902119005069, 0, '', 0, '19999999994-拉拉', '2020-09-02 17:32:07', NULL, '2021-05-17 11:53:11');

--联系人相关
drop table if exists `crm_channel_contact`;
CREATE TABLE `crm_channel_contact` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `global_id` varchar(50) NOT NULL DEFAULT '' COMMENT '全局id',
  `channel_global_id` varchar(50) NOT NULL DEFAULT '' COMMENT '渠道全局id',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '姓名',
  `phone` varchar(50) NOT NULL DEFAULT '' COMMENT '电话',
  `headship` tinyint(2) NOT NULL DEFAULT '0' COMMENT '职务，1企业法人、2实际控制人、3企业股东、4负责人、5业务经理、6其他',
  `remark` varchar(150) NOT NULL DEFAULT '' COMMENT '备注',
  `business` varchar(50) NOT NULL DEFAULT '' COMMENT '事业部',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本',
  `deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  `creator` varchar(50) NOT NULL DEFAULT 'system' COMMENT '创建人工号-姓名',
  `creation_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(50) NOT NULL DEFAULT 'system' COMMENT '修改人工号-姓名',
  `modified_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_global_id` (`global_id`),
  KEY `idx_channel_global_id` (`channel_global_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='渠道联系人表';

INSERT INTO `crm_channel_contact`(`id`, `global_id`, `channel_global_id`, `name`, `phone`, `headship`, `remark`, `business`, `version`, `deleted`, `creator`, `creation_time`, `modifier`, `modified_time`) VALUES (17898770778, '1406872335277596673', '1394138899521728513', '航天', '15686369636', 1, '', 'youche', 1, 0, '1003491-蔡松', '2021-06-21 15:11:18', '1003491-蔡松', '2021-06-21 15:11:18');
