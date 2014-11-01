package co.com.hammerlab.util;

import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messsage extends ResourceBundle {

    private static ResourceBundle myResources = ResourceBundle.getBundle("hammerlab");

    public String getMessage(String originalStr) {
        try {
            return myResources.getString(originalStr);
        } catch (MissingResourceException e) {
            return originalStr;
        }
    }

    @Override
    protected Object handleGetObject(String key) {
        // TODO Auto-generated method stub
        return getMessage(key);
    }

    @Override
    public Enumeration<String> getKeys() {
        // TODO Auto-generated method stub
        return null;
    }

}
