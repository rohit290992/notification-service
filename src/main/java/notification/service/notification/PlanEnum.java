package notification.service.notification;

public enum PlanEnum {

  SILVER(49, 1000000), GOLD(99, 10000000), PLATINUM(500, 0);
  private Integer cost;

  private Integer limit;

  PlanEnum(Integer cost, Integer limit) {
    this.cost = cost;
    this.limit = limit;
  }

  /**
   * @return the cost
   */
  public Integer getCost() {
    return cost;
  }

  /**
   * @param cost the cost to set
   */
  public void setCost(Integer cost) {
    this.cost = cost;
  }

  /**
   * @return the limit
   */
  public Integer getLimit() {
    return limit;
  }

  /**
   * @param limit the limit to set
   */
  public void setLimit(Integer limit) {
    this.limit = limit;
  }

}
