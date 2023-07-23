package com.springdasar.scopes;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * UserSession
 */
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class UserSession {
    private String username;
    private String sessionId;

    public void setAllFields(String username, String sessionId) {
        this.username = username;
        this.sessionId = sessionId;
        System.out.println("User session logged in: " + this);
    }

    public void logout() {
        this.username = null;
        this.sessionId = null;
        System.out.println("User session logged out: " + this);
    }

    @Override
    public String toString() {
        return "UserSession [username=" + username + ", sessionId=" + sessionId + "] " + this.hashCode();
    }

}

@ComponentScan
public class Example01 {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(Example01.class)) {
            UserSession userSession1 = context.getBean(UserSession.class);
            userSession1.setAllFields("Username1", "Session123");
            System.out.println(userSession1 + ", " + userSession1.hashCode());

            UserSession userSession2 = context.getBean(UserSession.class);
            userSession2.setAllFields("Username2", "Session123");
            System.out.println(userSession2 + ", " + userSession2.hashCode());

            userSession1.logout();
            userSession2.logout();

        }
    }
}
