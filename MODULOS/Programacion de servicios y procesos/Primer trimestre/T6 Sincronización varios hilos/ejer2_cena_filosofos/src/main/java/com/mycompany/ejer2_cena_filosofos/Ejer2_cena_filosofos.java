/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejer2_cena_filosofos;

/**
 *
 * @author Ana
 */

/*En este problema, tenemos a cinco filósofos que se pasan la vida pensando y comiendo. Los filósofos están sentados en una mesa circular. Delante de cada filósofo hay un plato, y hay cinco platos en total. Cuando un filósofo está pensando, no necesita comer, y cuando come, no piensa. Cuando a un filósofo le da hambre y quiere comer, necesitará 2 cubiertos, por tanto, tratará de coger los dos cubiertos más cercanos a él, pero solo podrá usar cada cubierto si no lo tiene el filósofo contiguo. Cada cubierto, por tanto, es compartido por 2 filósofos. Cuando termina de comer, vuelve a dejar sus dos cubiertos en la mesa y comienza a pensar de nuevo.

Captura de pantalla 2024-11-13 192303.png

Crea, en tu proyecto Java, lo siguiente:

Clase Mesa, con métodos 'cogerTenedores' y 'soltarTenedores'. La clase debe comprobar qué cubiertos coge y suelta, en base al número de Filósofo (el filósofo 4, por ejemplo, utilizará los tenedores 3 y 4).
Clase Filosofo, que sencillamente coge tenedores, espera un tiempo aleatorio (mientras come) y suelta los tenedores, espera un tiempo aleatorio (mientras piensa) y vuelve a coger tenedores...
Clase Main en la que creas los 5 filósofos y la Mesa.*/

public class Ejer2_cena_filosofos {

    public static void main(String[] args) {
        
        Mesa m1 = new Mesa(5);

        Filosofo f1 = new Filosofo(0, m1, "Sócrates");
        Filosofo f2 = new Filosofo(1, m1, "Descartes");
        Filosofo f3 = new Filosofo(2, m1, "Platon");
        Filosofo f4 = new Filosofo(3,m1, "Nietzche");
        Filosofo f5 = new Filosofo(4,m1, "Kant");
        
        f1.start();
        f2.start();
        f3.start();
        f4.start();
        f5.start();
      

        
    }
}
