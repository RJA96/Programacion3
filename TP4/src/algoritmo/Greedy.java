package algoritmo;

import entidad.Empleado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Greedy {

    public List<ArrayList<Empleado>> resolveGreedy(ArrayList<Empleado> empleados, Integer contadorGreedy) {
        ArrayList<ArrayList<Empleado>> resultado = new ArrayList();
        empleados.sort(Empleado::compareTo);
        Collections.reverse(empleados);
        resultado.add(empleados);
        return resultado;
    }


}
