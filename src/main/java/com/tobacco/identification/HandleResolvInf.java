package com.tobacco.identification;


import com.tobacco.identification.vo.ResultInfo;

/**
 * @author JXiangYu
 * @create 2022/1/18 14:34
 */
public interface HandleResolvInf {

    ResultInfo parseIdentificationData(String handleCode);

    ResultInfo parseIdentificationGraphData(String handleCode);

}
