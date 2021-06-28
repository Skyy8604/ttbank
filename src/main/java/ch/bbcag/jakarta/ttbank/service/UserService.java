package ch.bbcag.jakarta.ttbank.service;

import ch.bbcag.jakarta.ttbank.exception.EmailAlreadyExistsException;
import ch.bbcag.jakarta.ttbank.exception.WrongEmailException;
import ch.bbcag.jakarta.ttbank.exception.WrongPasswordException;
import ch.bbcag.jakarta.ttbank.model.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

@Stateless
public class UserService {

	@PersistenceContext
	private EntityManager em;

	@Inject
	private Pbkdf2PasswordHash passwordHash;

	public User register(String email, String lastName, String firstName, String passwordNotHashed) {
		User userWithSameEmail = em.find(User.class, email);

		if (userWithSameEmail != null) {
			throw new EmailAlreadyExistsException();
		}

		User newUser = new User();
		String password = passwordHash.generate(passwordNotHashed.toCharArray());

		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);

		em.persist(newUser);

		return newUser;
	}

	public User login(String email, String password) {
		User user = em.find(User.class, email);

		if (user == null) {
			throw new WrongEmailException();
		} else {
			if (passwordHash.verify(password.toCharArray(), user.getPassword())) {
				return user;
			} else {
				throw new WrongPasswordException();
			}
		}
	}

	public User getUserByEmail(String email) {
		return em.find(User.class, email);
	}

	public boolean checkTwoFactorCode(String code, String email) {
		User user = em.find(User.class, email);
		return user.getTfa_code().equals(code);
	}

	public void saveTwoFactorCode(String code, String email) {
		Query query = em.createQuery("UPDATE user SET tfa_code = '" + code + "' WHERE email = '" + email + "'");
		query.executeUpdate();
	}

	public void deleteTwoFactorCode(String emailOfUser) {
		Query query = em.createQuery("UPDATE user SET tfa_code = null WHERE email = '" + emailOfUser +"' ");
		query.executeUpdate();
	}
}