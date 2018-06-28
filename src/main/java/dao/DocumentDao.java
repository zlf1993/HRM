package dao;

import dao.provider.DocumentDynaSqlProvider;
import domain.Document;
import domain.Notice;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

import static util.HrmConstants.DOCUMENTTABLE;


public interface DocumentDao {
    @Select("select * from "+ DOCUMENTTABLE+" where ID = #{id}")
    Notice selectById(int id);

    @Delete("delete from "+ DOCUMENTTABLE + " where ID = #{id}")
    void deleteById(Integer id);

    @SelectProvider(type = DocumentDynaSqlProvider.class, method = "selectWithParam")
    @Results({
            @Result(id = true, column = "ID", property = "id"),
            @Result(column = "CREATE_DATE",property = "createData",javaType = java.util.Date.class),
            @Result(column = "USER_ID",property = "user",
                    one = @One(select = "main.java.dao.UserDao.selectById",
                            fetchType = FetchType.EAGER))
    })
    List<Document> selectByPage(Map<String,Object> params);

    @SelectProvider(type = DocumentDynaSqlProvider.class, method = "count")
    Integer count(Map<String,Object> params);

    @SelectProvider(type = DocumentDynaSqlProvider.class, method = "insertNotice")
    void save(Document document);

    @SelectProvider(type = DocumentDynaSqlProvider.class, method = "updateNotice")
    void update(Document document);
}
