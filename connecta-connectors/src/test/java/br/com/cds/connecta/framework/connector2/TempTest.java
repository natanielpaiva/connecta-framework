package br.com.cds.connecta.framework.connector2;

import br.com.cds.connecta.framework.connector2.common.Base;
import java.util.Set;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 *
 */
public class TempTest {

    private final FusionClient client = new FusionClient();
    
    @Test
    public void testRedis() {
        Base base = new Base();
        Jedis jedisInstance = base.getJedisInstance();
//        jedisInstance.lpush("list", "Redis");
//        jedisInstance.lpush("list", "Mongo");
//        jedisInstance.lpush("list", "Mysql");
//       
//        ScanResult<String> scan = jedisInstance.scan(1);
//        ScanResult<String> scan1 = jedisInstance.scan("list");

        //Set<String> keys = jedisInstance.keys("*");
        Set<byte[]> keys = jedisInstance.keys("*".getBytes());
        
        for (byte[] key : keys) {
            //System.out.println("key: " + key);
            jedisInstance.del(key);
        }    

//        List<String> lrange = jedisInstance.lrange("list", 0, 5);
//        for (String lrange1 : lrange) {
//            
//            System.out.println("---- " + lrange1);
//        }
//        
        
    }

}
