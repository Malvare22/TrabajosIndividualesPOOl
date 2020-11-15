package mundo;
import java.util.ArrayList;

/**
 * Escriba en lenguaje natural una descripción de los objetos
 * que caben en el concepto de la clase Grupo.
 * 
 * @author (Milton Jesús Vera Contreras - miltonjesusvc@ufps.edu.co) 
 * @version Math.sin(Math.PI-Double.MIN_VALUE) :) 
 */
public class Grupo
{
    protected Alumno[] alumnos;
    protected Materia materia;
    protected int contadorDeAlumnos;

    public Grupo(Materia materia)
    {
        this.alumnos = new Alumno[materia.getMaximoDeAlumnosPorGrupo()];
        this.materia = materia;
    }//fin construuctor

    public boolean agregarAlumno(Alumno alumno)
    {
        boolean puedeAgregar = contadorDeAlumnos < alumnos.length 
            && !contieneAlumno(alumno);
        if(puedeAgregar) this.alumnos[contadorDeAlumnos++] = alumno;
        return puedeAgregar;
    }//fin agregarAlumno

    public boolean contieneAlumno(Alumno alumno){
        boolean rta = false; 
        for(int i=0; i<alumnos.length;i++){
            if(alumnos[i]!=null && alumnos[i].equals(alumno)){
                rta = true;
                break;
            }
        }
        return rta;
    }

    /**Metodo de acceso a la propiedad Alumnos*/
    public Alumno[] getAlumnos(){
        return this.alumnos;
    }//end method getAlumnos

    /**Metodo de modificación a la propiedad contadorDeAlumnos*/
    public void setContadorDeAlumnos(int contadorDeAlumnos){
        this.contadorDeAlumnos = contadorDeAlumnos;
    }//end method setContadorDeAlumnos

    /**Metodo de acceso a la propiedad contadorDeAlumnos*/
    public int getContadorDeAlumnos(){
        return this.contadorDeAlumnos;
    }//end method getContadorDeAlumnos

    /**Metodo de acceso a la propiedad materia*/
    public Materia getMateria(){
        return this.materia;
    }//end method getMateria

    /**Metodo de modificación a la propiedad materia*/
    public void setMateria(Materia materia){
        this.materia = materia;
    }//end method setMateria


}//fin class Grupo