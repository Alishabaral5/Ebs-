import java.util.LinkedList;
import java.util.Queue;

public class notification {
    private static notification instance;
    private Queue<String> notifications; // Queue to store notifications

    private notification() {
        notifications = new LinkedList<>();
    }

    // Singleton pattern to access the instance of NotificationManager
    public static notification getInstance() {
        if (instance == null) {
            instance = new notification();
        }
        return instance;
    }

    // Add a new notification to the queue
    public void addNotification(String message) {
        notifications.add(message);
    }

    // Get the latest notification (and remove it from the queue)
    public String getLatestNotification() {
        return notifications.poll();
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author acer
 */
