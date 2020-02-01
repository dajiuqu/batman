package com.bigdata.coreweb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bigdata.coreweb.common.ResultInfo;
import com.bigdata.coreweb.service.ICommunicateInfoService;
import com.bigdata.coreweb.util.ResultInfoUtil;

/**
 * <p>
 * 通信情况API
 * </p>
 *
 * @author root
 * @since 2020-02-01
 */
@RestController
@RequestMapping("/communicateInfo")
public class CommunicateInfoController {
	
	@Autowired
	private ICommunicateInfoService communicateInfoService;
	
	/**
	 * 查询通信情况列表
	 * @param page
	 * @return
	 */
	@GetMapping("/list")
	public ResultInfo list(Page page) {
		Page data = communicateInfoService.page(page);
		return ResultInfoUtil.success(data);
	}
}
