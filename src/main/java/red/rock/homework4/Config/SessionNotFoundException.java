package red.rock.homework4.Config;


import lombok.Getter;
import lombok.Setter;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/20 21:05
 **/
public class SessionNotFoundException extends Exception {
    @Getter
    @Setter
    protected String message;

    public SessionNotFoundException() {
        setMessage("Session is not found!");
    }

    public SessionNotFoundException(String message) {
        this.message = message;
    }
}
