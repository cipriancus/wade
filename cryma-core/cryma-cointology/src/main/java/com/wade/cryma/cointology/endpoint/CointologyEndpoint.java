package com.wade.cryma.cointology.endpoint;

import com.wade.cryma.cointology.repository.ICointologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;

@CrossOrigin
@RestController
@RequestMapping(path = "/cointology")
public class CointologyEndpoint {

    @Autowired
    private ICointologyRepository cointologyRepository;

    /**
     * GET /plot/{abbreviation}
     *
     */
    @RequestMapping(method = RequestMethod.GET, path = "/", produces = "text/plain")
    public String getCoins(@RequestParam(value = "limit") String limit,@RequestParam(value = "format") String format){
        return cointologyRepository.getCoinValues(limit,format);
    }

    /**
     * GET /plot/{abbreviation}
     *
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{abbreviation}", produces = "text/plain")
    public String getCoinByAbbreviation(@PathVariable(name = "abbreviation") String abbreviation, @RequestParam(value = "format") String format){
        return cointologyRepository.getCoinByAbbreviation(abbreviation,format);
    }
}