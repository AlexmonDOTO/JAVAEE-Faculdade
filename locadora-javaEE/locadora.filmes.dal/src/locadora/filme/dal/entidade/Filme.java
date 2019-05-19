package locadora.filme.dal.entidade;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.*;

@Entity
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFilme;
	
		
	@NotNull(message = "Informe a quantidade de exemplares")
	@Min(value = 1, message = "Quantidade de portas inválida." )
	private Short quantidadeExemplares;
	
	
	@NotNull(message = "Insiras as informações do filme")
	@ManyToOne
	@JoinColumn(name = "idInfoFilme")
	private InfoFilme infoFilme;
	
	@NotNull(message = "Informe o combustível")
	@ManyToOne
	@JoinColumn(name = "idCombustivel")
	private Combustivel combustivel;
	
	
	@ManyToMany
	@JoinTable(name = "AutomovelOpcional",
			joinColumns = @JoinColumn(name = "idAutomovel"),
			inverseJoinColumns = @JoinColumn(name = "idOpcional"))
	private List<Opcional> opcionais;
	
	@OneToMany(mappedBy = "automovel")
	private List<LocacaoAutomovel> locacaoAutomoveis;


	private Genero genero;

	
	public List<LocacaoAutomovel> getLocacaoAutomoveis() {
		return locacaoAutomoveis;
	}


	public void setLocacaoAutomoveis(List<LocacaoAutomovel> locacaoAutomoveis) {
		this.locacaoAutomoveis = locacaoAutomoveis;
	}


	public Integer getIdAutomovel() {
		return idAutomovel;
	}


	public void setIdAutomovel(Integer idAutomovel) {
		this.idAutomovel = idAutomovel;
	}


	public Integer getAno() {
		return ano;
	}


	public void setAno(Integer ano) {
		this.ano = ano;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public Short getQuantidadeExemplares() {
		return quantidadeExemplares;
	}


	public void setQuantidadeExemplares(Short quantidadeExemplares) {
		this.quantidadeExemplares = quantidadeExemplares;
	}


	public List<Opcional> getOpcionais() {
		return opcionais;
	}


	public void setOpcionais(List<Opcional> opcionais) {
		this.opcionais = opcionais;
	}


	public Genero getGenero() {
		return getGenero();
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}



	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFilme == null) ? 0 : idFilme.hashCode());
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
		Filmel other = (Filme) obj;
		if (idFilme == null) {
			if (other.idFilme != null)
				return false;
		} else if (!idFilme.equals(other.idFilme))
			return false;
		return true;
	}
	
		
	
	
}
