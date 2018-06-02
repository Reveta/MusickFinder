package ua.com.epam.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import ua.com.epam.templates.Site;

public class JuicesSite extends Site {

    public JuicesSite() {
        super.urlStartedPage = "https://www.mp3juices.cc/";
    }

    public void downloadMusic(String name) {
        searchMusicNameInput(name);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickDownload();
        waiting(5000);
    }

    private void searchMusicNameInput(String name) {

        WebElement input = getInput();
        input.clear();
        input.sendKeys(name);
        waiting(500);
        clickEnter();
    }

    private WebElement getInput() {

        if (this.elementMap.containsKey("input")) {
            return this.elementMap.get("input");

        } else {
            WebElement query = this.driver.findElement(By.id("query"));
            this.addElementToMap("input", query);
            return query;
        }
    }

    private void clickEnter() {

        if (this.elementMap.containsKey("enter")) {
            this.elementMap.get("enter").click();

        } else {
            WebElement query = this.driver.findElement(By.id("button"));
            this.addElementToMap("enter", query);
            query.click();
        }
    }

    private void clickDownload() {

        this.driver.findElement(By.id("result_1"))
                .findElement(By.className("options")).click();

        waiting(3000);

        WebElement element = this.driver.findElement(By.id("download_1"))
                    .findElement(By.className("options"));

            System.out.println("Помилка до кнопки завантажити");

        String attribute = element
                    .findElement(By.className("url"))
                    .getAttribute("href");
            System.out.println("Помилка після кнопки завантажити");

        this.openPage(attribute);
    }

}
