package Aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		/**Forma de remover uma entidade monitorada.Funciona quando ela acaba de ser inserida ou através de busca como o exemplo abaixo.*/
		Pessoa p = em.find(Pessoa.class, 6);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("Pessoa de ID 6 removida");
		
	

		
		em.close();
		emf.close();
	}

}
