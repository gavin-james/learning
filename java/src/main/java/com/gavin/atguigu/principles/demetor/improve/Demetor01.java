package com.gavin.atguigu.principles.demetor.improve;

import java.util.ArrayList;
import java.util.List;

public class Demetor01 {
  public static void main(String[] args) {
    SchoolManager schoolManager = new SchoolManager();
    schoolManager.printEmployee(new CollegeManager());

  }
}

// 学校总部员工id
class Employee {
  private int id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}

// 学校员工
class CollegeEmployee {
  private int id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}

// 管理学院员工的管理类
class CollegeManager {
  // 返回学校的所有员工
  public List<CollegeEmployee> getAllEmployee() {
    List<CollegeEmployee> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      CollegeEmployee employee = new CollegeEmployee();
      employee.setId(i);
      list.add(employee);
    }
    return list;

  }

  public void printEmployee() {
    List<CollegeEmployee> allEmployee = this.getAllEmployee();
    allEmployee.stream().map(CollegeEmployee::getId).forEach(System.out::print);
    System.out.println();
  }
}

// 学校管理类
class SchoolManager {

  // 返回学校总部的员工
  public List<Employee> getAllEmployee() {
    List<Employee> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      Employee employee = new Employee();
      employee.setId(i);
      list.add(employee);
    }
    return list;
  }

  public void printEmployee(CollegeManager collegeManager) {
    collegeManager.printEmployee();
    System.out.println("-----------------------------------");
    List<Employee> allEmployee1 = this.getAllEmployee();
    allEmployee1.stream().map(Employee::getId).forEach(System.out::print);


  }
}