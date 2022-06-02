package cn.chenjr.jedis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author chenjr
 * @version 1.0
 * @date 2022/6/2 16:39
 */
public class Demo01 {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String ping = jedis.ping();
//        System.out.println("连接" + ping);

        // key
        jedis.set("k1","v1");
        jedis.set("k2","v2");
        jedis.set("k3","v3");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys.size());
        for (String key : keys) {
            System.out.println(key);
        }
        System.out.println(jedis.exists("k1"));
        System.out.println(jedis.ttl("k1"));
        System.out.println(jedis.get("k1"));


        jedis.close();
    }

}
