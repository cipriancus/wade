package com.wade.cryma.crymaplot.endpoint;

import com.wade.cryma.crymaplot.service.ICoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/plot")
public class PlotEndpoint {

    @Autowired
    private ICoinService coinService;

    /**
     * GET /plot/{abbreviation}
     *
     * @param abbreviation    The coin abbreviation that is searched.
     * @param startDate The start date for the data.
     * @param endDate   The end date for the data.
     * @return a map of data
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{abbreviation}", produces = "text/plain")
    public String plot(@PathVariable(value = "abbreviation") String abbreviation, @RequestParam(value = "startDate") String startDate, @RequestParam(value = "endDate") String endDate, @RequestParam(value = "format") String format) {
        return coinService.getCoinValues(abbreviation,startDate,endDate,format);
    }
}