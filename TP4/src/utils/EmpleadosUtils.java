package utils;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class EmpleadosUtils {
  public ArrayList<Employee> getTotalEmployees() {
    ArrayList<Employee> employees = new ArrayList<>();
    employees.add(new Employee("e1", "Juan", "Perez", 32, 48));
    employees.add(new Employee("e2", "Roberto", "Hernández", 45, 57));
    employees.add(new Employee("e3", "Camila", "Gutiérrez", 33, 51));
    employees.add(new Employee("e4", "Francisco", "Martínez", 22, 73));
    employees.add(new Employee("e5", "Benjamín", "Núñez", 55, 15));
    employees.add(new Employee("e6", "Mateo", "Morales", 24, 33));
    employees.add(new Employee("e7", "Delfina", "López", 36, 92));
    employees.add(new Employee("e8", "Catalina", "Cruz", 51, 71));
    employees.add(new Employee("e9", "Benicio", "Montero", 48, 19));
    employees.add(new Employee("e10", "Valentino", "González", 58, 22));
    employees.add(new Employee("e11", "Olivia", "Gómez", 33, 41));
    employees.add(new Employee("e12", "Martina", "Díaz", 21, 49));
    employees.add(new Employee("e13", "Joaquín", "Cabrera", 22, 14));
    employees.add(new Employee("e14", "Bautista", "Domínguez", 36, 33));
    employees.add(new Employee("e15", "Emilia", "Paz", 40, 16));
    employees.add(new Employee("e16", "Francesca", "Figueroa", 43, 21));
    employees.add(new Employee("e17", "Santino", "Blanco", 25, 79));
    employees.add(new Employee("e18", "Ignacio", "Ibarra", 61, 32));
    employees.add(new Employee("e19", "Andrea", "Chávez", 27, 78));
    employees.add(new Employee("e20", "Elena", "Mengochea", 52, 67));
    return employees;
  }

  public ArrayList<Employee> getEntry1() {
    ArrayList<Employee> employees = new ArrayList<>();
    employees.add(new Employee("e1", "Juan", "Perez", 32, 48));
    employees.add(new Employee("e2", "Roberto", "Hernández", 45, 57));
    employees.add(new Employee("e3", "Camila", "Gutiérrez", 33, 51));
    employees.add(new Employee("e4", "Francisco", "Martínez", 22, 73));
    employees.add(new Employee("e5", "Benjamín", "Núñez", 55, 15));
    employees.add(new Employee("e6", "Mateo", "Morales", 24, 33));
    return employees;
  }

  public ArrayList<Employee> getEntry2() {
    ArrayList<Employee> employees = new ArrayList<>();
    employees.add(new Employee("e7", "Delfina", "López", 36, 92));
    employees.add(new Employee("e4", "Francisco", "Martínez", 22, 73));
    employees.add(new Employee("e8", "Catalina", "Cruz", 51, 71));
    employees.add(new Employee("e15", "Emilia", "Paz", 40, 16));
    return employees;
  }

  public ArrayList<Employee> getEntry3() {
    ArrayList<Employee> employees = new ArrayList<>();
    employees.add(new Employee("e19", "Andrea", "Chávez", 27, 78));
    employees.add(new Employee("e12", "Martina", "Díaz", 21, 49));
    employees.add(new Employee("e11", "Olivia", "Gómez", 33, 41));
    employees.add(new Employee("e13", "Joaquín", "Cabrera", 22, 14));
    return employees;
  }

  public ArrayList<Employee> getEntry4() {
    ArrayList<Employee> employees = new ArrayList<>();
    employees.add(new Employee("e19", "Andrea", "Chávez", 27, 78));
    employees.add(new Employee("e18", "Ignacio", "Ibarra", 61, 32));
    employees.add(new Employee("e14", "Bautista", "Domínguez", 36, 33));
    employees.add(new Employee("e16", "Francesca", "Figueroa", 43, 21));
    return employees;
  }

  public ArrayList<Employee> getEntry5() {
    ArrayList<Employee> employees = new ArrayList<>();
    employees.add(new Employee("e7", "Delfina", "López", 36, 92));
    employees.add(new Employee("e8", "Catalina", "Cruz", 51, 71));
    employees.add(new Employee("e20", "Elena", "Mengochea", 52, 67));
    employees.add(new Employee("e3", "Camila", "Gutiérrez", 33, 51));
    employees.add(new Employee("e16", "Francesca", "Figueroa", 43, 21));
    return employees;
  }

  public ArrayList<Employee> getEntry6() {
    ArrayList<Employee> employees = new ArrayList<>();
    employees.add(new Employee("e6", "Mateo", "Morales", 24, 33));
    employees.add(new Employee("e15", "Emilia", "Paz", 40, 16));
    employees.add(new Employee("e17", "Santino", "Blanco", 25, 79));
    employees.add(new Employee("e13", "Joaquín", "Cabrera", 22, 14));
    employees.add(new Employee("e16", "Francesca", "Figueroa", 43, 21));
    employees.add(new Employee("e10", "Valentino", "González", 58, 22));
    return employees;
  }
  public ArrayList<Employee> getEntry7() {
    ArrayList<Employee> employees = new ArrayList<>();
    employees.add(new Employee("e17", "Santino", "Blanco", 25, 79));
    employees.add(new Employee("e2", "Roberto", "Hernández", 45, 57));
    employees.add(new Employee("e19", "Andrea", "Chávez", 27, 78));
    employees.add(new Employee("e20", "Elena", "Mengochea", 52, 67));
    employees.add(new Employee("e4", "Francisco", "Martínez", 22, 73));
    employees.add(new Employee("e12", "Martina", "Díaz", 21, 49));
    employees.add(new Employee("e15", "Emilia", "Paz", 40, 16));
    return employees;
  }

  public ArrayList<Employee> getEntry8() {
    ArrayList<Employee> employees = new ArrayList<>();
    employees.add(new Employee("e12", "Martina", "Díaz", 21, 49));
    employees.add(new Employee("e14", "Bautista", "Domínguez", 36, 33));
    employees.add(new Employee("e18", "Ignacio", "Ibarra", 61, 32));
    employees.add(new Employee("e6", "Mateo", "Morales", 24, 33));
    employees.add(new Employee("e2", "Roberto", "Hernández", 45, 57));
    employees.add(new Employee("e9", "Benicio", "Montero", 48, 19));
    employees.add(new Employee("e10", "Valentino", "González", 58, 22));
    employees.add(new Employee("e16", "Francesca", "Figueroa", 43, 21));
    return employees;
  }
  public ArrayList<Employee> getEntry9() {
    return this.getTotalEmployees();
  }
  public Integer getWorkForce(List<Employee> employees) {
    AtomicReference<Integer> total = new AtomicReference<>(0);
    employees.forEach(
        empleado -> {
          total.updateAndGet(v -> v + empleado.getWorkForce());
        });
    return total.get();
  }

  public void printEmploys(List<Employee> employees) {
    employees.forEach(System.out::println);
    System.out.println();
  }

  public void printResult(ArrayList<ArrayList<Employee>> grupos) {
    AtomicReference<Integer> contador = new AtomicReference<>(1);
    grupos.forEach(
        grupo -> {
          System.out.println("Group: " + contador);
          System.out.println("Group workforce: " + getWorkForce(grupo));
          printEmploys(grupo);
          contador.getAndSet(contador.get() + 1);
        });
  }
}
