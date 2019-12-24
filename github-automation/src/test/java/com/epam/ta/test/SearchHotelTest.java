package com.epam.ta.test;

import com.epam.ta.model.SearchQuery;
import com.epam.ta.page.HomePage;
import com.epam.ta.service.SearchQueryCreator;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchHotelTest extends CommonConditions {

    @Test
    public void incorrectCity() {
        String expected = "Выбран неизвестный город";
        SearchQuery hotelTerms = SearchQueryCreator.withIncorrectCity();
        String errorMessageDueToIncorrectCity = new HomePage(driver)
                .openPage()
                .searchHotelsByWrongParameters(hotelTerms)
                .errorMessage();

        assertThat(errorMessageDueToIncorrectCity, is(expected));
    }

    @Test
    public void withoutChildrenAge() {
        String expected = "Некорректное число или возраст гостей";
        SearchQuery hotelTerms = SearchQueryCreator.withoutChildrenAge();
        String errorMessageDueToIncorrectCity = new HomePage(driver)
                .openPage()
                .searchHotelsByWrongParameters(hotelTerms)
                .errorMessage();

        assertThat(errorMessageDueToIncorrectCity, is(expected));
    }

    @Test
    public void withoutIncorrectDate() {
        String expected = "Некорректное число или возраст гостей";
        SearchQuery hotelTerms = SearchQueryCreator.withIncorrectDate();
        String errorMessageDueToIncorrectCity = new HomePage(driver)
                .openPage()
                .searchHotelsByWrongParameters(hotelTerms)
                .errorMessage();

        assertThat(errorMessageDueToIncorrectCity, is(expected));
    }



}
