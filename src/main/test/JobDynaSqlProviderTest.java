package test.fei.provider; 

import fei.domain.Job;
import fei.domain.Page;
import fei.mapper.JobDao;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/** 
* JobDynaSqlProvider Tester. 
* 
* @author <Authors name> 
* @since <pre>Jul 2, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath*:spring-mybatis.xml"})
public class JobDynaSqlProviderTest {
    Map<String, Object> jobMap = null;
    Page page=null;
    Job job = null;
    @Autowired
    JobDao jobDao = null;

    @Before
    public void before() throws Exception {
        job = new Job();
        job.setName("Senior_Java_Development_Engineer");
        job.setId(4);

        page = new Page();
        page.setPageSize(6);
        page.setFirstLimitParam(0);

        jobMap = new HashMap<String,Object>();
        jobMap.put("job",job);
        jobMap.put("pageModel",page);
    }

    @After
    public void after() throws Exception {
        jobMap = null;
        page=null;
        job = null;
        jobDao = null;
    }

    @Test
    public void testSelectById()throws Exception{
        jobDao.selectById(4);
    }

    @Test
    public void testSelectAllDept()throws Exception{
        jobDao.selectAllDept();
    }
    /**
    *
    * Method: selectWithParam(final Map<String, Object> params)
    *
    */
    @Test
    public void testSelectWithParam() throws Exception {
        jobDao.selectByPage(jobMap);
    }

    /**
    *
    * Method: count(final Map<String, Object> params)
    *
    */
    @Test
    public void testCount() throws Exception {
        jobDao.count(jobMap);
    }

    /**
    *
    * Method: insertJob(final Job job)
    *
    */

    @Test
    public void testDeleteJob()throws Exception{
        job.setId(10);
        jobDao.deleteById(10);
    }
    @Test
    public void testInsertJob() throws Exception {
        job.setName("Tester");
        jobDao.save(job);
    }

    /**
    *
    * Method: updateJob(final Job job)
    *
    */
    @Test
    public void testUpdateJob() throws Exception {
        job.setId(10);
        job.setName("Tester-2");
        jobDao.update(job);
    }


} 
