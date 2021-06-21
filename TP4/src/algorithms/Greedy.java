package algorithms;

import entities.Employee;
import utils.EmpleadosUtils;

import java.util.ArrayList;

public class Greedy {

  private Integer greedyCounter = 0;

  private final EmpleadosUtils empleadosUtils = new EmpleadosUtils();

  public ArrayList<ArrayList<Employee>> resolveGreedy(ArrayList<Employee> employees) {
    greedyCounter = 0;
    ArrayList<Employee> candidatos = new ArrayList<>(employees);
    ArrayList<ArrayList<Employee>> resultado = new ArrayList();
    ArrayList<Employee> empleadosGrupo1 = new ArrayList<>();
    candidatos.sort(Employee::compareTo);
    while (!candidatos.isEmpty()) {
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

  private Employee seleccionar(ArrayList<Employee> employees) {
    if (!employees.isEmpty()) {
      return employees.get(0);
    } else return null;
  }

  private boolean esFactible(Employee e, ArrayList<Employee> G1, ArrayList<Employee> candidatos) {
    greedyCounter++;
    candidatos.removeAll(G1);
    Integer fuerzaTrabajoRestante = empleadosUtils.getWorkForce(candidatos);
    if (diferenciaFuerzaDeTrabajo(
            empleadosUtils.getWorkForce(G1) + e.getWorkForce(), fuerzaTrabajoRestante)
        < diferenciaFuerzaDeTrabajo(empleadosUtils.getWorkForce(G1), fuerzaTrabajoRestante)) {
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

  private ArrayList<Employee> findGrupo2(
      ArrayList<Employee> empleadosTotales, ArrayList<Employee> empleadosGrupo) {
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
