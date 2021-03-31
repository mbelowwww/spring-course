package com.luxoft.springioc.lab3.model;

public interface Person {
  String getName();

  void setName(String name);

  boolean isRegistered();

  void setRegistered(boolean isRegistered);

  void sayHello(Person person);
}