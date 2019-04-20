package red.rock.homework4.Config;


import lombok.Getter;
import lombok.Setter;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/20 21:07
 **/
public class NullOrEmptyException extends Exception {
    @Getter
    @Setter
    protected String message;

    public NullOrEmptyException() {
        setMessage("Parameter is null or empty!");
    }

    public NullOrEmptyException(String message) {
        this.message = message;
    }
}
