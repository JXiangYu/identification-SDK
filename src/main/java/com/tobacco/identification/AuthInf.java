package com.tobacco.identification;


import com.tobacco.identification.vo.ResultInfo;

public interface AuthInf {

    ResultInfo loginHandle(String host, String path, String appKey);

    String signOut();

}
