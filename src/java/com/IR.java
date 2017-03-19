package com;
/*@Program - InformationRetrieval 
 * @author - ADITYA BISHT
 * @author- KARAN KOTHARI 
 * @AUTHOR- MAITRI TOILA 
 * */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Hit;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;

public class IR {

    public ArrayList<String> return_hits = new ArrayList<String>();
    public ArrayList<String> name = new ArrayList<String>();

    public final String FILES_TO_INDEX_DIRECTORY = "/Users/karankothari1/GlassFish_Server/glassfish/domains/Resumepedia/FTI";
    public final String INDEX_DIRECTORY = "/Users/karankothari1/GlassFish_Server/glassfish/domains/Resumepedia/IT";

    public final String FIELD_PATH = "path";
    public final String FIELD_CONTENTS = "contents";
    private final String NULL = null;

    public static void main(String[] args) throws Exception {

        IR i = new IR();
        i.run();
      

    }

    public void run() throws Exception {
        createIndex();

        Directory directory = FSDirectory.getDirectory(INDEX_DIRECTORY);
        IndexSearcher indexSearcher = new IndexSearcher(directory);

        Query query1 = new TermQuery(new Term(FIELD_CONTENTS, ""));

        System.out.println("Enter the query of any of the following types : ");
        System.out.println("");
        System.out.println("1. WILDCARD QUERY FOR MULTIPLE CHARACTERS MISSING - 'so*ware' ");
        System.out.println("2. WILDCARD QUERY FOR SINGLE CHARACTER MISSING - 'mana?ement' ");
        System.out.println("3. BOOLEAN QUERY WITH OR - '(COMPUTERS  ) OR (MANAGEMENT )' ");
        System.out.println("4. BOOLEAN QUERY WITH AND - '(education ) AND (information)'");
        System.out.println("5. COMBINATION OF BOOLENA AND WILDCARD QUERY '(comp*rs OR information) AND (info?mation)'");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String f1;
        f1 = br.readLine();
        searchIndexWithQueryParser(f1);

    }

    public void createIndex() throws CorruptIndexException, LockObtainFailedException, IOException {
        Analyzer analyzer = new StandardAnalyzer();
        System.out.println(analyzer);
        boolean recreateIndexIfExists = true;
        IndexWriter indexWriter = new IndexWriter(INDEX_DIRECTORY, analyzer, recreateIndexIfExists);
        File dir = new File(FILES_TO_INDEX_DIRECTORY);
        File[] files = dir.listFiles();
        for (File file : files) {
            Document document = new Document();

            String path = file.getCanonicalPath();
            document.add(new Field(FIELD_PATH, path, Field.Store.YES, Field.Index.UN_TOKENIZED));

            Reader reader = new FileReader(file);
            document.add(new Field(FIELD_CONTENTS, reader));

            indexWriter.addDocument(document);
        }
        indexWriter.optimize();
        indexWriter.close();
    }

    public void searchIndexWithQueryParser(String searchString) throws IOException, ParseException {
        System.out.println("Searching for '" + searchString + "' using QueryParser");
        Directory directory = FSDirectory.getDirectory(INDEX_DIRECTORY);
        IndexSearcher indexSearcher = new IndexSearcher(directory);

        QueryParser queryParser = new QueryParser(FIELD_CONTENTS, new StandardAnalyzer());
        Query query = queryParser.parse(searchString);
        System.out.println("Type of query: " + query.getClass().getSimpleName());
        displayQuery(query);
        Hits hits = indexSearcher.search(query);
        displayHits(hits);
    }

    @SuppressWarnings("unchecked")
    public void displayHits(Hits hits) throws CorruptIndexException, IOException {
        System.out.println("Number of hits: " + hits.length());

        Iterator<Hit> it = hits.iterator();
        while (it.hasNext()) {
            Hit hit = it.next();
            Document document = hit.getDocument();

            String path = document.get(FIELD_PATH);
            String paths = path.substring(67, path.length());
            return_hits.add(paths);
            String linksReturnedToUser = path.substring(72, path.length() - 4);
           // String content = linksReturnedToUser.
            name.add(linksReturnedToUser);
               //System.out.println(name);
            System.out.println("TI-IDF Score:" + hit.getScore() + "  Hit: " + path);
        }
        System.out.println();

    }

    public void displayQuery(Query query) {
        //System.out.println("Query: " + query.toString());
    }
}
