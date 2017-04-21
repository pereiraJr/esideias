package ideias.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
@IdClass(Avaliacao.AvaliacaoPK.class)
public class Avaliacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToMany
	private Avaliador avaliador;
	@Id
	@OneToMany
	private Ideias ideia;
	@NotNull
	private Integer nota;

	public Avaliador getAvaliador() {
		return avaliador;
	}
	public void setAvaliador(Avaliador avaliador) {
		this.avaliador = avaliador;
	}
	public Ideias getIdeia() {
		return ideia;
	}
	public void setIdeia(Ideias ideia) {
		this.ideia = ideia;
	}
	public Integer getNota() {
		return nota;
	}
	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public static class AvaliacaoPK implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Avaliador avaliador;
		private Ideias ideia;
		public Avaliador getAvaliador() {
			return avaliador;
		}
		public void setAvaliador(Avaliador avaliador) {
			this.avaliador = avaliador;
		}
		public Ideias getIdeia() {
			return ideia;
		}
		public void setIdeia(Ideias ideia) {
			this.ideia = ideia;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((avaliador == null) ? 0 : avaliador.hashCode());
			result = prime * result + ((ideia == null) ? 0 : ideia.hashCode());
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
			AvaliacaoPK other = (AvaliacaoPK) obj;
			if (avaliador == null) {
				if (other.avaliador != null)
					return false;
			} else if (!avaliador.equals(other.avaliador))
				return false;
			if (ideia == null) {
				if (other.ideia != null)
					return false;
			} else if (!ideia.equals(other.ideia))
				return false;
			return true;
		}
	}
}
