package com.tobacco.identification;


import com.alibaba.fastjson2.JSON;
import com.tobacco.identification.pojo.IODMetaData;
import com.tobacco.identification.utils.RestJsonApi;
import com.tobacco.identification.vo.ResultHelper;
import com.tobacco.identification.vo.ResultInfo;
import java.util.HashMap;
import java.util.Map;

class DataDefine extends Base implements DataDefineInf {

    private final IODSYSDK iodsysdk;


    public DataDefine(IODSYSDK iodsysdk) {
        this.iodsysdk = iodsysdk;
    }


    @Override
    public ResultInfo addOneMetaData(IODMetaData iodMetaData){

        Map<String, String> querys = new HashMap<>();
        ResultInfo result = RestJsonApi.doPostJsonObj(iodsysdk.getHost(), "/iodapi/iod_data_mgr/iodMetaRelation/add", headers, querys, iodMetaData, null);
        ResultInfo resultInfo = JSON.parseObject(result.getObj().toString(), ResultInfo.class);
        if (resultInfo.isOK()) {
            return resultInfo;
        }
        return ResultHelper.requestFaild("添加失败");
    }


    public ResultInfo addAndApproveOneMetaData(IODMetaData iodMetaData) {
        Map<String, String> querys = new HashMap<>();
        ResultInfo result = RestJsonApi.doPostJsonObj(iodsysdk.getHost(), "/iodapi/iod_data_mgr/iodMetaRelation/addAndApprove", headers, querys, iodMetaData, null);
        ResultInfo resultInfo = JSON.parseObject(result.getObj().toString(), ResultInfo.class);
        if (resultInfo.isOK()) {
            return resultInfo;
        }
        return ResultHelper.requestFaild("添加失败");
    }


    @Override
    public ResultInfo approveOneMetaData(Long id, String status) {
        Map<String, String> querys = new HashMap<>();
        ResultInfo result = RestJsonApi.doPutJsonObj(iodsysdk.getHost(), "/iodapi/iod_data_mgr/iodMetaRelation/modify/approve/"+id+"/"+status, headers, querys, null, null);
        ResultInfo resultInfo = JSON.parseObject(result.getObj().toString(), ResultInfo.class);
        if (resultInfo.isOK()) {
            return ResultHelper.getSuccess(resultInfo.getObj());
        }
        return ResultHelper.requestFaild("审批失败");
    }

}
