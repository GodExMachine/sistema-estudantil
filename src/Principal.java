
public class Principal {

	public static void main(String[] args) {
		
	
	
		Empregado[] empregados = new Empregado[3];
		
		empregados[0]  = new Professor("Juscelino","tem","0921798731", 3000);
		empregados[1]  = new Diretor("Sonia","Abrao","3242343242",5000);
		empregados[2]  = new Professor("fabio","Silva","3563245435",3000);
		

		
		for(Empregado empregado : empregados) {
			
			System.out.println(empregado.calcularSalario());
			
			
		}
		
		
		
	}
}
