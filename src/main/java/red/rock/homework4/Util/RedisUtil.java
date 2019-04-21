package red.rock.homework4.Util;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;

/**
 * TODO
 *
 * @author tudou
 * @version 1.0
 * @date 2019/4/19 21:43
 **/
public class RedisUtil {

    /**
     * Redis服务器IP
     */
    private static String ADDR="127.0.0.1";

    /**
     * Redis的端口号
     */
    private static int PORT=6397;

    /**
     * 访问密码
     */
    private static String AUTH="123456";

    /**
     * 可用连接实例的最大数目默认值为8
     * 如果赋值为-1,则表示不限制;如果pool已经分配了maxActive个jedis实例
     */
    private static int MAX_ACTIVE=1024;

    /**
     * 控制一个Pool最多有多少个状态为idle(空闲的)的Jedis实例,默认值也是8
     */
    private static int MAX_IDLE=200;

    /**
     * 等待可用连接的最大时间,单位为毫秒,默认值为-1表示永不超时;如果超过等待时间，则直接抛出JedisConnectionException；
     */
    private static int MAX_WAIT=10000;

    private static int TIMEOUT=10000;

    /**
     * 在borrow一个jedis实例时,是否提前进行validate操作;如果为true,则得到的Jedis实例均是可用的
     */
    private static  boolean TEST_ON_BORROW=true;

}
