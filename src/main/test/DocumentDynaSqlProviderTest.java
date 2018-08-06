
import fei.domain.Document;
import fei.domain.Page;
import fei.domain.User;
import fei.mapper.DocumentDao;
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
* DocumentDynaSqlProvider Tester. 
* 
* @author <Authors name> 
* @since <pre>Jul 3, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath*:spring-mybatis.xml"})
public class DocumentDynaSqlProviderTest {
    public User user = null;
    public Document document = null;
    public Page page = null;
    Map<String, Object> map = null;
    @Autowired
    DocumentDao documentDao;
    @Autowired
    UserDao userDao;

    @Before
    public void before() throws Exception {
        user = userDao.selectById(1);
        document = new Document();
        document.setTitle("first Document");
        document.setFilename("/a/b/c.text");
        document.setUser(user);
        document.setId(1);

        map = new HashMap<String,Object>();
        map.put("document",document);
        page = new Page();
        page.setFirstLimitParam(0);
        page.setPageSize(10);
        map.put("pageModel",page);


    }

    @After
    public void after() throws Exception {
        user = null;
        document = null;
        page = null;
        map = null;
    }
    @Test
    public void testDeleteById() throws Exception {
        documentDao.deleteById(1);
    }


    @Test
    public void testSelectById() throws Exception {
        documentDao.selectById(1);
    }

    /**
    *
    * Method: selectWithParam(final Map<String, Object> params)
    *
    */
    @Test
    public void testSelectWithParam() throws Exception {
        documentDao.selectByPage(map);
    }

    /**
    *
    * Method: count(final Map<String, Object> params)
    *
    */
    @Test
    public void testCount() throws Exception {
        documentDao.count(map);
    }

    /**
    *
    * Method: insertDocument(final Document document)
    *
    */
    @Test
    public void testInsertDocument() throws Exception {
        documentDao.save(document);
    }

    /**
    *
    * Method: updateDocument(final Document document)
    *
    */
    @Test
    public void testUpdateDocument() throws Exception {
        document.setFilename("/a/a/a/txt");
        documentDao.update(document);
    }


} 
