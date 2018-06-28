package dao;

import dao.provider.NoticeDynaSqlProvider;
import domain.Notice;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

import static util.HrmConstants.NOTICETABLE;

public interface NoticeDao {
    @Select("select * from "+ NOTICETABLE+" where ID = #{id}")
    Notice selectById(int id);

    @Delete("delete from "+ NOTICETABLE + " where ID = #{id}")
    void deleteById(Integer id);

    @SelectProvider(type = NoticeDynaSqlProvider.class, method = "selectWithParam")
    @Results({
            @Result(id = true, column = "ID", property = "id"),
            @Result(column = "CREATE_DATE",property = "createData",javaType = java.util.Date.class),
            @Result(column = "USER_ID",property = "user",
                    one = @One(select = "org.fkit.hrm.dao.UserDao.selectById",
            fetchType = FetchType.EAGER))
    })
    List<Notice> selectByPage(Map<String,Object> params);

    @SelectProvider(type = NoticeDynaSqlProvider.class, method = "count")
    Integer count(Map<String,Object> params);

    @SelectProvider(type = NoticeDynaSqlProvider.class, method = "insertNotice")
    void save(Notice notice);

    @SelectProvider(type = NoticeDynaSqlProvider.class, method = "updateNotice")
    void update(Notice notice);
}
