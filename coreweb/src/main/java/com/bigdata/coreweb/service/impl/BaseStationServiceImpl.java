package com.bigdata.coreweb.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bigdata.coreweb.entity.CommunicateInfo;
import com.bigdata.coreweb.mapper.BaseStationMapper;
import com.bigdata.coreweb.mapper.CommunicateInfoMapper;
import com.bigdata.coreweb.model.BaseStation;
import com.bigdata.coreweb.model.CommunicateParam;
import com.bigdata.coreweb.service.BaseStationService;
import com.bigdata.coreweb.service.ICommunicateInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 通信情况表 服务实现类
 * </p>
 *
 * @author root
 * @since 2020-02-01
 */
@Service
public class BaseStationServiceImpl extends ServiceImpl<BaseStationMapper, BaseStation> implements BaseStationService {

@Override
public List<BaseStation> list(CommunicateParam param){
	return getBaseMapper().list(param);
}
}
