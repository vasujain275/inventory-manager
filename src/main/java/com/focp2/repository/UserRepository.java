package com.focp2.repository;

import com.focp2.model.User;
import com.focp2.util.JsonFileManager;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;

public class UserRepository {
    private final String FILE_NAME = "users.json";

    public User getUserByEmail(String email) {
        try {
            JSONArray jsonArray = JsonFileManager.readJsonArrayFromFile(FILE_NAME);
            for (Object obj : jsonArray) {
                JSONObject jsonUser = (JSONObject) obj;
                if (jsonUser.getString("email").equals(email)) {
                    return new User(
                            jsonUser.getString("email"),
                            jsonUser.getString("password")
                    );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
