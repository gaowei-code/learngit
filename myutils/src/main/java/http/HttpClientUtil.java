package http;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author gw
 * @Date 2020/7/31 15:04
 * httpClient工具类
 */
public class HttpClientUtil {

    private HttpClientUtil(){}

    /**默认编码格式 UTF-8*/
    private static final String DEFAULT_CHARSET = "UTF-8";
    /**连接超时时间 单位：毫秒*/
    private static final int CONNECT_TIMEOUT = 6000;
    /**请求数据的超时时间，即响应时间，单位：毫秒*/
    private static final int SOCKET_TIMEOUT = 6000;

    /**
     * 添加请求头到请求头部
     * @param headers 要添加的请求头key-value
     * @param httpMethod 请求对象
     * @return 添加请求头后的请求对象
     */
    public static HttpRequestBase addHeaders(Map<String, String> headers, HttpRequestBase httpMethod){
        if (headers != null && !headers.isEmpty() && httpMethod != null){
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpMethod.addHeader(entry.getKey(), entry.getValue());
            }
        }
        return httpMethod;
    }

    /**
     * 发送请求
     * @param httpClient HttpClient 对象
     * @param httpResponse 相应对象
     * @param httpMethod 请求对象
     * @return 相应结果
     */
    public static HttpResult getHttpResult(CloseableHttpClient httpClient, CloseableHttpResponse httpResponse, HttpRequestBase httpMethod){
        HttpResult result = new HttpResult();
        try {
            httpResponse = httpClient.execute(httpMethod);
            StatusLine statusLine = httpResponse.getStatusLine();
            if (httpResponse != null && statusLine != null){
                String content = "";
                HttpEntity entity = httpResponse.getEntity();
                if (entity != null){
                    content = EntityUtils.toString(entity, DEFAULT_CHARSET);
                }
                result.setCode(statusLine.getStatusCode());
                result.setData(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 释放资源
     * @param httpClient
     * @param httpResponse
     */
    public static void flush(CloseableHttpClient httpClient, CloseableHttpResponse httpResponse){
        try {
            if (httpClient != null){
                httpClient.close();
            }
            if (httpResponse != null){
                httpResponse.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送get请求，带参数，带请求头
     * @param url 请求地址
     * @param params 请求参数
     * @param headers 请求头
     * @return 响应结果
     */
    public static HttpResult doGet(String url, Map<String,String> params, Map<String, String> headers){
        HttpResult result = new HttpResult();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            if (params != null && !params.isEmpty()){
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    uriBuilder.addParameter(entry.getKey(),entry.getValue());
                }
            }

            HttpGet httpGet = new HttpGet(uriBuilder.build());
            RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(CONNECT_TIMEOUT)
                    .setConnectionRequestTimeout(CONNECT_TIMEOUT)
                    .setSocketTimeout(SOCKET_TIMEOUT)
                    .build();
            httpGet.setConfig(requestConfig);
            addHeaders(headers, httpGet);
            CloseableHttpResponse httpResponse = null;
            result = getHttpResult(httpClient, httpResponse, httpGet);
            flush(httpClient,httpResponse);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 请求参数封装
     * @param httpMethod 请求对象
     * @param params 请求参数
     */
    public static void addParams(HttpEntityEnclosingRequestBase httpMethod, Map<String, String> params){
        if (params != null && !params.isEmpty()){
            List<NameValuePair> list = new ArrayList<>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            try {
                httpMethod.setEntity(new UrlEncodedFormEntity(list, DEFAULT_CHARSET));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发送post请求，带参数，带请求头
     * @param url 请求地址
     * @param params 请求参数
     * @param headers 请求头
     * @return 响应结果
     */
    public static HttpResult doPost(String url, Map<String,String> params, Map<String, String> headers){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        addParams(httpPost, params);
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(CONNECT_TIMEOUT)
                .setConnectionRequestTimeout(CONNECT_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .build();
        httpPost.setConfig(requestConfig);
        // 封装请求头
        addHeaders(headers, httpPost);
        CloseableHttpResponse httpResponse = null;
        HttpResult result = getHttpResult(httpClient, httpResponse, httpPost);
        flush(httpClient,httpResponse);
        return result;
    }
}
