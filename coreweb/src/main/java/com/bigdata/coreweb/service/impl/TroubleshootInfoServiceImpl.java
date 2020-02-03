package com.bigdata.coreweb.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bigdata.coreweb.entity.TroubleCountInfo;
import com.bigdata.coreweb.entity.TroubleshootInfo;
import com.bigdata.coreweb.mapper.TroubleshootInfoMapper;
import com.bigdata.coreweb.model.TroubleCountParam;
import com.bigdata.coreweb.model.TroubleshootInfoParam;
import com.bigdata.coreweb.service.ITroubleshootInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author root
 * @since 2020-02-01
 */
@Service
public class TroubleshootInfoServiceImpl extends ServiceImpl<TroubleshootInfoMapper, TroubleshootInfo> implements ITroubleshootInfoService {
    @Override
    public Page list(TroubleshootInfoParam param, Page page) {
        page.setRecords(getBaseMapper().list(param, page));
        return page;
    }

    @Override
    public Page listTroubleCount(TroubleCountParam param, Page page) {
        page.setRecords(getBaseMapper().listTroubleCount(param, page));
        return page;
    }

    @Override
    public List<TroubleCountInfo> exportListData(TroubleCountParam param) {
        return getBaseMapper().exportListData(param);
    }
}
