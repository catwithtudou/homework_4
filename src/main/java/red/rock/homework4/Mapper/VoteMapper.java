package red.rock.homework4.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/19 11:13
 **/
@Repository
@Mapper
public interface VoteMapper {

    /**
     * 插入投票记录
     * @param
     * @return
     */
    @Insert("insert into vote_info(uid,entity_id,timestamp)values(#{uid},#{entityId},#{timestamp})")
    boolean insertVote(int uid,int entityId,String timestamp);

}
