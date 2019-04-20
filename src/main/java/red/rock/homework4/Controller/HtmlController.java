package red.rock.homework4.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/20 21:24
 **/
@Controller
public class HtmlController {

    @GetMapping("/voteteam")
    public String voteTeam(){
        return "voteteam";
    }
}
