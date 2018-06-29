package dao.provider;
import static util.HrmConstants.NOTICETABLE;

import domain.Notice;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class NoticeDynaSqlProvider {

    public String selectWithParam(final Map<String, Object> params){
        String sql = new SQL(){
            {
                SELECT("*");
                FROM(NOTICETABLE);
                if(params.get("notice") != null){
                    Notice notice = (Notice) params.get("notice");
                    if(notice.getTitle() != null && !notice.getTitle().equals("")){
                        WHERE(" TITLE LIKE CONCAT ('%',#{notice.title},'%')");
                    }
                    if(notice.getContent() != null && !notice.getContent().equals("")){
                        WHERE(" CONTENT LIKE CONCAT ('%',#{notice.content},'%')");
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
                FROM(NOTICETABLE);
                if (params.get("notice") != null){
                    Notice notice = (Notice) params.get("notice");
                    if(notice.getTitle() != null && !notice.getTitle().equals("")){
                        WHERE(" TITLE LIKE CONCAT ('%',#{notice.title},'%')");
                    }
                    if(notice.getContent() != null && !notice.getContent().equals("")){
                        WHERE(" CONTENT LIKE CONCAT ('%',#{notice.content},'%')");
                    }
                }
            }
        }.toString();
    }

    public String insertJob(final Notice notice){
        return new SQL(){
            {
                INSERT_INTO(NOTICETABLE);
                if(notice.getTitle() != null && !notice.getTitle().equals("")){
                    VALUES("TITLE","#{title}");
                }
                if(notice.getContent() != null && !notice.getContent().equals(""))
                    VALUES("CONTENT","#{content}");
                if(notice.getUser() != null && notice.getUser().getId() != null){
                    VALUES("USER_ID","#{user.id}");
                }
            }
        }.toString();
    }

    public String updateDept(final Notice notice){
        return new SQL(){
            {
                UPDATE(NOTICETABLE);
                if(notice.getTitle() != null && !notice.getTitle().equals("")){
                    SET(" TITLE = #{title} ");
                }
                if(notice.getContent() != null && !notice.getContent().equals("")){
                    SET(" CONTENT = #{content} ");
                }
                if(notice.getUser() != null && notice.getUser().getId() != null){
                    SET(" USER_ID = #{user.id}");
                }
                WHERE (" ID = #{id}");
            }
        }.toString();
    }
}
