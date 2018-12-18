package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Aplicacao {

	public static void main(String[] args) {
	
		Pessoa p1 = new Pessoa(null, "Helenice", "helenice_as@hotmail.com");
		Pessoa p2 = new Pessoa(null, "Aline", "racaline@hotmail.com");
		Pessoa p3 = new Pessoa(null, "Will", "will.silva@hotmail.com");
		
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager entityManager = entityFactory.createEntityManager();
		//Persistindo
//		entityManager.getTransaction().begin();
//		entityManager.persist(p1);
//		entityManager.persist(p2);
//		entityManager.persist(p3);
//		entityManager.getTransaction().commit();
		
		Pessoa p = entityManager.find(Pessoa.class, 2);
		entityManager.getTransaction().begin();
		entityManager.remove(p);
		entityManager.getTransaction().commit();
		System.out.println(p);
		System.out.println("OK");
		entityManager.close();
		entityFactory.close();
	

	}

}
