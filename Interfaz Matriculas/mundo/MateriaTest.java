package mundo;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MateriaTest.
 *
 * @author (Milton Jesús Vera Contreras - miltonjesusvc@ufps.edu.co) 
 * @version Math.sin(Math.PI-Double.MIN_VALUE) :) 
 */
public class MateriaTest
{
    /**
     * Default constructor for test class MateriaTest
     */
    public MateriaTest()
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
    public void testConstructorMateria()
    {
        int r = (int)(Math.random()*100);
        mundo.Materia materia1 = new mundo.Materia("POO II", r);
        assertEquals(r, materia1.getMaximoDeAlumnosPorGrupo());
        assertEquals("POO II", materia1.getNombre());
        assertNotNull(materia1.getInscripciones());
        assertEquals(0, materia1.getInscripciones().size());
        assertNotNull(materia1.getGrupos());
        assertEquals(0, materia1.getGrupos().length);
    }

    @Test
    public void testInscribirAlumnoOK()
    {
        mundo.Materia materia1 = new mundo.Materia("POO II", 40);
        mundo.Alumno alumno1 = new mundo.Alumno("1", "Primero", "de la lista", 16, 4.2f);
        mundo.Alumno alumno2 = new mundo.Alumno("2", "Segundo", "de la lista", 16, 4.2f);
        assertEquals(true, materia1.inscribir(alumno1));
        assertEquals(true, materia1.inscribir(alumno2));
        assertNotNull(materia1.getInscripciones());
        assertEquals(2, materia1.getInscripciones().size());
    }
    
    @Test
    public void testInscribirAlumnoErrorCondicional()
    {
        mundo.Materia materia1 = new mundo.Materia("POO II", 40);
        mundo.Alumno alumno1 = new mundo.Alumno("1", "Primero", "de la lista", 16, 4.2f);
        mundo.Alumno alumno2 = new mundo.Alumno("2", "Segundo", "de la lista", 16, 3.0f);
        mundo.Alumno alumno3 = new mundo.Alumno("3", "Tercero", "de la lista", 16, 3.5f);
        assertEquals(true, materia1.inscribir(alumno1));
        assertEquals(false, materia1.inscribir(alumno2));
        assertEquals(true, materia1.inscribir(alumno3));
        assertNotNull(materia1.getInscripciones());
        assertEquals(2, materia1.getInscripciones().size());
    }
    
    @Test
    public void testInscribirAlumnoErrorRepetido()
    {
        mundo.Materia materia1 = new mundo.Materia("POO II", 40);
        mundo.Alumno alumno1 = new mundo.Alumno("1", "Primero", "de la lista", 16, 4.2f);
        mundo.Alumno alumno2 = new mundo.Alumno("2", "Segundo", "de la lista", 16, 3.6f);
        mundo.Alumno alumno3 = new mundo.Alumno("3", "Tercero", "de la lista", 16, 3.5f);
        materia1.inscribir(alumno1);
        materia1.inscribir(alumno2);
        materia1.inscribir(alumno3);
        assertEquals(false, materia1.inscribir(alumno1));
        assertEquals(false, materia1.inscribir(alumno2));
        assertEquals(false, materia1.inscribir(alumno3));
        assertNotNull(materia1.getInscripciones());
        assertEquals(3, materia1.getInscripciones().size());
    }
    
    @Test
    public void testGenerarGrupos1()
    {
        mundo.Materia materia1 = new mundo.Materia("POO II", 8);
        mundo.Alumno alumno = null;
        for(int i=1;i<=100;i++){
         alumno = new mundo.Alumno(""+i, "Alumno " + i, "de la lista", 16, 4.2f);
         materia1.inscribir(alumno);
        }
        assertEquals(true, materia1.generarGrupos());
    }
    
    @Test
    public void testGenerarGrupos2()
    {
        mundo.Materia materia1 = new mundo.Materia("POO II", 8);
        mundo.Alumno alumno = null;
        for(int i=1;i<=100;i++){
         alumno = new mundo.Alumno(""+i, "Alumno " + i, "de la lista", 16, 4.2f);
         materia1.inscribir(alumno);
        }
        materia1.generarGrupos();
        assertNotNull(materia1.getGrupos());
        assertEquals(13, materia1.getGrupos().length);
    }
    
    @Test
    public void testGenerarGrupos3()
    {
        mundo.Materia materia1 = new mundo.Materia("POO II", 8);
        mundo.Alumno alumno = null;
        for(int i=1;i<=100;i++){
         alumno = new mundo.Alumno(""+i, "Alumno " + i, "de la lista", 16, 4.2f);
         materia1.inscribir(alumno);
        }
        materia1.generarGrupos();
        assertNotNull(materia1.getGrupos());
        Grupo [] grupos = materia1.getGrupos();
        for(int i=0;i<grupos.length-1;i++){
          for(int j=0;j<8;j++)
            assertNotNull(grupos[i].getAlumnos()[j]);
        }
        for(int j=0;j<4;j++)
            assertNotNull(grupos[grupos.length-1].getAlumnos()[j]);
        for(int j=4;j<8;j++)
            assertNull(grupos[grupos.length-1].getAlumnos()[j]);
    }
    
    @Test
    public void testGenerarGrupos4()
    {
        mundo.Materia materia1 = new mundo.Materia("POO II", 8);
        mundo.Alumno alumno = null;
        mundo.Alumno [ ] alumnos = new Alumno[100];
        for(int i=1;i<=100;i++){
         alumno = new mundo.Alumno(""+i, "Alumno " + i, "de la lista", 16, 4.2f);
         materia1.inscribir(alumno);
         alumnos[i-1]=alumno;
        }
        materia1.generarGrupos();
        assertNotNull(materia1.getGrupos());
        Grupo [] grupos = materia1.getGrupos();
        int k=0;
        for(int j=0;j<8;j++){        
          for(int i=0;i<grupos.length-1;i++){
            assertEquals(alumnos[k++],grupos[i].getAlumnos()[j]);
          }
        }
        for(int j=0;j<4;j++){
            assertEquals(alumnos[k++],grupos[grupos.length-1].getAlumnos()[j]);
        }
    }

}


