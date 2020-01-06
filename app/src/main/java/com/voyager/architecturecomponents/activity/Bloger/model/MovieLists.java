package com.voyager.architecturecomponents.activity.Bloger.model;

import java.util.ArrayList;

public class MovieLists {


    /**
     * count : 7
     * next : null
     * previous : null
     */

    private int count;

    private ArrayList<Results> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Results> getResults() {
        return results;
    }

    public void setResults(ArrayList<Results> results) {
        this.results = results;
    }
}
