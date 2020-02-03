package com.bigdata.coreweb.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TroubleshootInfoParam implements Serializable {
	private Long startDate;
	private Long endDate;
	private Integer id;
	private String phone;
	private String person;
	private Long time;
	private Integer phoneStatus;
	private String area;
	private Integer auditStatus;
	private String auditUser;
	private Long auditTime;
	private String creator;
	private Long createTime;
	private Long updateTime;
	private String authCode;

}
