package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

import grafo.Grafo;

public class DFS {

    private Grafo<?, ?> grafo;
    private HashMap<Integer, String> colores;
    private Integer origen;
    private Integer destino;
    private Integer kmRecorridos;
    private Mapa mapa;
    private Integer cantidadMaximaDeBalanzas;

    /**
     * O(1) setea los valores al objeto e inicializa el hashMap
     */
    public DFS(Grafo<?, ?> grafo, Integer origen, Integer destino, Mapa mapa, Integer cantidadMaximaDeBalanzas) {
        this.grafo = grafo;
        this.colores = new HashMap<>();
        this.origen = origen;
        this.destino = destino;
        this.kmRecorridos = 0;
        this.mapa = mapa;
        this.cantidadMaximaDeBalanzas = cantidadMaximaDeBalanzas;
    }

    /**
     * O(N+M) Siendo N = Vertices y M = Arcos
     */
    public HashMap<ArrayList<Integer>, Integer> dfs() {
        Iterator<Integer> it = this.grafo.obtenerVertices();
        HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();
        while (it.hasNext()) {
            Integer verticeId = it.next();
            colores.put(verticeId, "blanco");
        }
        ArrayList<Integer> caminoCorrecto = caminoCorrecto(this.origen, kmRecorridos);
        if (Objects.nonNull(caminoCorrecto)) {
            map.put(caminoCorrecto, kmRecorridos);
        }
        return map;
    }

    private ArrayList<Integer> caminoCorrecto(Integer vertice, Integer kilometros) {
        ArrayList<ArrayList<Integer>> caminoFinal = getCaminos(vertice, kilometros, 0);
        if (!caminoFinal.isEmpty()) {
            return caminoFinal.get(caminoFinal.size() - 1);
        } else return null;
    }

    /**
     * O(N+M) Siendo N = Vertices y M = Arcos
     */
    private ArrayList<ArrayList<Integer>> getCaminos(Integer vertice, Integer kilometros, Integer balanza) {
        ArrayList<ArrayList<Integer>> resultado = new ArrayList<>();
        colores.put(vertice, "amarillo");
        if ((vertice.equals(this.destino))
                && balanza <= cantidadMaximaDeBalanzas) {
            if (((kmRecorridos >= kilometros) || (kmRecorridos.equals(0)))) {
                ArrayList<Integer> unicoCamino = new ArrayList<>();
                unicoCamino.add(vertice);
                resultado.add(unicoCamino);
                kmRecorridos = kilometros;
            }
        } else {
            Iterator<Integer> it = this.grafo.obtenerAdyacentes(vertice);
            while (it.hasNext()) {
                Integer adyacente = it.next();
                if (colores.get(adyacente).equals("blanco")) {
                    kilometros += getEtiquetaArco(vertice, adyacente);
                    if (haveBalanza(vertice)&&!vertice.equals(origen)) {
                        balanza++;
                    }
                    ArrayList<ArrayList<Integer>> caminosParciales = getCaminos(adyacente, kilometros, balanza);
                    kilometros -= getEtiquetaArco(vertice, adyacente);
                    if (haveBalanza(vertice)) {
                        balanza--;
                    }
                    if (kilometros <= kmRecorridos && !caminosParciales.isEmpty()) {
                        for (ArrayList<Integer> caminoParcial : caminosParciales) {
                            ArrayList<Integer> caminoCompleto = new ArrayList<>();
                            caminoCompleto.add(vertice);
                            caminoCompleto.addAll(caminoParcial);
                            resultado.add(caminoCompleto);
                        }
                    }
                }
            }
        }
        colores.put(vertice, "blanco");
        return resultado;
    }


    /**
     * Complejidad: O(N + M) Siendo N = cantidadDeVertices y M = cantidadDeArcos.
     */
    private Integer getEtiquetaArco(Integer verticeId, Integer verticeId2) {
        return (Integer) this.grafo.obtenerArco(verticeId, verticeId2);
    }

    /**
     * Complejidad: O(1) Obtiene el boolean de la ciudad accediendo al hashmap por Id
     */
    private Boolean haveBalanza(Integer verticeId) {
        return mapa.getCiudad(verticeId).isTieneBalanza();
    }
}
