package red.rock.homework4.Service;

import org.springframework.beans.factory.annotation.Autowired;
import red.rock.homework4.Entity.User;
import red.rock.homework4.Mapper.TeamMapper;
import red.rock.homework4.Mapper.UserMapper;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/20 20:19
 **/
public class test {
    @Autowired
    private static TeamMapper teamMapper;

    @Autowired
    private static UserMapper userMapper;

    public static void main(String[] args) {
        //System.out.println(teamMapper.getAllTeam().size());
        User user=new User();
        user.setCount(5);
        user.setId(1);
        user.setNickname("土豆啊土豆");
        user.setOpenid("oC75M1Kw9r6ChcVv06imFS2aG8dY");
        user.setSex("男");
        userMapper.addUser(user);
    }
}
