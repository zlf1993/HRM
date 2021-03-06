package fei.mapper;

import fei.domain.Document;
import fei.domain.Notice;
import fei.provider.DocumentDynaSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

import static fei.util.HrmConstants.DOCUMENTTABLE;


public interface DocumentDao {
    @Select("select * from "+ DOCUMENTTABLE+" where ID = #{id}")
    Notice selectById(int id);

    @Delete("delete from "+ DOCUMENTTABLE + " where ID = #{id}")
    void deleteById(Integer id);

    @SelectProvider(type = DocumentDynaSqlProvider.class, method = "selectWithParam")
    @Results({
            @Result(id = true, column = "ID", property = "id"),
            @Result(column = "CREATE_DATE",property = "createDate",javaType = java.util.Date.class),
            @Result(column = "USER_ID",property = "user",
                    one = @One(select = "fei.mapper.UserDao.selectById",
                            fetchType = FetchType.EAGER))
    })
    List<Document> selectByPage(Map<String,Object> params);

    @SelectProvider(type = DocumentDynaSqlProvider.class, method = "count")
    Integer count(Map<String,Object> params);

    @SelectProvider(type = DocumentDynaSqlProvider.class, method = "insertDocument")
    void save(Document document);

    @SelectProvider(type = DocumentDynaSqlProvider.class, method = "updateDocument")
    void update(Document document);
}
