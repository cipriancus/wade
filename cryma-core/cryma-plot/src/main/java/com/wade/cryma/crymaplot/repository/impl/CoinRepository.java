package com.wade.cryma.crymaplot.repository.impl;

import com.wade.cryma.crymaplot.repository.ICoinRepository;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.sparql.resultset.RDFOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class CoinRepository implements ICoinRepository {

    private String fusekiEndpoint;

    public CoinRepository(String fusekiEndpoint) {
        this.fusekiEndpoint = fusekiEndpoint;
    }

    @Override
    public String getCoinValues(String abbreviation, String startDate, String endDate, String format) {
        final StringBuilder response = new StringBuilder();
        query(fusekiEndpoint, "" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX cryma: <http://purl.org/cryma#>\n" +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> \n" +
                "\n" +
                "SELECT ?coin_name ?price ?date\n" +
                "WHERE {\n" +
                " \t ?coin rdf:type cryma:Cryptocurrency.\n" +
                "  \t ?coin cryma:abbreviation ?coin_name.\n" +
                "  \t ?value rdf:type cryma:Value.\n" +
                "  \t ?value cryma:coin ?coin.\n" +
                "  \t ?value cryma:price_USD ?price.\n" +
                "\t ?value cryma:dateTime ?date\n" +
                "     FILTER regex(?coin_name,\"" + abbreviation + "\")\n" +
                "  \t FILTER (?date > \"" + startDate + "\"^^xsd:dateTime)\n" +
                "  \t FILTER (?date < \"" + endDate + "\"^^xsd:dateTime)\n" +
                "}", qExec -> {
            Model model = RDFOutput.encodeAsModel(qExec.execSelect());
            StringWriter out = new StringWriter();
            model.write(out, format);
            response.append(out.toString());
        });
        return response.toString();
    }

    static void query(String URL, String query, Consumer<QueryExecution> body) {
        try (QueryExecution qExec = QueryExecutionFactory.sparqlService(URL, query)) {
            body.accept(qExec);
        }
    }
}
