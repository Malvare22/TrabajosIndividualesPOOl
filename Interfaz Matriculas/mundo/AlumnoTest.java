package mundo;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AlumnoTest.
 *
 * @author (Milton Jesús Vera Contreras - miltonjesusvc@ufps.edu.co) 
 * @version Math.sin(Math.PI-Double.MIN_VALUE) :) 
 */
public class AlumnoTest
{
    /**
     * Default constructor for test class AlumnoTest
     */
    public AlumnoTest()
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
    public void testConstructorAlumno()
    {
        mundo.Alumno alumno1 = new mundo.Alumno("1", "Primero", "de la lista", 16, 4.2f);
        assertEquals("1", alumno1.getCodigo());
        assertEquals("Primero", alumno1.getNombres());
        assertEquals("de la lista", alumno1.getApellidos());
        assertEquals(16, alumno1.getEdad());
        assertEquals(4.2, alumno1.getPromedio(), 0.001);
    }


    @Test
    public void testAlumnoCondicional()
    {
        mundo.Alumno alumno1 = new mundo.Alumno("1", "Primero", "de la lista", 16, 3.0f);
        assertEquals(true, alumno1.tienePromedioCondicional());
    }
}



