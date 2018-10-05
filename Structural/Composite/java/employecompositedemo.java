package javaapplication10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class employecompositedemo {
  
  
  
  public static void main(String[] args) {
 Employee emp1=new Developer("per1", 10000);
  Employee emp2=new Developer("per2", 15000);
  Employee manager1=new Manager("per3",25000);
  manager1.add(emp1);
  manager1.add(emp2);
  Employee emp3=new Developer("per4", 20000);
  Manager generalManager=new Manager("per4", 50000);
  generalManager.add(emp3);
  generalManager.add(manager1);
  generalManager.print();
 }   
  }
  