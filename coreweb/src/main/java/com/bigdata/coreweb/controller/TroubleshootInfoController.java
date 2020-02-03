package com.bigdata.coreweb.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bigdata.coreweb.aspect.AuthAspect;
import com.bigdata.coreweb.common.ResultInfo;
import com.bigdata.coreweb.entity.TroubleCountInfo;
import com.bigdata.coreweb.entity.TroubleshootInfo;
import com.bigdata.coreweb.exception.ContentException;
import com.bigdata.coreweb.model.TroubleCountParam;
import com.bigdata.coreweb.model.TroubleshootInfoParam;
import com.bigdata.coreweb.service.ITroubleshootInfoService;
import com.bigdata.coreweb.util.DateTimeUtil;
import com.bigdata.coreweb.util.ResultInfoUtil;
import com.bigdata.coreweb.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  排查控制类
 * </p>
 *
 * @author root
 * @since 2020-02-01
 */
@RestController
@RequestMapping("/troubleshootInfo")
public class TroubleshootInfoController {
    @Autowired
    ITroubleshootInfoService troubleshootInfoService;

    @Autowired
    AuthAspect authAspect;
    /**
     * 新增排查
     * @param troubleshootInfo
     * @return
     */
    @PostMapping("/save")
    public ResultInfo save(@RequestBody TroubleshootInfo troubleshootInfo) {
        troubleshootInfo.setCreateTime(DateTimeUtil.nowLong());
        troubleshootInfo.setCreator(authAspect.getLoginName());
        troubleshootInfoService.save(troubleshootInfo);
        return ResultInfoUtil.success();
    }

    /**
     * 修改排查
     * @param troubleshootInfo
     * @return
     */
    @PostMapping("/update")
    public ResultInfo update(@RequestBody TroubleshootInfo troubleshootInfo) {
        if(!StringUtil.isNullOrEmpty(String.valueOf(troubleshootInfo.getAuditStatus()))){
            troubleshootInfo.setAuditTime(DateTimeUtil.nowLong());
            troubleshootInfo.setAuditUser(authAspect.getLoginName());
        }
        troubleshootInfo.setUpdateTime(DateTimeUtil.nowLong());
        troubleshootInfoService.updateById(troubleshootInfo);
        return ResultInfoUtil.success();
    }

    /**
     * 查询排查列表
     * @param page
     * @return
     * @throws ContentException
     */
    @GetMapping("/list")
    public ResultInfo list(Page page, TroubleshootInfoParam param) throws ContentException {
        param.setArea(authAspect.getLoginUserDistrictCode());
        Page data = troubleshootInfoService.list(param, page);
        return ResultInfoUtil.success(data);
    }

    /**
     * 查询排查汇总信息
     * @param param
     * @return
     * @throws ContentException
     */
    @GetMapping("/listTroubleCount")
    public ResultInfo listTroubleCount(Page page,TroubleCountParam param) throws ContentException {
        param.setArea(authAspect.getLoginUserDistrictCode());
        Page data = troubleshootInfoService.listTroubleCount(param, page);
        return ResultInfoUtil.success(data);
    }

    @GetMapping("/exportListData")
    public void exportListDataq(TroubleCountParam param, HttpServletResponse response) throws IOException, ContentException {
        param.setArea(authAspect.getLoginUserDistrictCode());
        List<TroubleCountInfo> data = troubleshootInfoService.exportListData(param);
        ExcelWriter writer = ExcelUtil.getWriter();
        writer.addHeaderAlias("confirmDate", "日期");
        writer.addHeaderAlias("hbq", "汉滨区");
        writer.addHeaderAlias("hyx", "汉阴县");
        writer.addHeaderAlias("sqx", "石泉县");
        writer.addHeaderAlias("nsx", "宁陕县");
        writer.addHeaderAlias("zyx", "紫阳县");
        writer.addHeaderAlias("lgx", "岚皋县");
        writer.addHeaderAlias("plx", "平利县");
        writer.addHeaderAlias("zpx", "镇坪县");
        writer.addHeaderAlias("xyx", "旬阳县");
        writer.addHeaderAlias("bhx", "白河县");
        writer.addHeaderAlias("total", "汇总");
        int size = data.size();
        int len = 60000;
        if (size < len) {
            writer.write(data);
        } else {
            int n;
            if (size % len == 0) {
                n = size / len;
            } else {
                n = size / len + 1;
            }
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    writer.write(data.subList(i*len, (i+1)*len));
                } else if (i == n - 1) {
                    writer.setSheet("sheet"+(i+1)).write(data.subList(i*len, size));
                } else {
                    writer.setSheet("sheet"+(i+1)).write(data.subList(i*len, (i+1)*len));
                }
            }
        }
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=troubleInfo_"+ DateUtil.today()+".xls");
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out);
        writer.close();
    }

}
