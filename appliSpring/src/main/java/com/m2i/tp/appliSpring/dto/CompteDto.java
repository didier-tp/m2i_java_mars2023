package com.m2i.tp.appliSpring.dto;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

//@Getter @Setter @ToString @NoArgsConstructor
//@AllArgsConstructor
public class CompteDto {
	
    private Integer id;
    //ou bien private Integer numero;
    //ou bien private String numero;
    
    @Length(min=3, max=64, message = "entre 3 et 64 caracteres")
    private String label;
    //ou bien private String libelle;
    
    @Min(value=0 , message="le solde doit etre positif")  //necessite spring-boot-starter-validation
    private Double solde;
    

	public CompteDto() {
		super();
	}
	
	

	public CompteDto(Integer id,  String label, Double solde) {
		super();
		this.id = id;
		this.label = label;
		this.solde = solde;
	}



	@Override
	public String toString() {
		return "CompteDto [id=" + id + ", label=" + label + ", solde=" + solde + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}
    
    
}
