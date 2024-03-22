package com.focp2.repository;

import com.focp2.model.Product;
import com.focp2.util.JsonFileManager;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final String FILE_NAME = "products.json";

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            JSONArray jsonArray = JsonFileManager.readJsonArrayFromFile(FILE_NAME);
            for (Object obj : jsonArray) {
                JSONObject jsonProduct = (JSONObject) obj;
                Product product = new Product(
                        jsonProduct.getString("id"),
                        jsonProduct.getString("name"),
                        jsonProduct.getDouble("price"),
                        jsonProduct.getInt("quantity")
                );
                products.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void addProduct(Product product) {
        try {
            JSONArray jsonArray = JsonFileManager.readJsonArrayFromFile(FILE_NAME);
            JSONObject jsonProduct = new JSONObject()
                    .put("id", product.getId())
                    .put("name", product.getName())
                    .put("price", product.getPrice())
                    .put("quantity", product.getQuantity());
            jsonArray.put(jsonProduct);
            JsonFileManager.writeJsonArrayToFile(jsonArray, FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(Product updatedProduct) {
        try {
            JSONArray jsonArray = JsonFileManager.readJsonArrayFromFile(FILE_NAME);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonProduct = jsonArray.getJSONObject(i);
                if (jsonProduct.getString("id").equals(updatedProduct.getId())) {
                    jsonProduct.put("name", updatedProduct.getName());
                    jsonProduct.put("price", updatedProduct.getPrice());
                    jsonProduct.put("quantity", updatedProduct.getQuantity());
                    break;
                }
            }
            JsonFileManager.writeJsonArrayToFile(jsonArray, FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
