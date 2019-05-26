package unq.tpi.desapp.persistence;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import unq.tpi.desapp.builders.UserBuilder;
import unq.tpi.desapp.model.User;

import static org.junit.Assert.assertEquals;

//@Ignore
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    // write test cases here

    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        User alex = new UserBuilder().withEmail("hola@hola.com").getUser();
        entityManager.persist(alex);
        entityManager.flush();

        // when
        User found = userRepository.findByEmail(alex.getEmail());

        // then
        assertEquals(found.getName(), alex.getName());
    }

}