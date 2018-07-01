package fei.mapper;


import fei.domain.User;
import fei.provider.UserDynaSqlProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

import static fei.util.HrmConstants.USERTABLE;

public interface UserDao {
    @Select("select * from "+USERTABLE+"where LOGINNAME = #{loginname) and PASSWORD = #{password}")
    User selectByLoginnameAndPassword(
            @Param("loginname") String loginname,
            @Param("password") String password
    );

    @Select("select * from "+USERTABLE + "where ID = #{id}")
    User selectById(Integer id);

    @Delete("delete from "+USERTABLE+"where ID = #{id)}")
    void deleteById(Integer id);

    @SelectProvider(type = UserDynaSqlProvider.class, method = "updateUser")
    void update(User user);

    @SelectProvider(type = UserDynaSqlProvider.class, method = "selectWithParam")
    List<User> selectByPage(Map<String,Object> params);

    @SelectProvider(type = UserDynaSqlProvider.class,method = "count")
    Integer count(Map<String,Object> params);

    @SelectProvider(type=UserDynaSqlProvider.class, method = "insertUser")
    void save(User user);
}
