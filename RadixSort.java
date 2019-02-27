//Alumno: Fonseca Ramírez Gadiel Moisés
import java.util.LinkedList;
public class RadixSort {
    //Atributos
    int minNum, maxNum, rango, digitos;
    //LinkedList[] colas = new LinkedList[maxNum];
    LinkedList colas = new LinkedList();

    //Constructores
    RadixSort(int minNum, int maxNum, int digitos){
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.digitos = digitos;
    }


    //Métodos

    void radixSort(LinkedList lista){

        //Crear las colas de Q0 a QN
        for (int i = 0; i < maxNum+1; i++) {
            colas.add(new LinkedList());
        }

        //Dividir la lista en cada COLA
        int digito,iteracion = -1;
        String  numString;
        LinkedList cola;

        System.out.println("##RADIX SORT##");
        System.out.println("lista a ordenar:" + lista);

        for (int j = this.digitos-1; j > -1 ; j--) { //Ciclo que elige la posición significativa
            iteracion++;
            System.out.println("\nIteración del Digito " + iteracion);

            //Ciclo que pone divide la lista en las COLAS correspondiente
            for (int i = 0; i < lista.size(); i++) {

                try {
                    numString = String.valueOf((int) lista.get(i));

                    if (numString.length() < this.digitos) {
                        int diferencia = (this.digitos) - numString.length();
                        System.out.println("JJ"+(j-diferencia));
                        digito = Character.getNumericValue(numString.charAt((j-diferencia)));
                    }else{
                        digito = Character.getNumericValue(numString.charAt(j));
                    }

                }catch (StringIndexOutOfBoundsException sinDigito){
                    digito = 0;
                }

                cola = (LinkedList) this.colas.get(digito); //No. de COLA a usar
                cola.add((int)lista.get(i));

            }

            //Imprimir como quedaron las COLAS
            for (int i = 0; i < colas.size(); i++) {
                cola = (LinkedList) this.colas.get(i); //No. de COLA a usar
                System.out.println("Cola " + i + ":" + cola);

            }

            //Vaciar las colas de la primera a la última en la lista original
            lista.clear(); //Limpiar la lista original
            for (int i = 0; i < colas.size(); i++) {
                cola = (LinkedList) this.colas.get(i); //No. de COLA a usar

                //Vaciar "cada" COLA
                for (int k = 0; k < cola.size(); k++) {
                    int primero = (int)cola.get(k);
                    lista.add(primero);
                }
                cola.clear(); //Limpiar la COLA copiada
            }


            System.out.println("Lista reordenada : " + lista);
        }

        System.out.println("\n\nFIN RADIX SORT");
        System.out.println("lista ordenada:" + lista + " longitud: " + lista.size());
    }

}
