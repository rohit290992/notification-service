package notification.service.notification;

import org.springframework.stereotype.Service;

@Service
public class SendPushNotificationImpl implements SendNotification {

  public void sendNotification(String address) throws Exception {
    System.out.println("Push notification sent at " + address);
  }

}
