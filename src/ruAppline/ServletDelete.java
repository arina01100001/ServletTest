package ruAppline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ruAppline.logic.Model1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletDelete")
public class ServletDelete extends HttpServlet {

    Model1 model = Model1.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        StringBuffer jb = new StringBuffer();
        String line;

        try{
            BufferedReader br = request.getReader();
            while ((line=br.readLine())!=null){
                jb.append(line);
            }
        } catch (Exception e){
            System.out.println("error");
        }

        System.out.println(jb);

        JsonObject jsobject = gson.fromJson(String.valueOf(jb), JsonObject.class);

        int id = jsobject.get("id").getAsInt();
        model.delete(id);

        PrintWriter pw = response.getWriter();
        response.setContentType("application/json");

        pw.print(gson.toJson(model.getFromList()));

    }

}
