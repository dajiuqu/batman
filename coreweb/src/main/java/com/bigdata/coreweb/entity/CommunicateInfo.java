package com.bigdata.coreweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 通信情况表
 * </p>
 *
 * @author root
 * @since 2020-02-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("communicate_info")
public class CommunicateInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 手机号码
     */
    @TableId("mobie_phone")
    private Long mobiePhone;

    /**
     * 所属运营商
     */
    @TableField("belong_company")
    private String belongCompany;

    /**
     * 号码归属地
     */
    @TableField("belong_zone")
    private String belongZone;

    /**
     * 确认时间
     */
    @TableField("confirm_time")
    private Long confirmTime;

    /**
     * 到访地区行政编号
     */
    @TableField("visit_zone_code")
    private String visitZoneCode;

    /**
     * 到访地区
     */
    @TableField("visit_zone")
    private String visitZone;

    /**
     * 所在区县
     */
    @TableField("location")
    private String location;

    /**
     * 驻留天数
     */
    @TableField("lingen_days")
    private Integer lingenDays;

    /**
     * 离开日期
     */
    @TableField("leave_date")
    private Long leaveDate;

    /**
     * 基站标识
     */
    @TableField("station_id")
    private String stationId;

    /**
     * 基站名称
     */
    @TableField("station_name")
    private String stationName;

    /**
     * 数据导入人员
     */
    @TableField("create_user")
    private String createUser;

    /**
     * 修改人员
     */
    @TableField("update_user")
    private String updateUser;

    /**
     * 状态（N 初始 A已排查 V无效）
     */
    @TableField("status")
    private String status;


}
