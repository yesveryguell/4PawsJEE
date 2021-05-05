package edu.unbosque.PawsJEE;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "datos", value = "/datos")
public class DataServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = new Date();
        format.format(fecha);
        String descripcion = request.getParameter("message");

        try {

            PrintWriter out = response.getWriter();
            out.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void destroy() {
    }

    public Properties cargarInfo(File archivo) throws Exception {
        Properties datos = new Properties();
        FileInputStream in = new FileInputStream(archivo);
        try {
            datos.load(in);
            in.close();
        } catch (Exception e) {
            throw new Exception("Paila pai");
        }
        return datos;
    }
}
