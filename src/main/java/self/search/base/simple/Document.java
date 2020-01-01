package self.search.base.simple;

import lombok.Data;

/**
 * 文档
 */
@Data
public class Document {

    /*标题*/
    private String title;
    /*内容*/
    private String content;

    @Data
    public class Field {

        private String name;

        private String data;
    }
}
