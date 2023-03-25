package taller_excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

/**

	La clase CalculosNumericos contiene métodos para realizar cálculos matemáticos
	como raíz cuadrada, pendiente y punto medio de una recta, raíces cuadráticas y
	convertir números de base 10 a cualquier otra base.
*/

public class CalculosNumericos {
	public CalculosNumericos() {
		// TODO Auto-generated constructor stub
	}	
	
	/**
	 * Este método calcula la raíz cuadrada de un número positivo.
	 * @param numero el número del que se desea calcular la raíz cuadrada
	 * @throws ArithmeticException si el número es negativo
	 */
	public static void raizCuadrada(double numero) {		
		try {
			if(numero < 0) {
				throw new ArithmeticException("el numero debe ser positivo");
			}
			double raiz = Math.sqrt(numero);
			System.out.println("la raiz es: "+raiz);
		} catch (ArithmeticException e) {
			System.out.println("solo asi se puede hallar la raiz");
		}
	}
	
	/**
	 * Este método calcula la pendiente o el punto medio de una recta, según la opción 
	 * seleccionada por el usuario.
	 * @param opc la opción seleccionada por el usuario (1 para pendiente, 2 para punto medio)
	 * @throws ArithmeticException si ocurre una división por cero al calcular la pendiente
	 * @throws InputMismatchException si el usuario ingresa un valor no numérico
	 */
	public static void Recta(int opc) {
		Scanner teclado = new Scanner(System.in);			
		try {
			
			System.out.println("digita el valor de x1 ");
			double x1 = teclado.nextDouble();
			System.out.println("digita el valor de y1 ");
			double y1 = teclado.nextDouble();
			System.out.println("digita el valor de x2 ");
			double x2 = teclado.nextDouble();
			System.out.println("digita el valor de y2 ");
			double y2 = teclado.nextDouble();
			teclado.close();
			if (opc == 1) {
				if ( x2 - x1 == 0 ) {
					throw new ArithmeticException("x1 debe ser diferente de x2");
				}
				double pendiente = (y2-y1)/(x2-x1);
				System.out.println("La pendiente es: "+pendiente);
			}else {
				double medioX = (x1+x2)/2;
				double medioY = (y1+y2)/2;
				System.out.println("Punto medio es: ("+medioX+","+medioY+")");
			}		
			
		} catch (ArithmeticException e) {
			System.out.println("porque la division por zero no esta permitida");
			teclado.close();
		} catch (InputMismatchException e) {
			System.out.println("deben ser numeros reales sin espacios o letras");
			teclado.close();
		}
	}
	
	/**
	 * Este método calcula las raíces cuadráticas de una ecuación de segundo grado.
	 * @throws ArithmeticException si el coeficiente A es cero o si se intenta dividir por cero
	 * @throws InputMismatchException si el usuario ingresa un valor no numérico
	 */
	public static void raicesCuadraticas() {
		Scanner teclado = new Scanner(System.in);
		try {
			System.out.println("digita el valor de x1 ");
			double a = teclado.nextDouble();
			System.out.println("digita el valor de y1 ");
			double b = teclado.nextDouble();
			System.out.println("digita el valor de x2 ");
			double c = teclado.nextDouble();
			teclado.close();
			double determinante =b*b-4*a*c;
			if ( a == 0) {
				throw new ArithmeticException("A no puede valer cero");
			} else if(determinante == 0) {
				double raiz = -b/(2*a);
				System.out.println("la misma raiz = "+raiz);
			}else if(determinante > 0) {
				double raiz1 = (-b+Math.sqrt(determinante))/(2*a);
				double raiz2 = (-b-Math.sqrt(determinante))/(2*a);
				System.out.println("x1 = "+raiz1);
				System.out.println("x2 = "+raiz2);
			}else {
				double real = a/(2*a);
				double imaginario = Math.sqrt(-1*determinante)/(2*a);
				System.out.println("x1 = "+real+" + "+imaginario+"i");
				System.out.println("x1 = "+real+" - "+imaginario+"i");
			}
			
		} catch (ArithmeticException e) {
			System.out.println("la division por cero no existe");
			teclado.close();
		} catch (InputMismatchException e) {
			System.out.println("deben ser numeros reales sin espacios o letras");
			teclado.close();
		}
	}
	
	/**
	* Convierte un número entero a una base N.
	* @param opc Indica si el número a convertir es entero (1) o decimal (2).
	* @param base La base a la cual se quiere convertir el número.
	* @throws InputMismatchException Si el usuario ingresa un valor no numérico.
	* @throws IllegalArgumentException Si la base ingresada no es válida.
	*/
	public static void base_10_a_N() {
		Scanner teclado = new Scanner(System.in);
		String strEntero = "", strDecimal = "";
		Character[] digito = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		try {
			System.out.println("digite 1 para entero o 2 para decimal ");
			int opc = teclado.nextInt();
			System.out.println("digite un numero entero para la base ");
			int base = teclado.nextInt();
			
			
			
			do {
				if (opc == 1) {
					System.out.println("digite el numero decimal ");
					int entero = teclado.nextInt();
					
					while (entero >= base) {
						int residuo = entero % base;
						entero =  entero/base;
						strEntero += String.valueOf(digito[residuo]);
					}
					
					System.out.println("el entero "+entero+" a base "+base+" es: ");
					System.out.println(revertir(strEntero));
				} else if (opc == 2) {
					System.out.println("digite el numero decimal ");
					double decimal = teclado.nextDouble();
					
					String[] matriz = String.valueOf(decimal).split(".");
					int entero = Integer.parseInt(matriz[0]);
					double dec = Double.parseDouble("0."+matriz[1]);
					
					while (entero >= base) {
						int residuo = entero % base;
						entero = entero/base;
						strEntero += String.valueOf(digito[residuo]);
					}
					
					dec = dec*base;
					String[] cadena_num = String.valueOf(dec).split(".");
					while (Integer.parseInt( cadena_num[1] ) != 0) {						
						strDecimal += String.valueOf(digito[Integer.parseInt(cadena_num[0])]);
						dec = Double.parseDouble("0."+cadena_num[0]);
						dec = dec*base;
						cadena_num = String.valueOf(dec).split(".");
					}
					
					
					System.out.println("el entero "+entero+" a base "+base+" es: ");
					System.out.println( revertir(strEntero) + strDecimal);
					
				} else {
					System.out.println("digite una opcion valida");
					System.out.println("digite unicamente 1 para entero o 2 para decimal ");
					opc = teclado.nextInt();
				}
				teclado.close();
				
			} while (opc!=1 && opc!=2);
		} catch (NumberFormatException e) {
			System.out.println("deben ser numeros reales sin espacios, letras o simbolos excepto un .");
			teclado.close();
		}
	}
	
	public static String revertir(String str) {
		return new StringBuilder(str).reverse().toString();
	}
}
