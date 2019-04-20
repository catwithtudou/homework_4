package red.rock.homework4.Mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import red.rock.homework4.Entity.Photo;
import red.rock.homework4.Entity.Team;

import java.util.List;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/19 10:04
 **/
@Repository
@Mapper
public interface TeamMapper {

    /**
     * 若用户投票则count+1
     * @param id
     * @return boolean
     */
    @Update("update team_info set count=count+1 where id=#{id}")
    boolean updateCount(int id);

    /**
     * 得到team的信息
     * @param
     * @return Team
     */
    @Select("select * from team_info ")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "information", column = "information"),
            @Result(property = "label", column = "label"),
            @Result(property = "count", column = "count")
    })
    List<Team> getAllTeam();

    /**
     * 得到team所有photo集合
     * @param entityId
     * @return List<Photo>
     */
    @Select("select * from photo_info where entity_id=#{entityId}")
    @Results({
            @Result(property = "entityId",column = "entity_id"),
            @Result(property = "photo",column = "photo"),
            @Result(property = "id",column = "id")
    })
    List<Photo> getPhotos(int entityId);

    /**
     * 上传teamPhoto
     * @param photoObject
     * @return
     */
    @Insert("insert into photo_info(entity_id,photo)values(#{entityId},#{photo})")
    boolean insertPhoto(Photo photoObject);
}
