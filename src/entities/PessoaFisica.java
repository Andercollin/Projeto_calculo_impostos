package entities;

public class PessoaFisica extends Contribuintes {

	private Double gastosSaude;
	
	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String name, Double rendaAnual, Double gastosSaude) {
		super(name, rendaAnual);
		this.gastosSaude = gastosSaude;
	}
	
	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	@Override
	public Double impostos() {
		if(rendaAnual<20000.00) {
			return ((rendaAnual * 0.15) - (gastosSaude * 0.5)); 
		}
		else {
			return ((rendaAnual * 0.25) - (gastosSaude * 0.5)); 
		}
	}
}
