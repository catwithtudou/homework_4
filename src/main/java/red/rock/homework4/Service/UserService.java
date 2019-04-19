package red.rock.homework4.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import red.rock.homework4.Entity.Team;
import red.rock.homework4.Entity.User;
import red.rock.homework4.Mapper.TeamMapper;
import red.rock.homework4.Mapper.UserMapper;
import red.rock.homework4.Mapper.VoteMapper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/18 20:17
 **/

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private VoteMapper voteMapper;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 注册用户
     * @param user
     * @return boolean
     */
    public void registerUser(User user){
        userMapper.addUser(user);
    }

    /**
     * 是否为新用户
     * @param
     * @return
     */
    public User getUser(String openid){
         User user=userMapper.getUser(openid);
         if(user==null){
             return null;
         }
         return user;
    }

    /**
     * 用户投票
     * @param uid
     * @param entityId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean voteTeam(int uid,int entityId){
        if(userMapper.updateCount(uid)&&
        teamMapper.updateCount(entityId)){
            if(voteMapper.insertVote(uid,entityId,DATE_FORMAT.format(new Date()))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检查用户投票是否有剩余票数
     * @param openid
     * @return boolean
     */
    public boolean isEnough(String openid){
        User user=userMapper.getUser(openid);
        if(user.getCount()>0){
            return true;
        }
        return false;
    }

}
