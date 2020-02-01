package com.bigdata.coreweb.controller;

import com.bigdata.coreweb.common.ResultInfo;
import com.bigdata.coreweb.entity.Flowpeople;
import com.bigdata.coreweb.service.IFlowpeopleService;
import com.bigdata.coreweb.util.DateTimeUtil;
import com.bigdata.coreweb.util.ResultInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list")
    public ResultInfo list(@RequestBody Flowpeople flowpeople) {
//        flowpeople.setId(UUIDUtil.uuid());
        flowpeople.setCreateTime(DateTimeUtil.nowLong());
        flowpeople.setUpdateTime(DateTimeUtil.nowLong());
        flowpeople.setCheckTime(DateTimeUtil.nowLong());
        boolean save = flowpeopleService.save(flowpeople);
        return ResultInfoUtil.success(flowpeople);
    }

}
