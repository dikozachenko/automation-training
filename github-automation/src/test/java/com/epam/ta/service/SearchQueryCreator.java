package com.epam.ta.service;

import com.epam.ta.model.SearchQuery;

public class SearchQueryCreator {

    public static final String TESTDATA_PLACE = "testdata.place";
    public static final String TESTDATA_ARRIVAL_DATE = "testdata.arrival.date";
    public static final String TESTDATA_DEPARTURE_DATE = "testdata.departure.date";
    public static final String TESTDATA_ADULTS = "testdata.adults";
    public static final String TESTDATA_CHILDREN = "testdata.children";

    public static SearchQuery withIncorrectCity() {
        return new SearchQuery(TestDataReader.getTestData(TESTDATA_PLACE),
                TestDataReader.getTestData(TESTDATA_ARRIVAL_DATE),
                TestDataReader.getTestData(TESTDATA_DEPARTURE_DATE),
                TestDataReader.getTestData(TESTDATA_ADULTS),
                TestDataReader.getTestData(TESTDATA_CHILDREN));
    }

}
