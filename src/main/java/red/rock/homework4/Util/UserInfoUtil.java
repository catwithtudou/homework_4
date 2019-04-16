package red.rock.homework4.Util;

import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/16 17:53
 **/
public class UserInfoUtil {


    public static String GetCode="https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=STAT#wechat_redirect";
        /**
             * 获取code地址
             * @param APPID
             * @param REDIRECT_URL
             * @param SCOPE
             * @return String
             */
        public static String getCode(String APPID,String REDIRECT_URL,String SCOPE){
            return String.format(GetCode,APPID,REDIRECT_URL,SCOPE);
        }


        public static String Web_Access="https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
            /**
                 * 获取Web_access_token_https的请求地址
                 * @param APPID
                 * @param SECRET
                 * @param CODE
                 * @return String
                 */
        public static String getWebAccess(String APPID,String SECRET,String CODE){
            return String.format(Web_Access,APPID,SECRET,CODE);
        }

        public static String User_Message="https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";
            /**
                 * 拉取用户信息的请求地址
                 * @param access_token
                 * @param openid
                 * @return String
                 */
        public static String getUserMessage(String access_token,String openid){
            return String.format(User_Message,access_token,openid);
        }

}
