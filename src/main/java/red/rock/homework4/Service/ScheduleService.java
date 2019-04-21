package red.rock.homework4.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import red.rock.homework4.Entity.AccessToken;
import red.rock.homework4.Mapper.UserMapper;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/19 11:24
 **/

@Component
public class ScheduleService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccessTokenService accessTokenService;

    @Scheduled(cron = "0 0 6 * * ?")
    public void refreshCount(){
      userMapper.refreshUserCount();
    }

    @Scheduled(cron="0 0 0/2 * * ?")
    public void refreshAccessToken(){
        accessTokenService.saveAccessToken();
    }
}
