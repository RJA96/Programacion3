package algoritmo;

import entidad.Empleado;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Greedy {

    Integer contadorGreedy = 0;

    public ArrayList<ArrayList<Empleado>> resolveGreedy(ArrayList<Empleado> empleados) {
        ArrayList<Empleado> candidatos = new ArrayList<>();
        candidatos.addAll(empleados);
        ArrayList<ArrayList<Empleado>> resultado = new ArrayList();
        ArrayList<Empleado> empleadosGrupo1 = new ArrayList<>();
        candidatos.sort(Empleado::compareTo);
        while (!candidatos.isEmpty()) {
            Empleado empleadoSeleccionado = seleccionar(candidatos);
            candidatos.remove(empleadoSeleccionado);
            if(esFactible(empleadoSeleccionado,empleadosGrupo1, candidatos)) {
                empleadosGrupo1.add(empleadoSeleccionado);
            }
            contadorGreedy++;
        }
        resultado.add(empleados);
        return resultado;
    }

    private Integer getFuerzaTrabajo(List<Empleado> empleados) {
        AtomicReference<Integer> suma = new AtomicReference<>(0);
        empleados.forEach(empleado -> {
            suma.updateAndGet(v -> v + empleado.getFuerzaDeTrabajo());
        });
        return suma.get();
    }
    
    private Empleado seleccionar(ArrayList<Empleado> empleados){
         if (!empleados.isEmpty()) {
             return empleados.get(0);
         } else return null;
    }

    private boolean esFactible(Empleado e, ArrayList<Empleado> G1,ArrayList<Empleado> candidatos){
        Integer fuerzaTrabajoRestante = this.getFuerzaTrabajo(candidatos);
        if (this.getFuerzaTrabajo(G1)+e.getFuerzaDeTrabajo()<fuerzaTrabajoRestante){
            return true;
        }else{
            return false;
        }
    }

    private ArrayList<Empleado> findGrupo2 (ArrayList<Empleado> empleadosTotales, ArrayList<Empleado> empleadosGrupo) {
        empleadosTotales.removeAll(empleadosGrupo);
        return empleadosTotales;
    }
}
