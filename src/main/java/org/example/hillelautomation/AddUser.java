package org.example.hillelautomation;

import java.io.IOException;

public class AddUser {
    public static void main(String[] args) {
        UserData user = new UserData("John", "john123@mail.com", 19);
        try {
            user.serialize("data.txt");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        user = new UserData(null, "jane456@mail.com", null);
        try {
            user.deserialize("data.txt");
            System.out.println(user.getName());
            System.out.println(user.getEmail());
            System.out.println(user.getAge());
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
