/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registroAlumno;

/**
 *
 * @author Ariadna Yenisey Librado Flores
 */
public class AlumnoUniversitario extends Alumno {
    private String carrera;

    public AlumnoUniversitario(String nombre, String matricula, int edad,
            double[] calificaciones, String carrera) {
        super(nombre, matricula, edad, calificaciones); // reutiliza validaciones de Alumno
        setCarrera(carrera);
    }

    public String getCarrera() { return carrera; }

    /** Valida que la carrera no esté vacía. */
    public final void setCarrera(String carrera) {
        if (carrera == null || carrera.trim().isEmpty())
            throw new IllegalArgumentException("La carrera no puede estar vacía.");
        this.carrera = carrera.trim();
    }

    /** Sobrescribe el resumen del padre para incluir la carrera (polimorfismo). */
    @Override
    public String obtenerResumen() {
        return super.obtenerResumen() + "\nCarrera: " + carrera;
    }
}
