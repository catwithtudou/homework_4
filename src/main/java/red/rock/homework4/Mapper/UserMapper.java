package red.rock.homework4.Mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import red.rock.homework4.Entity.User;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/18 20:11
 **/
@Repository
@Mapper
public interface UserMapper {

    /**
     * 增加用户
     *
     * @param user
     * @return void
     */
    @Insert("insert into user_info(openid,nickname,sex,count) values(#{openid},#{nickname},#{sex},#{count})")
    void addUser(User user);

    /**
     * 检查是否有重复用户
     * @param openid
     * @return String
     */
    @Select("select * from user_info where openid=#{openid}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "openid",column = "openid"),
            @Result(property = "nickname",column = "nickname"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "count",column = "count")
    })
    User getUser(String openid);

    /**
     * 更新用户票数
     * @param id
     * @return
     */
    @Update("update user_info set count=count-1 where id=#{id}")
    boolean updateCount(int id);

    /**
     * 重置用户票数
     */
    @Update("update user_info set count=5 ")
    void refreshUserCount();
}
