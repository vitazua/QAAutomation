package org.example.hillelautomation;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserData implements Serializable {
    private String name;
    private String email;
    private Integer age;

    public UserData(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;

    }
    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public Integer getAge() {
        return this.age;
    }
    public void serialize(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }

        Map<String, Object> data = new HashMap<>();
        if (name != null) {
            data.put("name", name);
        }
        if (email != null) {
            data.put("email", email);
        }
        if (age != null) {
            data.put("age", age);
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(data);
        }
    }

    public void deserialize(String filePath) throws IOException, ClassNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File does not exist.");
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Map<String, Object> data = (Map<String, Object>) ois.readObject();
            name = (String) data.get("name");
            email = (String) data.get("email");
            age = (Integer) data.get("age");
        } catch (EOFException ex) {
            // The file is empty or does not contain any data.
            // In this case, leave the fields as null.
        }
    }

    // getters and setters omitted for brevity
}