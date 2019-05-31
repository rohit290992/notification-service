package notification.service.notification;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendNotificationService {

  @Autowired
  SendNotifiacationFactory sendNotifiacationFactory;

  private Map<String, Integer> dailyLimitUserMap = new HashMap<String, Integer>();

  private Map<PlanEnum, List<NotificationEnum>> planNotificationMap =
      new HashMap<PlanEnum, List<NotificationEnum>>();

  private Map<String, PlanEnum> userPlanMap = new HashMap<String, PlanEnum>();

  public void init() {
    planNotificationMap.put(PlanEnum.SILVER, Arrays.asList(NotificationEnum.EMAIL));
    planNotificationMap.put(PlanEnum.GOLD,
        Arrays.asList(NotificationEnum.EMAIL, NotificationEnum.SMS));
    planNotificationMap.put(PlanEnum.PLATINUM, Arrays.asList(NotificationEnum.EMAIL,
        NotificationEnum.SMS, NotificationEnum.PUSH_NOTIFICATION));
  }

  public void sendNotification(String address, String notificationType) throws Exception {
    PlanEnum userPlan = userPlanMap.get(address);
    if (!planNotificationMap.get(userPlan).contains(NotificationEnum.valueOf(notificationType))) {
      throw new Exception("Notification type not allowed with plan");
    }
    Integer sentMessages = dailyLimitUserMap.get(address);
    if (sentMessages >= userPlan.getLimit()) {
      throw new Exception("limit exceeded");
    }
    SendNotification sendNotification = sendNotifiacationFactory
        .getSendNotificationImpl(NotificationEnum.valueOf(notificationType));

    dailyLimitUserMap.put(address, sentMessages + 1);
    try {
      sendNotification.sendNotification(address);
    } catch (Exception e) {
      System.out.println("Exception occured while sending notification");
      dailyLimitUserMap.put(address, dailyLimitUserMap.get(address) - 1);
    }
  }

  public void subscribePlan(String email, String plan) {
    userPlanMap.put(email, PlanEnum.valueOf(plan));
  }

}
