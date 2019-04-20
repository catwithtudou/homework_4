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
public class IllegalPropertiesException extends Exception {
    @Getter
    @Setter
    protected String message;

    public IllegalPropertiesException() {
        setMessage("Prop is illegal!");
    }

    public IllegalPropertiesException(String message) {
        this.message = message;
        setMessage(String.format("Prop: %s is illegal!", message));
    }
}
