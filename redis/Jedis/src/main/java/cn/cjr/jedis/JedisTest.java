package cn.cjr.jedis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class JedisTest {

    private Jedis jedis;

    @BeforeEach
    public void setUp(){
        /*
            1、建立连接
            2、设置密码
            3、选择默认库
         */
        jedis = new Jedis("116.63.138.54",6379);
//        jedis.auth("123456");
        jedis.select(0);
    }

    @Test
    public void testString(){
        String result = jedis.set("name", "chenjunran");
        System.out.println("result = " + result);

        String name = jedis.get("name");
        System.out.println("name = " + name);
    }

    @Test
    public void testHash(){
        jedis.hset("usr:1","name","chenjunran");
        jedis.hset("usr:1","age","23");

        Map<String, String> stringStringMap = jedis.hgetAll("usr:1");
        System.out.println(stringStringMap);
    }

    @AfterEach
    public void setDown(){
        if (jedis != null){
            jedis.close();
        }
    }

}
