package ideias.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;

	@Deprecated
	private boolean gostou;
	
	@NotNull
	private Integer nota;

	@ManyToOne
	private Ideias ideias;

	@ManyToOne
	private Admin admin;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public boolean isGostou() {
		return gostou;
	}

	public void setGostou(boolean gostou) {
		this.gostou = gostou;
	}
	
	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public Ideias getIdeias() {
		return ideias;
	}

	public void setIdeias(Ideias ideias) {
		this.ideias = ideias;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
