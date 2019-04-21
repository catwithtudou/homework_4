package red.rock.homework4.Util;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import red.rock.homework4.Entity.AccessToken;
import red.rock.homework4.Service.AccessTokenService;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/21 10:02
 **/
public class MenuUtil {

    private static final String MENUURL="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    /**
     * 创建菜单
     * @param accessToken
     * @return
     */
    public static boolean createMenu(String accessToken){
        String url=MENUURL.replace("ACCESS_TOKEN",accessToken);
        JSONObject jsonObject
    }
}
