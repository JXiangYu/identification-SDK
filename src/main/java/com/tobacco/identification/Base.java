package com.tobacco.identification;

import com.tobacco.identification.utils.HeaderBuilder;

import java.util.Map;

/**
 * @author JXiangYu
 * @description: BaseServiceImpl
 * @date 2021/3/19 15:51
 */
public class Base {

	final static Map<String, String> headers = HeaderBuilder.buildJsonHeader();

}
