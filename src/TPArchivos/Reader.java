package TPArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Reader {
    public static void main(String[] args) {
        File sales= new File("src/TPArchivos/SalesPerYear");
        File destiny = new File("src/TPArchivos/Destinies");
        File dolarCotization = new File("src/TPArchivos/DolarCotizationFile");
        try {
            RandomAccessFile rafVentas = new RandomAccessFile(sales, "r");
            RandomAccessFile rafDolar= new RandomAccessFile(dolarCotization, "r");
            RandomAccessFile rafDestiny = new RandomAccessFile(destiny,"r");
            int sizeOfRegSales= 51;
            int sizeOfRegDolar= 8;
            rafDolar.seek(0);
            float[] dolarCotizationPerMonth = new float[12];
            for (int i = 0; i < 12; i++) {
                rafDolar.seek(4+(sizeOfRegDolar*i));
                dolarCotizationPerMonth[i]= rafDolar.readFloat();
            }
            String[] destinoArray = new String[30];
            rafDestiny.seek(0);
            for (int i = 0; i < 30; i++) {
                destinoArray[i]= rafDestiny.readUTF();
                rafDestiny.readUTF();
            }
            int counter=0;
            float[] ventasEnPesosPorDestino = new float[30];
            while(counter<rafVentas.length()){
                if (rafVentas.readBoolean()) {
                    int correspondant = getDestinyInt(destinoArray, rafVentas.readUTF());
                    rafVentas.seek(rafVentas.getFilePointer()+4);
                    int quantity= rafVentas.readInt();
                    int priceInDollars= rafVentas.readInt();
                    int totalSaleInDollars= quantity* priceInDollars;
                    rafVentas.seek(rafVentas.getFilePointer()+4);
                    ventasEnPesosPorDestino[correspondant]+= dolarCotizationPerMonth[rafVentas.readInt()]* totalSaleInDollars;
                    rafVentas.seek(rafVentas.getFilePointer()+4);
                }
                counter+= sizeOfRegSales;
            }

            //imprime
            for (int i= 0; i < 30; i++) {
                System.out.println("monto de las ventas en pesos de " + destinoArray[i] + ": " + ventasEnPesosPorDestino[i] + " pesos");
            }
            System.out.println("");
            rafVentas.seek(0);
            counter=0;
            float[] ventasEnPesosPorMes = new float[12];
            while(counter<rafVentas.length()){
                if (rafVentas.readBoolean()) {
                    rafVentas.readUTF();
                    rafVentas.seek(rafVentas.getFilePointer()+4);
                    int quantity= rafVentas.readInt();
                    int priceInDollars= rafVentas.readInt();
                    int totalSaleInDollars= quantity* priceInDollars;
                    rafVentas.seek(rafVentas.getFilePointer()+4);
                    int month= rafVentas.readInt();
                    ventasEnPesosPorMes[month]+= dolarCotizationPerMonth[month]* totalSaleInDollars;
                    rafVentas.seek(rafVentas.getFilePointer()+4);
                }
                counter+= sizeOfRegSales;
            }

            //imprime
            for (int i= 0; i < 12; i++) {
                System.out.println("Monto de las ventas en pesos en el mes " + (i+1) + ": " + ventasEnPesosPorMes[i] + " pesos");
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getDestinyInt(String[] destinyNames, String stringToFind){
        for (int i = 0; i < destinyNames.length; i++) {
            if(stringToFind.equals(destinyNames[i])){
                return i;
            }
        }
        return -1;
    }
}
