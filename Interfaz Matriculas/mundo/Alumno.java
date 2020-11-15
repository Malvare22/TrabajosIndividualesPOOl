package mundo;

/**
 * Escriba en lenguaje natural una descripción de los objetos
 * que caben en el concepto de la clase Alumno.
 * 
 * @author (Milton Jesús Vera Contreras - miltonjesusvc@ufps.edu.co) 
 * @version Math.sin(Math.PI-Double.MIN_VALUE) :) 
 */
public class Alumno
{
    protected String codigo;
    protected String nombres;
    protected String apellidos;
    protected int edad;
    protected float promedio;
  
    public Alumno(String codigo, String nombres, String apellidos, int edad, float promedio)
    {
      this.codigo = codigo;
      this.nombres = nombres;
      this.apellidos = apellidos;
      this.edad = edad;
      this.promedio = promedio;
    }//fin constructor
    
    public boolean tienePromedioCondicional(){
      return this.promedio <= 3.1;
    }
    
    /**Metodo de acceso a la propiedad codigo*/
    public String getCodigo(){
        return this.codigo;
    }//end method getCodigo

    /**Metodo de modificación a la propiedad codigo*/
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }//end method setCodigo

    /**Metodo de acceso a la propiedad nombres*/
    public String getNombres(){
        return this.nombres;
    }//end method getNombres

    /**Metodo de modificación a la propiedad nombres*/
    public void setNombres(String nombres){
        this.nombres = nombres;
    }//end method setNombres

    /**Metodo de acceso a la propiedad apellidos*/
    public String getApellidos(){
        return this.apellidos;
    }//end method getApellidos

    /**Metodo de modificación a la propiedad apellidos*/
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }//end method setApellidos

    /**Metodo de acceso a la propiedad edad*/
    public int getEdad(){
        return this.edad;
    }//end method getEdad

    /**Metodo de modificación a la propiedad edad*/
    public void setEdad(int edad){
        this.edad = edad;
    }//end method setEdad
    
     /**Metodo de acceso a la propiedad promedio*/
    public float getPromedio(){
        return this.promedio;
    }//end method getEdad

    /**Metodo de modificación a la propiedad promedio*/
    public void setPromedio(float promedio){
        this.promedio = promedio;
    }//end method setEdad
    
    /**Compara el codigo de this con un String u otro Alumno*/
    public boolean equals(Object other)
    {
      if(other instanceof String) return this.codigo.equals(other);
      if(other instanceof Alumno) return this.codigo.equals(((Alumno)other).getCodigo()) || 
                                         (this.nombres.equals(((Alumno)other).getNombres()) && 
                                         this.apellidos.equals(((Alumno)other).getApellidos()));
      
      return false;
    }//fin equals
    
}//fin class Alumno