package red.rock.homework4.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import red.rock.homework4.Entity.Photo;
import red.rock.homework4.Entity.Team;
import red.rock.homework4.Mapper.TeamMapper;

import java.util.List;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/19 10:34
 **/
@Service
public class TeamService {

    @Autowired
    TeamMapper teamMapper;

    /**
     * 得到team的所有信息
     * @return Team
     */
    public List<Team> getAllTeam(){
        List<Team> teams=teamMapper.getAllTeam();
        return teams;
    }

    /**
     * 得到team的所有头像
     * @param entityId
     * @return List
     */
    public List<Photo> getTeamPhotos(int entityId){
        List<Photo> photos=teamMapper.getPhotos(entityId);
        return photos;
    }

    /**
     * team上传头像
     * @param photo
     * @param entityId
     * @return boolean
     */
    public boolean uploadPhoto(String photo,int entityId){
        Photo photoObject=new Photo(entityId,photo);
        if(teamMapper.insertPhoto(photoObject)){
            return  true;
        }
        return false;
    }
}
