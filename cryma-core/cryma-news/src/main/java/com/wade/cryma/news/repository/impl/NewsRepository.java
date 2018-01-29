package com.wade.cryma.news.repository.impl;

import com.wade.cryma.news.model.News;
import com.wade.cryma.news.repository.INewsRepository;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.sparql.resultset.RDFOutput;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class NewsRepository implements INewsRepository {

    private String fusekiEndpoint;

    public NewsRepository(String fusekiEndpoint) {
        this.fusekiEndpoint = fusekiEndpoint;
    }

    @Override
    public String getNews(String limit,String format) {
        final StringBuilder response = new StringBuilder();
        query(fusekiEndpoint, "PREFIX rnews: <http://dev.iptc.org/files/rNews/rnews_1.0_draft1.owl#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
                "\n" +
                "SELECT ?name ?description ?date ?url\n" +
                "WHERE {\n" +
                " ?subject rdf:type rnews:Article.\n" +
                " ?subject rnews:name ?name.\n" +
                " ?subject rnews:description ?description.\n" +
                " OPTIONAL {\n" +
                "   ?subject rnews:datePublished ?date.\n" +
                "   ?subject rnews:url ?url\n" +
                "  }\n" +
                "} " +
                "LIMIT" + limit, qExec -> {
            Model model=RDFOutput.encodeAsModel(qExec.execSelect());
            StringWriter out = new StringWriter();
            model.write(out,format);
            response.append(out.toString());
        });
        return response.toString();
    }

    @Override
    public String getCoinNewsByAbbreviation(String abbreviation, String limit, String format) {
        final StringBuilder response = new StringBuilder();
        query(fusekiEndpoint, "PREFIX rnews: <http://dev.iptc.org/files/rNews/rnews_1.0_draft1.owl#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX cryma: <http://purl.org/cryma#>\n" +
                "\n" +
                "\n" +
                "SELECT ?name ?description ?date ?url\n" +
                "WHERE {\n" +
                " \t ?subject rdf:type rnews:Article.\n" +
                "     ?subject rnews:name ?name.\n" +
                "     ?subject rnews:description ?description.\n" +
                "     OPTIONAL {\n" +
                "       ?subject rnews:datePublished ?date.\n" +
                "       ?subject rnews:url ?url\n" +
                "      }\n" +
                "    ?subject cryma:aboutCoin ?coin.\n" +
                "  \t?coin cryma:abbreviation \"" + abbreviation + "\"     \n" +
                "} LIMIT " + limit, qExec -> {
            Model model=RDFOutput.encodeAsModel(qExec.execSelect());
            StringWriter out = new StringWriter();
            model.write(out,format);
            response.append(out.toString());
        });
        return response.toString();
    }


    private static List<News> getNewsRS(ResultSet rs) {
        List<News> list = new ArrayList<>();
        while (rs.hasNext()) {
            News news = new News();

            QuerySolution result = rs.next();
            RDFNode name = result.get("name");
            RDFNode description = result.get("description");
            RDFNode date = result.get("date");
            RDFNode url = result.get("url");

            news.setName(name.toString());
            news.setDescription(description.toString());
            news.setDate(date != null ? date.toString() : "");
            news.setUrl(url != null ? url.toString() : "");

            list.add(news);
        }
        return list;
    }

    static void query(String URL, String query, Consumer<QueryExecution> body) {
        try (QueryExecution qExec = QueryExecutionFactory.sparqlService(URL, query)) {
            body.accept(qExec);
        }
    }
}
