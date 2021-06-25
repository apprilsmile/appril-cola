package com.appril.leads.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
* @description 征信线索表
* @author yz
* @date 2021-06-10
* @version V1.0
*/
@Data
@EqualsAndHashCode
@Accessors(chain = true)
public class CrmCreditLeads {

	private static final long serialVersionUID = 1L;
        
	/**
     * id
     */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
        
	/**
     * 全局id
     */
	private String globalId;
        
	/**
     * 来源数据id
     */
	private String originId;
        
	/**
     * 客户经理工号
     */
	private String userNo;
        
	/**
     * 客户经理姓名
     */
	private String userName;
        
	/**
     * 客户经理组织机构id
     */
	private Long orgId;
        
	/**
     * 客户姓名
     */
	private String customerName;
        
	/**
     * 客户电话
     */
	private String customerPhone;
        
	/**
     * 经销商名称
     */
	private String splName;
        
	/**
     * 经销商电话
     */
	private String splPhone;
        
	/**
     * 狮桥分等级
     */
	private String creditGrade;
        
	/**
     * 狮桥分查询时间
     */
	private Date queryTime;
        
	/**
     * 商机阶段（1：未跟进，2：跟进中，3：赢单，4：输单）
     */
	private Integer status;
        
	/**
     * 输单记录（json）
     */
	private String loseRecord;
        
	/**
     * 是否删除（1：是，0：否）
     */
	private Integer deleted;
        
	/**
     * 版本
     */
	private Integer version;
        
	/**
     * 创建人工号-姓名
     */
	private String creator;
        
	/**
     * 修改人工号-姓名
     */
	private String modifier;
        
	/**
     * 创建时间
     */
	private Date creationTime;
        
	/**
     * 修改时间
     */
	private Date modifiedTime;

}