package mundo;

import java.util.ArrayList;
/**
 * Escriba en lenguaje natural una descripción de los objetos
 * que caben en el concepto de la clase Universidad.
 * 
 * @author (Milton Jesús Vera Contreras - miltonjesusvc@ufps.edu.co) 
 * @version Math.sin(Math.PI-Double.MIN_VALUE) :) 
 */
public class Universidad
{
  protected ArrayList<Materia> materias;
  protected ArrayList<Alumno> alumnos;
  
  public Universidad()
  {
    this.materias = new ArrayList<Materia>();
    this.alumnos = new ArrayList<Alumno>();
  }//fin constructor
  
  public boolean agregarMateria(String nombre, int maximoDeAlumnosPorGrupo)
  {
    boolean agrego = false;
    Materia materia = new Materia(nombre, maximoDeAlumnosPorGrupo);
    if(!this.materias.contains(materia)){
     this.materias.add(materia);
     agrego = true;
    }
    return agrego;
  }//fin agregarMateria
  
  public boolean agregarAlumno(String codigo, String nombres, String apellidos, int edad, float promedio)
  {
    boolean agrego = false;
    Alumno alumno = new Alumno(codigo, nombres, apellidos, edad, promedio);
    if(!this.alumnos.contains(alumno)){
      this.alumnos.add(alumno);
     agrego = true;
    }
    return agrego;
  }//fin agregarAlumno
  
    /**Metodo de acceso a la propiedad Materias*/
    public java.util.ArrayList<Materia> getMaterias(){
        return this.materias;
    }//end method getMaterias

    /**Metodo de acceso a la propiedad alumnos*/
    public java.util.ArrayList<Alumno> getAlumnos(){
        return this.alumnos;
    }//end method getAlumnos
    
    /**Regresa el alumno en la posicion numero o null si no existe*/
    public Alumno getAlumno(int numero)
    {
      if(numero > 0 && numero <= this.alumnos.size()) return this.alumnos.get(numero-1);
      else return null;
    }//fin getAlumno
    
    /**Regresa el Materia en la posicion numero o null si no existe*/
    public Materia getMateria(int numero)
    {
      if(numero > 0 && numero <= this.materias.size()) return this.materias.get(numero-1);
      else return null;
    }//fin getMateria    

    /**Metodo de modificación a la propiedad materias*/
    public void setMaterias(java.util.ArrayList<mundo.Materia> materias){
        this.materias = materias;
    }//end method setMaterias

    /**Metodo de modificación a la propiedad alumnos*/
    public void setAlumnos(java.util.ArrayList<mundo.Alumno> alumnos){
        this.alumnos = alumnos;
    }//end method setAlumnos

}//fin class Universidad