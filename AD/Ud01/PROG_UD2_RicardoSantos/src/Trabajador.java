public class Trabajador {

    private String name;
    private double salary;


    //constructor
    public Trabajador(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    //setters and getters
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    //methods

    public void incrementSalary() {
        if (this.salary<1000) {
            this.salary = this.salary + (this.salary*0.15);
        } else {
            this.salary = this.salary + (this.salary*0.12);
        }
    }

}
