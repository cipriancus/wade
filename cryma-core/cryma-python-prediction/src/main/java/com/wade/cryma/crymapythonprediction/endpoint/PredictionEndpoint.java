package com.wade.cryma.crymapythonprediction.endpoint;

import com.wade.cryma.crymapythonprediction.library.LibraryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PredictionEndpoint {

    private LibraryRequest libraryRequest;

    @Autowired
    public PredictionEndpoint(LibraryRequest libraryRequest) {
        this.libraryRequest = libraryRequest;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/predict/{coinId}")
    public @ResponseBody
    List<Integer> predict(@RequestParam(value = "coinId", required = true) String coinId) {
        List<Integer> predictionResult=libraryRequest.sendLibraryRequest(coinId);

        if(predictionResult!=null&&predictionResult.size()>0){
            return predictionResult;
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT);
    }

}
