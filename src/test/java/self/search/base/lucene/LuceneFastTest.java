package self.search.base.lucene;

import org.apache.lucene.queryparser.classic.ParseException;
import org.junit.Test;

import java.io.IOException;

/**
 * LuceneFastTest
 *
 * @author chenzb
 * @date 2020/1/9
 */
public class LuceneFastTest {

    LuceneFast luceneFast = new LuceneFast();

    String dir = "d:/search";
    String field = "title";

    @Test
    public void testWriter() throws IOException {
        String text = "this is text to be index";
        luceneFast.write(dir, field, text);
    }

    @Test
    public void testReader() throws IOException, ParseException {
        String queryString = "index";
        luceneFast.read(dir, field, queryString);
    }
}
