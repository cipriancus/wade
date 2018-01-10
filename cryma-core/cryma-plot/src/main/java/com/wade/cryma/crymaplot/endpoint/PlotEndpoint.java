package com.wade.cryma.crymaplot.endpoint;


import com.wade.cryma.crymaplot.model.TopCoin;
import com.wade.cryma.crymaplot.repository.TopCoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/plot")
public class PlotEndpoint {

    @Autowired
    TopCoinRepository topCoinService;

    /**
     * GET /plot
     *
     * @param page      The page number
     * @param pageNo    The page number
     * @param startDate The start date for the data.
     * @param endDate   The end date for the data.
     * @return a map of data
     */
    @RequestMapping(method = RequestMethod.GET, path = "/", produces = "application/json")
    public Map<String, List<String>> plot(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "pageNo", required = false) String pageNo,
                                          @RequestParam(value = "startDate", required = false) String startDate, @RequestParam(value = "endDate", required = false) String endDate) {
        throw new NotImplementedException();
    }

    /**
     * GET /plot/{coinId}
     *
     * @param coinId    The coin id that is searched.
     * @param startDate The start date for the data.
     * @param endDate   The end date for the data.
     * @return a map of data
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{coinId}", produces = "application/json")
    public Map<String, List<String>> plot(@PathVariable(value = "coinId") String coinId, @RequestParam(value = "startDate") String startDate, @RequestParam(value = "endDate") String endDate) {
        throw new NotImplementedException();
    }

    /**
     * GET /plot/pieChartDistrib
     *
     * @return Provides data for the distribution of main cryptocurrencies chart
     */
    @RequestMapping(method = RequestMethod.GET, path = "/pieChartDistrib", produces = "application/json")
    public Map<String, List<String>> pieChartDistrib() {
        throw new NotImplementedException();
    }

    /**
     * GET /plot/top
     *
     * @return Provides data for the top crypto currencies chart
     */
    @RequestMapping(method = RequestMethod.GET, path = "/top", produces = "application/json")
    public Page<TopCoin> top(Pageable pageable) {
        return topCoinService.findAll(pageable);
    }
}