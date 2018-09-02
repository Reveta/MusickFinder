package ua.com.reveta.templates;

import ua.com.reveta.siteShablon.SiteShablon;

public abstract class Site extends SiteShablon {

    public Site(){}

    public void waiting(int mils){
        try {
            Thread.sleep(mils);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
