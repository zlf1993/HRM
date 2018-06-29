package dao;

import dao.provider.JobDynaSqlProvider;
import domain.Job;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

import static util.HrmConstants.JOBTABLE;

public interface JobDao {
    @Select("select * from "+ JOBTABLE+" where ID = #{id}")
    Job selectById(int id);

    @Select("select * from"+ JOBTABLE +"")
    List<Job> selectAllDept();

    @SelectProvider(type = JobDynaSqlProvider.class, method = "selectWithParam")
    List<Job> selectByPage(Map<String,Object> params);

    @SelectProvider(type = JobDynaSqlProvider.class, method = "count")
    Integer count(Map<String,Object> params);

    @Delete("delete from "+ JOBTABLE + " where ID = #{id}")
    void deleteById(Integer id);

    @SelectProvider(type = JobDynaSqlProvider.class, method = "insertJob")
    void save(Job job);

    @SelectProvider(type = JobDynaSqlProvider.class, method = "updateJob")
    void update(Job job);
}
