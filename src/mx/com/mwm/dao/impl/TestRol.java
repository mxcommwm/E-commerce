package mx.com.mwm.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mx.com.mwm.model.Rol;

public class TestRol {
	private static EntityManager em;
	private static EntityManagerFactory emf;
	
	public static void main(String[] args) {
		// creamos el gestor de persistencia EM
				emf=Persistence.createEntityManagerFactory("mwisp");
				em=emf.createEntityManager();
				insertInicial();
				imprimirTodo();
		
	}
	
	private static void insertInicial() {
		Rol r = new Rol("Cliente", "Acivo");
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public static void imprimirTodo()
	{
		List<Rol> rol =(List<Rol>) em.createQuery("from Rol").getResultList();
		System.out.println("En la base de datos hay "+rol.size()+" Roles.");
		for (Rol rol2 : rol) {
			System.out.println(rol2);
		}
	}

}
