package unq.tpi.desapp.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import unq.tpi.desapp.builders.GuestBuilder;
import unq.tpi.desapp.model.event.ExpiredEventState;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    @Test
    public void whenTriesToConfirmAssitanceItChangesHisConfirmedAssitanceFlagValue() {
        Guest guest = new GuestBuilder().getGuest();
        guest.event.setDeadline(tomorrow());

        guest.confirmAssistance();

        assertEquals(guest.confirmedAssistance, Boolean.TRUE);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void whenTriesToConfirmAssitanceAndTheDeadlineHasPassedAwayItFails() {
        Guest guest = new GuestBuilder().getGuest();
        guest.event.setDeadline(yesterday());

        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage(ExpiredEventState.CANNOT_CONFIRM_ASSISTANCE);

        guest.confirmAssistance();
    }

    private Date tomorrow() {
        return new Date(new Date().getTime() + (1000 * 60 * 60 * 24));
    }

    private Date yesterday() {
        return new Date(new Date().getTime() - (1000 * 60 * 60 * 24));
    }
}
