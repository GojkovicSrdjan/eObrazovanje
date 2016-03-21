package rs.ac.uns.ftn.tseo.ssd.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.HashSet;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer studentID;
	
	@Column(nullable=false, unique=true)
	private String brojIndexa;
	
	// -> Korisnik.korisnikID
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Korisnik korisnik;
	
	// -> ERacun.eRacunID
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private ERacun eRacun;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Dokument> dokumenta = new HashSet<Dokument>();
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Pohadja> pohadjanja = new HashSet<Pohadja>();

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer studentID, String brojIndexa, Korisnik korisnik, ERacun eRacun, Set<Dokument> dokumenta,
			Set<Pohadja> pohadjanja) {
		super();
		this.studentID = studentID;
		this.brojIndexa = brojIndexa;
		this.korisnik = korisnik;
		this.eRacun = eRacun;
		this.dokumenta = dokumenta;
		this.pohadjanja = pohadjanja;
	}

	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public String getBrojIndexa() {
		return brojIndexa;
	}

	public void setBrojIndexa(String brojIndexa) {
		this.brojIndexa = brojIndexa;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public ERacun geteRacun() {
		return eRacun;
	}

	public void seteRacun(ERacun eRacun) {
		this.eRacun = eRacun;
	}

	public Set<Dokument> getDokumenta() {
		return dokumenta;
	}

	public void setDokumenta(Set<Dokument> dokumenta) {
		this.dokumenta = dokumenta;
	}

	public Set<Pohadja> getPohadjanja() {
		return pohadjanja;
	}

	public void setPohadjanja(Set<Pohadja> pohadjanja) {
		this.pohadjanja = pohadjanja;
	}

	
}
