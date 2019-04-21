package red.rock.homework4.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import red.rock.homework4.Entity.AccessToken;
import red.rock.homework4.Service.AccessTokenService;
import red.rock.homework4.Util.CheckUtil;
import red.rock.homework4.Util.GetAccessTokenUtil;
import red.rock.homework4.Util.MenuUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *与微信对接登陆验证
 * @author  tudou
 * @date 2019/4/15 18:31
 * @version 1.0
 **/


@RestController
public class BasicController {

    @Autowired
    private AccessTokenService accessTokenService;

    @RequestMapping("/weixin")
    public String LoginController(HttpServletRequest request, HttpServletResponse response)
    {
        System.out.printf("success");
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }
        return null;
    }

    @RequestMapping("/getAccessToken")
    public String getAccessToken(){
        boolean flag=accessTokenService.saveAccessToken();
        return accessTokenService.getAccessToken().getAccessToken();
    }

    @RequestMapping("/createMenu")
    public String createMenu(){
        String accessToken=accessTokenService.getAccessToken().getAccessToken();
        System.out.println(accessToken);
        String menu= MenuUtil.initMenu();
        boolean flag=MenuUtil.createMenu(accessToken,menu);
        if(flag){
            return "创建菜单成功";
        }
        return "创建菜单失败";
    }
}
