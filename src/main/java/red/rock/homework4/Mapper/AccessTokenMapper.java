package red.rock.homework4.Mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import red.rock.homework4.Entity.AccessToken;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/20 22:59
 **/
@Repository
@Mapper
public interface AccessTokenMapper {

    /**
     * 添加accessToken进数据库
     * @param accessToken
     * @return void
     */
    @Insert("insert into test(access_token,timestamp,expiresIn)values(#{accessToken},#{timestamp},#{expiresIn})")
    void addAccessToken(AccessToken accessToken);

    /**
     * 取出最后一条accessToken
     * @return AccessToken
     */
    @Select("select   *   from   test   order   by   id   desc   limit   1")
    @Results({
            @Result(property = "accessToken",column = "access_token"),
            @Result(property = "timestamp",column = "timestamp"),
            @Result(property = "expiresIn",column = "expiresIn"),
    })
    AccessToken getAccessToken();
}
