package edu.unbosque.PawsJEE;

import edu.unbosque.persistence.*;

import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "datos", value = "/datos")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class DataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ArrayList<Duenio> alDuenio = new ArrayList<Duenio>();
    private DuenioDAO duenioDAO = new DuenioDAO();
    private Archivo archivo = new Archivo();

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return Constants.DEFAULT_FILENAME;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        Cookie[] cookies = request.getCookies();
        alDuenio = archivo.leerArchivo(new File("C:\\Users\\felip\\4PawsJEE\\src\\main\\java\\edu\\unbosque\\persistence\\dato.dat"));
        String nombre = cookies[0].getValue();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha1 = new Date();
        String fecha = String.valueOf(format.format(fecha1));
        String descripcion = request.getParameter("message");
        Part foto2 = request.getPart("imagen");
        RequestDispatcher dis = getServletContext().getRequestDispatcher("/photos.jsp");
        dis.forward(request, response);

        for (int i = 0; i < cookies.length; i++) {
            System.out.println(cookies[i].getValue().toString());
        }

        try {

            PrintWriter out = response.getWriter();
            out.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        String uploadPath = getServletContext().getRealPath("") + File.separator + "fotos";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists())
            uploadDir.mkdir();
        String fileName = "";
        try {

            fileName = getFileName(foto2);
            foto2.write(uploadPath + File.separator + fileName);

            request.setAttribute("message", "File " + fileName + " has uploaded successfully!");
        } catch (FileNotFoundException fne) {
            request.setAttribute("message", "There was an error: " + fne.getMessage());
        }
        Duenio duenio = new Duenio(nombre, fecha, descripcion, fileName);
        duenioDAO.agregar(duenio, alDuenio);

    }
}