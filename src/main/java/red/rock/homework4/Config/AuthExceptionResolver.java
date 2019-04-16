package red.rock.homework4.Config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *  TODO
 * @author  tudou
 * @date 2019/4/16 16:22
 * @version 1.0
 **/

public class AuthExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv=new ModelAndView(new MappingJackson2JsonView());
        Map<String,String> map=new HashMap<>(16);
        map.put("status","error");
        mv.addAllObjects(map);
        return mv;
    }
}
