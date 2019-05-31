package notification.service.notification;

import org.springframework.stereotype.Service;

@Service
public class SendNotificationEmailImpl implements SendNotification {

  public void sendNotification(String address) throws Exception {
    System.out.println("Email Notification sent at " + address);
  }

}
