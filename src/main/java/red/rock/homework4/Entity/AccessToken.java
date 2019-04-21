package red.rock.homework4.Entity;

import lombok.Data;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/20 21:41
 **/
@Data
public class AccessToken {
    private String accessToken;
    private int expiresIn;
    private String timestamp;
}
