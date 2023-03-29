package fp.espacio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Astronautas {
	private List<Astronauta> astronautas;
	
	public Astronautas() {
		this.astronautas = new ArrayList<Astronauta>();
		
	}
	
	public Astronautas(List<Astronauta> astronautas) {
		this.astronautas = new ArrayList<Astronauta>();
	}
	
	public String toString() {
		return "Astronautas [astronautas=" + astronautas + "]";
	}
	
	public int hashCode() {
		return Objects.hash(astronautas);
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Astronautas other = (Astronautas) obj;
		return Objects.equals(astronautas, other.astronautas);
	}
	
	public Integer getNumeroAstronautas() {
		return astronautas.size();
	}
	
	public void agregarAstronauta(Astronauta a) {
		astronautas.add(a);
	}
	
	public void agregarColeccion(List<Astronauta> astronautas) {
		this.astronautas.addAll(astronautas);
	}
	
	public void eliminarAstronauta(Astronauta a) {
		astronautas.remove(a);
	}

	public List<Astronauta> getAstronautas() {
		return astronautas;
	}

	public void setAstronautas(List<Astronauta> astronautas) {
		this.astronautas = astronautas;
	}
	
	public Boolean hayAstronautaConMasVuelos(Integer n) {
		Boolean res = Boolean.FALSE;
		for(Astronauta a:astronautas) {
			if(a.getSpaceFlights() > n)
				res = Boolean.TRUE;
		}
		return res;
	}
	
	public Float getMediaDeYear() {
		Float suma = 0f;
		Integer cont = 0;
		for(Astronauta a:astronautas) {
			suma = suma+a.getYear();
			cont++;
		}
		return suma/cont;
	}
	
	public List<Astronauta> obtenerAstronautasPorGenero(Gender genero){
		List<Astronauta> res = new ArrayList<Astronauta>();
		for(Astronauta a:astronautas) {
			if(a.getGender().equals(genero))
				res.add(a);
		}
		return res;
	}
	
	public Map<Status, List<Astronauta>> agruparPorStatus(){
		Map<Status, List<Astronauta>> mapa = new HashMap<Status, List<Astronauta>>();
		for(Astronauta a:astronautas) {
			Status clave = a.getStatus();
			if(!mapa.containsKey(clave)) {
//				List<Astronauta> valor = new ArrayList<Astronauta>();
//				valor.add(a);
//				mapa.put(clave, valor);
				mapa.put(clave, new ArrayList<Astronauta>());
				mapa.get(clave).add(a);
			}else {
				mapa.get(clave).add(a);
			}
		}
		return mapa; 
	}
	
	public Map<Integer, Integer> getNumeroAstronautasPorYear(){
		Map<Integer, Integer> mapa = new HashMap<Integer, Integer>();
		for(Astronauta a:astronautas) {
			if(a.getSpaceFlights()>0) {
				Integer clave = a.getYear();
				if(!mapa.containsKey(clave)) {
					mapa.put(clave, 1);
				}else {
					Integer valor = mapa.get(clave);
					mapa.put(clave, valor+1);
				}
			}
		}
		return mapa;
	}
}
