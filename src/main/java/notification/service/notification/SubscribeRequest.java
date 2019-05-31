package notification.service.notification;

import java.io.Serializable;

public class SubscribeRequest implements Serializable {

  private String email;

  private String plan;

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the plan
   */
  public String getPlan() {
    return plan;
  }

  /**
   * @param plan the plan to set
   */
  public void setPlan(String plan) {
    this.plan = plan;
  }

}
