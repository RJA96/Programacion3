package entidad;

public class Empleado implements Comparable{
    String id;
    String nombre;
    String apellido;
    Integer edad;
    Integer fuerzaDeTrabajo;

    public Empleado(String id, String nombre, String apellido, Integer edad, Integer fuerzaDeTrabajo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fuerzaDeTrabajo = fuerzaDeTrabajo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", fuerzaDeTrabajo=" + fuerzaDeTrabajo +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getFuerzaDeTrabajo() {
        return fuerzaDeTrabajo;
    }

    public void setFuerzaDeTrabajo(Integer fuerzaDeTrabajo) {
        this.fuerzaDeTrabajo = fuerzaDeTrabajo;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.fuerzaDeTrabajo,((Empleado) o).fuerzaDeTrabajo);
    }
}
