package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import grafo.Grafo;
import grafo.GrafoNoDirigido;

public class Mapa {


    private Grafo<String, Integer> grafo;
    private HashMap<Integer, Ciudad> ciudades;

    /**
     * O(1) inicializa grafos y ciudades
     */
    public Mapa() {
        this.grafo = new GrafoNoDirigido<>();
        this.ciudades = new HashMap<>();
    }

    /**
     * O()
     */
    public void addCiudad(Ciudad ciudad) {
        this.ciudades.put(ciudad.getId(), ciudad);
        this.grafo.agregarVertice(ciudad.getId(), ciudad.getNombre());
    }

    /**
     * O()
     */
    public void borrarCiudad(Ciudad ciudad) {
        this.grafo.borrarVertice(ciudad.getId());
        this.ciudades.remove(ciudad.getId());
    }

    /**
     * O()
     */
    public void addRuta(Ciudad origen, Ciudad destino, int kilometros) {
        this.grafo.agregarArco(origen.getId(), destino.getId(), kilometros);
    }

    /**
     * O()
     */
    public void borrarRuta(Ciudad origen, Ciudad destino) {
        this.grafo.borrarArco(origen.getId(), destino.getId());
    }

    /**
     * O()
     */
    public List<String> encontrarCamino(Ciudad origen, Ciudad destino, Integer cantidadBalanzas) {
        DFS dfs = new DFS(grafo, origen.getId(), destino.getId(), this, cantidadBalanzas);
        HashMap<ArrayList<Integer>, Integer> mapCaminoKilometros = dfs.dfs();
        Optional<ArrayList<Integer>> camino = mapCaminoKilometros.keySet().stream().findFirst();
        System.out.println("Camino de " + origen + " hasta " + destino);
        if (camino.isPresent()) {
            System.out.println("Kilometros: " + mapCaminoKilometros.get(camino.get()));
            return fromIdToName(camino);
        } else {
            System.out.println("No Encontrado");
            return new ArrayList<>();
        }
    }

    /**
     * O(1) retorna la ciudad por un Id pasado por parametros
     */
    public Ciudad getCiudad(Integer id) {
        return ciudades.get(id);
    }

    /**
     * O(N), Siendo N el tamaño de la lista "ids" pasada por parametro.
     */
    private List<String> fromIdToName(Optional<ArrayList<Integer>> ids) {
        AtomicReference<List<String>> names = new AtomicReference<>(new ArrayList<>());
        ids.ifPresent(id -> id.forEach(idCiudad -> names.get().add(getCiudad(idCiudad).getNombre())));
        return names.get();
    }
}
