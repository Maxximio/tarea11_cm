package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Guardia;

@Repository
@Transactional
public class GuardiaRepoImpl implements IGuardiaRepo{

	//@Autowired
	//private JdbcTemplate jdbcTemplate;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void InsertarGuardia(Guardia guardia) {
		this.entityManager.persist(guardia);
	}

	@Override
	public Guardia buscarGuardia(Integer id) {		
		return this.entityManager.find(Guardia.class, id);
	}

	@Override
	public void ActualizarGuardia(Guardia guardia) {
		this.entityManager.merge(guardia);
	}

	@Override
	public void borrarGuardia(Integer id) {
		Guardia guardiaBorrar=this.buscarGuardia(id);
		this.entityManager.remove(guardiaBorrar);
	}

	@Override
	public Guardia buscarGuardiaApellido(String apellido) {
		//SQL NORMAL: select *from guardia where apellido= 'blablabla'
		//JPQL: select g from Guardia g where g.apellido= :valor
		Query miQuery= this.entityManager.createQuery("select g from Guardia g where g.apellido=:valor");
		miQuery.setParameter("valor", apellido);
		
		Guardia miGuardia=(Guardia) miQuery.getSingleResult();
		
		return miGuardia;
	}

	
	
}
