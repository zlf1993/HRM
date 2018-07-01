package fei.provider;

import fei.domain.User;
import org.apache.ibatis.jdbc.SQL;

import static fei.util.HrmConstants.USERTABLE;

import java.util.Map;

public class UserDynaSqlProvider {

    public String selectWithParam(final Map<String,Object> params){
        String sql = new SQL(){
            {
                SELECT("*");
                FROM(USERTABLE);
                if(params.get("user") != null){
                    User user = (User)params.get("user");
                    if(user.getUsername() != null && !user.getUsername().equals("")){
                        WHERE("USERNAME LIKE CONCAT('%',#{user.username},'%')");
                    }
                    if(user.getStatus() != null && !user.getStatus().equals("")){
                        WHERE("STATUS LIKE CONCAT ('%',#{user.status},'%')");
                    }
                }
            }
        }.toString();
        if(params.get("pageModel") != null){
            sql += "limit #{pageModel.firstLimitParam},#{pageModel.pageSize}";
        }
        return sql;
    }

    public String count(final Map<String,Object> params){
        return new SQL(){
            {
                SELECT("count(*)");
                FROM(USERTABLE);
                if(params.get("user")!= null){
                    User user = (User)params.get("user");
                    if(user.getUsername() != null && !user.getUsername().equals("")){
                        WHERE("USERNAME LIKE CONCAT('%',#{user.username},'%')");
                    }
                    if(user.getStatus() != null && !user.getStatus().equals("")){
                        WHERE("STATUS LIKE CONCAT ('%',#{user.status},'%')");
                    }
                }
            }
        }.toString();
    }

    public String insertUser(final User user){
        return new SQL(){
            {
                INSERT_INTO(USERTABLE);
                if(user.getLoginname()!=null && !user.getLoginname().equals("")) {
                    VALUES("LOGINNAME", "#{loginname}");
                }
                if(user.getPassword()!=null && !user.getPassword().equals("")){
                    VALUES("PASSWORD","#{password}");
                }
                if(user.getStatus() !=null && !user.getStatus().equals("")){
                    VALUES("STATUS","#{status}");
                }
                if(user.getCreateDate()!=null && !user.getCreateDate().equals("")){
                    VALUES("CREATEDATE","#{createDate}");
                }

                if(user.getUsername()!=null && !user.getUsername().equals("")){
                    VALUES("USERNAME","#{username}");
                }




            }
        }.toString();
    }

    public String updateUser(final User user){
        return new SQL(){
            {
                UPDATE(USERTABLE);
                if(user.getUsername() != null){
                    SET("USERNAME = #{username}");
                }
                if(user.getLoginname() != null){
                    SET("LOGINNAME = #{loginname}");
                }
                if(user.getPassword()!=null){
                    SET("PASSWORD = #{password}");
                }
                if(user.getStatus()!=null){
                    SET("STATUS = #{status}");
                }
                WHERE("ID = #{id}");
            }
        }.toString();
    }
}
