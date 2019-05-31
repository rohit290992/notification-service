package notification.service.notification;

import org.springframework.stereotype.Service;

@Service
public class SendNotificationSMSImpl implements SendNotification {

  public void sendNotification(String address) throws Exception {
    System.out.println("SMS has been sent at" + address);
  }

}
