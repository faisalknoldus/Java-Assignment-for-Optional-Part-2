
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PhoneBook {

     Map<String, String> phoneMap = new HashMap<>();

    public PhoneBook() {
        phoneMap.put("Faisal","7905179201");
        phoneMap.put("Ayush","8933825821");
    }

    public Map<String, String> getPhoneMap() {
        return phoneMap;
    }

    public void setPhoneMap(Map<String, String> phoneMap) {
        this.phoneMap = phoneMap;
    }

    public Optional<String> findPhoneNumberByName(String name){
        if(phoneMap.containsKey(name)){
            return Optional.of(phoneMap.get(name)) ;
        }
        return Optional.empty();
    }

    public Optional<String> findNameByPhoneNumber(String phoneNumber) {
        for (Map.Entry<String, String> entry : phoneMap.entrySet()) {
            if (entry.getValue() == phoneNumber) {
                return Optional.of(entry.getKey());
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return "PhoneBook{ PhoneBook = "+phoneMap+"}";
    }
}
