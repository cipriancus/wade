package com.wade.cryma.crymaprediction.endpoint;

import com.wade.cryma.crymaprediction.exception.RequestNoResponseException;
import com.wade.cryma.crymaprediction.service.IPredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PredictionEndpoint {

    @Autowired
    IPredictionService predictionService;

    /**
     * GET /predict/{coinId}
     *
     * @param coinId    The coin id that is searched.
     * @param startDate The start date for the data.
     * @param endDate   The end date for the data.
     *                  All params are mandatory
     * @return a map of data
     */
    @RequestMapping(method = RequestMethod.GET, path = "/predict/{coinId}", produces = "application/json")
    public Map<String, List<String>> predict(@PathVariable(value = "coinId") String coinId, @RequestParam(value = "startDate") String startDate, @RequestParam(value = "endDate") String endDate) {

        Map<String, List<String>> predictionResult = predictionService.predict(coinId, startDate, endDate);

        if (predictionResult != null && predictionResult.keySet().isEmpty() == false) {
            return predictionResult;
        }

        throw new RequestNoResponseException();
    }
}
