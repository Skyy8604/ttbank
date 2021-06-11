package ch.bbcag.jakarta.ttbank.service;

import ch.bbcag.jakarta.ttbank.exception.EmailAlreadyExistsException;
import ch.bbcag.jakarta.ttbank.model.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

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
}
