package algoritmo;

import entidad.Empleado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Greedy {

    Integer contadorGreedy;
    public List<ArrayList<Empleado>> resolveGreedy(ArrayList<Empleado> empleados) {
        ArrayList<ArrayList<Empleado>> resultado = new ArrayList();
        ArrayList<Empleado> empleadosGrupo1 = new ArrayList<>();
        empleados.sort(Empleado::compareTo);
        Collections.reverse(empleados);
        while (!empleados.isEmpty()) {
            if ()
        }
        resultado.add(empleados);
        return resultado;
    }

    private Integer getFuerzaTrabajo(List<Empleado> empleados) {

    }

}
