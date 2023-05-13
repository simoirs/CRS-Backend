package com.CRS.util;

import com.CRS.model.Candidato;

public class CandidatoUpdater {
	
	public static Candidato transferFields(Candidato candidatoToUpdate, Candidato candidato) {
		candidatoToUpdate.setNome(candidato.getNome());
		candidatoToUpdate.setCognome(candidato.getCognome());
		candidatoToUpdate.setEmail(candidato.getEmail());
		candidatoToUpdate.setTelefono(candidato.getTelefono());
		candidatoToUpdate.setPosizione(candidato.getPosizione());
		candidatoToUpdate.setValutazione(candidato.getValutazione());
		candidatoToUpdate.setNote(candidato.getNote());
		
		return candidatoToUpdate;
	}

}
