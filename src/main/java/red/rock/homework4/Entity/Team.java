package red.rock.homework4.Entity;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/18 19:39
 **/

import lombok.Data;

@Data
public class Team {

    private int id;
    private String name;
    private String information;
    private String label;
    private int count;
}
