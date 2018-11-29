/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author estudiante
 */
public class Principal {

    public static void main(String[] args)
    {
    
        int numero;
        float numeroFloat;
        double numeroPreciso;
        String texto;
        float[] decimales = new float[5];
        
        numero = 5;
        numeroFloat = 314156e-5f;
        numeroPreciso = 0.00000001;
        texto = "Hola Mundo! Soy un print con formato!";
        
        System.out.println("Un numero: "+numero);
        System.out.println("Un float: "+numeroFloat);
        System.out.println("Un double: "+numeroPreciso);
        System.out.printf("%s \n",texto); // Uso printf como para variar un poco.
    
        decimales[0] = 1.2f;
        decimales[1] = 3e-5f;
        decimales[2] = 4.2f;
        decimales[3] = -5.5f;
        decimales[4] = 0f;
        
        for(int i = 0; i < 5; i++)
        {
            System.out.println("El elemento "+(i+1)+" vale: "+decimales[i]);
        }
        
        System.out.printf("El promedio de el vector de floats es: %f\n",promediar(decimales));
        
    }
    
    public static float promediar(float[] vector)
    {
        float contador = 0f;
        
        for( float individual : vector )
        {
            contador += individual;
        }
        contador/=5;
        
        return contador;
    }
}


