package it.prova.dottore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dottore")
public class Dottore {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "codicedottore")
	private String codiceDottore;
	@Column(name = "codfiscalepazienteattualmenteinvisita")
	private String codFiscalePazienteAttualmenteInVisita;
	@Column(name = "invisita")
	private Boolean inVisita;
	@Column(name = "inservizio")
	private Boolean inServizio;
	
	public Dottore(String nome, String cognome, String codiceDottore, String codFiscalePazienteAttualmenteInVisita,
			Boolean inVisita, Boolean inServizio) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDottore = codiceDottore;
		this.codFiscalePazienteAttualmenteInVisita = codFiscalePazienteAttualmenteInVisita;
		this.inVisita = inVisita;
		this.inServizio = inServizio;
	}

	public Dottore(Long id, @NotBlank(message = "Il campo Nome deve essere valorizzato") String nome,
			@NotBlank(message = "Il campo Cognome deve essere valorizzato") String cognome,
			@NotBlank(message = "Il campo Codice Dottore  deve essere valorizzato") String codiceDottore,Boolean inVisita, Boolean inServizio,
			String codFiscalePazienteAttualmenteInVisita) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDottore = codiceDottore;
		this.codFiscalePazienteAttualmenteInVisita = codFiscalePazienteAttualmenteInVisita;
		this.inVisita = inVisita;
		this.inServizio = inServizio;
	}



}

