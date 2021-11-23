package ruAppline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ruAppline.logic.Model1;
import ruAppline.logic.User1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.spec.ECField;

@WebServlet(name = "ServletPut")

public class ServletPut extends HttpServlet {
    Model1 model = Model1.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuffer jb = new StringBuffer();
        String line;

        try{
            BufferedReader br = request.getReader();
            while ((line=br.readLine())!=null){
                jb.append(line);
            }
        } catch(Exception e){
            System.out.println("error");
        }

        System.out.println(jb);

        JsonObject jsobject = gson.fromJson(String.valueOf(jb), JsonObject.class);

        int id = jsobject.get("id").getAsInt();
        String name = jsobject.get("name").getAsString();
        String surname = jsobject.get("surname").getAsString();
        double salary = jsobject.get("salary").getAsDouble();

        User1 user1 = new User1(name, surname, salary);
        model.put(user1, id);

        response.setContentType("application/json; charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.print(gson.toJson(model.getFromList()));

    }

}
