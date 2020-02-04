package com.bigdata.coreweb.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bigdata.coreweb.aspect.AuthAspect;
import com.bigdata.coreweb.common.ResultInfo;
import com.bigdata.coreweb.common.SystemException;
import com.bigdata.coreweb.constant.ResultStatus;
import com.bigdata.coreweb.entity.CommunicateInfo;
import com.bigdata.coreweb.exception.ContentException;
import com.bigdata.coreweb.model.BaseStation;
import com.bigdata.coreweb.model.CommunicateParam;
import com.bigdata.coreweb.model.LoginInfo;
import com.bigdata.coreweb.service.BaseStationService;
import com.bigdata.coreweb.service.ICommunicateInfoService;
import com.bigdata.coreweb.util.RedisUtil;
import com.bigdata.coreweb.util.ResultInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 通信情况API
 * </p>
 *
 * @author root
 * @since 2020-02-01
 */
@RestController
@RequestMapping("/basestation")
public class BaseStationController {
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private BaseStationService baseStationService;

	@Autowired
	AuthAspect authAspect;
	
	/**
	 * 查询通信情况列表
	 * @param page
	 * @return
	 * @throws ContentException 
	 */
	@GetMapping("/list")
	public ResultInfo list(Page page, CommunicateParam param, @RequestHeader String token) throws ContentException {
		param.setCode(authAspect.getLoginUserDistrictCode());
		List<BaseStation> list = new ArrayList<BaseStation>();
		list = baseStationService.list(param);
		return ResultInfoUtil.success(list);
	}
	private String getCode(String token) throws ContentException {
		Object obj = redisUtil.get(token);
		if (obj == null) {
			throw new SystemException(ResultStatus.TOKEN_IS_VVALID);
		}
		LoginInfo user = (LoginInfo)obj;
		return user.getDistrictCode();
	}




}
