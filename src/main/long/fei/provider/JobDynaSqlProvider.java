package fei.provider;

import fei.domain.Job;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

import static fei.util.HrmConstants.JOBTABLE;

public class JobDynaSqlProvider {
    public String selectWithParam(final Map<String, Object> params){
        String sql = new SQL(){
            {
                SELECT("*");
                FROM(JOBTABLE);
                if(params.get("job") != null){
                    Job job = (Job) params.get("job");
                    if(job.getName() != null && !job.getName().equals("")){
                        WHERE(" NAME LIKE CONCAT ('%',#{job.name},'%')");
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
                FROM(JOBTABLE);
                if (params.get("job") != null){
                    Job job = (Job) params.get("job");
                    if(job.getName() != null && !job.getName().equals("")){
                        WHERE(" NAME LIKE CONCAT ('%',#{job.name},'%')");
                    }
                }
            }
        }.toString();
    }

    public String insertJob(final Job job){
        return new SQL(){
            {
                INSERT_INTO(JOBTABLE);
                if(job.getName() != null && !job.getName().equals("")){
                    VALUES("NAME","#{name}");
                }
                if(job.getRemark() != null && !job.getRemark().equals(""))
                    VALUES("REMARK","#{remark}");
            }
        }.toString();
    }

    public String updateJob(final Job job){
        return new SQL(){
            {
                UPDATE(JOBTABLE);
                if(job.getName() != null){
                    SET(" NAME = #{name} ");
                }
                if(job.getRemark() != null){
                    SET(" REMARK = #{remark} ");
                }
                WHERE (" ID = #{id}");
            }
        }.toString();
    }
}
