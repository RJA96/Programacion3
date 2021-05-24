package grafo;

public class Arco<V> {

    private int verticeOrigen;
    private int verticeDestino;
    private V etiqueta;

    public Arco(int verticeOrigen, int verticeDestino, V etiqueta) {
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.etiqueta = etiqueta;
    }

    //O(1) obtiene el valor de vertice
    public int getVerticeOrigen() {
        return verticeOrigen;
    }

    //O(1) obtiene el valor de vertice
    public int getVerticeDestino() {
        return verticeDestino;
    }

    //O(1) obtiene el valor de etiqueta
    public V getEtiqueta() {
        return etiqueta;
    }

    //O(1) devuelve ambos vertices y sus etiquetas
    @Override
    public String toString() {
        return "Arco{" +
                "verticeOrigen=" + verticeOrigen +
                ", verticeDestino=" + verticeDestino +
                ", etiqueta=" + etiqueta +
                '}';
    }
}
