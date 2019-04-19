package red.rock.homework4.Entity;

import lombok.Data;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/19 10:40
 **/
@Data
public class Photo {

    private int id;
    private int entityId;
    private String photo;

    public Photo(){

    }

    public Photo(int entityId,String photo){
        this.entityId=entityId;
        this.photo=photo;
    }
}
