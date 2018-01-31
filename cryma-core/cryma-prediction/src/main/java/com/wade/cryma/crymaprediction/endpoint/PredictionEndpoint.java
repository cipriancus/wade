package com.wade.cryma.crymaprediction.endpoint;

import com.wade.cryma.crymaprediction.exception.RequestNoResponseException;
import com.wade.cryma.crymaprediction.service.IPredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class PredictionEndpoint {

    @Autowired
    IPredictionService predictionService;

    /**
     * GET /predict/{abbreviation}
     *
     * @param coinId    The coin id that is searched
     * @return a map of data
     */
    @RequestMapping(method = RequestMethod.GET, path = "/predict/{abbreviation}", produces = "application/json")
    public Map<String, List<String>> predict(@PathVariable(value = "abbreviation") String abbreviation) {

        Map<String, List<String>> predictionResult = predictionService.predict(abbreviation);

        if (predictionResult != null && predictionResult.keySet().isEmpty() == false) {
            return predictionResult;
        }

        throw new RequestNoResponseException();
    }
}
