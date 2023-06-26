package pacote;

public class Validacao {
	public static boolean validarNome(String nome) {
		if(nome == null) {
			System.out.println("Nome vazio");
			return false;
		}
		if(nome.matches("[a-zA-Z]*")) {
			//System.out.println("Nome válido\n");
			return true;
		}
		System.out.println("Nome só pode conter letras");
		return false;
	}
	public static boolean validarCnpj(String cnpj) {
		if(cnpj == null) {
			System.out.println("CNPJ vazio");
			return false;
		}
		cnpj = cnpj.replaceAll("[^0-9]+", "");//remover caract nao num
		int n = cnpj.length();
		if(n != 14) { //verifica se tem 14 digitos
			System.out.println("CNPJ precisa ter 14 dígitos");
			return false;
		}
		//verifica digitos iguais
		int i = 0;
		while (i < n) {
			if(cnpj.charAt(i) != cnpj.charAt(n-1))
				break;
			i++;
		}
		if (i == n) {
			System.out.println("CNPJ não pode ter todos os dígitos iguais");
			return false;
		}
		//calcular digito verificador
		int sm = 0;
		int p1 = 5;
		int p2 = 13;
		int r, num;
		int digito1, digito2;
		//calculo do digito1
		for (var j = 0; j < 12; j++, p1--, p2--) {
			if(p1 >=2) {
				num = (int)(cnpj.charAt(j)-48);
				sm = sm +(num*p1);	
			}
			else {
				num = (int)(cnpj.charAt(j)-48);
				sm = sm +(num*p2);
			}
		}
		r = sm % 11;
		if(r < 2)
			digito1 = '0';
		else digito1 = (char)(48+(11-r));
		//calculo do digito2
		sm = 0;
		int p3 = 6;
		int p4 = 14;
		for (var j = 0; j < 13; j++, p3--, p4--) {
			if(p3 >=2) {
				num = (int)(cnpj.charAt(j)-48);
				sm = sm +(num*p3);	
			}
			else {
				num = (int)(cnpj.charAt(j)-48);
				sm = sm +(num*p4);
			}
		}
		r = sm % 11;
		if(r < 2)
			digito2 = '0';
		else digito2 = (char)(48+(11-r));
		//verificar os digitos calculados com os dados
		if((digito1 != cnpj.charAt(12)||(digito2 != cnpj.charAt(13)))) {
			System.out.println("CNPJ não possui os últimos dígitos corretos");
			return false;
		}
		//System.out.println("CNPJ válido\n");
		return true;
	}
}
