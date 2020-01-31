package top.itbneo.redisPlus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisPlusApplication.class)
public class RedisSetTest {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void setSet(){
        redisTemplate.boundSetOps("name").add("BNEO");
        redisTemplate.boundSetOps("name").add("LITTLEDUMPLING");
        redisTemplate.boundSetOps("name").add("团子");
    }
    @Test
    public void getSet(){
        Set<String> name = redisTemplate.boundSetOps("name").members();
        System.out.println(name);
        Iterator<String> iterator = name.iterator();
         while (iterator.hasNext()){
             System.out.println(iterator.next());
         }
    }

    @Test
    public void deleteSet(){
        redisTemplate.boundSetOps("name").remove("BNEO");
        redisTemplate.delete("name");
    }
}
