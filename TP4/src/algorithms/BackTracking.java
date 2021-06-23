package algorithms;

import entities.Employee;
import utils.EmployeesUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class BackTracking {
  EmployeesUtils employeesUtils = new EmployeesUtils();
  private int bestDifference = -1;
  private List<Employee> mejorGrupo;
  private final List<Employee> visitados = new ArrayList<>();
  private List<Employee> todosEmpleados;
  int contador = 0;

  public List<List<Employee>> resolveBackTracking(List<Employee> employees) {
    int i = 0;
    mejorGrupo = new ArrayList<>();
    todosEmpleados = new ArrayList<>();
    contador = 0;
    bestDifference = -1;

    List<List<Employee>> mejorSolucion = new ArrayList();
    List<Employee> g1 = new ArrayList<>();
    todosEmpleados = employees;
    List<Employee> finalG = g1;
    resolverBacktracking(employees.get(0), finalG);

    g1 = mejorGrupo;
    mejorSolucion.add(g1);
    mejorSolucion.add(findGrupo2(g1));
    System.out.println(contador);
    return mejorSolucion;
  }

  private void resolverBacktracking(Employee e, List<Employee> solucionG1) {
    contador++;
    List<Employee> g2 = findGrupo2(solucionG1);
    int fuerzaGrupoRestate = employeesUtils.getWorkForce(g2);
    if (es_estado_final(e, solucionG1, fuerzaGrupoRestate)) { // Si esta equitativo
      if (mejor_solucion(fuerzaGrupoRestate, solucionG1)) { // Si es la mejor solución
        operar_solucion(solucionG1);
      }
    } else {
      // obtengo los empleados
      for (Employee siguiente : todosEmpleados) { // por cada empleado
        if (!visitados.contains(siguiente)
            && !solucionG1.contains(siguiente)) { // restricción de re-visita
          solucionG1.add(siguiente); // aplicó cambios lo agrego al grupo1 y lo eliminó de empleado
          visitados.add(siguiente);
          if (employeesUtils.getWorkForce(solucionG1).equals(employeesUtils.getWorkForce(g2))) {
            break;
          }

          resolverBacktracking(siguiente, solucionG1); // Llamar recursivamente
          solucionG1.remove(
              siguiente); // deshago los cambios, vuelvo a agregar al empleado en empleados y
                          // eliminar de grupo 1
        }
      }
    }
    visitados.clear();
  }

  private Iterator<Employee> generarEstado() {
    List<Employee> empleados = todosEmpleados;
    return empleados.iterator();
  }

  private List<Employee> findGrupo2(List<Employee> employees) {
    List<Employee> empleados = new ArrayList<>();
    empleados.addAll(todosEmpleados);
    empleados.removeAll(employees);
    return empleados;
  }

  private boolean es_estado_final(Employee empleado, List<Employee> grupo1, int fG2) {
    if (Objects.nonNull(empleado)) {
      int auxSuma = employeesUtils.getWorkForce(grupo1) + empleado.getWorkForce();
      if (auxSuma >= fG2) {
        return true;
      } else return false;
    } else return false;
  }

  private boolean mejor_solucion(int fG2, List<Employee> grupo1) {
    int fuerzaGrupo1 = employeesUtils.getWorkForce(grupo1);
    int diferencia = fG2 - fuerzaGrupo1;
    if (diferencia < 0) {
      diferencia = fuerzaGrupo1 - fG2;
    }
    if (bestDifference > diferencia || bestDifference == -1) {
      bestDifference = diferencia;
      return true;
    }
    return false;
  }

  private void operar_solucion(List<Employee> employeeList) {
    mejorGrupo = new ArrayList<>();
    mejorGrupo.addAll(employeeList);
  }
}
