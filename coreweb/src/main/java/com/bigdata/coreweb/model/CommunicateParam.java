package com.bigdata.coreweb.model;

import java.io.Serializable;
import java.sql.Date;
import lombok.Data;

@Data
public class CommunicateParam implements Serializable {
	private Date startDate;
	private Date endDate;
	private String phone;
	private String code;
	private Long[] ids;
}
