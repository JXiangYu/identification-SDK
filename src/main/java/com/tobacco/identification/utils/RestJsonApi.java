package com.tobacco.identification.utils;

import com.tobacco.identification.vo.HttpCodeDef;
import com.tobacco.identification.vo.ResultHelper;
import com.tobacco.identification.vo.ResultInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public class RestJsonApi {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger(RestJsonApi.class);

    public static <T> ResultInfo doGet(String host, String path,
                                       Map<String, String> headers,
                                       Map<String, String> querys,
                                       Class<T> transToObjClass) {
        HttpEntity httpEntity = null;
        try {
            CloseableHttpResponse closeableHttpResponse = (CloseableHttpResponse) HttpUtils.doGet(host, path, null, headers, querys);
            httpEntity = closeableHttpResponse.getEntity();
            return parseResponse(closeableHttpResponse, httpEntity, transToObjClass);
        } catch (Exception e) {
            logger.error(e.getMessage());
            try {
                EntityUtils.consume(httpEntity);
            } catch (IOException e2) {
                logger.error(e2.getMessage());
            }
            throw new RuntimeException(e.getMessage(), e);
        }
    }


    /**
     * @param host            主机地址
     * @param path            路径
     * @param headers         请求头
     * @param querys          参数
     * @param bodys           此方法传数据对象 即可
     * @param transToObjClass 期望的返回值
     * @param <T>             返回值泛型
     * @return
     */
    public static <T> ResultInfo doPostJsonObj(String host, String path,
                                               Map<String, String> headers,
                                               Map<String, String> querys,
                                               Object bodys,
                                               Class<T> transToObjClass) {
        {
            HttpEntity httpEntity = null;
            try {
                CloseableHttpResponse closeableHttpResponse = (CloseableHttpResponse) HttpUtils.doPost(host, path, null, headers, querys, objectMapper.writeValueAsString(bodys));
                httpEntity = closeableHttpResponse.getEntity();
                return parseResponse(closeableHttpResponse, httpEntity, transToObjClass);
            } catch (Exception e) {
                logger.error(e.getMessage());
                try {
                    EntityUtils.consume(httpEntity);
                } catch (IOException e2) {
                    logger.error(e2.getMessage());
                }
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    /**
     * @param host            主机地址
     * @param path            路径
     * @param headers         请求头
     * @param querys          参数
     * @param bodys           此方法传数据对象 即可
     * @param transToObjClass 期望的返回值
     * @param <T>             返回值泛型
     * @return
     */
    public static <T> ResultInfo doPutJsonObj(String host, String path,
                                              Map<String, String> headers,
                                              Map<String, String> querys,
                                              Object bodys,
                                              Class<T> transToObjClass) {
        {
            HttpEntity httpEntity = null;
            try {
                String body = (bodys instanceof String)? (String)bodys:objectMapper.writeValueAsString(bodys);
                CloseableHttpResponse closeableHttpResponse = (CloseableHttpResponse) HttpUtils.doPut(host, path, null, headers, querys, body);
                httpEntity = closeableHttpResponse.getEntity();
                return parseResponse(closeableHttpResponse, httpEntity, transToObjClass);
            } catch (Exception e) {
                logger.error(e.getMessage());
                try {
                    EntityUtils.consume(httpEntity);
                } catch (IOException e2) {
                    logger.error(e2.getMessage());
                }
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    public static <T> ResultInfo doPost(String host, String path,
                                        Map<String, String> headers,
                                        Map<String, String> querys,
                                        Map<String, String> bodys,
                                        Class<T> transToObjClass) {
        {
            HttpEntity httpEntity = null;
            try {
                CloseableHttpResponse closeableHttpResponse = (CloseableHttpResponse) HttpUtils.doPost(host, path, null, headers, querys, bodys);
                httpEntity = closeableHttpResponse.getEntity();
                return parseResponse(closeableHttpResponse, httpEntity, transToObjClass);
            } catch (Exception e) {
                logger.error(e.getMessage());
                try {
                    EntityUtils.consume(httpEntity);
                } catch (IOException e2) {
                    logger.error(e2.getMessage());
                }
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    public static <T> ResultInfo doPostBytes(String host, String path,
                                             Map<String, String> headers,
                                             Map<String, String> querys,
                                             byte[] bytes,
                                             Class<T> transToObjClass) {
        {
            HttpEntity httpEntity = null;
            try {
                CloseableHttpResponse closeableHttpResponse = (CloseableHttpResponse) HttpUtils.doPost(host, path, null, headers, querys, bytes);
                httpEntity = closeableHttpResponse.getEntity();
                return parseResponse(closeableHttpResponse, httpEntity, transToObjClass);
            } catch (Exception e) {
                logger.error(e.getMessage());
                try {
                    EntityUtils.consume(httpEntity);
                } catch (IOException e2) {
                    logger.error(e2.getMessage());
                }
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    public static <T> ResultInfo doDelete(String host, String path,
                                          Map<String, String> headers,
                                          Map<String, String> querys,
                                          Class<T> transToObjClass) {
        {
            HttpEntity httpEntity = null;
            try {
                CloseableHttpResponse closeableHttpResponse = (CloseableHttpResponse) HttpUtils.doDelete(host, path, null, headers, querys);
                httpEntity = closeableHttpResponse.getEntity();
                return parseResponse(closeableHttpResponse, httpEntity, transToObjClass);
            } catch (Exception e) {
                logger.error(e.getMessage());
                try {
                    EntityUtils.consume(httpEntity);
                } catch (IOException e2) {
                    logger.error(e2.getMessage());
                }
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    public static void download(String host, HttpMethods method, Object bodys, String path, Map<String, String> headers, Map<String, String> querys, OutputStream ous) {
        HttpEntity httpEntity = null;
        try {
            CloseableHttpResponse closeableHttpResponse = null;
            switch (method) {
                case GET:
                    closeableHttpResponse = (CloseableHttpResponse) HttpUtils.doGet(host, path, null, headers, querys);
                    break;
                case POST:
                    closeableHttpResponse = (CloseableHttpResponse) HttpUtils.doPost(host, path, null, headers, querys, objectMapper.writeValueAsString(bodys));
                    break;
                default:
                    closeableHttpResponse = (CloseableHttpResponse) HttpUtils.doGet(host, path, null, headers, querys);
            }
            if (null == closeableHttpResponse) {
                return;
            }
            httpEntity = closeableHttpResponse.getEntity();
            httpEntity.writeTo(ous);
            ous.flush();
        } catch (Exception e) {
            logger.error(e.getMessage());
            try {
                EntityUtils.consume(httpEntity);
            } catch (IOException e2) {
                logger.error(e2.getMessage());
            }
            throw new RuntimeException(e.getMessage(), e);
        }
    }


    private static <T> ResultInfo parseResponse(CloseableHttpResponse closeableHttpResponse, HttpEntity httpEntity, Class<T> transToObjClass) throws IOException {


        int responseCode = -1;
        byte[] responseBytes = null;
        responseCode = closeableHttpResponse.getStatusLine().getStatusCode();
        byte[] responseBody = null == httpEntity ? null : EntityUtils.toByteArray(httpEntity);


        if (responseBody != null) {
            responseBytes = responseBody;
        } else if (null == httpEntity) {
            if (responseCode >= 200 && responseCode <= 206) {
                HttpCodeDef httpCodeDef = HttpCodeDef.findByHttpCode(responseCode);
                return ResultHelper.getSuccess(httpCodeDef, null);
            }
        } else {
            InputStream respStream = null;
            try {
                respStream = httpEntity.getContent();
                int respBodySize = respStream.available();
                if (respBodySize <= 0)
                    throw new IOException("Invalid respBodySize: " + respBodySize);
                responseBytes = new byte[respBodySize];
                if (respStream.read(responseBytes) != respBodySize)
                    throw new IOException("Read respBody Error");
            } catch (Exception e) {
                logger.error(e.getMessage());
                throw new RuntimeException(e.getMessage());
            } finally {
                if (respStream != null) {
                    respStream.close();
                }
            }
        }
        String result = new String(responseBytes, "UTF-8");
        if (responseCode >= 200 && responseCode <= 206) {
            HttpCodeDef httpCodeDef = HttpCodeDef.findByHttpCode(responseCode);
            if (null == transToObjClass) {
                return ResultHelper.getSuccess(httpCodeDef, result);
            } else {
                if (StringUtils.isEmpty(result)) {
                    return ResultHelper.getSuccess(httpCodeDef, result);
                }
                T obj = objectMapper.readValue(result, transToObjClass);
                return ResultHelper.getSuccess(httpCodeDef, obj);
            }
        } else {
            return ResultHelper.requestFaild(result, responseCode + "");
        }
    }

}