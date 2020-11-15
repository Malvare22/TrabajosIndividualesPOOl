package mundo;
/**
 * Escriba en lenguaje natural una descripción de los objetos
 * que caben en el concepto de la clase Inscripcion.
 * 
 * @author (Milton Jesús Vera Contreras - miltonjesusvc@ufps.edu.co) 
 * @version Math.sin(Math.PI-Double.MIN_VALUE) :) 
 */
public class Inscripcion
{
    protected Alumno alumno;
    protected Materia materia;

    public Inscripcion(Alumno alumno, Materia materia)
    {
        this.alumno = alumno;
        this.materia = materia;
    }//fin constructor

    /**Metodo de acceso a la propiedad alumno*/
    public Alumno getAlumno(){
        return this.alumno;
    }//end method getAlumno

    public Materia getMateria(){
        return this.materia;
    }

    public String getNombresAlumno(){
        return this.alumno.getNombres() + " " + this.alumno.getApellidos();
    }

    public String getNombreDeLaMateria(){
        return this.materia.getNombre();
    }

    /**Compara el Materia y alumno de this con el Materia y Alumno de other*/
    public boolean equals(Object other)
    {
        if(other instanceof Inscripcion) return this.materia.equals(((Inscripcion)other).materia) &&
            this.alumno.equals(((Inscripcion)other).alumno);
        return false;
    }//fin equals    

}//fin class Inscripcion