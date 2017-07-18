package com.mbdebian.codingtasks.controllers;

import com.mbdebian.codingtasks.models.AppModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Manuel Bernal Llinares
 *         Project: accession-service
 *         Package: com.mbdebian.codingtasks.controllers
 *         Timestamp: 2017-07-18 19:51
 *         ---
 *         © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 *         All rights reserved.
 *
 *         Web service interface for this application
 */
@RestController
public class RestApi {
    @Autowired
    private AppModel appModel;

    @RequestMapping("sortAccessions")
    public String sortAccessions(@RequestParam List<String> accessions) {
        return String.join(",", appModel.sortAndAggregate(accessions));
    }
}
