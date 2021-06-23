package algorithms;

import entities.Employee;
import utils.EmployeesUtils;

import java.util.ArrayList;
import java.util.List;

public class Greedy {

  private Integer greedyCounter = 0;

  private final EmployeesUtils employeesUtils = new EmployeesUtils();

  public List<List<Employee>> resolveGreedy(List<Employee> employees) {
    greedyCounter = 0;
    List<Employee> candidatos = new ArrayList<>(employees);
    List<List<Employee>> resultado = new ArrayList();
    List<Employee> empleadosGrupo1 = new ArrayList<>();
    candidatos.sort(Employee::compareTo);
    while (!candidatos.isEmpty()) {
      greedyCounter++;
      Employee employeeSeleccionado = seleccionar(candidatos);
      candidatos.remove(employeeSeleccionado);
      if (esFactible(employeeSeleccionado, empleadosGrupo1, employees)) {

        empleadosGrupo1.add(employeeSeleccionado);
      }

    }
    resultado.add(empleadosGrupo1);
    resultado.add(findGrupo2(employees, empleadosGrupo1));

    return resultado;
  }

  private Employee seleccionar(List<Employee> employees) {
    if (!employees.isEmpty()) {
      return employees.get(0);
    } else return null;
  }

  private boolean esFactible(Employee e, List<Employee> G1, List<Employee> candidatos) {

    candidatos.removeAll(G1);
    Integer fuerzaTrabajoRestante = employeesUtils.getWorkForce(candidatos);
    if (diferenciaFuerzaDeTrabajo(
            employeesUtils.getWorkForce(G1) + e.getWorkForce(), fuerzaTrabajoRestante)
        < diferenciaFuerzaDeTrabajo(employeesUtils.getWorkForce(G1), fuerzaTrabajoRestante)) {
        return true;
    } else {
      return false;
    }
  }

  private Integer diferenciaFuerzaDeTrabajo(Integer grupo1, Integer grupo2) {
    if (grupo1 > grupo2) {
      return grupo1 - grupo2;
    } else {
      return grupo2 - grupo1;
    }
  }

  private List<Employee> findGrupo2(
      List<Employee> empleadosTotales, List<Employee> empleadosGrupo) {
    empleadosTotales.removeAll(empleadosGrupo);
    return empleadosTotales;
  }

  public Integer getGreedyCounter() {
    return greedyCounter;
  }

  public void setGreedyCounter(Integer greedyCounter) {
    this.greedyCounter = greedyCounter;
  }
}
