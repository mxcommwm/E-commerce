package mx.com.mwm.dao.impl;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mx.com.mwm.model.Empleado;

//import org.hibernate.engine.spi.Managed;



public class TestEmpleado {
	private static EntityManager em;
	private static EntityManagerFactory emf;
	

	public static void main(String[] args) {
		// creamos el gestor de persistencia EM
		emf=Persistence.createEntityManagerFactory("aplicacion");
		em=emf.createEntityManager();
		insertInicial();
		imprimirTodo();
		em.getTransaction().begin();
		Empleado e=em.find(Empleado.class, 10l);
		e.setApellidos("Rodriguez");
		e.setNombre("Laura");
		em.getTransaction().commit();
		imprimirTodo();
		em.close();
	}

	private static void insertInicial() {
		Empleado e = new Empleado(10l, "Damian", "Vasquez", new GregorianCalendar(1993, 9, 29).getTime());
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public static void imprimirTodo()
	{
		List<Empleado> empleado =(List<Empleado>) em.createQuery("from Empleado").getResultList();
		System.out.println("En la base de datos hay "+empleado.size()+" Empleados.");
		for (Empleado empleado2 : empleado) {
			System.out.println(empleado2);
		}
	}

}
