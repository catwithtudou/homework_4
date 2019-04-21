package red.rock.homework4.Entity;

import lombok.Data;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/21 10:10
 **/

@Data
public class Button {

    private String name;

    private String type;

    private Button[] sub_button;
}
