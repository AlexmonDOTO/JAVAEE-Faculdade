package locadora.filme.dal.entidade;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.*;

@Entity
public class InfoFilme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private integer idInfoFilme;
	
	@NotNull(message = "Campo ano lançamento é obrigatório")
	@Size(max = 50, message = "O campo descrição pode ter no máximo 50 caracteres")
	private date anoLancamento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDiretor")
	@NotNull(message = "Direto é obrigatória")
	private Diretor diretor;
	
	@OneToMany(mappedBy = "infoFilme")
	private List<Filmel> filme;

	public Short getIdInfoFilme() {
		return idInfoFilme;
	}

	public void setIdInfoFilme(Short idInfoFilme) {
		this.idInfoFilme = idInfoFilme;
	}

	public date getanoLancamento() {
		return anoLancamento;
	}

	public void setanoLancamento(date anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public Diretor getDiretor() {
		return Diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor =diretor;
	}

	public List<Filme> getFilme() {
		return filme;
	}

	public void setfilme(List<Filme> filme) {
		this.filme = filme;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idInfoFilme == null) ? 0 : idInfoFilme.hashCode());
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
		InfoFilme other = (InfoFilme) obj;
		if (idInfoFilme == null) {
			if (other.idInfoFilme != null)
				return false;
		} else if (!idInfoFilme.equals(other.idInfoFilme))
			return false;
		return true;
	}
	
}
