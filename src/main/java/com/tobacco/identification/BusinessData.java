package com.tobacco.identification;

import com.alibaba.fastjson2.JSON;
import com.tobacco.identification.pojo.IodBusinessModel;
import com.tobacco.identification.utils.RestJsonApi;
import com.tobacco.identification.vo.ResultHelper;
import com.tobacco.identification.vo.ResultInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BusinessData extends Base implements BusinessDataInf {
    private final IODSYSDK iodsysdk;

    public BusinessData(IODSYSDK iodsysdk) {
        this.iodsysdk = iodsysdk;
    }


    @Override
    public ResultInfo addOneBusiness(IodBusinessModel iodBusinessModel) {
        Map<String, String> querys = new HashMap<>();
        ResultInfo result = RestJsonApi.doPostJsonObj(iodsysdk.getHost(), "/iodapi/identification_mgr/iodRegister/add", headers, querys, iodBusinessModel, ResultInfo.class);
        if (result.isOK() && (result.getObj() != null)) {
            ResultInfo resultInfo = (ResultInfo) result.getObj();
            if (resultInfo.isOK()) {
                return resultInfo;
            } else {
                return ResultHelper.requestFaild(resultInfo.getMsg(), resultInfo.getCode());
            }
        }
        return ResultHelper.requestFaild("添加失败");
    }

    @Override

    public ResultInfo delOneBusiness(String handleCode) {

        Map<String, String> querys = new HashMap<>();
        ResultInfo result = RestJsonApi.doDelete(iodsysdk.getHost(), "/iodapi/identification_mgr/iodMaintain/delete/" + handleCode, headers, querys, null);
        ResultInfo resultInfo = JSON.parseObject(result.getObj().toString(), ResultInfo.class);
        if (resultInfo.isOK()) {
            return ResultHelper.getSuccess(resultInfo.getObj());
        }
        return ResultHelper.requestFaild("删除失败");
    }

    @Override
    public ResultInfo updateOneBusiness(IodBusinessModel iodBusinessModel) {
        Map<String, String> querys = new HashMap<>();
        headers.put("Content-Type", "application/json");
        ResultInfo result = RestJsonApi.doPutJsonObj(iodsysdk.getHost(), "/iodapi/identification_mgr/iodMaintain/modify", headers, querys, iodBusinessModel, null);
        if (result.isOK() && (result.getObj() != null)) {
            ResultInfo resultInfo = JSON.parseObject(result.getObj().toString(), ResultInfo.class);
            if (resultInfo.isOK()) {
                return resultInfo;
            }
            return resultInfo;
        }
        return ResultHelper.requestFaild("修改失败");
    }

    @Override
    public ResultInfo addBatchBusiness(List<IodBusinessModel> iodBusinessModelList) {
        if (iodBusinessModelList == null || iodBusinessModelList.size() <= 0) {
            return ResultHelper.requestFaild("批量注册数量须大于0");
        }
        Map<String, String> querys = new HashMap<>();
        try {
            ResultInfo result = RestJsonApi.doPostJsonObj(iodsysdk.getHost(), "/iodapi/identification_mgr/iodRegister/add/batch", headers, querys, iodBusinessModelList, null);
            if (result.isOK() && (result.getObj() != null)) {
                ResultInfo resultInfo = JSON.parseObject(result.getObj().toString(), ResultInfo.class);
                if (resultInfo.isOK() && (resultInfo.getObj() != null)) {
                    return resultInfo;
                } else {
                    return ResultHelper.requestFaild(resultInfo.getMsg(), resultInfo.getCode());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultHelper.requestFaild("添加失败");
    }
}
