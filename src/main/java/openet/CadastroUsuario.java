package openet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CadastroUsuario {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("usuarios");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Usuario user = new Usuario();
		user.setLogin("Rodrigo");
		user.setSenha("123321");
		user.setNome("Rodrigo");
		user.setCursoid(1);
		user.setPeriodo("Manha");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataFormatada = formato.parse("13/02/1985"); 
		user.setNascimento(dataFormatada);
	
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		
		Usuario usuario = entityManager.find(Usuario.class, 2);
		System.out.println(usuario.getNome());
    entityManager.close();
    entityManagerFactory.close();
	}

}
