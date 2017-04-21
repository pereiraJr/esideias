package ideias.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@IdClass(Usuario.usuarioPK.class)
public class Usuario implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@NotEmpty
	private String nome;
	@NotEmpty
	private String senha;
	private Integer matricula;
	private boolean aluno;
	
	@Id
	@Email
	private String email;
	@Id
	@NotEmpty
	private String login;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	@OneToMany(mappedBy="usuario")
	private List<Ideias> Ideias = new ArrayList<>();

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Ideias> getIdeias() {
		return Ideias;
	}
	public void setIdeias(List<Ideias> ideias) {
		Ideias = ideias;
	}
	public Integer getMatricula() {
		return matricula;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	public boolean isAluno() {
		return this.matricula != null;
	}
	public void setAluno(boolean aluno) {
		this.aluno = aluno;
	}

	
	public static class usuarioPK implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String email;
		
		private String login;
		public String getEmail() {
			return email;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((login == null) ? 0 : login.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			usuarioPK other = (usuarioPK) obj;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (login == null) {
				if (other.login != null)
					return false;
			} else if (!login.equals(other.login))
				return false;
			return true;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		
	}}

