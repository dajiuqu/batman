package com.bigdata.coreweb.model;

import java.io.Serializable;
import java.sql.Date;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bigdata.coreweb.util.StringUtil;

import lombok.Data;

@Data
public class CommunicateParam implements Serializable {
	private Date startDate;
	private Date endDate;
	private String phone;
	private Long[] ids;
	
	public QueryWrapper buildQuery() {
		QueryWrapper query = new QueryWrapper();
		if (startDate != null) {
			query.ge("date", startDate);
		}
		if (endDate != null) {
			query.le("date", endDate);
		}
		if (!StringUtil.isNullOrEmpty(phone)) {
			query.like("sj", "%"+phone+"%");
		}
		return query;
	}
}
