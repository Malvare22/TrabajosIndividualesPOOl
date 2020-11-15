package mundo;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GrupoTest.
 *
 * @author (Milton Jesús Vera Contreras - miltonjesusvc@ufps.edu.co) 
 * @version Math.sin(Math.PI-Double.MIN_VALUE) :) 
 */
public class GrupoTest
{
    /**
     * Default constructor for test class GrupoTest
     */
    public GrupoTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testConstructorGrupo()
    {
        int r = (int)(Math.random()*100);
        mundo.Materia materia1 = new mundo.Materia("POO II", r);
        mundo.Grupo grupo1 = new mundo.Grupo(materia1);
        assertNotNull(grupo1.getAlumnos());
        assertEquals(r, grupo1.getAlumnos().length);
        assertEquals(0, grupo1.getContadorDeAlumnos());
        assertEquals(materia1, grupo1.getMateria());
    }
    
    @Test
    public void testAgregarAlumnoOK()
    {
        mundo.Materia materia1 = new mundo.Materia("POO II", 4);
        mundo.Alumno alumno1 = new mundo.Alumno("1", "Primero", "de la lista", 16, 4.2f);
        mundo.Alumno alumno2 = new mundo.Alumno("2", "Segundo", "de la lista", 16, 3.6f);
        mundo.Alumno alumno3 = new mundo.Alumno("3", "Tercero", "de la lista", 16, 3.5f);
        mundo.Alumno alumno4 = new mundo.Alumno("4", "Cuarto", "de la lista", 16, 3.5f);        
        mundo.Grupo grupo1 = new mundo.Grupo(materia1);
        assertEquals(true, grupo1.agregarAlumno(alumno1));
        assertEquals(true, grupo1.agregarAlumno(alumno2));
        assertEquals(true, grupo1.agregarAlumno(alumno3));
        assertEquals(true, grupo1.agregarAlumno(alumno4));
    }
    
    @Test
    public void testAgregarAlumnoErrorTamanio()
    {
        mundo.Materia materia1 = new mundo.Materia("POO II", 3);
        mundo.Alumno alumno1 = new mundo.Alumno("1", "Primero", "de la lista", 16, 4.2f);
        mundo.Alumno alumno2 = new mundo.Alumno("2", "Segundo", "de la lista", 16, 3.6f);
        mundo.Alumno alumno3 = new mundo.Alumno("3", "Tercero", "de la lista", 16, 3.5f);
        mundo.Alumno alumno4 = new mundo.Alumno("4", "Cuarto", "de la lista", 16, 3.5f);        
        mundo.Grupo grupo1 = new mundo.Grupo(materia1);
        grupo1.agregarAlumno(alumno1);
        grupo1.agregarAlumno(alumno2);
        grupo1.agregarAlumno(alumno3);
        assertEquals(false, grupo1.agregarAlumno(alumno4));
    }
    
    @Test
    public void testAgregarAlumnoErrorRepetido()
    {
        mundo.Materia materia1 = new mundo.Materia("POO II", 4);
        mundo.Alumno alumno1 = new mundo.Alumno("1", "Primero", "de la lista", 16, 4.2f);
        mundo.Alumno alumno2 = new mundo.Alumno("1", "Segundo", "de la lista", 16, 3.6f);
        mundo.Alumno alumno3 = new mundo.Alumno("3", "Primero", "de la lista", 16, 3.5f);
        mundo.Alumno alumno4 = new mundo.Alumno("4", "Cuarto", "de la lista", 16, 3.5f);        
        mundo.Grupo grupo1 = new mundo.Grupo(materia1);
        grupo1.agregarAlumno(alumno1);
        assertEquals(false, grupo1.agregarAlumno(alumno2));
        assertEquals(false, grupo1.agregarAlumno(alumno3));
        assertEquals(true, grupo1.agregarAlumno(alumno4));
    }
}

