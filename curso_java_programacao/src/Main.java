import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		int x = 32;
		System.out.println(x);
		double y = 10.35784;
		System.out.println(y);
		
		//impressão formatada -- duas casas
		System.out.printf("%.2f\n",y);
		
		//impressão formatada -- 4 casas (formatação padrão do dispositivo)
		System.out.printf("%.4f\n",y);
		
		//impressão formatada -- 4 casas (formatação padrão Especifica)
		Locale.setDefault(Locale.US);
		System.out.printf("%.4f\n",y);
				
		System.out.println("Olá Mundo");
		
		System.out.println("Resultado = " + x + " metros.");
		
		System.out.printf("Resultado = %.2f metros.\n", y);
		
		String nome = "Maria";
		int idade = 32;
		double renda = 4000.0;
		System.out.printf("%s tem %d anos e ganha %.2f reais", nome, idade, renda);
		
	}

}
