package com.tobacco.identification;

import com.tobacco.identification.pojo.IODMetaData;
import com.tobacco.identification.vo.ResultInfo;


public interface DataDefineInf {

    ResultInfo addOneMetaData(IODMetaData iodMetaData);

    ResultInfo approveOneMetaData(Long id,String status);

}
