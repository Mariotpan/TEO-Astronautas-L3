package fp.espacio.test;

import java.util.List;
import java.util.Map;

import fp.espacio.Astronauta;
import fp.espacio.Astronautas;
import fp.espacio.FactoriaAstronautas;
import fp.espacio.Gender;
import fp.espacio.Status;

public class TestFactoria {
	
	public static void main(String[] args) {
		Astronautas astronautas = FactoriaAstronautas.leerAstronautas("data/astronautas.csv");
//		System.out.println(astronautas.getAstronautas().subList(0, 3));
		testLeerAstronautas(astronautas);
		testAgruparPorStatus(astronautas);
		testGetNumeroAstronautasPorYear(astronautas);
//		testObtenerAstronautasPorGenero(astronautas, Gender.MALE);
//		testObtenerAstronautasPorGenero(astronautas, Gender.FEMALE);
//		List<Astronauta> listaGenero =  astronautas.obtenerAstronautasPorGenero(Gender.MALE);
//		System.out.println(listaGenero.subList(0, 3));
	}
	
	public static void testLeerAstronautas(Astronautas as) {
		System.out.println("Hay un total de "+as.getNumeroAstronautas()+"stronauta en el CSV.");
		System.out.println("Los 3 primeros son:\n"+as.getAstronautas().subList(0, 3));
	}
	
	public static void testObtenerAstronautasPorGenero(Astronautas as, Gender genero) {
		List<Astronauta> listaGenero =  as.obtenerAstronautasPorGenero(genero);
		System.out.println(listaGenero.subList(0, 3));
	}
	
	public static void testAgruparPorStatus(Astronautas astronautas) {
		Map<Status, List<Astronauta>> mapa = astronautas.agruparPorStatus();
		System.out.println(mapa);
	}
	
	public static void testGetNumeroAstronautasPorYear(Astronautas astronautas) {
		Map<Integer, Integer> mapa = astronautas.getNumeroAstronautasPorYear();
		System.out.println(mapa);
	}
}
