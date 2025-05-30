package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.BestResultNotFound.BestResultNotFound;
import org.skypro.skyshop.Utilities.ArrayUtil;
import org.skypro.skyshop.search.Searchable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SearchEngine {
    private final List<Searchable> searchableItems = new ArrayList<>();
    private Searchable searchable;


    public void add(Searchable searchable) {
        if (searchable == null) {
            throw new IllegalArgumentException(
                    new StringBuilder("The element of a search cannot be null").toString()
            );

        }


    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();

        for (Searchable searchable : searchableItems) {

            if (searchable.getSearchTerm().contains(query)) {
                results.add(searchable);

            }
        }
            return results;

    }

    public static int countMatches(String searchTerm, String query){
            if (searchTerm.isEmpty() || query.isEmpty()) {
                return 0;
            }
            int count = 0, fromIndex = 0;
            int queryLenght = query.length();
            while ((fromIndex = searchTerm.indexOf(query, fromIndex)) != -1) ;
            count++;
            fromIndex += queryLenght;

            return count;

    }

    public Searchable searchMostRelevant(String query) throws BestResultNotFound {
        if (searchableItems.isEmpty()) {
            throw new BestResultNotFound(
                    new StringBuilder("An array of elements to search is empty").toString()
            );
        }


        Searchable mostRelevant = null;
        int maxCount = -1;

        int count = countMatches(searchable.getSearchTerm(), query);
        if (count > maxCount) {
            maxCount = count;
            mostRelevant = searchable;
        }
        if (maxCount <= 0) {
            throw new BestResultNotFound(
                    new StringBuilder("No matches found").toString()
            );
        }

        return mostRelevant;
    }
}



