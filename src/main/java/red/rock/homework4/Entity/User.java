package red.rock.homework4.Entity;

import lombok.Data;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/18 19:34
 **/
@Data
public class User {

    int id;
    private String openid;
    private String nickname;
    private String sex;
    private int count;

    public User(){

    }
    public User(String openid,String nickname,String sex,int count){
        this.count=count;
        this.nickname=nickname;
        this.openid=openid;
        this.sex=sex;
    }
}
