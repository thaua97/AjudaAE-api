package local.model;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Usuario{

private boolean ativo;
	
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
