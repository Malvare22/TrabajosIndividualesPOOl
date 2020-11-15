package mundo;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UniversidadTest.
 *
 * @author (Milton Jesús Vera Contreras - miltonjesusvc@ufps.edu.co) 
 * @version Math.sin(Math.PI-Double.MIN_VALUE) :) 
 */
public class UniversidadTest
{
    /**
     * Default constructor for test class UniversidadTest
     */
    public UniversidadTest()
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
    public void testConstructorUniversidad()
    {
        mundo.Universidad universidad1 = new mundo.Universidad();
        assertNotNull(universidad1.getAlumnos());
        assertEquals(0, universidad1.getAlumnos().size());
        assertNotNull(universidad1.getMaterias());
        assertEquals(0, universidad1.getMaterias().size());
    }

    @Test
    public void testAgregarAlumnoOK()
    {
        mundo.Universidad universidad1 = new mundo.Universidad();
        assertEquals(true, universidad1.agregarAlumno("1", "Primero", "de la lista", 16, 4.2f));
        assertEquals(true, universidad1.agregarAlumno("2", "Segundo", "de la lista", 17, 3.0f));
        assertEquals(true, universidad1.agregarAlumno("3", "Tercero", "de la lista", 20, 3.5f));
        assertNotNull(universidad1.getAlumnos());
        assertEquals(3, universidad1.getAlumnos().size());
    }
    
    @Test
    public void testAgregarAlumnoErrorCodigoRepetido()
    {
        mundo.Universidad universidad1 = new mundo.Universidad();
        assertEquals(true, universidad1.agregarAlumno("1", "Primero", "de la lista", 16, 4.2f));
        assertEquals(false, universidad1.agregarAlumno("1", "Segundo", "de la lista", 17, 3.0f));
        assertEquals(true, universidad1.agregarAlumno("3", "Tercero", "de la lista", 20, 3.5f));
        assertNotNull(universidad1.getAlumnos());
        assertEquals(2, universidad1.getAlumnos().size());
    }
    
    @Test
    public void testAgregarAlumnoErrorNombresYApellidosRepetidos()
    {
        mundo.Universidad universidad1 = new mundo.Universidad();
        assertEquals(true, universidad1.agregarAlumno("1", "Primero", "de la lista", 16, 4.2f));
        assertEquals(false, universidad1.agregarAlumno("2", "Primero", "de la lista", 17, 3.0f));
        assertEquals(true, universidad1.agregarAlumno("2", "Segundo", "de la lista", 20, 3.5f));
        assertNotNull(universidad1.getAlumnos());
        assertEquals(2, universidad1.getAlumnos().size());
    }

    @Test
    public void testAgregarMateriaOK()
    {
        mundo.Universidad universidad1 = new mundo.Universidad();
        assertEquals(true, universidad1.agregarMateria("Fundamentos", 40));
        assertEquals(true, universidad1.agregarMateria("POO I", 40));
        assertEquals(true, universidad1.agregarMateria("POO II", 40));
        assertNotNull(universidad1.getMaterias());
        assertEquals(3, universidad1.getMaterias().size());
    }
    
     @Test
    public void testAgregarMateriaError()
    {
        mundo.Universidad universidad1 = new mundo.Universidad();
        assertEquals(true, universidad1.agregarMateria("Fundamentos", 40));
        assertEquals(false, universidad1.agregarMateria("Fundamentos", 40));
        assertEquals(true, universidad1.agregarMateria("POO I", 40));
        assertNotNull(universidad1.getMaterias());
        assertEquals(2, universidad1.getMaterias().size());
    }
    
    @Test
    public void testGetAlumnoPorPosicionOK()
    {
        mundo.Universidad universidad1 = new mundo.Universidad(); 
        universidad1.agregarAlumno("1", "Primero", "de la lista", 16, 4.2f);
        universidad1.agregarAlumno("2", "Segundo", "de la lista", 17, 3.0f);
        universidad1.agregarAlumno("3", "Tercero", "de la lista", 20, 3.5f);
        assertNotNull(universidad1.getAlumno(1));
        assertNotNull(universidad1.getAlumno(2));
        assertNotNull(universidad1.getAlumno(3));
    }
    
    @Test
    public void testGetAlumnoPorPosicionError()
    {
        mundo.Universidad universidad1 = new mundo.Universidad(); 
        universidad1.agregarAlumno("1", "Primero", "de la lista", 16, 4.2f);
        universidad1.agregarAlumno("2", "Segundo", "de la lista", 17, 3.0f);
        universidad1.agregarAlumno("3", "Tercero", "de la lista", 20, 3.5f);
        assertNull(universidad1.getAlumno(-1));
        assertNull(universidad1.getAlumno(0));
        assertNull(universidad1.getAlumno(4));
    }    
    
    @Test
    public void testGetMateriaPorPosicionOK()
    {
        mundo.Universidad universidad1 = new mundo.Universidad();
        universidad1.agregarMateria("Fundamentos", 40);
        universidad1.agregarMateria("POO I", 40);
        universidad1.agregarMateria("POO II", 40);
        assertNotNull(universidad1.getMateria(1));
        assertNotNull(universidad1.getMateria(2));
        assertNotNull(universidad1.getMateria(3));        
    }
    
    @Test
    public void testGetMateriaPorPosicionError()
    {
        mundo.Universidad universidad1 = new mundo.Universidad();
        universidad1.agregarMateria("Fundamentos", 40);
        universidad1.agregarMateria("POO I", 40);
        universidad1.agregarMateria("POO II", 40);
        assertNull(universidad1.getMateria(-1));
        assertNull(universidad1.getMateria(0));
        assertNull(universidad1.getMateria(4));        
    }

}





