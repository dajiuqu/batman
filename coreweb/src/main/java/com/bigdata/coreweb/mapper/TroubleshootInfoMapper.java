package com.bigdata.coreweb.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bigdata.coreweb.entity.TroubleCountInfo;
import com.bigdata.coreweb.entity.TroubleshootInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bigdata.coreweb.model.TroubleCountParam;
import com.bigdata.coreweb.model.TroubleshootInfoParam;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author root
 * @since 2020-02-01
 */
public interface TroubleshootInfoMapper extends BaseMapper<TroubleshootInfo> {
    List<Map<String, Object>> list(TroubleshootInfoParam param, Page page);
    List<Map<String, Object>> listTroubleCount(TroubleCountParam param, Page page);
    List<TroubleCountInfo> exportListData(TroubleCountParam param);
}
