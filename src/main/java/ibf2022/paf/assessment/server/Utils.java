package ibf2022.paf.assessment.server;

import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ibf2022.paf.assessment.server.models.User;
import ibf2022.paf.assessment.server.models.User2;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Utils {
    public static JsonArray toJsonArray(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(df);
        try {
            String jsonString = objectMapper.writeValueAsString(object);
            JsonReader jsonReader = Json.createReader(new StringReader(jsonString));
            return jsonReader.readArray();

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            JsonArray jsonArr = Json.createArrayBuilder().add("Object notmapped correctly").build();
            return jsonArr;
        }
    }

    public static JsonObject toJsonObject(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(df);
        try {
            String jsonString = objectMapper.writeValueAsString(object);
            JsonReader jsonReader = Json.createReader(new StringReader(jsonString));
            return jsonReader.readObject();

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            JsonObject jsonObject = Json.createObjectBuilder().add("message", "Object not mapped correctly").build();
            return jsonObject;
        }
    }

    public static String toJsonStr(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(df);
        try {
            String jsonString = objectMapper.writeValueAsString(object);
            return jsonString;

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static User user2ToUser(User2 user2){
        User user = new User();

        user.setName(user2.getFullname());
        user.setUserId(user2.getUserId());
        user.setUsername(user2.getUsername());

        return user;
    }

    public static User2 userToUser2(User user){
        User2 user2 = new User2();

        user2.setFullname(user.getName());
        user2.setUserId(user.getUserId());
        user2.setUsername(user.getUsername());

        return user2;
    }

}
