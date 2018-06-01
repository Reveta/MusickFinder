package ua.com.epam.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.com.epam.templates.Site;

import java.util.ArrayList;
import java.util.List;

public class YouTubeMusicSite extends Site {

    private List<String> listVideoNames;

    public YouTubeMusicSite() {
        super.urlStartedPage = "https://www.youtube.com/playlist?list=PL0RpQMuoj3eE3T7Zi0F7k2ADDbhmNAb6I";

        this.listVideoNames = new ArrayList<>();
    }

    public List<String> getListVideoNames(){
        addVideoNamesList();
        return this.listVideoNames;
    }

    private void addVideoNamesList(){

        this.driver.
                findElements(By.id("video-title")).
                forEach(this::addVideoNameList);
    }

    private void addVideoNameList(WebElement element){
        listVideoNames.add(element.getText());
    }

}
