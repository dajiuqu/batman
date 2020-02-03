package com.bigdata.coreweb.entity;

import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author root
 * @since 2020-02-01
 */
@Data
public class TroubleCountInfo  {
    String confirmDate;
    //汉滨区
    Integer hbq;
    //汉阴县
    Integer hyx;
    //石泉县
    Integer sqx;
    //宁陕县
    Integer nsx;
    //紫阳县
    Integer zyx;
    //岚皋县
    Integer lgx;
    //平利县
    Integer plx;
    //镇坪县
    Integer zpx;
    //旬阳县
    Integer xyx;
    //白河县
    Integer bhx;
    //汇总
    Integer total;
}
