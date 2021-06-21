package main;

import algorithms.Greedy;
import entities.Employee;
import utils.EmpleadosUtils;

import java.util.ArrayList;

public class mainGreedy {
  public static void main(String[] args) {
    Greedy greedy = new Greedy();
    EmpleadosUtils empleadosUtils = new EmpleadosUtils();
    System.out.println("Entry 1");
    ArrayList<Employee> entry = empleadosUtils.getEntry1();
    System.out.println("Total workforce: " + empleadosUtils.getWorkForce(entry));
    ArrayList<ArrayList<Employee>> resolveGreedy = greedy.resolveGreedy(entry);
    empleadosUtils.printResult(resolveGreedy);

    System.out.println("Entry 2");
    entry = empleadosUtils.getEntry2();
    System.out.println("Total workforce: " + empleadosUtils.getWorkForce(entry));
    resolveGreedy = greedy.resolveGreedy(entry);
    empleadosUtils.printResult(resolveGreedy);

    System.out.println("Entry 3");
    entry = empleadosUtils.getEntry3();
    System.out.println("Total workforce: " + empleadosUtils.getWorkForce(entry));
    resolveGreedy = greedy.resolveGreedy(entry);
    empleadosUtils.printResult(resolveGreedy);

    System.out.println("Entry 4");
    entry = empleadosUtils.getEntry4();
    System.out.println("Total workforce: " + empleadosUtils.getWorkForce(entry));
    resolveGreedy = greedy.resolveGreedy(entry);
    empleadosUtils.printResult(resolveGreedy);

    System.out.println("Entry 5");
    entry = empleadosUtils.getEntry4();
    System.out.println("Total workforce: " + empleadosUtils.getWorkForce(entry));
    resolveGreedy = greedy.resolveGreedy(entry);
    empleadosUtils.printResult(resolveGreedy);
  }
}
