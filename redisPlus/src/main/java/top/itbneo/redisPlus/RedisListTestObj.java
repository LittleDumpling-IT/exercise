package top.itbneo.redisPlus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisPlusApplication.class)
public class RedisListTestObj {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @Test
    public void setLeftValues(){
        redisTemplate.boundListOps("NAME").leftPush("BNEO");
        redisTemplate.boundListOps("NAME").leftPush("LITTLEDUMPLING");
        redisTemplate.boundListOps("NAME").leftPush("团子");
    }
    @Test
    public void getLeftValues(){
        List<String > list = redisTemplate.boundListOps("NAME").range(0, -1);
        for (String name : list) {
            System.out.println(name);
        }

    }

    @Test
    public void getIndexValues(){
        String name = redisTemplate.boundListOps("NAME").index(0);
        System.out.println(name);
    }

    @Test
    public void setRightValues(){
        redisTemplate.boundListOps("NAME").rightPushAll("BNEO","LITTLEDUMPLING","团子");
    }


    @Test
    public void delete(){
        redisTemplate.delete("NAME");
    }
}
