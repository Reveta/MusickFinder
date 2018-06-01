package ua.com.epam;

import ua.com.epam.sites.JuicesSite;
import ua.com.epam.sites.YouTubeMusicSite;

import java.util.List;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        YouTubeMusicSite site = new YouTubeMusicSite();
        site.openStartPage();
        List<String> videoNames = site.getListVideoNames();
        site.exit();

        JuicesSite juicesSite = new JuicesSite();
        juicesSite.openStartPage();

        videoNames.forEach(juicesSite::downloadMusic);

//        juicesSite.downloadMusic(videoNames.get(1));
//        juicesSite.exit();
    }
}
