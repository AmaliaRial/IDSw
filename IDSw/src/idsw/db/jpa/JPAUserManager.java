package idsw.db.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import idsw.db.jpaInterfaces.UserManager;
import idsw.db.pojos.Role;
import idsw.db.pojos.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class JPAUserManager implements UserManager {
	
	private EntityManager em;
	
	public JPAUserManager() {
		em = Persistence.createEntityManagerFactory("idsw-provider").createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		em.getTransaction().commit();
		//Create default roles
		try {//because if one role already exists all of them must exist ( they are created at the same time)
			this.getRole("researcher");  
		}catch (NoResultException e) {
			this.createRole(new Role("researcher"));
			this.createRole(new Role("doctor"));
			this.createRole(new Role("patient"));
		}
	}

	@Override
	public void register(User u) {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
	}

	@Override
	public void createRole(Role r) {
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
	}

	@Override
	public Role getRole(String name) {
		Query query = em.createNativeQuery("SELECT * FROM roles WHERE name LIKE ?", Role.class);
		query.setParameter(1, name);
		Role r = (Role)query.getSingleResult();
		return r;
	}

	@Override
	public List<Role> getAllRoles() {
		Query query = em.createNativeQuery("SELECT * FROM roles;",Role.class);
		List<Role> roles = (List<Role>) query.getResultList();
		return roles;
	}

	@Override
	public void assignRole(User u, Role r) {
		em.getTransaction().begin();
		u.setRole(r);
		r.addUser(u);
		em.getTransaction().commit();
	}

	@Override
	public User login(String username) {
		User u = null;
		Query q = em.createNativeQuery("SELECT * FROM users WHERE username = ?;", User.class);
		q.setParameter(1, username);
		try {
			u = (User)q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		return u;
	}
	
	private String returnPassword(String username) {
		String password = null;
		Query q = em.createNativeQuery("SELECT * FROM users WHERE username = ?;", User.class);
		q.setParameter(1, username);
		try {
			User u  = (User) q.getSingleResult();
			password = u.getPassword();
		} catch (NoResultException e) {
			return null;
		}
		return password;
	}
	
	@Override
	 public boolean verifyPassword(String inputPassword, String username) {
		if(login(username)!=null) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	        return encoder.matches(inputPassword, returnPassword(username));
		}else{
			return false;
		}
	 }

	@Override
	public User getUser(String username) {
		User u = null;
		Query q = em.createNativeQuery("SELECT * FROM users WHERE username = ?;", User.class);
		q.setParameter(1, username);
		try {
			u = (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		return u;
	}


}
