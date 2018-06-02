package ua.com.epam;

import ua.com.epam.sites.JuicesSite;
import ua.com.epam.sites.YouTubeMusicSite;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        YouTubeMusicSite site = new YouTubeMusicSite();
        JuicesSite juicesSite = new JuicesSite();
        List<String> videoNames;
        try {
            site.openStartPage();
            videoNames = site.getListVideoNames();
        } finally {
            site.exit();
        }

        try {
            juicesSite.openStartPage();
        videoNames.forEach(name -> {
            try {
                juicesSite.downloadMusic(name);
            } catch (Exception error) {
                System.out.println("One element down! " + name);
            }
        });
        } finally {
            juicesSite.waiting(60000);
            juicesSite.exit();
        }
    }
}
