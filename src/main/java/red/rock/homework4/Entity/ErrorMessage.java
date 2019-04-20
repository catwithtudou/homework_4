package red.rock.homework4.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/20 21:02
 **/
@NoArgsConstructor
@Data
@ToString
public class ErrorMessage<T> {
    public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    private Integer code;
    private String message;
    private String url;
    private T data;

}
