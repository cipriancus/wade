package com.wade.cryma.crymaplot.service.impl;

import com.wade.cryma.crymaplot.repository.ICoinRepository;
import com.wade.cryma.crymaplot.service.ICoinService;
import org.springframework.beans.factory.annotation.Autowired;

public class CoinService implements ICoinService {

    @Autowired
    private ICoinRepository coinRepository;

    @Override
    public String getCoinValues(String abbreviation, String startDate, String endDate, String format) {
        return coinRepository.getCoinValues(abbreviation, startDate, endDate, format);
    }
}
