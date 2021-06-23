package algorithms;

import entities.Employee;
import utils.EmployeesUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BackTracking {

  EmployeesUtils employeesUtils = new EmployeesUtils();
  private int bestDifference = -1;
  private List<Employee> group1;
  private final List<Employee> visit = new ArrayList<>();
  private List<Employee> allEmployees;
  int count = 0;

  public List<List<Employee>> resolveBackTracking(List<Employee> employees) {
    //reset
    group1 = new ArrayList<>();
    allEmployees = new ArrayList<>();
    count = 0;
    bestDifference = -1;

    List<List<Employee>> resolve = new ArrayList();
    List<Employee> g1 = new ArrayList<>();
    allEmployees = employees;
    resolverBacktracking(employees.get(0), g1);

    g1 = group1;
    resolve.add(g1);
    resolve.add(findGroup2(g1));
    System.out.println("Backtracking count: " + count);
    return resolve;
  }

  private void resolverBacktracking(Employee e, List<Employee> candidates) {
    count++;
    List<Employee> group2 = findGroup2(candidates);
    Integer workForceGroup2 = employeesUtils.getWorkForce(group2);
    if (finalState(e, candidates, workForceGroup2)) {
      if (checkSolution(workForceGroup2, candidates)) {
        group1 = new ArrayList<>();
        group1.addAll(candidates);
      }
    } else {
      for (Employee next : allEmployees) {
        if (!visit.contains(next)
            && !candidates.contains(next)) {
          candidates.add(next);
          visit.add(next);
          if (employeesUtils.getWorkForce(candidates).equals(employeesUtils.getWorkForce(group2))) {
            break;
          }
          resolverBacktracking(next, candidates);
          candidates.remove(next);
        }
      }
    }
    visit.clear();
  }

  private List<Employee> findGroup2(List<Employee> employees) {
    List<Employee> employeesGroup2 = new ArrayList<>(allEmployees);
    employeesGroup2.removeAll(employees);
    return employeesGroup2;
  }

  private boolean finalState(Employee employee, List<Employee> group1, Integer forceGroup2) {
    if (Objects.nonNull(employee)) {
      return (employeesUtils.getWorkForce(group1) + employee.getWorkForce()) >= forceGroup2;
    } else {
      return false;
    }
  }

  private Boolean checkSolution(Integer forceGroup2, List<Employee> group1) {
    int workForceGroup1 = employeesUtils.getWorkForce(group1);
    int dif = forceGroup2 - workForceGroup1;
    if (dif < 0) {
      dif = workForceGroup1 - forceGroup2;
    }
    if (bestDifference > dif || bestDifference == -1) {
      bestDifference = dif;
      return true;
    }
    return false;
  }
}
