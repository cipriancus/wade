package com.wade.cryma.crymaplot.endpoint;

import com.wade.cryma.crymamodel.model.Coin;
import com.wade.cryma.crymaplot.service.ICoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/plot")
public class PlotEndpoint {

    @Autowired
    private ICoinService coinService;

    /**
     * GET /plot/{coinId}
     *
     * @param coinId    The coin id that is searched.
     * @param startDate The start date for the data.
     * @param endDate   The end date for the data.
     * @return a map of data
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{coinId}", produces = "application/json")
    public List<Coin> plot(@PathVariable(value = "coinId") String coinId, @RequestParam(value = "startDate") String startDate, @RequestParam(value = "endDate") String endDate) {
        return coinService.getCoinValues(coinId,startDate,endDate);
    }
}