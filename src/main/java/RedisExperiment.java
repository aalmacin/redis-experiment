import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisConnection;
import com.lambdaworks.redis.RedisURI;

import java.util.List;

public class RedisExperiment {

    public static void main(String[] args) {
        System.out.println("Start");
        RedisClient redisClient = new RedisClient(RedisURI.create("rediss://10.98.144.67:6379"));

        RedisConnection<String, String> redisConnection = redisClient.connect();

        System.out.println("Connected to redis");
//
//        redisConnection.setex("banana1", 300, "100");
//        redisConnection.setex("vm1", 300, "100");
//        redisConnection.setex("vm2", 300, "58");
//        redisConnection.setex("vm3", 300, "38");
//
//        List<String> keys = redisConnection.keys("vm*");
//        keys.forEach(k -> {
//            String s = redisConnection.get(k);
//            System.out.println("Value: " + s);
//        });
//
//        redisConnection.del("banana1", "vm1", "vm2", "vm3");

        redisConnection.close();
        redisClient.shutdown();

        System.out.println("Done");
    }
}
