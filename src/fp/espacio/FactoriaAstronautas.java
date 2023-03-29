package fp.espacio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FactoriaAstronautas {
	public static Astronautas leerAstronautas(String rutaFichero) {
		Astronautas astronautas = new Astronautas();
		try {
			List<String> lineas = Files.readAllLines(Paths.get(rutaFichero));
			lineas.remove(0);
			for(String linea: lineas) {
				astronautas.agregarAstronauta(new Astronauta(linea));
				//astronautas.agregarAstronauta(parseaAstronauta(linea));
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return astronautas;
	}
	
	public static Astronauta parseaAstronauta(String linea) {
		String[] trozos = linea.split("\t");
		
		String name = trozos[0].trim();
		Integer year = Integer.valueOf(trozos[1].trim());
		Status status = Status.valueOf(trozos[2].trim().toUpperCase());
		Gender gender = Gender.valueOf(trozos[5].trim().toUpperCase());
		Integer spaceFlights = Integer.valueOf(trozos[6].trim());
		Boolean dead = Boolean.valueOf(trozos[7].trim());//trozos[7].equalsIgnoreCase("True");
		String birthPlace = trozos[4].trim();
		LocalDate birthDate = LocalDate.parse(trozos[3], DateTimeFormatter.ofPattern("M/dd/yyyy"));
		
		return new Astronauta(name, year, status, gender, spaceFlights, dead, birthPlace, birthDate);
	}
}
