package top.itbneo.redisPlus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisPlusApplication.class )
public class RedisValuesTest {

    @Autowired
    private RedisTemplate redisTemplate;

//    @Test
//    public void test(){
//        //1.从redis获取数据，数据格式一般为json
//        String strJson = (String) redisTemplate.boundValueOps(UserTest.EX_VALUES).get();
//        if (StringUtils.isEmpty(strJson)){
//            //数据库查询数据
//            System.out.println("没有数据");
//            strJson = "11111";
//            redisTemplate.boundValueOps(UserTest.EX_VALUES).set("111111");
//        }
//        System.out.println(strJson);
//    }

    @Test
    public void setValue(){
        redisTemplate.boundValueOps("name").set("top.itbneo");
    }
    @Test
    public void getValue(){
        String name = (String) redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }
    @Test
    public void deleteValue(){
        redisTemplate.delete("name");
    }
}
