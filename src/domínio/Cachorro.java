package domínio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Cachorro implements Serializable {
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cor;
	
	private static final long serialVersionUID = 1L;
	public Cachorro(Integer id, String nome, String cor) {
		super();
		this.id = id;
		this.nome = nome;
		this.cor = cor;
	}
	public Cachorro() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	@Override
	public String toString() {
		return "Cachorro [id=" + id + ", nome=" + nome + ", cor=" + cor + "]";
	}


}
