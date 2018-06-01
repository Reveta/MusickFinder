package ua.com.epam.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.com.epam.templates.Site;

public class JuicesSite extends Site {

    public JuicesSite() {
        super.urlStartedPage = "https://www.mp3juices.cc/";
    }

    public void downloadMusic(String name) {
        inputMusicNameInput(name);

    }

    private void inputMusicNameInput(String name) {

        WebElement input = getInput();
        input.sendKeys(name);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickEnter();
        input.clear();
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

    private void clickEnter(){

        if (this.elementMap.containsKey("enter")) {
            this.elementMap.get("enter").click();

        } else {
            WebElement query = this.driver.findElement(By.id("button"));
            this.addElementToMap("enter", query);
            query.click();
        }
    }

}
