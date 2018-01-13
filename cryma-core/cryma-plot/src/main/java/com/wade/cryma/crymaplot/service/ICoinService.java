package com.wade.cryma.crymaplot.service;

import com.wade.cryma.crymamodel.model.Coin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICoinService {
    List<Coin> getCoinValues(String coinId, String startDate, String endDate);
}
