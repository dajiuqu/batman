package com.bigdata.coreweb.service;

import com.bigdata.coreweb.entity.CommunicateInfo;
import com.bigdata.coreweb.model.CommunicateParam;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 通信情况表 服务类
 * </p>
 *
 * @author root
 * @since 2020-02-01
 */
public interface ICommunicateInfoService extends IService<CommunicateInfo> {
	Page list(CommunicateParam param, Page page);
	Page listByPhone(CommunicateParam param, Page page);
}
