package com.bigdata.coreweb.controller;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bigdata.coreweb.common.ResultInfo;
import com.bigdata.coreweb.entity.Flowpeople;
import com.bigdata.coreweb.model.FlowPeopleParam;
import com.bigdata.coreweb.service.IFlowpeopleService;
import com.bigdata.coreweb.util.CopyUtils;
import com.bigdata.coreweb.util.DateTimeUtil;
import com.bigdata.coreweb.util.RedisUtil;
import com.bigdata.coreweb.util.ResultInfoUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;

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

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/test")
    public ResultInfo test(@RequestHeader("token") String token) {
//        flowpeople.setId(UUIDUtil.uuid());
//        Object token1 = redisUtil.get("token");
        Object orgCode = redisUtil.hget(token, "orgCode");
        Object userId = redisUtil.hget(token, "userId");
        return null;
    }

    /**
     * 添加数据
     *
     * @param flowpeople
     * @return
     */
    @PostMapping("/add")
    public ResultInfo add(@RequestBody Flowpeople flowpeople, @RequestHeader("token") String token) {
//        flowpeople.setId(UUIDUtil.uuid());
        Object token1 = redisUtil.get("token");
        flowpeople.setCreateTime(DateTimeUtil.nowLong());
        flowpeople.setUpdateTime(DateTimeUtil.nowLong());
        flowpeople.setCheckTime(DateTimeUtil.nowLong());
        boolean save = flowpeopleService.save(flowpeople);
        return ResultInfoUtil.success(flowpeople);
    }

    /**
     * h5分页条件查询
     *
     * @param flowPeopleParam
     * @param page
     * @return
     */
    @GetMapping("/list")
    public ResultInfo list(FlowPeopleParam flowPeopleParam, Page page) {
//        flowpeople.setId(UUIDUtil.uuid());
        LambdaQueryChainWrapper<Flowpeople> flowpeopleLambdaQueryChainWrapper = flowpeopleService.lambdaQuery();
        flowPeopleParam.buildQuery(flowpeopleLambdaQueryChainWrapper);
        Page<Flowpeople> page1 = flowpeopleLambdaQueryChainWrapper.page(page);
        return ResultInfoUtil.success(page1);
    }

    /**
     * 后台分页条件查询
     *
     * @param flowPeopleParam
     * @param page
     * @return
     */
    @GetMapping("/listback")
    public ResultInfo listback(FlowPeopleParam flowPeopleParam, Page page) {
//        flowpeople.setId(UUIDUtil.uuid());
        LambdaQueryChainWrapper<Flowpeople> flowpeopleLambdaQueryChainWrapper = flowpeopleService.lambdaQuery();
        flowPeopleParam.buildQuery(flowpeopleLambdaQueryChainWrapper);
        Page<Flowpeople> page1 = flowpeopleLambdaQueryChainWrapper.page(page);
        return ResultInfoUtil.success(page1);
    }

    /**
     * 查询单个接口
     *
     * @param flowPeopleParam
     * @param page
     * @return
     */
    @GetMapping("/findById")
    public ResultInfo findById(String id) {
        Flowpeople byId = flowpeopleService.getById(id);
        return ResultInfoUtil.success(byId);
    }

    /**
     * 修改记录
     *
     * @param flowPeopleParam
     * @param page
     * @return
     */
    @PostMapping("/update")
    public ResultInfo update(@RequestBody Flowpeople flowpeople) {
        Flowpeople before = flowpeopleService.getById(flowpeople.getId());
        before.setCheckTime(DateTimeUtil.nowLong());
        before.setUpdateTime(DateTimeUtil.nowLong());
        CopyUtils.copyProperties(flowpeople, before);
        flowpeopleService.updateById(before);
        return ResultInfoUtil.success(before);
    }

    /**
     * 批量删除
     *
     * @param flowPeopleParam
     * @param page
     * @return
     */
    @PostMapping("/delete")
    public ResultInfo delete(@RequestBody String[] ids) {
        flowpeopleService.removeByIds(Arrays.asList(ids));
        return ResultInfoUtil.success();
    }


}
