package self.search.base.simple;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 倒排索引
 */
@Data
@AllArgsConstructor
public class Posting {

    /*文档ID*/
    private int docId;

    /*词在该文档中出现的次数*/
    private int freq;
}
