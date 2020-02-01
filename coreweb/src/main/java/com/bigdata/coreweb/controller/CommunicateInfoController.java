package com.bigdata.coreweb.controller;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bigdata.coreweb.common.ResultInfo;
import com.bigdata.coreweb.entity.CommunicateInfo;
import com.bigdata.coreweb.model.CommunicateParam;
import com.bigdata.coreweb.service.ICommunicateInfoService;
import com.bigdata.coreweb.util.RedisUtil;
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
	private RedisUtil redisUtil;
	
	@Autowired
	private ICommunicateInfoService communicateInfoService;
	
	/**
	 * 查询通信情况列表
	 * @param page
	 * @return
	 */
	@GetMapping("/list")
	public ResultInfo list(Page page, CommunicateParam param) {
		param.setCode(redisUtil.get("uuid").toString());
		Page data = communicateInfoService.list(param, page);
		return ResultInfoUtil.success(data);
	}
	
	@GetMapping("/listByPhone")
	public ResultInfo listByPhone(Page page, CommunicateParam param) {
		param.setCode(redisUtil.get("uuid").toString());
		Page data = communicateInfoService.listByPhone(param, page);
		return ResultInfoUtil.success(data);
	}
	
	/**
	 * 新增通信情况
	 * @param communicateInfo
	 * @return
	 */
	@PostMapping("/save")
	public ResultInfo save(@RequestBody CommunicateInfo communicateInfo) {
		communicateInfoService.save(communicateInfo);
		return ResultInfoUtil.success();
	}
	
	/**
	 * 修改通信情况
	 * @param communicateInfo
	 * @return
	 */
	@PostMapping("/update")
	public ResultInfo update(@RequestBody CommunicateInfo communicateInfo) {
		communicateInfoService.updateById(communicateInfo);
		return ResultInfoUtil.success();
	}
	
	/**
	 * 删除通信情况
	 * @param ids
	 * @return
	 */
	@PostMapping("/delete")
	public ResultInfo delete(@RequestBody CommunicateParam param) {
		communicateInfoService.removeByIds(Arrays.asList(param.getIds()));
		return ResultInfoUtil.success();
	}
}
