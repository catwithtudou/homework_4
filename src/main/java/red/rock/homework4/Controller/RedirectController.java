package red.rock.homework4.Controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import red.rock.homework4.Entity.User;
import red.rock.homework4.Mapper.UserMapper;
import red.rock.homework4.Service.UserService;
import red.rock.homework4.Util.HttpsUtil;
import red.rock.homework4.Util.UserInfoUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/16 18:05
 **/

@RestController
public class RedirectController {

    @Autowired
    private UserService userService;


    private static final String WXAPPID="wxc59f653b654edada";
    private static final String WXAPPSECRECT="03ad94f4fc842cefcd36b11b21fef998";
    private static final String MYURL="http://tudou.ngrok.xiaomiqiu.cn";



   @RequestMapping("/getUser")
   public void getUserInofmation(HttpServletResponse response)throws IOException {
       String REDIRECT_URL=MYURL+"/url";
       String SCOPE="snsapi_userinfo";
       String userUrl=UserInfoUtil.getCode(WXAPPID,REDIRECT_URL,SCOPE);
       response.sendRedirect(userUrl);
   }

    /**
     * 微信网页授权流程:
     * 1. 用户同意授权,获取 code
     * 2. 通过 code 换取网页授权 access_token
     * 3. 使用获取到的 access_token 和 openid 拉取用户信息
     * @param code  用户同意授权后,获取到的code
     * @param state 重定向状态参数
     * @return
     */
    @GetMapping("/url")
    public String  wechatLogin(@RequestParam(name="code",required = false)String code,
                               @RequestParam(name="state",required = false)String state, HttpSession session,HttpServletResponse servletResponse){
        if(code!=null||!(code.equals(""))||state!=null){
            String APPID=WXAPPID;
            String SECRECT=WXAPPSECRECT;
            String CODE=code;
            String WebAccessToken;
            String openid;
            String nickname;
            String sex;
            String REDIRECT_URL=MYURL+"/url";
            String SCOPE="snsapi_userinfo";

            String getCodeUrl= UserInfoUtil.getCode(APPID,REDIRECT_URL,SCOPE);

            String tokenurl=UserInfoUtil.getWebAccess(APPID,SECRECT,CODE);

            String response= HttpsUtil.httpsRequestToString(tokenurl,"GET",null);


            JSONObject jsonObject=new JSONObject(response);
            if(null!=jsonObject){
                try{
                    WebAccessToken=jsonObject.getString("access_token");
                    openid=jsonObject.getString("openid");

                    String userMessageUrl=UserInfoUtil.getUserMessage(WebAccessToken,openid);

                    String userInformation=HttpsUtil.httpsRequestToString(userMessageUrl,"GET",null);

                    JSONObject userMessage=new JSONObject(userInformation);

                    if(userMessage!=null){
                        try{
                            int Sex;
                            nickname=userMessage.getString("nickname");
                            Sex=userMessage.getInt("sex");
                            sex=(Sex==1)?"男":"女";
                            openid=userMessage.getString("openid");
                            User user=userService.getUser(openid);
                            if(user==null){
                                user=new User(openid,nickname,sex,5);
                                userService.registerUser(user);
                                user=userService.getUser(user.getOpenid());
                            }
                            session.setAttribute("user",user);
                            servletResponse.sendRedirect("/voteteam");
                            return "授权成功";
                        }catch (Exception e){
                            e.printStackTrace();
                            return "授权失败";
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    return "授权失败";
                }
            }
        }
        return "授权失败";
    }


}
