package fp.espacio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Astronauta {
	private String name;
	private Integer year;
	private Status status;
	private Gender gender;
	private Integer spaceFlights;
	private Boolean dead;
	private Nacimiento birth;
	
	
	public Astronauta(String name, Integer year, Status status, Gender gender, Integer spaceFlights, Boolean dead, String birthPlace, LocalDate birthDate) {
		this.name = name;
		this.year = year;
		this.status = status;
		this.gender = gender;
		this.spaceFlights = spaceFlights;
		this.dead = dead;
		this.birth = new Nacimiento(birthPlace, birthDate);
	}
	
	public Astronauta(String datos) {
		String[] trozos = datos.split("\t");
		
		this.name = trozos[0];
		this.year = Integer.valueOf(trozos[1]);
		this.status = Status.valueOf(trozos[2].toUpperCase());
		this.gender = Gender.valueOf(trozos[5].toUpperCase());
		this.spaceFlights = Integer.valueOf(trozos[6]);
		this.dead = Boolean.valueOf(trozos[7]);
		
		LocalDate birthDate = LocalDate.parse(trozos[3], DateTimeFormatter.ofPattern("M/dd/yyyy"));
		this.birth = new Nacimiento(trozos[4], birthDate);
	}

	public String toString() {
		return "Astronauta [name=" + name + ", year=" + year + ", status=" + status + ", gender=" + gender
				+ ", spaceFlights=" + spaceFlights + ", dead=" + dead + ", birth=" + birth + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(birth.birthDate(), name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Astronauta other = (Astronauta) obj;
		return Objects.equals(birth.birthDate(), other.birth.birthDate()) && Objects.equals(name, other.name);
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Boolean getDead() {
		return dead;
	}

	public void setDead(Boolean dead) {
		this.dead = dead;
	}

	public Nacimiento getBirth() {
		return birth;
	}

	public void setBirth(Nacimiento birth) {
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public Integer getYear() {
		return year;
	}

	public Gender getGender() {
		return gender;
	}

	public Integer getSpaceFlights() {
		return spaceFlights;
	}
	
	public int compareTo(Astronauta o) {
		int r= name.compareTo(o.getName());
		if(r==0) {
			r=birth.birthDate().compareTo(o.birth.birthDate());
		}
		return r;
	}

}
