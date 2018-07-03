

import fei.mapper.UserDao;
import fei.domain.Page;
import fei.domain.User;

import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
* UserDynaSqlProvider Tester. 
* 
* @author <Authors name> 
* @since <pre>Jun 30, 2018</pre> 
* @version 1.0 
*/

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath*:spring-mybatis.xml"})
public class UserDynaSqlProviderTest {
    Map<String, Object> userMap = null;
    private User user = null;

    private Page page = null;
    @Autowired
    public UserDao userDao;


    @Before
    public void before() throws Exception {

        userMap = new HashMap<String, Object>();


        user = new User();
        user.setUsername("Longfei");
        user.setLoginname("zlf1993");
        user.setPassword("z123456");
        user.setStatus(1);
        Date date = new Date();
        user.setCreateDate(date);


        page = new Page();
        page.setFirstLimitParam(0);
        page.setPageSize(20);


        userMap.put("user",user);
        userMap.put("pagemodel",page);

    }

    @After
    public void after() throws Exception {
        user = null;
        page = null;
        userMap = null;
        userDao = null;
    }
    @Test
    public void testSelectByLoginnameAndPassword() throws Exception {
        userDao.selectByLoginnameAndPassword("admin","123456");
    }

    @Test
    public void testSelectById() throws Exception {
        Integer i = 1;
        userDao.selectById(i);
    }
    /**
    *
    * Method: selectWithParam(final Map<String,Object> params)
    *
    */
    @Test
    public void testSelectWithParam() throws Exception {
        List<User> users;
        users = userDao.selectByPage(userMap);
        System.out.println(users.get(0).getUsername());
    }

    /**
    *
    * Method: count(final Map<String,Object> params)
    *
    */
    @Test
    public void testCount() throws Exception {
        int count = userDao.count(userMap);
        System.out.println(count);
    }

    /**
    *
    * Method: save(final User user)
    *
    */
    @Test
    public void testSave() throws Exception {
        userDao.save(user);
        System.out.println("ok2");
    }

    /**
    *
    * Method: updateUser(final User user)
    *
    */
    @Test
    public void testUpdateUser() throws Exception {
        user.setId(3);
        user.setPassword("111111");
        userDao.update(user);
    }

    @Test
    public void testDeleteUser() throws Exception {
        userDao.deleteById(3);
    }


} 
