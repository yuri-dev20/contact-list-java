import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ContactList {
    private static int id;
    private static final String path = "src/main/contactlistoutput.json";

    public static void addContact(Person p) {
        JsonObject jsonObject = new JsonObject();
        HashMap<String, String> list = new HashMap<>();

        if (Files.exists(Path.of(path))) {
            try (FileReader reader = new FileReader("src/main/contactlistoutput.json")) {
                jsonObject = (JsonObject) Jsoner.deserialize(reader);

                list.put("name", p.getName());
                list.put("address", p.getAddress());
                list.put("phone", p.getPhone());
                list.put("email", p.getEmail());

                id = jsonObject.size();
                jsonObject.put(String.valueOf(id), list);


                try (FileWriter writer = new FileWriter(path)) {
                    Jsoner.serialize(jsonObject, writer);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            list.put("name", p.getName());
            list.put("address", p.getAddress());
            list.put("phone", p.getPhone());
            list.put("email", p.getEmail());
            jsonObject.put(String.valueOf(id), list);

            try (FileWriter writer = new FileWriter(path)) {
                Jsoner.serialize(jsonObject, writer);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void showContactInfo() {
        try (FileReader reader = new FileReader("src/main/contactlistoutput.json")) {
            JsonObject jsonObject = (JsonObject) Jsoner.deserialize(reader);

            for (String s : jsonObject.keySet()) {
                System.out.println("ID: " + s + " info: " + jsonObject.get(s));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void removeContact(String id) {
        Scanner sc =  new Scanner(System.in);
        System.out.println();

        try (FileReader reader = new FileReader("src/main/contactlistoutput.json")) {
            JsonObject jsonObject = (JsonObject) Jsoner.deserialize(reader);
            jsonObject.remove(id);

            try (FileWriter writer = new FileWriter(path)) {
                Jsoner.serialize(jsonObject, writer);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
