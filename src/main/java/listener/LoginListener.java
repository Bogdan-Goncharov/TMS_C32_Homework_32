package listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebListener
public class LoginListener implements HttpSessionAttributeListener {

    private static final String LOG_FILE = "\"C:\\Users\\user.WIN-KLKMDAT4B5D\\IdeaProjects\\TMS_C32_Homework_25\\src\\main\\resources\\logs.txt\"";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if ("user".equals(event.getName())) {
            User user = (User) event.getValue();
            String logMessage = String.format("[%s] User logged in: %s with role %s%n",
                    LocalDateTime.now().format(DATE_FORMATTER), user.getUsername(), user.getRole());
            logToFile(logMessage);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if ("user".equals(event.getName())) {
            User user = (User) event.getValue();
            String logMessage = String.format("[%s] User logged out: %s%n",
                    LocalDateTime.now().format(DATE_FORMATTER), user.getUsername());
            logToFile(logMessage);
        }
    }

    private void logToFile(String message) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}