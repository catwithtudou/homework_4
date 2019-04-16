package red.rock.homework4.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/16 18:05
 **/

@RestController
public class RedirectController {



    private static final String WXAPPID="wxc59f653b654edada";
    private static final String WXAPPSECRECT="03ad94f4fc842cefcd36b11b21fef998";

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
    public 


}
