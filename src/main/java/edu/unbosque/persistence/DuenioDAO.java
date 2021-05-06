
package edu.unbosque.persistence;

import java.io.*;
import java.util.*;



public class DuenioDAO {

	private File file = new File("C:\\Users\\felip\\4PawsJEE\\src\\main\\java\\edu\\unbosque\\persistence\\dato.dat");
	private Archivo archivo = new Archivo(file);

	public DuenioDAO() {

	}

	public void agregar(Duenio duenio, ArrayList<Duenio> alDuenio) {
		alDuenio.add(duenio);
		archivo.escribirEnArchivo(alDuenio, file);

	}

	public String ver(ArrayList<Duenio> alDuenio) {

		String texto = "";
		for(int i = 0; i < alDuenio.size();i++) {
			texto = alDuenio.get(i).getNombre();
		}

		return texto;

	}

//	public String verBalotoTotal(ArrayList<Baloto> alBaloto) {
//
//		String texto = "";
//
//		for (int i = 0; i < alBaloto.size(); i++) {
//
//			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
//			formateador.setLenient(false);
//			String pFecha = formateador.format(alBaloto.get(i).getFecha());
//
//			texto += ("Sede: " + alBaloto.get(i).getSede() + "\n" + "Cedula: " + alBaloto.get(i).getCedula() + "\n"
//					+ "Fecha: " + alBaloto.get(i).getFecha() + "\n" + "Valor de la apuesta: "
//					+ alBaloto.get(i).getValorApuesta() + "\n" + alBaloto.get(i).getPremio() + "\n" + "Numero: "
//					+ alBaloto.get(i).getNumero() + "\n\n");
//
//		}
//
//		return texto;
//
//	}

}
