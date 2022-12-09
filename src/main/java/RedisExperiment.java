import io.lettuce.core.*;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.List;

public class RedisExperiment {

    public static void main(String[] args) {
        System.out.println("Start");
        int port = 6379;
        String host = "10.98.144.67";
        RedisClient redisClient = RedisClient.create(String.format("redis://%s:%d/0", host, port));

        StatefulRedisConnection<String, String> redisConnection = redisClient.connect();
        RedisCommands<String, String> redisCommands = redisConnection.sync();
        System.out.println("Connected to Redis using SSL");

        redisCommands.setex("banana1", 300, "100");
        redisCommands.setex("vm1", 300, "100");
        redisCommands.setex("vm2", 300, "58");
        redisCommands.setex("vm3", 300, "38");

        List<String> keys = redisCommands.keys("vm*");
        keys.forEach(k -> {
            String s = redisCommands.get(k);
            System.out.println("Value: " + s);
        });

        redisCommands.del("banana1", "vm1", "vm2", "vm3");

        redisConnection.close();
        redisClient.shutdown();

        System.out.println("Done");
    }
}
