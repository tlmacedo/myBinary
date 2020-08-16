package br.com.tlmacedo.binary.services;

import br.com.tlmacedo.binary.model.Msg_type;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class UtilJson {
    static ObjectMapper mapper = new ObjectMapper();

    public static Object getObjectFromJson(String json, Class classe, Object o) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            o = mapper.readValue(json, classe);
            return o;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static JSONObject getJsonObjectFromObject(Object object) {
        try {
            return new JSONObject(mapper.writeValueAsString(object));
        } catch (JSONException | IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String getJsonFromObject(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            return null;
        }
    }

    public static String getJsonFromList(List list) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void printJsonFromObject(Object object, String label) {
        try {
            if (label != null)
                System.out.printf(label + "\n");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printJsonFromString(String string, String label) {
        try {
            JsonFactory factory = mapper.getFactory();
            JsonParser parser = factory.createParser(string);
            JsonNode actualObj = mapper.readTree(parser);
            if (label != null)
                System.out.printf(label + "\n");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(actualObj) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printJsonFromList(List list, String label) {
        try {
            if (label != null)
                System.out.printf(label + "\n");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getMsg_Type(String strJson) {
        JSONObject obj = new JSONObject(strJson);
        return new Msg_type(obj.getString("msg_type"));
    }

//    public static Object getMsg_Type(String strJson, String objeto, Class classe) {
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        Msg_type msg_type = gson.fromJson(strJson, classe);
//        System.out.printf("strJson:: %s\n", strJson);
//        System.out.printf("objeto:: %s\n", objeto);
//        printJsonFromString(strJson, "teste00");
//        JSONObject obj = new JSONObject(strJson);
//        printJsonFromObject(obj, "teste01");
//        if (obj.has(objeto)) {
//            System.out.printf("achou alguma coisa %s", obj.getString(objeto));
//            JSONObject msgType = obj.getJSONObject(objeto);
//            return getObjectFromJson(msgType.toString(), classe);
//        }
//        return null;
//    }
}
