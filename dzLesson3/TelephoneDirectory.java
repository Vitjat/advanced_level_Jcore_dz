package dzLesson3;

import java.util.*;

public class TelephoneDirectory {
    HashMap<String, Set<String>> td = new HashMap<>();

    public void addContact (String name, String phone){
        Set<String> catalog = td.getOrDefault(name, new HashSet<>());
        catalog.add(phone);
        td.put(name, catalog);
    }

    public void add(String name, String phones) {
        Set<String> catalog = td.getOrDefault(name, new HashSet<>());
        catalog.addAll(Arrays.asList(phones));
        td.put(name, catalog);
    }

    public Set<String> get(String name) {
        return Collections.unmodifiableSet(td.get(name));
    }

}
