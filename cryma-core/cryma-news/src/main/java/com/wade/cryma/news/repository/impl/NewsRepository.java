package com.wade.cryma.news.repository.impl;

import com.wade.cryma.news.model.News;
import com.wade.cryma.news.repository.INewsRepository;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;


public class NewsRepository implements INewsRepository{

    String newsOWLUri;

    OntModel base;

    public NewsRepository(String newsOWLUri){
        this.newsOWLUri=newsOWLUri;
        base = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
        base.read( newsOWLUri, "TURTLE" );
    }

    @Override
    public List<News> getNews(String Page, String size) {
        ExtendedIterator<Individual> individuals = base.listIndividuals(base.getOntClass("http://iptc.org/std/rNews/2011-10-07#NewsItem"));
        while (individuals.hasNext()) {
            System.out.print(individuals);
            individuals.next();
        }
        return null;
    }
}
