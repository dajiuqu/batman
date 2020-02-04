package com.bigdata.coreweb.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bigdata.coreweb.entity.TroubleCountInfo;
import com.bigdata.coreweb.entity.TroubleshootInfo;
import com.bigdata.coreweb.model.TroubleCountParam;
import com.bigdata.coreweb.model.TroubleshootInfoParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author root
 * @since 2020-02-01
 */
public interface ITroubleshootInfoService extends IService<TroubleshootInfo> {
    Page list(TroubleshootInfoParam param, Page page);
    Page<TroubleCountInfo> listTroubleCount(TroubleCountParam param, Page page);
    List<TroubleCountInfo> exportListData(TroubleCountParam param);
}
