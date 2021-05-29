package TPArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.Random;

public class Writer {
    public static void main(String[] args) {

        File sales= new File("src/TPArchivos/SalesPerYear");
        File destiny = new File("src/TPArchivos/Destinies");
        File dolarCotization = new File("src/TPArchivos/DolarCotizationFile");
        String[] destinyNames= {"ABD", "ABA","ABJ", "AUH","ACC","ADD","ADL","ADE","ALY", "ALP", "ALC", "LEI", "AMM", "AMS", "ANC", "ANK", "AYT", "TNR", "APW", "AJU", "AQP", "ALG", "ARI", "AUA", "ASM","ASU","ARH","ATL", "AKL", "AYP"};
        Ventas[] ventas= new Ventas[1000];
        DolarCotization[] dolar= new DolarCotization[12];
        Random random= new Random();

        for (int i = 0; i < 1000; i++) {
            Date date= new Date(2021, random.nextInt(12)+1, random.nextInt(302)+1);
            ventas[i]= new Ventas(new Destino(destinyNames[random.nextInt(destinyNames.length)]), random.nextInt(10000),random.nextInt(20)+1, random.nextInt(20)+1, date,  true);
        }
        for (int i = 0; i <12 ; i++) {
            dolar[i] = new DolarCotization(i+1, random.nextFloat()*100);
        }

        try {
            //RandomAccessFiles that write the information
            RandomAccessFile rafVentas = new RandomAccessFile(sales, "rw");
            RandomAccessFile rafDolar= new RandomAccessFile(dolarCotization, "rw");
            RandomAccessFile rafDestiny = new RandomAccessFile(destiny,"rw");
            for (int i = 0; i < ventas.length; i++) {
                rafVentas.writeBoolean(ventas[i].isActive());
                rafVentas.writeUTF(ventas[i].getDestiny().getDestinyCode());
                rafVentas.writeInt(ventas[i].getProductCode());
                rafVentas.writeInt(ventas[i].getQuantity());
                rafVentas.writeInt(ventas[i].getPrice());
                rafVentas.writeInt(ventas[i].getDateOfPayment().getDay());
                rafVentas.writeInt(ventas[i].getDateOfPayment().getMonth());
                rafVentas.writeInt(ventas[i].getDateOfPayment().getYear());
            }
            for (int i = 0; i < destinyNames.length; i++) {
                rafDestiny.writeUTF(destinyNames[i]);   //name
                rafDestiny.writeUTF("");     //description
            }
            for (int i = 0; i <dolar.length ; i++) {
                rafDolar.writeInt(dolar[i].getMonth());
                rafDolar.writeFloat(dolar[i].getCotization());
            }

            int ventasEnPesosPorDestino = 0;
            rafVentas.seek(25);

            ventasEnPesosPorDestino += rafVentas.readInt();
            ventasEnPesosPorDestino *= rafVentas.readInt();
            rafDolar.seek(4);
            ventasEnPesosPorDestino *= rafDolar.readInt();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
