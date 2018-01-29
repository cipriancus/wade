package com.wade.cryma.crymaplot.service;

import org.springframework.stereotype.Service;

@Service
public interface ICoinService {
    String getCoinValues(String abbreviation, String startDate, String endDate,String format);
}
