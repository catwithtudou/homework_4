package red.rock.homework4.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import red.rock.homework4.Entity.User;
import red.rock.homework4.Service.UserService;

import javax.servlet.http.HttpSession;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/18 20:54
 **/
@RestController
public class VoteController {

    @Autowired
    UserService userService;


    @RequestMapping("/vote")
    public String vote(@RequestParam(name="entityId" ,required = false)int entityId, HttpSession session){
        User user= (User) session.getAttribute("user");
        String openid=user.getOpenid();
        String nickname=user.getNickname();
        int uid=user.getId();
        if(openid==null){
            return "请登录后再试";
        }
        if(userService.isEnough(openid)){
            if(userService.voteTeam(uid,entityId)){
                return nickname+"投票成功";
            }
        }
        return nickname+"投票失败,请检查剩余票数";
    }


}
