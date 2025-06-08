package org.skypro.skyshop.engine;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.search.Searchable;

import java.util.*;

public final class SearchEngine {
    private final List<Searchable> searchableItems = new ArrayList<>();

    public void add(Searchable searchable) {
        if (searchable == null) {
            throw new IllegalArgumentException("The element of a search cannot be null");
        }
        searchableItems.add(searchable);
    }

    public Map<String, Searchable> search(String query) {

        Map<String, Searchable> results = new TreeMap<>(new Comparator<String>() {


            @Override
            public int compare(String s1, String s2) {
                int lengthCompare = Integer.compare(s1.length(), s2.length());
                if (lengthCompare != 0) {
                    return lengthCompare;
                }
                return s1.compareTo(s2);
            }
        });


        for (Searchable searchable : searchableItems) {
            if (searchable.getSearchTerm().contains(query)) {
                String key = searchable.getSearchTerm();

                results.put(key, searchable);
            }
        }
        return results;
    }


    public static int countMatches(String searchTerm, String query) {
        if (searchTerm.isEmpty() || query.isEmpty()) {
            return 0;
        }
        int count = 0;
        int fromIndex = 0;
        int queryLength = query.length();
        while ((fromIndex = searchTerm.indexOf(query, fromIndex)) != -1) {
            count++;
            fromIndex += queryLength;
        }
        return count;
    }

    public Searchable searchMostRelevant(String query) throws BestResultNotFound {
        if (searchableItems.isEmpty()) {
            throw new BestResultNotFound("An array of elements to search is empty");
        }

        Searchable mostRelevant = null;
        int maxCount = -1;

        for (Searchable item : searchableItems) {
            int count = countMatches(item.getSearchTerm(), query);
            if (count > maxCount) {
                maxCount = count;
                mostRelevant = item;
            }
        }

        if (maxCount <= 0) {
            throw new BestResultNotFound("No matches found");
        }

        return mostRelevant;
    }
}

