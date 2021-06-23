package algorithms;

import entities.Employee;
import java.util.Objects;
import utils.EmployeesUtils;

import java.util.ArrayList;
import java.util.List;

public class Greedy {

  private Integer greedyCounter = 0;

  private final EmployeesUtils employeesUtils = new EmployeesUtils();

  public List<List<Employee>> resolveGreedy(List<Employee> employees) {
    greedyCounter = 0;
    List<Employee> candidates = new ArrayList<>(employees);
    List<List<Employee>> result = new ArrayList();
    List<Employee> employeesGroup1 = new ArrayList<>();
    candidates.sort(Employee::compareTo);
    while (!candidates.isEmpty()) {
      greedyCounter++;
      Employee candidateEmployee = selector(candidates);
      candidates.remove(candidateEmployee);
      if (Objects.nonNull(candidateEmployee) && isSolution(candidateEmployee, employeesGroup1,
          employees)) {

        employeesGroup1.add(candidateEmployee);
      }

    }
    result.add(employeesGroup1);
    result.add(findGroup2(employees, employeesGroup1));

    return result;
  }

  private Employee selector(List<Employee> employees) {
    if (!employees.isEmpty()) {
      return employees.get(0);
    } else {
      return null;
    }
  }

  private Boolean isSolution(Employee e, List<Employee> G1, List<Employee> candidates) {

    candidates.removeAll(G1);
    Integer workForceLeft = employeesUtils.getWorkForce(candidates);
    return workGroupDiff(
        employeesUtils.getWorkForce(G1) + e.getWorkForce(), workForceLeft)
        < workGroupDiff(employeesUtils.getWorkForce(G1), workForceLeft);
  }

  private Integer workGroupDiff(Integer group1, Integer group2) {
    if (group1 > group2) {
      return group1 - group2;
    } else {
      return group2 - group1;
    }
  }

  private List<Employee> findGroup2(
      List<Employee> totalEmployees, List<Employee> groupEmployees) {
    totalEmployees.removeAll(groupEmployees);
    return totalEmployees;
  }

  public Integer getGreedyCounter() {
    return greedyCounter;
  }
}
