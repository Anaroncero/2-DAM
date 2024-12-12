package com.ejemploclase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Inicializa el EntityManagerFactory con la ruta donde queremos crear nuestra bd (dentro de ObjectDB)
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("E:\\GitHub\\2-DAM\\MODULOS\\Acceso a datos\\Segundo Trimestre\\T9\\ObjectDB\\objectdb-2.9.1\\db\\ejemplo.odb");
       EntityManager em = emf.createEntityManager();

    
       //Transaccion interesante que estuviera dentro de un try para manejar los errores
       em.getTransaction().begin();
       // crear objetos departamento
       Departamento dpRRHH = new Departamento("RRHH");
       Departamento dpTIC = new Departamento("TIC");
       em.persist(dpRRHH); //prsist es que es persistente quiere decir que se almacene en esa base de datos
       em.persist(dpTIC);
       //em.persist(dpTIC);
       // crear objetos empleado
       Empleado e1 = new Empleado("pepe", 2000, dpRRHH); //id no se lo pasamos debe crearlo solo
       Persona p = new Persona();
       em.persist(e1);

       em.getTransaction().commit();
    
    }
}