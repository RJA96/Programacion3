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
    System.out.println("counterGreedyCandidates: " + greedy.getGreedyCounter());
    empleadosUtils.printResult(resolveGreedy);

    System.out.println("Entry 2");
    entry = empleadosUtils.getEntry2();
    System.out.println("Total workforce: " + empleadosUtils.getWorkForce(entry));
    resolveGreedy = greedy.resolveGreedy(entry);
    System.out.println("counterGreedyCandidates: " + greedy.getGreedyCounter());
    empleadosUtils.printResult(resolveGreedy);

    System.out.println("Entry 3");
    entry = empleadosUtils.getEntry3();
    System.out.println("Total workforce: " + empleadosUtils.getWorkForce(entry));
    resolveGreedy = greedy.resolveGreedy(entry);
    System.out.println("counterGreedyCandidates: " + greedy.getGreedyCounter());
    empleadosUtils.printResult(resolveGreedy);

    System.out.println("Entry 4");
    entry = empleadosUtils.getEntry4();
    System.out.println("Total workforce: " + empleadosUtils.getWorkForce(entry));
    resolveGreedy = greedy.resolveGreedy(entry);
    System.out.println("counterGreedyCandidates: " + greedy.getGreedyCounter());
    empleadosUtils.printResult(resolveGreedy);

    System.out.println("Entry 5");
    entry = empleadosUtils.getEntry5();
    System.out.println("Total workforce: " + empleadosUtils.getWorkForce(entry));
    resolveGreedy = greedy.resolveGreedy(entry);
    empleadosUtils.printResult(resolveGreedy);

    System.out.println("Entry 6");
    entry = empleadosUtils.getEntry6();
    System.out.println("Total workforce: " + empleadosUtils.getWorkForce(entry));
    resolveGreedy = greedy.resolveGreedy(entry);
    System.out.println("counterGreedyCandidates: " + greedy.getGreedyCounter());
    empleadosUtils.printResult(resolveGreedy);

    System.out.println("Entry 7");
    entry = empleadosUtils.getEntry7();
    System.out.println("Total workforce: " + empleadosUtils.getWorkForce(entry));
    resolveGreedy = greedy.resolveGreedy(entry);
    System.out.println("counterGreedyCandidates: " + greedy.getGreedyCounter());
    empleadosUtils.printResult(resolveGreedy);

    System.out.println("Entry 8");
    entry = empleadosUtils.getEntry8();
    System.out.println("Total workforce: " + empleadosUtils.getWorkForce(entry));
    resolveGreedy = greedy.resolveGreedy(entry);
    System.out.println("counterGreedyCandidates: " + greedy.getGreedyCounter());
    empleadosUtils.printResult(resolveGreedy);

    System.out.println("Entry 9");
    entry = empleadosUtils.getEntry9();
    System.out.println("Total workforce: " + empleadosUtils.getWorkForce(entry));
    resolveGreedy = greedy.resolveGreedy(entry);
    System.out.println("counterGreedyCandidates: " + greedy.getGreedyCounter());
    empleadosUtils.printResult(resolveGreedy);
  }

}
