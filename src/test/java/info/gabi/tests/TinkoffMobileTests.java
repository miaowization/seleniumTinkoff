package info.gabi.tests;

import info.gabi.BaseRunner;
import info.gabi.pages.GooglePage;
import info.gabi.pages.TinkoffMobilePage;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TinkoffMobileTests extends BaseRunner {
    private TinkoffMobilePage mobilePage;

    @Test
    public void goToTinkoffMobileWebSite() {
        GooglePage googlePage = new GooglePage(getDriver());
        googlePage.open();
        googlePage.searchFor("мобайл тинькофф тарифы");
        googlePage.chooseLinkFromSearchResults("https://www.tinkoff.ru/mobile-operator/tariffs/");
        mobilePage = new TinkoffMobilePage(getDriver());
        mobilePage.closePreviousTab();
        mobilePage.checkTabName("Тарифы Тинькофф Мобайла");
    }

    @Test
    public void comparePrices() {
        mobilePage = new TinkoffMobilePage(getDriver());
        mobilePage.open();
        mobilePage.compareDefaultPrices();
        mobilePage.compareMaxPrices();
    }

    @Test
    public void checkButtonActive() {
        mobilePage = new TinkoffMobilePage(getDriver());
        mobilePage.open();
        mobilePage.checkAllCheckboxes(false);
        mobilePage.selectInternetOption("0 ГБ");
        mobilePage.selectCallsOption("0 минут");
        mobilePage.checkPriceInTotal("0");
        mobilePage.checkOrderButtonIsClickable();
    }
}