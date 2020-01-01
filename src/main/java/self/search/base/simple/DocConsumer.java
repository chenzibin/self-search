package self.search.base.simple;

import lombok.Data;

import java.util.Map;

/**
 * 正排索引，文档索引
 */
@Data
public class DocConsumer {

    /*文档ID*/
    private int docId;

    /*词到频率的映射*/
    private Map<String, int[]> frequencyList;

    /*文档长度，包含的词数*/
    private int words;

}
