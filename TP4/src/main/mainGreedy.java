package main;

import algoritmo.Greedy;
import entidad.Empleado;
import utils.EmpleadosUtils;

import java.util.ArrayList;
import java.util.List;

public class mainGreedy {
    public static void main(String[] args) {
        Greedy greedy = new Greedy();
        EmpleadosUtils empleadosUtils = new EmpleadosUtils();
        ArrayList<Empleado> empleados = empleadosUtils.cargarEmpleados();
        System.out.println(greedy.resolveGreedy(empleados));

    }
}
