package homi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.json.simple.JSONObject;

public class search {

   public static void main(String[] args) throws MalformedURLException, ProtocolException, UnsupportedEncodingException, IOException {
      // TODO Auto-generated method stub

         JSONObject search = new JSONObject();

         search.put("search", "1910");;

       URL url = new URL("http://172.30.1.55:3000/search_date");
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setDoOutput(true);
         conn.setRequestMethod("POST"); // 보내는 타입
         conn.setRequestProperty("Content-Type", "application/json");
         // 데이터
         //String param = "{\"title\": \"asdasd\", \"body\" : \"ddddddddd\"}";
         // 전송
         OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
         try {
            osw.write(search.toString());
            osw.flush();
            // 응답
            BufferedReader br = null;
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
               System.out.println(line);
            }
            // 닫기
            osw.close();
            br.close();
         } catch (MalformedURLException e) {
            e.printStackTrace();
         } catch (ProtocolException e) {
            e.printStackTrace();
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         }

      }
   }

