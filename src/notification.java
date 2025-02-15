import java.util.ArrayList;
import java.util.List;

public class notification {
     private String message;
    private static notification instance;
    private List<String> notifications;
    
    // Private constructor for Singleton pattern
    private notification(String message) {
         this.message = message;
        notifications = new ArrayList<>();
    }
    
    // Get the single instance of NotificationManager
    public static notification getInstance() {
        if (instance == null) {
            instance = new notification("");
        }
        return instance;
    }
    
    // Add a new notification to the list
    public void addNotification(String message) {
        notifications.add(message);
    }
    
    // Get all notifications
    public List<String> getNotifications() {
        return notifications;
    }
    
    // Clear notifications (optional)
    public void clearNotifications() {
        notifications.clear();
    }
    public String getMessage() {
        return message;
}
}
