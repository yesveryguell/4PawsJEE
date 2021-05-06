package edu.unbosque.persistence;

import java.io.*;
import java.util.*;


public class Archivo {

	private ObjectInputStream entrada;
	private ObjectOutputStream salida;

	public Archivo() {

	}

	public Archivo(File archivo) {

		if (archivo.exists()) {

		} else {
			try {
				archivo.createNewFile();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	public void escribirEnArchivo(ArrayList<Duenio> alDuenio, File archivo) {

		try {

			salida = new ObjectOutputStream(new FileOutputStream(archivo));
			salida.writeObject(alDuenio);
			salida.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public ArrayList<Duenio> leerArchivo(File archivo) {

		ArrayList<Duenio> alDuenio = new ArrayList<Duenio>();

		if (archivo.length() != 0)

		{
			try {

				entrada = new ObjectInputStream(new FileInputStream(archivo));
				alDuenio = (ArrayList<Duenio>) entrada.readObject();

			} catch (FileNotFoundException e) {

				e.printStackTrace();
				System.out.println(e);

			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}

		return alDuenio;
	}
}