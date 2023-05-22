package elakeel.services;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import elakeel.ejbs.*;
import elakeel.ejbs.Customer;
import elakeel.ejbs.Order;
import elakeel.ejbs.OrderItem;
import elakeel.ejbs.OrderStatus;
import elakeel.ejbs.Runner;
import elakeel.ejbs.RunnerStatus;
import elakeel.ejbs.User;
import elakeel.ejbs.UserRole;
import java.util.List;

@Stateless
public class AuthenticationService implements AutheticationServicesInterface{
    @PersistenceContext(unitName = "akeel")
  private EntityManager entityManager;

  public User signUp(User user) {
        entityManager.persist(user);
        return user;
    }

  public User login(String username, String password) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        query.setMaxResults(1);
        List<User> users = query.getResultList();
        return users.isEmpty() ? null : users.get(0);
    }
}
