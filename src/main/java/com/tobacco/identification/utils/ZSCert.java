package com.tobacco.identification.utils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.security.KeyStore;

public class ZSCert {


    public static HttpClientConnectionManager CONNECTION_MANAGER = null;
    Logger log = LoggerFactory.getLogger(ZSCert.class);

    /**
     * 初始化 connection manager.
     *
     * @param keyStoreFile
     * @param keyStorePass
     * @param trustStoreFile
     * @param trustStorePass
     * @throws Exception
     */
    public void init(String keyStoreFile, String keyStorePass, String trustStoreFile, String trustStorePass) throws Exception {
        log.info("init conection pool...");
        InputStream ksis = new FileInputStream(new File(keyStoreFile));
        InputStream tsis = new FileInputStream(new File(trustStoreFile));
        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(ksis, keyStorePass.toCharArray());
        KeyStore ts = KeyStore.getInstance("JKS");
        ts.load(tsis, trustStorePass.toCharArray());
        SSLContext sslContext = SSLContexts.custom()
                .loadKeyMaterial(ks, keyStorePass.toCharArray())
                // 如果有 服务器证书
                .loadTrustMaterial(ts, new TrustSelfSignedStrategy())
                //  如果没有服务器证书，可以采用自定义 信任机制
                // .loadTrustMaterial(null, new TrustStrategy() {
                // // 信任所有
                // public boolean isTrusted(X509Certificate[] arg0,
                // String arg1) throws CertificateException {
                // return true;
                // }
                // })
                .build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create().register("http", PlainConnectionSocketFactory.INSTANCE).register("https", sslsf).build();
        ksis.close();
        tsis.close();
        CONNECTION_MANAGER = new PoolingHttpClientConnectionManager(registry);
    }

    /**
     * do post
     *
     * @param url
     * @param params
     */
    public void post(String url, String params) throws Exception {
        if (CONNECTION_MANAGER == null) {
            return;
        }
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(CONNECTION_MANAGER).build();
        HttpPost httpPost = new HttpPost(url);

        httpPost.setEntity(new StringEntity(params,
                ContentType.APPLICATION_JSON));

        CloseableHttpResponse resp = httpClient.execute(httpPost);
//            log.info(resp.getStatusLine());
        InputStream respIs = resp.getEntity().getContent();
        String content = convertStreamToString(respIs);
        log.info(content);
        EntityUtils.consume(resp.getEntity());
    }

    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // 服务地址
        String url = "https://101.200.85.246:2014/biaoshi_bihindend/rootnode/save/approve";
        // 服务参数，这里接口的参数采用 json 格式传递
        String params = "{\n" +
                "  \"companyid\": 0,\n" +
                "  \"auditStatus\": \"string\",\n" +
                "  \"auditPerson\": \"string\",\n" +
                "  \"auditTime\": \"2011-01-22\",\n" +
                "  \"reason\": \"string\",\n" +
                "  \"perfix\": \"string\"\n" +
                "}";
        // 私钥证书
        String keyStoreFile = "f:/customer/local.p12";
        String keyStorePass = "libadmin";

        // 配置信任证书库及密码
        String trustStoreFile = "f:/customer/local.jks";
        String trustStorePass = "libadmin";

        ZSCert httpSSLClient = new ZSCert();
        try {
            httpSSLClient.init(keyStoreFile, keyStorePass, trustStoreFile, trustStorePass);
            httpSSLClient.post(url, params);
            //String body=httpSSLClient.get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



