package ru.netology.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class DebitCardApplication {
    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999");
        SelenideElement form = $(".form");
        form.$("[data-test-id=name] input").setValue("Иван Иванов");
        form.$("[data-test-id=phone] input").setValue("+79000000000");
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $(".Success_successBlock__2L3Cw").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldvalidated() {
        open("http://localhost:9999");
        SelenideElement form = $(".form");
        form.$("[data-test-id=name] input").setValue("Иванов Иван");
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $(".input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }
}