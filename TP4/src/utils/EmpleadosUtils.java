package utils;

import entidad.Empleado;

import java.util.ArrayList;
import java.util.List;

public class EmpleadosUtils {
    public ArrayList<Empleado> cargarEmpleados() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado("e1","Juan","Perez",32,48));
        empleados.add(new Empleado("e2","Roberto","Hernández",45,57));
        empleados.add(new Empleado("e3","Camila","Gutiérrez",33,51));
        empleados.add(new Empleado("e4","Francisco","Martínez",22,73));
        empleados.add(new Empleado("e5","Benjamín","Núñez",55,15));
        empleados.add(new Empleado("e6","Mateo","Morales",24,33));
        empleados.add(new Empleado("e7","Delfina","López",36,92));
        empleados.add(new Empleado("e8","Catalina","Cruz",51,71));
        empleados.add(new Empleado("e9","Benicio","Montero",48,19));
        empleados.add(new Empleado("e10","Valentino","González",58,22));
        empleados.add(new Empleado("e11","Olivia","Gómez",33,41));
        empleados.add(new Empleado("e12","Martina","Díaz",21,49));
        empleados.add(new Empleado("e13","Joaquín","Cabrera",22,14));
        empleados.add(new Empleado("e14","Bautista","Domínguez",36,33));
        empleados.add(new Empleado("e15","Emilia","Paz",40,16));
        empleados.add(new Empleado("e16","Francesca","Figueroa",43,21));
        empleados.add(new Empleado("e17","Santino","Blanco",25,79));
        empleados.add(new Empleado("e18","Ignacio","Ibarra",61,32));
        empleados.add(new Empleado("e19","Andrea","Chávez",27,78));
        empleados.add(new Empleado("e20","Elena","Mengochea",52,67));
        return empleados;
    }

}
