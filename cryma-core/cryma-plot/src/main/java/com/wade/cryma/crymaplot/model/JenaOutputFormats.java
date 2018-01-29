package com.wade.cryma.crymaplot.model;

public class JenaOutputFormats {
    public static String[] formats={
        "TURTLE",
        "TTL",
        "Turtle",
        "N-TRIPLES",
        "N-TRIPLE",
        "NT",
        "JSON-LD",
        "RDF/XML-ABBREV	",
        "RDF/XML",
        "N3",
        "RDF/JSON" };

    public static boolean verify(String format){
        return format.contains(format);
    }
}
