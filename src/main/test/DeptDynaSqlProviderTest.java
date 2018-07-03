

import fei.domain.Dept;
import fei.domain.Page;
import fei.mapper.DeptDao;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* DeptDynaSqlProvider Tester. 
* 
* @author <Authors name> 
* @since <pre>Jul 2, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath*:spring-mybatis.xml"})
public class DeptDynaSqlProviderTest {
    Map<String, Object> deptMap = null;
    public Dept dept = null;

    public Page page = null;
    @Autowired
    DeptDao deptDao;


    @Before
    public void before() throws Exception {
        deptMap = new HashMap<String, Object>();
        dept = new Dept();
        dept.setId(1);
        dept.setName("Technolog_Department");

        page = new Page();
        page.setFirstLimitParam(0);
        page.setPageSize(3);


        deptMap.put("dept",dept);
        deptMap.put("pageModel",page);
    }

    @After
    public void after() throws Exception {
        dept = null;
        page = null;
        deptDao = null;
        deptMap = null;
    }

    /**
    *
    * Method: selectWithParam(final Map<String, Object> params)
    *
    */
    @Test
    public void testSelectWithParam() throws Exception {
        dept.setName("Department");
        deptDao.selectByPage(deptMap);
    }

    /**
    *
    * Method: count(final Map<String, Object> params)
    *
    */
    @Test
    public void testCount() throws Exception {
        dept.setName("Department");
        System.out.println(deptDao.count(deptMap));
    }


    @Test
    public void testSelectAllDept() throws Exception {
        deptDao.selectAllDept();
    }

    @Test
    public  void testSelectById() throws  Exception{
        deptDao.selectById(1);
    }

    @Test
    public  void testDelete() throws Exception{
        deptDao.deleteById(7);
    }
    /**
    *
    * Method: insertDept(final Dept dept)
    *
    */
    @Test
    public void testInsertDept() throws Exception {
        dept.setName("Test_Department");
        deptDao.save(dept);
    }

    /**
    *
    * Method: updateDept(final Dept dept)
    *
    */
    @Test
    public void testUpdateDept() throws Exception {
        dept.setRemark("this is remark.");
        deptDao.update(dept);
    }


} 
