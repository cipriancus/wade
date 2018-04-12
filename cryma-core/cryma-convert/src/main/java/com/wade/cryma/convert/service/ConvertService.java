package com.wade.cryma.convert.service;

import org.springframework.beans.factory.annotation.Autowired;

public class ConvertService {

    @Autowired
    PlotService plotService;

    public Double convert(String from, String to) {
        Double valueOfFromCoinInDollars = plotService.getValueByAbbreviation(from);//if is coin
        Double valueOfToCoinInDollars = plotService.getValueByAbbreviation(to);//if is coin

        Double fromValue = 0.0;
        Double toValue = 0.0;

        if (valueOfFromCoinInDollars != null) {
            fromValue = valueOfFromCoinInDollars;
        } else {
            return 0.0;
        }

        if (valueOfToCoinInDollars != null) {
            toValue = valueOfToCoinInDollars;
        } else {
            return 0.0;
        }
        return fromValue / toValue;
    }
}
