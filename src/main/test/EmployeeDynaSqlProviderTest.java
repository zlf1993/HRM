

import fei.domain.Dept;
import fei.domain.Employee;
import fei.domain.Job;
import fei.domain.Page;
import fei.mapper.EmployeeDao;
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
* EmployeeDynaSqlProvider Tester. 
* 
* @author <Authors name> 
* @since <pre>Jul 3, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath*:spring-mybatis.xml"})
public class EmployeeDynaSqlProviderTest {
    public Employee employee = null;
    public Page page = null;
    public Map<String,Object> map = null;
    @Autowired
    EmployeeDao employeeDao;


@Before
public void before() throws Exception {
    employee = new Employee();
    employee.setSex(1);

    page = new Page();
    page.setFirstLimitParam(0);
    page.setPageSize(10);

    map = new HashMap<String,Object>();
    map.put("employee",employee);
    map.put("pageModel",page);
} 

@After
public void after() throws Exception {
    employee = null;
    page = null;
    employeeDao = null;
    map = null;
} 

/** 
* 
* Method: selectWithParam(final Map<String,Object> params) 
* 
*/ 
@Test
public void testSelectWithParam() throws Exception {
    employeeDao.selectByPage(map);
} 

/** 
* 
* Method: count(final Map<String, Object> params) 
* 
*/ 
@Test
public void testCount() throws Exception {

    employeeDao.count(map);
} 

/** 
* 
* Method: insertEmployee(final Employee employee) 
* 
*/ 
@Test
public void testInsertEmployee() throws Exception {
    Dept dept = new Dept();
    dept.setId(1);
    Job job = new Job();
    job.setId(1);
    employee.setDept(dept);
    employee.setJob(job);
    employee.setName("test");
    employee.setAddress("haha");
    employee.set
} 

/** 
* 
* Method: updateEmployee(final Employee employee) 
* 
*/ 
@Test
public void testUpdateEmployee() throws Exception { 
//TODO: Test goes here... 
} 


} 
