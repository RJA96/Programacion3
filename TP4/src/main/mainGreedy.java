package main;

import algoritmo.Greedy;
import entidad.Empleado;
import utils.EmpleadosUtils;

import java.util.ArrayList;

public class mainGreedy {
    public static void main(String[] args) {
        Greedy greedy = new Greedy();
        EmpleadosUtils empleadosUtils = new EmpleadosUtils();
        ArrayList<Empleado> empleados = empleadosUtils.cargarEmpleados();
        System.out.println(greedy.getFuerzaTrabajo(empleados));
        ArrayList<ArrayList<Empleado>> resolve = greedy.resolveGreedy(empleados);

        resolve.forEach(grupo -> {
            System.out.println("GRUPO N");
            System.out.println(greedy.getFuerzaTrabajo(grupo));
            System.out.println(grupo);
        });
        System.out.println();

    }
}
