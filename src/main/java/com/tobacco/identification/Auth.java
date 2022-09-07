package com.tobacco.identification;

import com.alibaba.fastjson2.JSON;
import com.tobacco.identification.Model.SimpleLoginModel;
import com.tobacco.identification.utils.ReadFileUtil;
import com.tobacco.identification.utils.RestJsonApi;
import com.tobacco.identification.vo.ResultHelper;
import com.tobacco.identification.vo.ResultInfo;



/**
 * @author JXiangYu
 * @description: login interfaceImpl
 * @date 2021/1/4 20:13
 */
class Auth extends Base implements AuthInf {

    private final IODSYSDK iodsysdk;

    public Auth(IODSYSDK iodsysdk) {
        this.iodsysdk = iodsysdk;
    }

    @Override
    public ResultInfo loginHandle(String host, String path, String appKey) {
        byte[] bytes = ReadFileUtil.readFile(path);
        SimpleLoginModel simpleLoginModel = new SimpleLoginModel();
        simpleLoginModel.setAppKey(appKey);
        simpleLoginModel.setPrivateKey(bytes);
        iodsysdk.setHost(host);
        ResultInfo loginResult = RestJsonApi.doPostJsonObj(host, "/iodapi/sys_mgr/loginHandle", headers, null, simpleLoginModel, null);
        if (loginResult.isOK()) {
            if(loginResult.getObj().toString().startsWith("ey")) {
                headers.put("Authorization", "xytoken_" + loginResult.getObj().toString());
                ResultInfo result = RestJsonApi.doGet(iodsysdk.getHost(), "/iodapi/identification_mgr/iodRegister/query/sitePrefix", headers, null, null);
                if (result.isOK()){
                    ResultInfo resultInfo = JSON.parseObject(result.getObj().toString(), ResultInfo.class);
                    iodsysdk.setPrefix(resultInfo.getObj().toString());
                }
                return ResultHelper.getSuccess(loginResult.getObj().toString());
            }else{
                return ResultHelper.requestFaild(loginResult.getObj().toString());
            }
        }
        return ResultHelper.requestFaild(loginResult.getMsg());
    }


    @Override
    public String signOut() {
        RestJsonApi.doGet(iodsysdk.getHost(), "/iodapi/sys_mgr/sign_out", headers, null, null);
        return "Sign Out SUCCESS";
    }

}
