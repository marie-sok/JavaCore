package org.skypro.skyshop.engine;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.search.Searchable;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public final class SearchEngine {
    private final Set<Searchable> searchableItems = new HashSet<>();

    public void add(Searchable searchable) {
        if (searchable == null) {
            throw new IllegalArgumentException("The element of a search cannot be null");
        }
        searchableItems.add(searchable);
    }


    public Set<Searchable> search(String query) {

        Comparator<Searchable> comparator = Comparator
                .comparingInt((Searchable s) -> s.getSearchTerm().length()).reversed()
                .thenComparing(Searchable::getSearchTerm);


        Set<Searchable> results = new TreeSet<>(comparator);


        if (query == null || query.isEmpty()) {
            return results;
        }

                for (Searchable searchable : searchableItems) {
                    if (searchable.getSearchTerm().contains(query)) {
                        String key = searchable.getSearchTerm();

                        results.add(searchable);
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

