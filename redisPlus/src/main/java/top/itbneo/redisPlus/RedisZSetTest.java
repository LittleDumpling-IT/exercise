package top.itbneo.redisPlus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisPlusApplication.class)
public class RedisZSetTest {

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void setZsetValue(){
        redisTemplate.boundZSetOps("NAME").add("BNEO",100);
        redisTemplate.boundZSetOps("NAME").add("LittleDumpling",100);
        redisTemplate.boundZSetOps("NAME").add("小团子",100);
        redisTemplate.boundZSetOps("NAME").add("团子",100);
        redisTemplate.boundZSetOps("NAME").expire(10, TimeUnit.SECONDS);
    }


    @Test
    public void addZsetValue(){
        redisTemplate.boundZSetOps("NAME").incrementScore("BNEO",200);
    }

    @Test
    public void getZsetValue(){
        Set name = redisTemplate.boundZSetOps("NAME").range(0, -1);
//        System.out.println(name.size());
//        System.out.println(name);
        Iterator iterator = name.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void getAllValues(){
        //Set<ZSetOperations.TypedTuple> name = redisTemplate.boundZSetOps("NAME").reverseRangeWithScores(0, -1);
        Set<ZSetOperations.TypedTuple> name = redisTemplate.boundZSetOps("NAME").rangeWithScores(0, -1);
        for (ZSetOperations.TypedTuple typedTuple : name) {
            System.out.println(
                    "姓名："+typedTuple.getValue()+"    分数："+typedTuple.getScore());

        }
    }
    @Test
    public void delete(){
        redisTemplate.delete("NAME");
    }
}
