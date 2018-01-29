package com.wade.cryma.crymapythonprediction.endpoint;

import com.wade.cryma.crymapythonprediction.exception.RequestNoResponseException;
import com.wade.cryma.crymapythonprediction.library.LibraryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class PredictionEndpoint {

    @Autowired
    private LibraryRequest libraryRequest;

    @RequestMapping(method = RequestMethod.GET, path = "predict/{coinId}",produces = "application/json")
    public Map<String,List<String>> predict(@PathVariable(value = "coinId") String coinId) {
        Map<String,List<String>> predictionResult = libraryRequest.sendLibraryRequest(coinId);

        if (predictionResult != null && predictionResult.size() > 0) {
            return predictionResult;
        }
        throw new RequestNoResponseException();
    }
}
