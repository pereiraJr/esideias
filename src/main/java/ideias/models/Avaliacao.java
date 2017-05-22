package ideias.models;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Avaliacao {

	
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer Id;
	private boolean gostou;
	public boolean isGostou() {
		return gostou;
	}

	public void setGostou(boolean gostou) {
		this.gostou = gostou;
	}
	



	@ManyToOne
	private Ideias ideias;
	
	public Ideias getIdeias() {
		return ideias;
	}

	public void setIdeias(Ideias ideias) {
		this.ideias = ideias;
	}

	@ManyToOne
	private Admin admin;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
