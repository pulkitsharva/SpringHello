package com.pulkitsharva.Spring4Sample;


import java.io.Serializable;

public class GetResponse implements Serializable {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  
}
