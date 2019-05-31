package notification.service.notification;

import java.io.Serializable;

public class SendNotificationRequest implements Serializable {

  private String address;

  private String notificationType;

  /**
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * @return the notificationType
   */
  public String getNotificationType() {
    return notificationType;
  }

  /**
   * @param notificationType the notificationType to set
   */
  public void setNotificationType(String notificationType) {
    this.notificationType = notificationType;
  }


}
