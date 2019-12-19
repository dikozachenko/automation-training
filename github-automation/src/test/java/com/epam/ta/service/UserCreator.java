package com.epam.ta.service;

import com.epam.ta.model.User;

public class UserCreator {

    public static final String TESTDATA_USER_EMAIL = "testdata.userData.email";
    public static final String TESTDATA_USER_PASSWORD = "testdata.userData.password";
    public static final String TESTDATA_USER_FIRST_NAME = "testdata.userData.firstName";
    public static final String TESTDATA_USER_LAST_NAME = "testdata.userData.lastName";

    public static User authentificationData() {
        return new User(
                TestDataReader.getTestData(TESTDATA_USER_EMAIL),
                TestDataReader.getTestData(TESTDATA_USER_FIRST_NAME),
                TestDataReader.getTestData(TESTDATA_USER_LAST_NAME),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD)
        );
    }

    public static User emptyUser(){
        return new User(null, null, null, null);
    }

}
