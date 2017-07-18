package com.mbdebian.codingtasks.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manuel Bernal Llinares
 *         Project: accession-service
 *         Package: com.mbdebian.codingtasks.models
 *         Timestamp: 2017-07-18 19:48
 *         ---
 *         © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 *         All rights reserved.
 *
 *         This is the main application model (we won't need more for covering the requirements)
 */
@Component
public class AppModel {

    // Helper class for collapsing consecutive accessions (Builder)
    class Collapser {
        private List<String> collapsing = new ArrayList<>();
        private List<String> product = new ArrayList<>();

        private boolean processAdjacency(String accession) {
            // TODO
            return false;
        }

        private String collapseAdjacentAccessions(String accession) {
            // TODO
            return "";
        }

        public void build(String accession) {
            // TODO
            // TODO is adjacent
            // TODO collapse
        }

        public List<String> getProduct() {
            // TODO
            return product;
        }
    }

    public List<String> sortAndAggregate(List<String> accessions) {
        Collapser collapser = new Collapser();
        accessions.stream().sorted().forEach(accession -> collapser.build(accession));
        return collapser.getProduct();
    }
}
