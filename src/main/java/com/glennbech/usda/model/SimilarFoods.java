package com.glennbech.usda.model;

import java.io.*;
import java.util.*;

/**
 *
 */
public class SimilarFoods {

    private static SimilarFoods instance;

    private Map<String, List<String>> similarItems;

    private SimilarFoods(InputStream is) throws IOException {
        loadData(is);
    }

    public static void initialize(InputStream is) throws IOException {
        if (instance == null) {
            instance = new SimilarFoods(is);
        }
    }

    public static SimilarFoods instance() {
        if (instance == null) {
            throw new IllegalStateException("Please call inisitalize first");
        }
        return instance;
    }

    public List<String> getSimilarItems(String ndbNo) {
        return similarItems.get(ndbNo);
    }

    private void loadData(InputStream is) throws IOException {

        BufferedReader r = new BufferedReader(new InputStreamReader(is));
        String l;
        similarItems = new HashMap<String, List<String>>();
        while ((l = r.readLine()) != null) {
            if (l.contains(",,") || l.endsWith(","))
                continue;

            StringTokenizer tz = new StringTokenizer(l, ",", false);
            String ndbNo = tz.nextToken();

            List<String> fooditems = new ArrayList<String>();
            similarItems.put(ndbNo, fooditems);

            while (tz.hasMoreTokens()) {
                fooditems.add(tz.nextToken());
            }
        }
    }

    public List<String> getSimilarItems(String ndbNo, int limit) {
        List<String> list = new ArrayList<String>();
        if (similarItems.get(ndbNo) == null) {
            return list;
        }
        for (int i = 0; i < limit; i++) {
            list.add(similarItems.get(ndbNo).get(i));
        }
        return list;
    }
}
