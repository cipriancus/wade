package com.wade.cryma.crymaprediction.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface IPredictionService {
    Map<String, List<String>> predict(String coinId, String startDate, String endDate);
}
