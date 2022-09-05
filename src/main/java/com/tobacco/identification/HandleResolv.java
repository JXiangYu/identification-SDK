package com.tobacco.identification;

import com.alibaba.fastjson.JSON;
import com.tobacco.identification.utils.RestJsonApi;
import com.tobacco.identification.vo.ResultHelper;
import com.tobacco.identification.vo.ResultInfo;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JXiangYu
 * @create 2022/1/18 14:35
 */
public class HandleResolv extends Base implements HandleResolvInf {

    private final IODSYSDK iodsysdk;

    public HandleResolv(IODSYSDK iodsysdk) {
        this.iodsysdk = iodsysdk;
    }

    @Override
    public ResultInfo parseIdentificationData(String handleCode) {
        Map<String, String> querys = new HashMap<>();
        ResultInfo resultInfo = RestJsonApi.doGet(iodsysdk.getHost(), "/iodapi/iod_site_mgr/iodSiteResolv/query/getTableListData/" + handleCode, headers, querys, null);
        return JSON.parseObject(resultInfo.getObj().toString(), ResultInfo.class);
    }

    @Override
    public ResultInfo parseIdentificationGraphData(String handleCode) {
        Map<String, String> querys = new HashMap<>();
        ResultInfo resultInfo = RestJsonApi.doGet(iodsysdk.getHost(), "/iodapi/iod_site_mgr/iodSiteResolv/query/getStarGraphData/" + handleCode, headers, querys, null);
        ResultInfo result = JSON.parseObject(resultInfo.getObj().toString(), ResultInfo.class);
        if (result.isOK()) {
            return ResultHelper.getSuccess(result.getObj());
        }
        return ResultHelper.requestFaild("查询异常");
    }
}
