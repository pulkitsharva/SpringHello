package com.shhh.spring.dto;

import java.io.Serializable;
import java.util.Date;

public class Response implements Serializable {
  
  private String status;
  
  private Date timestamp;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }
  
  

}
