package com.wade.cryma.crymaplot.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ICoinRepository {
    String getCoinValues(String abbreviation, String startDate, String endDate,String format);
}
