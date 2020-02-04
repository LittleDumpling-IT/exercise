package top.itbneo.redisPlus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisPlusApplication.class)
public class RedisOpsTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void opsHashValues(){
        redisTemplate.opsForHash().put("NAME","A","BNEO");
        Object o = redisTemplate.opsForHash().get("NAME", "A");
        Set name = redisTemplate.opsForHash().keys("NAME");
        for (Object o1 : name) {
            System.out.println(o1);
        }
        System.out.println(o);
    }
}
