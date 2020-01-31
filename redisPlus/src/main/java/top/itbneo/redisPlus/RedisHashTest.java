package top.itbneo.redisPlus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisPlusApplication.class)
public class RedisHashTest {

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void setHashValues(){
        redisTemplate.boundHashOps("NAME").put("A","BNEO");
        redisTemplate.boundHashOps("NAME").put("B","LittleDumpling");
        redisTemplate.boundHashOps("NAME").put("C","团子");
        redisTemplate.boundHashOps("NAME").put("D","小团子");
    }
    @Test
    public void getHashValue1(){
        String stra = (String) redisTemplate.boundHashOps("NAME").get("A");
        System.out.println(stra);
    }
    @Test
    public void getHashValueKey(){
        Set name = redisTemplate.boundHashOps("NAME").keys();
        Iterator iterator = name.iterator();
        while (iterator.hasNext()){
            Object va = redisTemplate.boundHashOps("NAME").get(iterator.next());
            System.out.println(va);
        }

    }
    @Test
    public void getHashValues(){
        List name = redisTemplate.boundHashOps("NAME").values();
        System.out.println(name);
    }
    @Test
    public void delete(){
        //redisTemplate.boundHashOps("NAME").delete("A");
        redisTemplate.delete("NAME");
    }


}
