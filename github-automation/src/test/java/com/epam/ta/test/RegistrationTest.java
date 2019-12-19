package com.epam.ta.test;

import com.epam.ta.model.User;
import com.epam.ta.page.RegistrationPage;
import com.epam.ta.service.UserCreator;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegistrationTest extends CommonConditions {
    @Test
    public void registrationWithoutData() {
        String expected = "E-mail (логин) не может быть пустой строкой\n" +
                "Фамилия не может быть пустой строкой\n" +
                "Имя не может быть пустой строкой\n" +
                "Пароль должен состоять не менее, чем из 6 символов";
        User user = UserCreator.emptyUser();
        String actual = new RegistrationPage(driver)
                .openPage()
                .registration(user)
                .message();
        assertThat(actual, is(expected));
    }

    @Test
    public void registration() {
        String expected = "Регистрация прошла успешно";
        User user = UserCreator.authentificationData();
        String actual = new RegistrationPage(driver)
                .openPage()
                .registration(user)
                .message();
        assertThat(actual, is(expected));
    }


    @Test
    public void registrationWithExistingLogin() {
        String expected = "Данный логин занят";
        User user = UserCreator.authentificationData();
        String actual = new RegistrationPage(driver)
                .openPage()
                .registration(user)
                .message();
        assertThat(actual, is(expected));
    }



}
