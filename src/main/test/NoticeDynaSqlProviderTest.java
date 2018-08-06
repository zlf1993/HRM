

import fei.domain.Document;
import fei.domain.Notice;
import fei.domain.Page;
import fei.domain.User;
import fei.mapper.DocumentDao;
import fei.mapper.NoticeDao;
import fei.mapper.UserDao;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/** 
* NoticeDynaSqlProvider Tester. 
* 
* @author <Authors name> 
* @since <pre>Jul 3, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath*:spring-mybatis.xml"})
public class NoticeDynaSqlProviderTest {
    public User user = null;
    public Notice notice = null;
    public Page page = null;
    Map<String, Object> map = null;
    @Autowired
    NoticeDao noticeDao;
    @Autowired
    UserDao userDao;

    @Before
    public void before() throws Exception {
        user = userDao.selectById(1);
        notice = new Notice();
        notice.setContent("this is a notification");
        notice.setTitle("New Notice");
        notice.setUser(user);
        notice.setId(1);

        map = new HashMap<String,Object>();
        map.put("notice",notice);
        page = new Page();
        page.setFirstLimitParam(0);
        page.setPageSize(10);
        map.put("pageModel",page);
    }

    @After
    public void after() throws Exception {
        user = null;
        page = null;
        notice = null;
    }
    @Test
    public void testSelectByID() throws Exception {
        noticeDao.selectById(1);
    }
    @Test
    public void testDeleteByID() throws Exception {
        noticeDao.deleteById(1);
    }
    /**
    *
    * Method: selectWithParam(final Map<String, Object> params)
    *
    */
    @Test
    public void testSelectWithParam() throws Exception {
        noticeDao.selectByPage(map);
    }

    /**
    *
    * Method: count(final Map<String, Object> params)
    *
    */
    @Test
    public void testCount() throws Exception {
        noticeDao.count(map);
    }

    /**
    *
    * Method: insertNotice(final Notice notice)
    *
    */
    @Test
    public void testInsertNotice() throws Exception {
        noticeDao.save(notice);
    }

    /**
    *
    * Method: updateNotice(final Notice notice)
    *
    */
    @Test
    public void testUpdateNotice() throws Exception {
        notice.setTitle("second notice");
        noticeDao.update(notice);
    }


} 
