package com.bigdata.coreweb.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bigdata.coreweb.entity.CommunicateInfo;
import com.bigdata.coreweb.mapper.CommunicateInfoMapper;
import com.bigdata.coreweb.model.CommunicateParam;
import com.bigdata.coreweb.service.ICommunicateInfoService;

/**
 * <p>
 * 通信情况表 服务实现类
 * </p>
 *
 * @author root
 * @since 2020-02-01
 */
@Service
public class CommunicateInfoServiceImpl extends ServiceImpl<CommunicateInfoMapper, CommunicateInfo> implements ICommunicateInfoService {

	@Override
	public Page list(CommunicateParam param, Page page) {
		page.setRecords(getBaseMapper().list(param, page));
		return page;
	}

	@Override
	public Page listByPhone(CommunicateParam param, Page page) {
		page.setRecords(getBaseMapper().listByPhone(param, page));
		return page;
	}

	@Override
	public Page listData(CommunicateParam param, Page page) {
		page.setRecords(getBaseMapper().listData(param, page));
		return page;
	}
}
