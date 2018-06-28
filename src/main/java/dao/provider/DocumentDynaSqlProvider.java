package dao.provider;

import domain.Document;
import org.apache.ibatis.jdbc.SQL;

import javax.print.Doc;
import java.util.Map;
import static util.HrmConstants.DOCUMENTTABLE;

public class DocumentDynaSqlProvider {
    public String selectWithParam(final Map<String, Object> params){
        String sql = new SQL(){
            {
                SELECT("*");
                FROM(DOCUMENTTABLE);
                if(params.get("document") != null){
                    Document document = (Document) params.get("document");
                    if(document.getTitle() != null && !document.getTitle().equals("")){
                        WHERE(" TITLE LIKE CONCAT ('%',#{document.title},'%')");
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
                FROM(DOCUMENTTABLE);
                if (params.get("document") != null){
                    Document document = (Document) params.get("document");
                    if(document.getTitle() != null && !document.getTitle().equals("")){
                        WHERE(" TITLE LIKE CONCAT ('%',#{document.title},'%')");
                    }

                }
            }
        }.toString();
    }

    public String insertJob(final Document document){
        return new SQL(){
            {
                INSERT_INTO(DOCUMENTTABLE);
                if(document.getTitle() != null && !document.getTitle().equals("")){
                    VALUES("TITLE","#{title}");
                }
                if(document.getFilename() != null && !document.getFilename().equals(""))
                    VALUES("FILENAME","#{fileName}");

                if(document.getRemark() != null && !document.getRemark().equals(""))
                    VALUES("REMARK","#{remark}");

                if(document.getUser() != null && document.getUser().getId() != null){
                    VALUES("USER_ID","#{user.id}");
                }
            }
        }.toString();
    }

    public String updateDept(final Document document){
        return new SQL(){
            {
                UPDATE(DOCUMENTTABLE);
                if(document.getTitle() != null && !document.getTitle().equals("")){
                    SET(" TITLE = #{title} ");
                }
                if(document.getFilename() != null && !document.getFilename().equals(""))
                    SET("FILENAME","#{fileName}");

                if(document.getRemark() != null && !document.getRemark().equals(""))
                    SET("REMARK","#{remark}");

                if(document.getUser() != null && document.getUser().getId() != null){
                    SET("USER_ID","#{user.id}");
                }
                WHERE (" ID = #{id}");
            }
        }.toString();
    }
}
