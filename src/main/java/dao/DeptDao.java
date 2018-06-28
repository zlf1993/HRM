package dao;
import domain.Dept;
import dao.provider.DeptDynaSqlProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import sun.rmi.log.LogInputStream;

import java.util.List;
import java.util.Map;


public interface DeptDao {
    @SelectProvider(type = DeptDynaSqlProvider.class, method = "selectWithParam")
    List<Dept> selectByPage(Map<String,Object> params);
    @SelectProvider(type = DeptDynaSqlProvider.class, method = "count")
    Integer count(Map<String,Object> params);
    @Select("select * from"+ DEPTTABLE +"")
    List<Dept> selectAllDept();
    @Select("select * from "+ DEPTTABLE+" where ID = #{id}")
    Dept selectById(int id);

}