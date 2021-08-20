package entities;

public class PessoaJuridica extends Contribuintes {
	
	private Integer numeroFuncionarios;
	
	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String name, Double rendaAnual, Integer numeroFuncionarios) {
		super(name, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	@Override
	public Double impostos() {
		if(numeroFuncionarios<10) {
			return rendaAnual * 0.16; 
		}
		else {
			return rendaAnual * 0.14; 
		}
	}	
}
