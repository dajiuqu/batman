package com.bigdata.coreweb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author root
 * @since 2020-02-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("troubleshoot_info")
public class TroubleshootInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableField("id")
    private Integer id;

    /**
     * 手机号码
     */
    @TableField("phone")
    private String phone;

    /**
     * 排查人员名称
     */
    @TableField("person")
    private String person;

    /**
     * 排查时间
     */
    @TableField("time")
    private Long time;

    /**
     * 排查情况
     */
    @TableField("info")
    private String info;

    /**
     * 手机号码状态（正常、关机、空号、无人接、拒接）
     */
    @TableField("phone_status")
    private Integer phoneStatus;

    /**
     * 排查地区
     */
    @TableField("area")
    private String area;

    /**
     * 审核状态
     */
    @TableField("audit_status")
    private Integer auditStatus;

    /**
     * 审核人
     */
    @TableField("audit_user")
    private String auditUser;

    /**
     * 审核时间
     */
    @TableField("audit_time")
    private Long auditTime;

    /**
     * 创建人姓名
     */
    @TableField("creator")
    private String creator;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Long createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Long updateTime;


}
