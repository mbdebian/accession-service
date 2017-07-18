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
            // If there is only one accession in the collapsing list, we just add it to the product, if not, we need to
            // collapse adjacent accessions
            String accessionToAdd = collapsing.get(0);
            if (collapsing.size() > 1) {
                // Collapse using the first-last in the collapsing list
                accessionToAdd = String.format("%s-%s",
                        collapsing.get(0),
                        collapsing.get(collapsing.size() - 1));
            }
            product.add(accessionToAdd);
            collapsing.clear();
            if (accession != null) {
                // Add possible new accession after collapsing (corner case for the last accession that may just
                // collapse)
                collapsing.add(accession);
            }
            // I'm not sure I will use this value for logging purposes...
            return accessionToAdd;
        }

        private void finalizeProduct() {
            if (!collapsing.isEmpty()) {
                // Flush pending accessions from the collapsing list
                collapseAdjacentAccessions(null);
            }
        }

        public void build(String accession) {
            if (!processAdjacency(accession)) {
                // This accession is not adjacent, so collapse existing ones
                collapseAdjacentAccessions(accession);
            }
        }

        public List<String> getProduct() {
            // We need to finalize the product, i.e. there may be pending accessions in the collapsing list
            finalizeProduct();
            return product;
        }
    }

    public List<String> sortAndAggregate(List<String> accessions) {
        Collapser collapser = new Collapser();
        accessions.stream().sorted().forEach(accession -> collapser.build(accession));
        return collapser.getProduct();
    }
}
