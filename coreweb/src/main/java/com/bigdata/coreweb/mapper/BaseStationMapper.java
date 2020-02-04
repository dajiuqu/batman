package com.bigdata.coreweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bigdata.coreweb.entity.CommunicateInfo;
import com.bigdata.coreweb.model.BaseStation;
import com.bigdata.coreweb.model.CommunicateParam;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 通信情况表 Mapper 接口
 * </p>
 *
 * @author root
 * @since 2020-02-01
 */
public interface BaseStationMapper extends BaseMapper<BaseStation> {
	List<BaseStation> list(CommunicateParam param);
}
