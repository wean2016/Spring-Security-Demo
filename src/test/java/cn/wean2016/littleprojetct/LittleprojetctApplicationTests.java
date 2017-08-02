package cn.wean2016.littleprojetct;

import cn.wean2016.littleprojetct.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LittleprojetctApplicationTests {

	@Test
	public void contextLoads() {
	}



	@Autowired
    private UserDao userDao;

	@Test
    public void testMyBatis(){

	    Object object = userDao.findByUserName("admin");
        System.out.println(1);

    }

}
