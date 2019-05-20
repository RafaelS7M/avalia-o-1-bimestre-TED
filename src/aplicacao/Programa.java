package aplicacao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domínio.Cachorro;

public class Programa {
	public static void main(String[] args)  {
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("avaliacao-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		int escolha;
		int escolhaid;
		String nome;
		String cor;
		
		do {
		
			System.out.println("1 – Listar Cachorro cadastradas"); 
			System.out.println("2 – Buscar um Cachorro pelo id");
			System.out.println("3 – Cadastrar Cachorro");
			System.out.println("4 – Atualizar Cachorro"); 
			System.out.println("5 – Remover um Cachorro"); 
			System.out.println("0 – Sair");
			
			escolha = scanner.nextInt();
			
			switch (escolha) {
				case 1:
					String jpql = "SELECT c FROM Cachorro c";
					List<Cachorro> cachorros = entityManager.createQuery(jpql, Cachorro.class).getResultList();				
					System.out.println(cachorros);
					break;
				
				case 2:
					System.out.print("digite o id procurado: ");
					escolhaid = scanner.nextInt();
					Cachorro cachorroFound = entityManager.find(Cachorro.class, escolhaid);
					System.out.println(cachorroFound);
					break;
				
				case 3:
					System.out.print("digite o nome do cachorro: ");
					nome = scanner.next();
					System.out.print("digite a cor do cachorro: ");
					cor = scanner.next();
					Cachorro cachorro = new Cachorro(null, nome, cor);
					entityManager.getTransaction().begin();
					entityManager.persist(cachorro);
					entityManager.getTransaction().commit();
					break;
				
				case 4:
					System.out.print("digite o id dO cachorro: ");
					escolhaid = scanner.nextInt();
					System.out.print("digite o novo nome: ");
					nome = scanner.next();
					System.out.print("digite a nova cor: ");
					cor = scanner.next();
					Cachorro cachorroFound2 = entityManager.find(Cachorro.class, escolhaid);
					cachorroFound2.setNome(nome);
					cachorroFound2.setCor(cor);
					entityManager.getTransaction().begin();
					entityManager.persist(cachorroFound2);
					entityManager.getTransaction().commit();
					break;
				
				case 5:
					System.out.print("digite o id do cachorro: ");
					escolhaid = scanner.nextInt();
					Cachorro cachorroFound3 = entityManager.find(Cachorro.class, escolhaid);
					entityManager.getTransaction().begin();
					entityManager.remove(cachorroFound3);
					entityManager.getTransaction().commit();
					break;
				
			}
		} while(escolha != 0);
		
		entityManager.close();
		entityManagerFactory.close();
		scanner.close();
	}

}
