package dao.provider;
import static util.HrmConstants.DEPTTABLE;

import domain.Dept;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class DeptDynaSqlProvider {
    public String selectWithParam(final Map<String, Object> params){
        String sql = new SQL(){
            {SELECT("*");
                FROM(DEPTTABLE);
                if(params.get("dept") != null){
                    Dept dept = (Dept) params.get("dept");
                    if(dept.getName() != null && !dept.getName().equals("")){
                        WHERE(" NAME LIKE CONCAT ('%',#{dept.name},'%')");
                    }
                }
            }
        }.toString();
        if(params.get("pageModel") != null){
            sql += " limit #{pageModel.firstLimitParam}, #{pageModel.pageSize}";
        }
     return sql;
    }

    public String count(final Map<String, Object> params){
        return new SQL(){
            {
                SELECT("count(*)");
                FROM(DEPTTABLE);
                if (params.get("dept") != null){
                    Dept dept = (Dept) params.get("dept");
                    if(dept.getName() != null && !dept.getName().equals("")){
                        WHERE(" NAME LIKE CONCAT ('%',#{dept.name},'%')");
                    }
                }
            }
        }.toString();
    }

    public String insertDept(final Dept dept){
        return new SQL(){
            {
                INSERT_INTO(DEPTTABLE);
                if(dept.getName() != null && !dept.getName().equals("")){
                    VALUES("NAME","#{name}");
                }
                if(dept.getRemark() != null && !dept.getRemark().equals(""))
                    VALUES("REMARK","#{remark}");
            }
        }.toString();
    }

    public String updateDept(final Dept dept){
        return new SQL(){
            {
                UPDATE(DEPTTABLE);
                if(dept.getName() != null){
                    SET(" NAME = #{name} ");
                }
                if(dept.getRemark() != null){
                    SET(" REMARK = #{remark} ");
                }
                WHERE (" ID = #{id}");
            }
        }.toString();
    }
}
