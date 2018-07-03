package fei.provider;

import fei.domain.Employee;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

import static fei.util.HrmConstants.EMPLOYEETABLE;

public class EmployeeDynaSqlProvider {

    public String selectWithParam(final Map<String,Object> params){
        String sql = new SQL(){
            {
                SELECT("*");
                FROM(EMPLOYEETABLE);
                if(params.get("employee")!=null){
                    Employee employee = (Employee) params.get("employee");
                    if(employee.getDept()!=null && employee.getDept().getId()!=null && employee.getDept().getId()!=0){
                        WHERE("DEPT_ID = #{employee.dept.id}");
                    }
                    if(employee.getName()!=null && !employee.getName().equals("")){
                        WHERE("NAME LIKE CONCAT ('%',#{employee.name},'%')");
                    }
                    if(employee.getJob()!=null && employee.getJob().getId()!=null && employee.getJob().getId()!=0){
                        WHERE("JOB_ID = #{employee.job.id}");
                    }

                    if(employee.getPhone()!=null && !employee.getPhone().equals("")){
                        WHERE("PHONE LIKE CONCAT ('%',#{employee.phone},'%')");
                    }
                    if(employee.getCardId()!=null && !employee.getCardId().equals("")){
                        WHERE("CARD_ID LIKE CONCAT ('%',#{employee.cardId},'%')");
                    }
                    if(employee.getSex()!=null){
                        WHERE("SEX = #{employee.sex}");
                    }
                }
            }
        }.toString();
        if(params.get("pageModel")!= null){
            sql += " limit #{pageModel.firstLimitParam}, #{pageModel.pageSize}";
        }
        return sql;
    }

    public String count(final Map<String, Object> params){
        return  new SQL(){
            {
                SELECT("count(*)");
                FROM(EMPLOYEETABLE);
                if(params.get("employee")!=null){
                    Employee employee = (Employee) params.get("employee");
                    if(employee.getDept()!=null && employee.getDept().getId()!=null && employee.getDept().getId()!=0){
                        WHERE("DEPT_ID = #{employee.dept.id}");
                    }
                    if(employee.getJob()!=null && employee.getJob().getId()!=null && employee.getJob().getId()!=0){
                        WHERE("JOB_ID = #{employee.job.id}");
                    }
                    if(employee.getSex()!=null && employee.getSex()!=0){
                        WHERE("SEX = #{employee.sex}");
                    }
                    if(employee.getName()!=null && !employee.getName().equals("")){
                        WHERE("NAME LIKE CONCAT ('%',#{employee.name},'%')");
                    }
                    if(employee.getPhone()!=null && !employee.getPhone().equals("")){
                        WHERE("PHONE LIKE CONCAT ('%',#{employee.phone},'%')");
                    }
                    if(employee.getCardId()!=null && !employee.getCardId().equals("")){
                        WHERE("CARD_ID LIKE CONCAT ('%',#{employee.cardId},'%')");
                    }

                }
            }
        }.toString();
    }

    public String insertEmployee(final Employee employee){
        return new SQL(){
            {
                INSERT_INTO(EMPLOYEETABLE);
                if(employee.getName() != null){
                    VALUES("NAME", "#{name}");
                }
                if(employee.getCardId() != null){
                    VALUES("CARD_ID","#{cardId}");
                }
                if(employee.getAddress()!=null){
                    VALUES("ADDRESS","#{address}");
                }
                if(employee.getPostCode()!=null){
                    VALUES("POST_CODE","#{postCode}");
                }
                if(employee.getTel()!=null){
                    VALUES("TEL","#{tel}");
                }
                if(employee.getPhone()!= null){
                    VALUES("PHONE","#{phone}");
                }
                if(employee.getEmail()!= null){
                    VALUES("EMAIL","#{email}");
                }
                if(employee.getSex()!=null){
                    VALUES("SEX","#{sex}");
                }
                if (employee.getParty()!=null){
                    VALUES("PARTY","#{party}");
                }
                if(employee.getBirthday()!=null){
                    VALUES("BIRTHDAY","#{birthday}");
                }
                if(employee.getEducation()!=null){
                    VALUES("EDUCATION","#{education}");
                }
                if(employee.getSpeciality()!=null){
                    VALUES("SPECIALITY","#{speciality}");
                }
                if (employee.getHobby()!=null){
                    VALUES("HOBBY","#{hobby}");
                }
                if(employee.getRemark()!=null){
                    VALUES("REMARK","#{remark}");
                }
                if (employee.getCreateDate()!=null){
                    VALUES("CREATE_DATE","#{createDate}");
                }
                if (employee.getDept()!=null){
                    VALUES("DEPT_ID","#{dept.id}");
                }
                if (employee.getJob()!= null){
                    VALUES("JOB_ID","#{job.id}");
                }
            }
        }.toString();
    }

    public String updateEmployee(final Employee employee){
        return new SQL(){
            {
                UPDATE(EMPLOYEETABLE);
                if(employee.getName() != null){
                    SET("NAME", "#{name}");
                }
                if(employee.getCardId() != null){
                    SET("CARD_ID","#{cardId}");
                }
                if(employee.getAddress()!=null){
                    SET("ADDRESS","#{address}");
                }
                if(employee.getPostCode()!=null){
                    SET("POST_CODE","#{postCode}");
                }
                if(employee.getTel()!=null){
                    SET("TEL","#{tel}");
                }
                if(employee.getPhone()!= null){
                    SET("PHONE","#{phone}");
                }
                if(employee.getEmail()!= null){
                    SET("EMAIL","#{email}");
                }
                if(employee.getSex()!=null){
                    SET("SEX","#{sex}");
                }
                if (employee.getParty()!=null){
                    SET("PARTY","#{party}");
                }
                if(employee.getBirthday()!=null){
                    SET("BIRTHDAY","#{birthday}");
                }
                if(employee.getEducation()!=null){
                    SET("EDUCATION","#{education}");
                }
                if(employee.getSpeciality()!=null){
                    SET("SPECIALITY","#{speciality}");
                }
                if (employee.getHobby()!=null){
                    SET("HOBBY","#{hobby}");
                }
                if(employee.getRemark()!=null){
                    SET("REMARK","#{remark}");
                }
                if (employee.getCreateDate()!=null){
                    SET("CREATE_DATE","#{createDate}");
                }
                if (employee.getDept()!=null){
                    SET("DEPT_ID","#{dept.id}");
                }
                if (employee.getJob()!= null){
                    SET("JOB_ID","#{job.id}");
                }
                WHERE("ID = #{id}");
            }
        }.toString();
    }
}
