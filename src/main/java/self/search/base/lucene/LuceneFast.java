package self.search.base.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.ByteBuffersDirectory;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * LuceneFast
 *
 * @author chenzb
 * @date 2020/1/9
 */
public class LuceneFast {

    public void write(String indexDirPath, String field, String text) throws IOException {
        try (Analyzer analyzer = new StandardAnalyzer();
        Directory directory = FSDirectory.open(new File(indexDirPath).toPath());
        IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig(analyzer))) {
            Document document = new Document();
            document.add(new Field(field, text, TextField.TYPE_STORED));
            writer.addDocument(document);
        }
    }

    public void read(String indexDirPath, String field, String queryString) throws IOException, ParseException {
        try (Analyzer analyzer = new StandardAnalyzer();
             Directory directory = FSDirectory.open(new File(indexDirPath).toPath());
             IndexReader reader = DirectoryReader.open(directory)) {
            QueryParser parser = new QueryParser(field, analyzer);
            Query query = parser.parse(queryString);
            IndexSearcher searcher = new IndexSearcher(reader);
            TopDocs docs = searcher.search(query, 10);
            ScoreDoc[] hits = docs.scoreDocs;
            Stream.of(hits).forEach(hit -> {
                try {
                    String doc = searcher.doc(hit.doc).get(field);
                    System.out.println(doc);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
