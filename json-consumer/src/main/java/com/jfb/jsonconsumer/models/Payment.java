package com.jfb.jsonconsumer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
@Entity
public class Payment implements Serializable {

  @Id
  private Long id;
  private Long idUser;
  private Long idProduct;
  private String cardNumber;

}
