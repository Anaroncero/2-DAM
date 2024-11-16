/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejer_7;

/**
 *
 * @author Ana
 * 
 * Simula el panel de control de un vehículo robótico para la exploración espacial, donde varios sensores están detectando diferentes parámetros constantemente, y todos deben mostrarse (actualizándose simultáneamente) en el panel de control. Los sensores serán:

Sensor de temperatura: detecta temperaturas entre 0 y 40 grados centígrados y se actualiza cada 15 segundos.
Sensor de humedad: detecta humedades relativas entre 0 y 100% y se actualiza cada 22 segundos.
Sensor de presión atmosférica: detecta presiones atmosféricas de entre 0 y 5 atm y se actualiza cada 18 segundos.
Dado que no contamos con sensores reales, los datos los simularemos generando sus variaciones aleatoriamente. Por ejemplo, la temperatura comenzará en 20 grados e irá aumentando o disminuyendo entre 0 y 3 grados en cada lectura. Simula algo similar con el resto de sensores.
//Importante: no se generan automáticamente los valores, si no incrementos / decrementos.

Dado que no implementamos un máximo ni mínimo, las mediciones podrían salirse del rango que detecta el sensor, en cuyo caso simularemos que se apaga el sensor, tan solo imprimiendo por pantalla un ‘sensor de temperatura apagado por valor fuera de rango’ en lugar de imprimir el número.

El programa desarrollado debe ser concurrente, manteniendo en ejecución el algoritmo correspondiente a cada hilo de forma paralela.

En el main, se debe instanciar a cada sensor y lanzar su funcionamiento.

 

La consola debe verse actualizada en todo momento. Se debe mostrar información relativa al sensor y a las unidades de medida, no solo los números. Algo similar a esto:

Lectura de temperatura: 32 grados centígrados

Lectura de humedad relativa: 45%

Lectura de presión atmosférica: 4 atmósferas.
 * 
 */
public class Ejer_7 {

    public static void main(String[] args) {
     
        SensorTemperatura st = new SensorTemperatura();
        SensorHumedad sh = new SensorHumedad();
        
        st.start();
        sh.start();
        
        
    }
}
