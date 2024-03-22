package com.focp2.util;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonFileManager {

    private static final String DATA_FOLDER = "data/";

    public static JSONArray readJsonArrayFromFile(String fileName) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(DATA_FOLDER + fileName)));
        return new JSONArray(content);
    }

    public static void writeJsonArrayToFile(JSONArray jsonArray, String fileName) throws IOException {
        createDataFolderIfNotExists();
        try (FileWriter file = new FileWriter(DATA_FOLDER + fileName)) {
            file.write(jsonArray.toString(4)); // 4 is the indentation level
        }
    }

    public static JSONObject readJsonObjectFromFile(String fileName) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(DATA_FOLDER + fileName)));
        return new JSONObject(content);
    }

    public static void writeJsonObjectToFile(JSONObject jsonObject, String fileName) throws IOException {
        createDataFolderIfNotExists();
        try (FileWriter file = new FileWriter(DATA_FOLDER + fileName)) {
            file.write(jsonObject.toString(4)); // 4 is the indentation level
        }
    }

    private static void createDataFolderIfNotExists() throws IOException {
        Path path = Paths.get(DATA_FOLDER);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
    }
}
