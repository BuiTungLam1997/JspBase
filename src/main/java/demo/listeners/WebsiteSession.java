package demo.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class WebsiteSession implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("A new session is created");

    }

    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("A session was destroyed");
    }
}
