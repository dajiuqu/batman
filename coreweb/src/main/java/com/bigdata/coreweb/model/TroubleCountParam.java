package com.bigdata.coreweb.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TroubleCountParam implements Serializable {
	private Long startDate;
	private Long endDate;
	private String area;
	private Integer phoneStatus;
}
