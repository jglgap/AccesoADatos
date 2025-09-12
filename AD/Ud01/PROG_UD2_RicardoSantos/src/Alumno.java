public class Alumno {
    private String name;
    private int age;
    private double height;

    // constructor
    public Alumno(String name, int age, double altura) {
        this.name = name;
        this.age = age;
        this.height = altura;
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    //toString
    @Override
    public String toString() {
        return "Nombre = " + this.getName() + " estatura = " + this.getHeight() + " edad = " +  this.getAge();
    }
}
