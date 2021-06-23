package main;

import algorithms.BackTracking;
import entities.Employee;
import utils.EmployeesUtils;

import java.util.List;

public class mainBackTracking {

  public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
  public static final String ANSI_RESET = "\u001B[0m";

  public static void main(String[] args) {
    BackTracking backTracking = new BackTracking();
    EmployeesUtils employeesUtils = new EmployeesUtils();
    System.out.println(ANSI_PURPLE_BACKGROUND + "Entry 1" + ANSI_RESET);
    List<Employee> entry = employeesUtils.getEntry1();
    System.out.println("Total workforce: " + employeesUtils.getWorkForce(entry));
    List<List<Employee>> resolveBackTracking = backTracking.resolveBackTracking(entry);
    employeesUtils.printResult(resolveBackTracking);

    System.out.println(ANSI_PURPLE_BACKGROUND + "Entry 2" + ANSI_RESET);
    entry = employeesUtils.getEntry2();
    System.out.println("Total workforce: " + employeesUtils.getWorkForce(entry));
    resolveBackTracking = backTracking.resolveBackTracking(entry);
    System.out.println();
    employeesUtils.printResult(resolveBackTracking);

    System.out.println(ANSI_PURPLE_BACKGROUND + "Entry 3" + ANSI_RESET);
    entry = employeesUtils.getEntry3();
    System.out.println("Total workforce: " + employeesUtils.getWorkForce(entry));
    resolveBackTracking = backTracking.resolveBackTracking(entry);
    System.out.println();
    employeesUtils.printResult(resolveBackTracking);

    System.out.println(ANSI_PURPLE_BACKGROUND + "Entry 4" + ANSI_RESET);
    entry = employeesUtils.getEntry4();
    System.out.println("Total workforce: " + employeesUtils.getWorkForce(entry));
    resolveBackTracking = backTracking.resolveBackTracking(entry);
    System.out.println();
    employeesUtils.printResult(resolveBackTracking);

    System.out.println(ANSI_PURPLE_BACKGROUND + "Entry 5" + ANSI_RESET);
    entry = employeesUtils.getEntry5();
    System.out.println("Total workforce: " + employeesUtils.getWorkForce(entry));
    resolveBackTracking = backTracking.resolveBackTracking(entry);
    System.out.println();
    employeesUtils.printResult(resolveBackTracking);

    System.out.println(ANSI_PURPLE_BACKGROUND + "Entry 6" + ANSI_RESET);
    entry = employeesUtils.getEntry6();
    System.out.println("Total workforce: " + employeesUtils.getWorkForce(entry));
    resolveBackTracking = backTracking.resolveBackTracking(entry);
    System.out.println();
    employeesUtils.printResult(resolveBackTracking);

    System.out.println(ANSI_PURPLE_BACKGROUND + "Entry 7" + ANSI_RESET);
    entry = employeesUtils.getEntry7();
    System.out.println("Total workforce: " + employeesUtils.getWorkForce(entry));
    resolveBackTracking = backTracking.resolveBackTracking(entry);
    System.out.println();
    employeesUtils.printResult(resolveBackTracking);

    System.out.println(ANSI_PURPLE_BACKGROUND + "Entry 8" + ANSI_RESET);
    entry = employeesUtils.getEntry8();
    System.out.println("Total workforce: " + employeesUtils.getWorkForce(entry));
    resolveBackTracking = backTracking.resolveBackTracking(entry);
    System.out.println();
    employeesUtils.printResult(resolveBackTracking);

    System.out.println(ANSI_PURPLE_BACKGROUND + "Entry 9" + ANSI_RESET);
    entry = employeesUtils.getEntry9();
    System.out.println("Total workforce: " + employeesUtils.getWorkForce(entry));
    resolveBackTracking = backTracking.resolveBackTracking(entry);
    System.out.println();
    employeesUtils.printResult(resolveBackTracking);
  }
}
