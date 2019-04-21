package red.rock.homework4.Util;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import red.rock.homework4.Entity.*;
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

    private static final String MYURL="http://tudou.ngrok.xiaomiqiu.cn";

    /**
     * 创建菜单
     * @param accessToken
     * @param menu
     */
    public static boolean createMenu(String accessToken,String menu){
        String url=MENUURL.replace("ACCESS_TOKEN",accessToken);
        JSONObject jsonObject=GetAccessTokenUtil.doPostStr(url,menu);
        boolean flag=false;
        if(jsonObject!=null){
            if(jsonObject.getInt("errcode")==0){
                flag=true;
            }
        }
        return flag;
    }

    public static String initMenu(){

        ClickButton button11=new ClickButton();
        button11.setName("解压一下");
        button11.setKey("11");
        button11.setType("click");

        ViewButton button21=new ViewButton();
        button21.setName("投票入口");
        button21.setType("view");
        button21.setUrl(MYURL+"/getUser");

        Button button=new Button();
        button.setSub_button(new Button[]{button11,button21});
        button.setName("菜单");
        button.setType("click");

        Menu menu=new Menu();
        menu.setButton(new Button[]{button11,button21,button});
        return new JSONObject(menu).toString();
    }
}
