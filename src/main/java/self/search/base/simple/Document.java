package self.search.base.simple;

import lombok.Data;

import java.util.List;

/**
 * 文档
 */
@Data
public class Document {

    /*列集合*/
    private List<Field> fieldList;

    @Data
    public class Field {
        /*列名： 标题、内容等*/
        private String name;

        /*列值*/
        private String data;
    }
}
