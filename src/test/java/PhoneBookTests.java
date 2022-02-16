
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


public class PhoneBookTests {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final PhoneBook phoneBookTest = new PhoneBook();

    @Test
    public void findPhoneNumberByName_CorrectIfFound() {
        Optional<String> phoneNumber = phoneBookTest.findPhoneNumberByName("Faisal");
        assertThat(phoneNumber.get()).isEqualTo("7905179201");
    }

    @Test
    public void findPhoneNumberByName_CorrectIfNotFound(){
        expectedException.expect(NoSuchElementException.class);
        Optional<String> phoneNumber = phoneBookTest.findPhoneNumberByName("Aman");
        phoneNumber.get();
    }

    @Test
    public void findNameByPhoneNumber_CorrectIfFound(){
        Optional<String> name = phoneBookTest.findNameByPhoneNumber("8933825821");
        assertThat(name.get()).isEqualTo("Ayush");
    }

    @Test
    public void findNameByPhoneNumber_CorrectIfNotFound(){
        expectedException.expect(NoSuchElementException.class);
        Optional<String> phoneNumber = phoneBookTest.findNameByPhoneNumber("1234567894");
        phoneNumber.get();
    }
}