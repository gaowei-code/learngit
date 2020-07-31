package http;

/**
 * @Description
 * @Author gw
 * @Date 2020/7/31 15:05
 */
public class HttpResult {
    /**响应码*/
    private int code;
    /**相应数据*/
    private String data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "code=" + code +
                ", data='" + data + '\'' +
                '}';
    }
}
