package fei.mapper;

import fei.provider.EmployeeDynaSqlProvider;
import fei.domain.Employee;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import static fei.util.HrmConstants.EMPLOYEETABLE;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {
    @SelectProvider(type = EmployeeDynaSqlProvider.class, method = "count")
    Integer count(Map<String,Object> params);

    @SelectProvider(type = EmployeeDynaSqlProvider.class, method = "selectWithParam")
    @Results({
            @Result(id =true,column="ID",property = "id"),
            @Result(column = "CARD_ID",property = "cardId"),
            @Result(column = "POST_CODE",property = "postCode"),
            @Result(column = "BIRTHDAY",property = "birthday"),
            @Result(column = "CREATE_DATE",property = "createDate",javaType = java.util.Date.class),
            @Result(column = "DEPT_ID",property = "dept",one = @One(select = "fei.mapper.DeptDao.selectById",fetchType = FetchType.EAGER)),
            @Result(column = "JOB_ID",property = "job",one = @One(select = "fei.mapper.JobDao.selectById",fetchType = FetchType.EAGER))

    })
    List<Employee> selectByPage(Map<String, Object> params);

    @SelectProvider(type = EmployeeDynaSqlProvider.class, method = "insertEmployee")
    void save(Employee employee);

    @Delete("delect from "+EMPLOYEETABLE+"where ID = #{id}")
    void deletById(Integer id);

    @Select("select * from "+EMPLOYEETABLE+"where ID = #{id}")
    @Results({
            @Result(id =true,column="ID",property = "id"),
            @Result(column = "CARD_ID",property = "cardId"),
            @Result(column = "POST_CODE",property = "postcode"),
            @Result(column = "BIRTHDAY",property = "birthday"),
            @Result(column = "CREATE_DATE",property = "createDate",javaType = java.util.Date.class),
            @Result(column = "DEPT_ID",property = "dept",one = @One(select = "fei.mapper.DeptDao.selectById",fetchType = FetchType.EAGER)),
            @Result(column = "JOB_ID",property = "job",one = @One(select = "fei.mapper.JobDao.selectById",fetchType = FetchType.EAGER))
    })
    Employee selectById(Integer id);

    @SelectProvider(type = EmployeeDynaSqlProvider.class, method = "updateEmployee")
    void update(Employee employee);
}
