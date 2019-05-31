package notification.service.notification;

import org.springframework.beans.factory.annotation.Autowired;

public class SendNotifiacationFactory {

  @Autowired
  SendNotificationEmailImpl sendNotificationEmailImpl;

  @Autowired
  SendPushNotificationImpl sendPushNotificationImpl;

  @Autowired
  SendNotificationSMSImpl sendNotificationSMSImpl;

  public SendNotification getSendNotificationImpl(NotificationEnum notificationEnum) {
    SendNotification sendNotification = null;
    if (notificationEnum == NotificationEnum.EMAIL) {
      sendNotification = sendNotificationEmailImpl;
    } else if (notificationEnum == NotificationEnum.PUSH_NOTIFICATION) {
      sendNotification = sendPushNotificationImpl;
    } else if (notificationEnum == NotificationEnum.SMS) {
      sendNotification = sendNotificationSMSImpl;
    }
    return sendNotification;
  }
}
