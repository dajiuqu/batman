package com.bigdata.coreweb.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bigdata.coreweb.entity.CommunicateInfo;
import com.bigdata.coreweb.model.BaseStation;
import com.bigdata.coreweb.model.CommunicateParam;

import java.util.List;

/**
 * <p>
 * 通信情况表 服务类
 * </p>
 *
 * @author root
 * @since 2020-02-01
 */
public interface BaseStationService extends IService<BaseStation> {
	List<BaseStation> list(CommunicateParam param);
}
