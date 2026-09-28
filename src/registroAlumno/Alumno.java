/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registroAlumno;

/**
 *
 * @author Ariadna Yenisey Librado Flores
 */
public class Alumno {
    private String nombre;
    private String matricula;
    private int edad;
    private double[] calificaciones;

    /** Constructor: valida cada dato reutilizando los setters. */
    public Alumno(String nombre, String matricula, int edad, double[] calificaciones) {
        setNombre(nombre);
        setMatricula(matricula);
        setEdad(edad);
        setCalificaciones(calificaciones);
    }

    // Los setters son final porque se llaman desde el constructor
    public final void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        this.nombre = nombre.trim();
    }

    public final void setMatricula(String matricula) {
        if (matricula == null || matricula.trim().isEmpty())
            throw new IllegalArgumentException("La matrícula no puede estar vacía.");
        this.matricula = matricula.trim();
    }

    public final void setEdad(int edad) {
        if (edad <= 0 || edad > 120)
            throw new IllegalArgumentException("La edad debe estar entre 1 y 120.");
        this.edad = edad;
    }

    public final void setCalificaciones(double[] calificaciones) {
        if (calificaciones == null || calificaciones.length == 0)
            throw new IllegalArgumentException("Captura al menos una calificación.");
        for (double c : calificaciones) {
            if (c < 0 || c > 10)
                throw new IllegalArgumentException("Cada calificación debe estar entre 0 y 10.");
        }
        this.calificaciones = calificaciones.clone();
    }

    public String getNombre() { return nombre; }
    public String getMatricula() { return matricula; }
    public int getEdad() { return edad; }

    /** Devuelve true si el alumno tiene 18 años o más. */
    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    /**
     * MÉTODO RECURSIVO: suma las calificaciones desde 'posicion' hasta el final.
     * Caso base: si posicion == longitud del arreglo, devuelve 0.
     * Avance: calificación actual + suma desde posicion + 1.
     */
    public double calcularSuma(int posicion) {
        if (posicion == calificaciones.length) {
            return 0;
        }
        return calificaciones[posicion] + calcularSuma(posicion + 1);
    }

    /** Promedio de las calificaciones, usando la suma recursiva. */
    public double calcularPromedio() {
        return calcularSuma(0) / calificaciones.length;
    }

    /** Aprobado si el promedio es 7 o más. */
    public String determinarSituacion() {
        return calcularPromedio() >= 7 ? "Aprobado" : "Reprobado";
    }

    /** Clasifica el desempeño según el promedio. */
    public String obtenerNivel() {
        double p = calcularPromedio();
        if (p >= 9) return "Excelente";
        if (p >= 8) return "Bueno";
        if (p >= 7) return "Regular";
        return "Bajo";
    }

    /** Texto con todos los datos del alumno para mostrar en pantalla. */
    public String obtenerResumen() {
        return "Nombre: " + nombre
                + "\nMatrícula: " + matricula
                + "\nEdad: " + edad
                + "\nMayor de edad: " + (esMayorDeEdad() ? "Sí" : "No")
                + String.format("\nPromedio: %.2f", calcularPromedio())
                + "\nSituación: " + determinarSituacion()
                + "\nNivel: " + obtenerNivel();
    }
}
