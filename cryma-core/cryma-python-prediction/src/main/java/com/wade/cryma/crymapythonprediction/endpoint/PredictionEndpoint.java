package com.wade.cryma.crymapythonprediction.endpoint;

import com.wade.cryma.crymamodel.exception.RequestNoResponseException;
import com.wade.cryma.crymapythonprediction.library.LibraryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class PredictionEndpoint {

    @Autowired
    private LibraryRequest libraryRequest;

    @RequestMapping(method = RequestMethod.GET, path = "predict/{coinId}",produces = "application/json")
    public Map<String,List<String>> predict(@PathVariable(value = "coinId") String coinId, @RequestParam(value = "startDate") String startDate, @RequestParam(value = "endDate") String endDate) {
        Map<String,List<String>> predictionResult = libraryRequest.sendLibraryRequest(coinId,startDate,endDate);

        if (predictionResult != null && predictionResult.size() > 0) {
            return predictionResult;
        }
        throw new RequestNoResponseException();
    }
}
