package classify;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.StringReader;
import java.nio.file.Paths;

public class LuceneDemo {
            String s="被告人:对? 关于王立军,有几个基本事实.首先,1月28日我是初次听到此事.并不相信谷开来会杀人.我跟11·15杀人案无关.我不是谷开来11·15杀人罪的共犯.这个大家都认可.实际上谷开来3月14日她在北京被抓走!" +
            "在这之前她一直非常确切地跟我说她没杀人,是王立军诬陷她.我在1月28日和次听到这个事时我不相信她会杀人." +
            "第二个事实,免王立军的局长.是多个因素.一个,我确实认为他诬陷谷开来.但我并不是想掩盖11·15,我是觉得他人品不好." +
            "因为谷开来和他是如胶似漆,谷开来对他是言听计从,那王立军也通过与谷开来的交往中打入了我的家庭." +
            "那现在发生这么严重的事.作为一个起码的人,要讲人格的话,你干吗不找谷开来商量,而跑我这里来说这些话?" +
            "第二个免他的原因,是他想要挟我.他多次谈他身体不好,打黑压力大,得罪了人." +
            "其实这是在表功.第三,徐某某给我反映了他有五六条问题.有记录.实际上免他是有这些原因的,绝不只是一个谷开来的原因.这是多因一果.";

    public static void search(String indexDir,String q)throws Exception{
        Directory dir = FSDirectory.open(Paths.get(indexDir));
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher is = new IndexSearcher(reader);
        // Analyzer analyzer = new StandardAnalyzer(); // 标准分词器
        SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
        QueryParser parser = new QueryParser("desc", analyzer);
        Query query = parser.parse(q);
        long start = System.currentTimeMillis();
        TopDocs hits = is.search(query, 10);
        long end = System.currentTimeMillis();
        System.out.println("匹配 "+q+" ，总共花费"+(end-start)+"毫秒"+"查询到"+hits.totalHits+"个记录");

        QueryScorer scorer = new QueryScorer(query);
        Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
        SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<b><font color = 'red'>","</font></b>");
        Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer);
        highlighter.setTextFragmenter(fragmenter);
        for(ScoreDoc scoreDoc:hits.scoreDocs){
            Document doc = is.doc(scoreDoc.doc);
            System.out.println(doc.get("city"));
            System.out.println(doc.get("desc"));
            String desc = doc.get("desc");
            if(desc != null){
                TokenStream tokenStream = analyzer.tokenStream("desc", new StringReader(desc));
                System.out.println(highlighter.getBestFragment(tokenStream, desc));
            }
        }
        reader.close();
    }

    public static void main(String[] args) {
        String indexDir = "D:\\lucene6";
        String q = "南京文明";
        try {
            search(indexDir,q);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}


class Indexer {

    private Integer ids[] = {1,2,3};
    private String citys[] = {"青岛","南京","上海"};
    private String descs[] = {
            "青岛是一个美丽的城市。",
            "南京是一个有文化的城市。南京是一个文化的城市南京，简称宁，是江苏省会，地处中国东部地区，长江下游，濒江近海。全市下辖11个区，总面积6597平方公里，2013年建成区面积752.83平方公里，常住人口818.78万，其中城镇人口659.1万人。[1-4] “江南佳丽地，金陵帝王州”，南京拥有着6000多年文明史、近2600年建城史和近500年的建都史，是中国四大古都之一，有“六朝古都”、“十朝都会”之称，是中华文明的重要发祥地，历史上曾数次庇佑华夏之正朔，长期是中国南方的政治、经济、文化中心，拥有厚重的文化底蕴和丰富的历史遗存。[5-7] 南京是国家重要的科教中心，自古以来就是一座崇文重教的城市，有“天下文枢”、“东南第一学”的美誉。截至2013年，南京有高等院校75所，其中211高校8所，仅次于北京上海；国家重点实验室25所、国家重点学科169个、两院院士83人，均居中国第三。[8-10] 。",
            "上海是一个繁华的城市。"
    };

    private Directory dir;

    /**
     * 获取IndexWriter实例
     * @return
     * @throws Exception
     */
    private IndexWriter getWriter()throws Exception{
        //Analyzer analyzer  =  new StandardAnalyzer(); // 标准分词器
        SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        IndexWriter writer = new IndexWriter(dir, iwc);
        return writer;
    }

    /**
     * 生成索引
     * @param indexDir
     * @throws Exception
     */
    private void index(String indexDir)throws Exception{
        dir = FSDirectory.open(Paths.get(indexDir));
        IndexWriter writer = getWriter();
        for(int i = 0;i<ids.length;i++){
            Document doc = new Document();
            doc.add(new StringField("id", ids[i]+"", Field.Store.YES));
            doc.add(new StringField("city",citys[i],Field.Store.YES));
            doc.add(new TextField("desc", descs[i], Field.Store.YES));
            writer.addDocument(doc); // 添加文档
        }
        writer.close();
    }


    public static void main(String[] args) throws Exception {
        new Indexer().index("D:\\lucene6");
    }

}

class Highlight{
    public static void main(String[] args) {

    }
}