
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneBookCrawlerTests {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final PhoneBookCrawler phoneBookCrawler = new PhoneBookCrawler(new PhoneBook());

    @Test
    public void findPhoneNumberByNameAndPunishIfNothingFound()  {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("No phone number found");
        phoneBookCrawler.findPhoneNumberByNameAndPunishIfNothingFound("Mohd");
    }

    @Test
    public void findPhoneNumberByName_CorrectIfFind(){
        String phoneNumberActual = phoneBookCrawler.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Faisal");
        assertThat(phoneNumberActual).isEqualTo("7905179201");
    }

    @Test
    public void findPhoneNumberByNameAndReturnEntirePhoneBookIfNothingFound() {
        String phoneBookActual = phoneBookCrawler.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Shivam");
        assertThat(phoneBookActual).isEqualTo("PhoneBook{ PhoneBook = {Faisal=7905179201, Ayush=8933825821}}");
    }

    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumber_CorrectIfFoundByName() {
        String phoneNumberActual = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Faisal", "12456578");
        assertThat(phoneNumberActual).isEqualTo("7905179201");
    }

    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumber_CorrectIfFoundByPhoneNumber() {
        String name = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Aman", "8933825821");
        assertThat(name).isEqualTo("Ayush");
    }
}
