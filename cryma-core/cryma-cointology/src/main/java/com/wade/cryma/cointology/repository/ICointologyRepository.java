package com.wade.cryma.cointology.repository;

import org.springframework.stereotype.Repository;

public interface ICointologyRepository {
    String getCoinValues(String limit, String format);
    String getCoinByAbbreviation(String abbreviation, String format);

}
