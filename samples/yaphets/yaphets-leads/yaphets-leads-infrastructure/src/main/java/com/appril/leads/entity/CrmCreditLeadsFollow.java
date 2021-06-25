package com.appril.leads.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
* @description 征信线索跟进表
* @author yz
* @date 2021-06-10
* @version V1.0
*/
@Data
@EqualsAndHashCode
@Accessors(chain = true)
public class CrmCreditLeadsFollow {

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
     * 征信线索全局id
     */
	private String creditLeadsGlobalId;
        
	/**
     * 跟进方式：1：电话跟进，2：线下跟进
     */
	private Integer mode;
        
	/**
     * 客户意向
     */
	private Integer purpose;
        
	/**
     * 未立项原因
     */
	private Integer unapprovedReason;
        
	/**
     * 备注
     */
	private String remark;
        
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