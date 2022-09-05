package com.tobacco.identification;

import com.tobacco.identification.pojo.IodBusinessModel;
import com.tobacco.identification.vo.ResultInfo;

import java.util.List;

public interface BusinessDataInf {

    ResultInfo addOneBusiness(IodBusinessModel iodBusinessModel);

    ResultInfo delOneBusiness(String handleCode);

    ResultInfo updateOneBusiness(IodBusinessModel iodBusinessModel);

    ResultInfo addBatchBusiness(List<IodBusinessModel> iodBusinessModelList);

}
