package notification.service.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {

  @Autowired
  SendNotificationService sendNotificationService;

  @PostMapping(path = "/sendNotification", consumes = "application/json")
  public ResponseEntity<String> sendNotification(
      @RequestBody SendNotificationRequest sendnotificationRequest) {
    return ResponseEntity.ok().body(sendNotificationService.sendNotification(
        sendnotificationRequest.getAddress(), sendnotificationRequest.getNotificationType()));
  }

  @PostMapping(path = "/subscribe", consumes = "application/json")
  public ResponseEntity<String> subscribe(
      @RequestBody SubscribeRequest subscribeRequest) {
    return ResponseEntity.ok()
        .body(sendNotificationService.subscribePlan(subscribeRequest.getEmail(), subscribeRequest.getPlan());
  }
}
