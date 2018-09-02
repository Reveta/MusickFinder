package ua.com.reveta;

import com.google.common.collect.Lists;
import ua.com.reveta.sites.JuicesSite;
import ua.com.reveta.sites.YouTubeMusicSite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

/*        YouTubeMusicSite site = new YouTubeMusicSite();*/

        String[] arr = {
                "1. Thriller\n" ,
                "2. They Don't Care About Us\n" ,
                "3. Billie Jean\n" ,
                "4. We Are The World\n" ,
                "5. Beat It\n" ,
                "1. Black Or White\n" ,
                "2. We Are The World\n" ,
                "3. Billie Jean\n" ,
                "4. Bad\n" ,
                "5. Don't Stop 'Til You Get Enough\n" ,
                "1. Thriller\n" ,
                "2. Billie Jean\n" ,
                "3. We Are The World\n" ,
                "4. Beat It\n" ,
                "5. Black Or White\n" ,
                "1. Billie Jean\n" ,
                "2. Thriller\n" ,
                "3. Beat It\n" ,
                "4. Man In The Mirror\n" ,
                "5. Smooth Criminal\n" ,
                "1. Earth Song\n" ,
                "2. Thriller\n" ,
                "3. Will You Be There\n" ,
                "4. You Rock My World\n" ,
                "5. Bad"};

        List<String> videoNames = new ArrayList<>(Lists.newArrayList(arr));
        /*try {
            site.openStartPage();
            videoNames = site.getListVideoNames();
        } finally {
            site.exit();
        }*/

        JuicesSite juicesSite = new JuicesSite();
        try {
            juicesSite.openStartPage();
        videoNames.forEach(name -> {
            name = name.substring(2);
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
