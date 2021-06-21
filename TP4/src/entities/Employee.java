package entities;

public class Employee implements Comparable{
    String id;
    String name;
    String lastName;
    Integer age;
    Integer workForce;

    public Employee(String id, String name, String lastName, Integer age, Integer workForce) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.workForce = workForce;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id='" + id + '\'' +
                ", nombre='" + name + '\'' +
                ", apellido='" + lastName + '\'' +
                ", edad=" + age +
                ", fuerzaDeTrabajo=" + workForce +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWorkForce() {
        return workForce;
    }

    public void setWorkForce(Integer workForce) {
        this.workForce = workForce;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.workForce,((Employee) o).workForce);
    }
}
