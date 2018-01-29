package com.wade.cryma.cointology.repository.impl;

import com.wade.cryma.cointology.repository.ICointologyRepository;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.sparql.resultset.RDFOutput;

import java.io.StringWriter;
import java.util.function.Consumer;

public class CointologyRepository implements ICointologyRepository {

    private String fusekiEndpoint;

    public CointologyRepository(String fusekiEndpoint) {
        this.fusekiEndpoint = fusekiEndpoint;
    }

    @Override
    public String getCoinValues(String limit, String format) {
        final StringBuilder response = new StringBuilder();
        query(fusekiEndpoint, "" +
                "PREFIX  xsd:  <http://www.w3.org/2001/XMLSchema#>\n" +
                "PREFIX  rdf:  <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX  cryma: <http://purl.org/cryma#>\n" +
                "\n" +
                "SELECT  *\n" +
                "WHERE\n" +
                "  { \n" +
                "  \t?coin rdf:type cryma:Cryptocurrency .\n" +
                "    ?coin cryma:abbreviation ?abbreviation.\n" +
                "  \t?coin cryma:market_capital ?capital.\n" +
                "    ?coin cryma:maximum_supply ?supply.\n" +
                "  \t?coin cryma:percent_change_24h ?change.\n" +
                "  \t?coin cryma:price_USD ?price.\n" +
                "  \t?coin cryma:volume ?volume\n" +
                "  } ORDER BY DESC(?capital) LIMIT \n " + limit, qExec -> {
            Model model = RDFOutput.encodeAsModel(qExec.execSelect());
            StringWriter out = new StringWriter();
            model.write(out, format);
            response.append(out.toString());
        });
        return response.toString();
    }

    @Override
    public String getCoinByAbbreviation(String abbreviation, String format) {
        final StringBuilder response = new StringBuilder();
        query(fusekiEndpoint, "PREFIX  xsd:  <http://www.w3.org/2001/XMLSchema#>\n" +
                "PREFIX  rdf:  <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX  cryma: <http://purl.org/cryma#>\n" +
                "\n" +
                "SELECT  *\n" +
                "WHERE\n" +
                "  { \n" +
                "  \t?coin rdf:type cryma:Cryptocurrency .\n" +
                "    ?coin cryma:abbreviation ?abbreviation.\n" +
                "  \t?coin cryma:market_capital ?capital.\n" +
                "    ?coin cryma:maximum_supply ?supply.\n" +
                "  \t?coin cryma:percent_change_24h ?change.\n" +
                "  \t?coin cryma:price_USD ?price.\n" +
                "  \t?coin cryma:volume ?volume.\n" +
                "  \t{\n" +
                "      SELECT ?price_history ?date WHERE{\n" +
                "           ?value rdf:type cryma:Value.\n" +
                "           ?value cryma:coin ?coin.\n" +
                "           ?value cryma:price_USD ?price_history.\n" +
                "           ?value cryma:dateTime ?date\n" +
                "      }\n" +
                "    }\n" +
                "    FILTER regex(?abbreviation, \""+abbreviation+"\")\n" +
                "}", qExec -> {
            Model model = RDFOutput.encodeAsModel(qExec.execSelect());
            StringWriter out = new StringWriter();
            model.write(out, format);
            response.append(out.toString());
        });
        return response.toString();    }

    static void query(String URL, String query, Consumer<QueryExecution> body) {
        try (QueryExecution qExec = QueryExecutionFactory.sparqlService(URL, query)) {
            body.accept(qExec);
        }
    }
}
