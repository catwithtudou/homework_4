package red.rock.homework4.Util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import red.rock.homework4.Entity.AccessToken;
import red.rock.homework4.Mapper.AccessTokenMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/20 21:35
 **/

public class GetAccessTokenUtil {


    private static final String WXAPPID="wxc59f653b654edada";
    private static final String WXAPPSECRECT="03ad94f4fc842cefcd36b11b21fef998";

    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?"
            + "grant_type=client_credential&appid=APPID&secret=APPSECRET";


    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 处理get请求
     * @param url
     * @return
     */
    public static JSONObject doGetStr(String url){
        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpGet httpGet=new HttpGet(url);
        JSONObject jsonObject=null;
        try{
            CloseableHttpResponse response=httpClient.execute(httpGet);
            HttpEntity entity=response.getEntity();
            if(entity!=null){
                String result= EntityUtils.toString(entity);
                jsonObject=new JSONObject(result);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 处理post请求
     * @param  url
     * @param  outStr
     * @return
     */
    public static JSONObject doPostStr(String url,String outStr){
        CloseableHttpClient httpClient=HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        JSONObject jsonObject=null;
        try{
            httpPost.setEntity(new StringEntity(outStr,"utf-8"));
            CloseableHttpResponse response=httpClient.execute(httpPost);
            String result=EntityUtils.toString(response.getEntity(),"utf-8");
            jsonObject=new JSONObject(result);
        }catch (IOException e){
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 获取AccessToken FROM 接口
     */
    public static AccessToken getAccessToken(){
        AccessToken accessToken=new AccessToken();
        String url=ACCESS_TOKEN_URL.replace("APPID",WXAPPID).replace("APPSECRET",WXAPPSECRECT);
        JSONObject jsonObject=doGetStr(url);
        if(jsonObject!=null){
            accessToken.setAccessToken(jsonObject.getString("access_token"));
            accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
            accessToken.setTimestamp(DATE_FORMAT.format(new Date()));
        }
        return accessToken;
    }

}
