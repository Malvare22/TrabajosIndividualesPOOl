package mundo;
import java.util.ArrayList;

/**
 * Escriba en lenguaje natural una descripción de los objetos
 * que caben en el concepto de la clase Materia.
 * 
 * @author (Milton Jesús Vera Contreras - miltonjesusvc@ufps.edu.co) 
 * @version Math.sin(Math.PI-Double.MIN_VALUE) :) 
 */
public class Materia
{
    protected Grupo [] grupos;
    protected ArrayList<Inscripcion> inscripciones;
    protected String nombre;
    protected int maximoDeAlumnosPorGrupo;
  
    public Materia(String nombre, int maximoDeAlumnosPorGrupo)
    {
      setNombre(nombre);
      setMaximoDeAlumnosPorGrupo(maximoDeAlumnosPorGrupo);
      this.inscripciones = new ArrayList<Inscripcion>();
      this.grupos = new Grupo[0];
    }//fin constructor
    
    public boolean inscribir(Alumno alumno)
    {
      boolean inscribio = false;
      Inscripcion inscripcion = new Inscripcion(alumno, this);
      if(!alumno.tienePromedioCondicional() && 
         ! this.inscripciones.contains(inscripcion )){
       this.inscripciones.add(inscripcion);
       inscribio = true;
      }
      return inscribio;
    }//fin inscribir
    
    public boolean generarGrupos()
    {
      int totalGrupos = this.inscripciones.size()  /  this.maximoDeAlumnosPorGrupo;
      totalGrupos  += this.inscripciones.size()  %  this.maximoDeAlumnosPorGrupo !=0 ? 1: 0;
      int k=0;
      this.grupos = new Grupo[totalGrupos];
      
      for(int i=0; i<totalGrupos; i++)
      {
        this.grupos[i] = new Grupo(this);
      }//fin for i
      
      for(int i=0; i<this.maximoDeAlumnosPorGrupo; i++)
      {
        for(int j=0; j<totalGrupos-(this.inscripciones.size()  %  this.maximoDeAlumnosPorGrupo !=0 ? 1: 0); j++)
        {
          this.grupos[j].agregarAlumno(this.inscripciones.get(k++).getAlumno());
        }//fin for j
      }//fin for i
      
      for(int i=k;i<this.inscripciones.size();i++)
        this.grupos[totalGrupos-1].agregarAlumno(this.inscripciones.get(i).getAlumno());
      
      return totalGrupos > 0;
      
    }//fin generarGrupos
    
    /**Metodo de acceso a la propiedad nombre*/
    public String getNombre(){
        return this.nombre;
    }//end method getNombre

    /**Metodo de modificación a la propiedad nombre*/
    public void setNombre(String nombre){
        this.nombre = nombre;
    }//end method setNombre

    /**Metodo de acceso a la propiedad maximoDeAlumnosPorGrupo*/
    public int getMaximoDeAlumnosPorGrupo(){
        return this.maximoDeAlumnosPorGrupo;
    }//end method getMaximoDeAlumnosPorGrupo

    /**Metodo de modificación a la propiedad maximoDeAlumnosPorGrupo*/
    public void setMaximoDeAlumnosPorGrupo(int maximoDeAlumnosPorGrupo){
        this.maximoDeAlumnosPorGrupo = maximoDeAlumnosPorGrupo;
    }//end method setMaximoDeAlumnosPorGrupo

    /**Metodo de acceso a la propiedad Grupos*/
    public Grupo[] getGrupos(){
        return this.grupos;
    }//end method getGrupos

    /**Metodo de acceso a la propiedad inscripciones*/
    public java.util.ArrayList<Inscripcion> getInscripciones(){
        return this.inscripciones;
    }//end method getInscripciones
    
    /***/
    public Grupo getGrupo(int numero)
    {
      return this.grupos[numero];
    }//fin getGrupo
    
    /**Compara el nombre de this con un String u otro Materia*/
    public boolean equals(Object other)
    {
      if(other instanceof String) return this.nombre.equals(other);
      if(other instanceof Materia) return this.nombre.equals(((Materia)other).getNombre());
      return false;
    }//fin equals

}//fin class Materia