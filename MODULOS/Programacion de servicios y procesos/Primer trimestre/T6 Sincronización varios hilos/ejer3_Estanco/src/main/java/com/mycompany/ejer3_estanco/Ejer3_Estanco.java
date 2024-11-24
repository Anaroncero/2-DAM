/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejer3_estanco;

/**
 *
 * @author Ana
 */

/*El problema de los fumadores

Nos encontramos en un estanco, donde hay 3 fumadores y el trabajador del estanco o 'estanquero'. Los fumadores quieren fumar continuamente y para siempre, primero un cigarrillo, después otro... Para un cigarrillo los fumadores necesitan papel, tabaco y una cerilla. El trabajo del estanquero será suministrarles lo que les falte en cada momento. El estanquero, por lo tanto, no hará otra cosa que colocar los suministros (papel, tabaco y cerillas) en el mostrador, y los fumadores irán cogiendo los que necesiten.

Hay un fumador que de inicio ya tiene papel, otro que ya tiene tabaco y otro que ya tiene cerilla. Cada uno tiene una gran cantidad de su material, por lo que nunca se le acabará... siempre necesitará tan solo los 2 materiales que le faltan.

En el mostrador el estanquero solo puede colocar 2 ingredientes (no caben más), así que elegirá 2 ingredientes al azar y los colocará en el mostrador, avisando a los fumadores.

Los fumadores comprobarán qué ingredientes ha puesto, y evidentemente sólo les servirán a un fumador (por ejemplo, si se ha colocado en el mostrador papel y tabaco, solo le servirá a el fumador que ya tenía cerilla) que será quien coja los ingredientes, se ponga a fumar y avise al estanquero de que el mostrador está libre y ya puede volver a colocar ingredientes.

Cada fumador tarda un tiempo en fumarse un cigarro (que representaremos con un número aleatorio entre 3 y 6 segundos). Cuando pase este tiempo, el fumador habrá agotado los 2 ingredientes que cogió del mostrador (no el que traía, pues de este tiene cantidad ilimitada). Se quedará por tanto esperando a que los 2 ingredientes que le faltan vuelvan a estar en el mostrador.

Importante: el fumador siempre coge los dos ingredientes de golpe, y solo los coge cuando los 2 que hay en el mostrador son los 2 que a él le hacen falta. Si un ingrediente de los que hay en el mostrador le sirve pero el otro no, entonces no cogerá ninguno.

El estanquero, por su parte, siempre se dedica a poner 2 ingredientes al azar en el mostrador, esperar a que un fumador los coja y avise, y volver a poner otros 2 ingredientes en el mostrador... así indefinidamente. Puedes poner una espera de unos cuantos milisegundos entre que pone unos suministros y los siguientes, para simular lo que tarda en cogerlos.

 

Ejemplo de consola:

Estanquero coloca el ingrediente: papel
Estanquero coloca el ingrediente: cerilla
Fumador con tabaco está fumando.
Estanquero coloca el ingrediente: cerilla
Estanquero coloca el ingrediente: tabaco
Fumador con papel está fumando.
Estanquero coloca el ingrediente: tabaco
Estanquero coloca el ingrediente: cerilla
Fumador con papel deja de fumar, esperando ingredientes.
Fumador con papel está fumando.*/

public class Ejer3_Estanco {

    public static void main(String[] args) {
        
        Estanco estanco = new Estanco();
        
        //Creamos a tres fumadores con diferentes ingredientes
        Fumador fumadorPapel = new Fumador("papel", estanco); //Hilo funcionan simulaneamente
        Fumador fumadorTabaco = new Fumador ("tabaco", estanco);
        Fumador fumadorFosforos = new Fumador("cerilla", estanco);
        
        //Creamos el estanquero
         Estanquero estanquero = new Estanquero(estanco); //Hilo funcionan simultáneamente
         
         //Inicializamos los hilos
         fumadorPapel.start();
         fumadorTabaco.start();
         fumadorFosforos.start();
         estanquero.start();
        
        
    }
}
