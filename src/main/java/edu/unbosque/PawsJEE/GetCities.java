package edu.unbosque.PawsJEE;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.unbosque.persistence.Archivo;
import edu.unbosque.persistence.Duenio;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetCities", urlPatterns = {"/GetCities"})
public class GetCities extends HttpServlet {
    private Archivo archivo = new Archivo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            List<Duenio> duenio = archivo.leerArchivo(new File("C:\\Users\\felip\\4PawsJEE\\src\\main\\java\\edu\\unbosque\\persistence\\dato.dat"));

            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();

            out.print(gson.toJson(duenio));
        }
    }
}
