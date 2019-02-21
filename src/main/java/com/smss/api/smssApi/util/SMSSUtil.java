package com.smss.api.smssApi.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SMSSUtil {
    private static Logger logger = LogManager.getLogger();
    public static byte[] getDefaultPhoto() {
        ClassLoader classLoader = getDefaultPhoto().getClass().getClassLoader();
        File file = new File(classLoader.getResource("images/photo/default.jpg").getFile());

        if (file.exists()) {
            try {
                return Files.readAllBytes(file.toPath());
            } catch (IOException ioe) {
                logger.error("Default image not found");
                return null;
            }
        }
        return null;
    }
    public static void main(String...args) {
     /*   String obj = "{" +
                "  \"name\":\"John\"," +
                "  \"age\":30," +
                "  \"cars\": [" +
                "    { \"name\":\"Ford\", \"models\":[ \"Fiesta\", \"Focus\", \"Mustang\" ] }," +
                "    { \"name\":\"BMW\", \"models\":[ \"320\", \"X3\", \"X5\" ] }," +
                "    { \"name\":\"Fiat\", \"models\":[ \"500\", \"Panda\" ] }" +
                "  ]" +
                " }";
        try {
            ObjectMapper map = new ObjectMapper();
            JsonNode newNode = map.readTree(obj);
            System.out.println(newNode.get("cars"));
        }catch(Exception e ){
            e.printStackTrace();
        }*/
        String mydate = "Tue Jan 01 05:30:00 IST 2019";
        SimpleDateFormat df = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        SimpleDateFormat dp = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt = (Date) df.parse(mydate);
            System.out.println(dt);
            System.out.println(dp.format(dt));

        }catch(DateTimeException | NullPointerException e){
            e.printStackTrace();
        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
    finally
    {
        try {

            String url = "<![CDATA[ <IMG SRC=\"  javascript:document.vulnerable=true;\"> ]]>";

            String encodedUrl = URLEncoder.encode(url, "UTF-8");

            System.out.println("Encoded URL " + encodedUrl);

            String decodedUrl = URLDecoder.decode(url, "UTF-8");

            System.out.println("Dncoded URL " + decodedUrl);
            Map<String,String> test = new HashMap<String,String>();
            test.put("a","test a");
            test.put("a","test b");
            test.put("b","test b second");
            test.put("c","test c");
            for(String key:test.keySet()){
                System.out.println(test.get(key)+" key "+key);
            }
            Map<Integer, String> treemap = new TreeMap<>();
            treemap.put(3, "TreeMap");
            treemap.put(2, "vs");
            treemap.put(1, "HashMap");
            for(Integer key:treemap.keySet()){
                System.out.println(treemap.get(key)+" key "+key);
            }
return;
           // System.exit(0);
        } catch (UnsupportedEncodingException e) {

            System.err.println(e);

        }
        finally{
            System.out.println("finally");
        }
    }

    }
}
