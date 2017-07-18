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
            if (collapsing.isEmpty()) {
                // Add accession for comparison with the next one
                collapsing.add(accession);
                return true;
            }

            // Otherwise, we already have at least a previous accession
            String latestAccession = collapsing.get(collapsing.size() - 1);
            if (latestAccession.equals(accession)) {
                // Remove possible duplicates
                return true;
            }

            // If we can compare latest and current side by side
            if (latestAccession.length() == accession.length()) {
                int i = 0;
                while (latestAccession.charAt(i) == accession.charAt(i)) {
                    i++;
                }
                // Add the accession if it's consecutive
                if ((Integer.parseInt(accession.substring(i)) - Integer.parseInt(latestAccession.substring(i))) == 1) {
                    collapsing.add(accession);
                    return true;
                }
            }
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
