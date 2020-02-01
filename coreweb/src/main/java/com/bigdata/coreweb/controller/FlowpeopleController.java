package com.bigdata.coreweb.controller;

import com.bigdata.coreweb.common.ResultInfo;
import com.bigdata.coreweb.entity.Flowpeople;
import com.bigdata.coreweb.service.IFlowpeopleService;
import com.bigdata.coreweb.util.DateTimeUtil;
import com.bigdata.coreweb.util.ResultInfoUtil;
import com.bigdata.coreweb.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 流动人员登记表 前端控制器
 * </p>
 *
 * @author root
 * @since 2020-02-01
 */
@RestController
@RequestMapping("/flowpeople")
public class FlowpeopleController {

    @Autowired
    private IFlowpeopleService flowpeopleService;

    @PostMapping("/add")
    public ResultInfo add(@RequestBody Flowpeople flowpeople) {
//        flowpeople.setId(UUIDUtil.uuid());
        flowpeople.setCreateTime(DateTimeUtil.nowLong());
        flowpeople.setUpdateTime(DateTimeUtil.nowLong());
        flowpeople.setCheckTime(DateTimeUtil.nowLong());
        boolean save = flowpeopleService.save(flowpeople);
        return ResultInfoUtil.success(flowpeople);
    }

}
