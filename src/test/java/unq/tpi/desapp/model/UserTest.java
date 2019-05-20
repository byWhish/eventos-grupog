package unq.tpi.desapp.model;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void usersAreCreatedAsTheyHaveTo() {
        String name = "aName";
        User user = new User(name, "aSurname", "aMail@mail.com", "password", new Date());

        assertEquals(user.getName(), name);
    }
}
