package ej2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Persona implements Serializable{

        private String nombre;
        private int edad;
        private String nacionalidad;


        public Persona(String name, int age, String nationality){

            this.nombre = name;
            this.edad = age;
            this.nacionalidad = nationality;

        }

        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getEdad() {
            return edad;
        }
        public void setEdad(int edad) {
            this.edad = edad;
        }

        public String getNacionalidad() {
            return nacionalidad;
        }
        public void setNacionalidad(String nacionalidad) {
            this.nacionalidad = nacionalidad;
        }

     @Override
     public String toString() {
        return this.nombre + this.edad + this.nacionalidad;
     }

}
