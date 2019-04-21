package red.rock.homework4.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import red.rock.homework4.Entity.AccessToken;
import red.rock.homework4.Mapper.AccessTokenMapper;
import red.rock.homework4.Util.GetAccessTokenUtil;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/20 23:54
 **/
@Service
public class AccessTokenService {

    @Autowired
    private AccessTokenMapper accessTokenMapper;

    /**
     * 将得到的AccessToken存入数据库
     * @param
     * @return
     */
    public void addAccessToken(AccessToken accessToken){
        accessTokenMapper.addAccessToken(accessToken);
    }

    /**
     * 得到最近的AccessToken
     */
    public AccessToken getAccessToken(){
        return accessTokenMapper.getAccessToken();
    }

    /**
     * 获取accessToken from 接口 存入数据库
     */
    public boolean saveAccessToken(){
        AccessToken accessToken=GetAccessTokenUtil.getAccessToken();
        if(accessToken!=null) {
            addAccessToken(accessToken);
            return true;
        }
        return false;
    }


}
