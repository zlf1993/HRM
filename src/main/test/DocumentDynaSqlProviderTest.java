
import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: selectWithParam(final Map<String, Object> params) 
* 
*/ 
@Test
public void testSelectWithParam() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: count(final Map<String, Object> params) 
* 
*/ 
@Test
public void testCount() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: insertDocument(final Document document) 
* 
*/ 
@Test
public void testInsertDocument() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updateDocument(final Document document) 
* 
*/ 
@Test
public void testUpdateDocument() throws Exception { 
//TODO: Test goes here... 
} 


} 
