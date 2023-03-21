package com.m2i.tp.appliSpring.dto;

//soit DemandeVirementDto et StatusVirementDto
//ou bien VirementDto enrichi du coté serveur

//@Getter @Setter @ToString @NoArgsConstructor
//@AllArgsConstructor
public class VirementDto {

	private double montant;
	private int numCptDeb;
	private int numCptCred;
	private Boolean ok = null;
	private String message = null;
	
	
	
	public VirementDto() {
		super();
	}
	
	public VirementDto(double montant, int numCptDeb, int numCptCred, Boolean ok, String message) {
		super();
		this.montant = montant;
		this.numCptDeb = numCptDeb;
		this.numCptCred = numCptCred;
		this.ok = ok;
		this.message = message;
	}
	@Override
	public String toString() {
		return "VirementDto [montant=" + montant + ", numCptDeb=" + numCptDeb + ", numCptCred=" + numCptCred + ", ok="
				+ ok + ", message=" + message + "]";
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public int getNumCptDeb() {
		return numCptDeb;
	}
	public void setNumCptDeb(int numCptDeb) {
		this.numCptDeb = numCptDeb;
	}
	public int getNumCptCred() {
		return numCptCred;
	}
	public void setNumCptCred(int numCptCred) {
		this.numCptCred = numCptCred;
	}
	public Boolean getOk() {
		return ok;
	}
	public void setOk(Boolean ok) {
		this.ok = ok;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
