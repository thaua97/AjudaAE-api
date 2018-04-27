package local.model;

import javax.persistence.Entity;

import local.model.GenericModel;

@Entity
public class Funcionario extends GenericModel {

private boolean ativo;
	
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
