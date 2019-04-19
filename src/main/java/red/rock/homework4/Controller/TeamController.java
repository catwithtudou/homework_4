package red.rock.homework4.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import red.rock.homework4.Entity.Photo;
import red.rock.homework4.Entity.Team;
import red.rock.homework4.Service.TeamService;
import red.rock.homework4.Service.UserService;

import java.util.List;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/19 10:27
 **/
@RestController
public class TeamController {

    @Autowired
    TeamService teamService;

    @RequestMapping("/getAllTeam")
    public List<Team> getAllTeamInformation(){
        List<Team> teams=teamService.getAllTeam();
        return teams;
    }

    @RequestMapping("/getTeamPhoto")
    public List<Photo> getTeamPhotos(@RequestParam(name = "entityId")int entityId){
        List<Photo> photos=teamService.getTeamPhotos(entityId);
        return photos;
    }

    @RequestMapping("/uploadTeamPhoto")
    public String uploadTeamPhoto(){
        return null;
    }
}
