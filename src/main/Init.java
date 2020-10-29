package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Init {

    private static final String fileName = "entrada.txt";
    private CPD cpd;
    private FEL fel;

    public Init(){
        pedirDatos();
    }

    private void showError() {
        System.out.println("Ha debido ocurrir un error");
        pedirDatos();
    }

    private void pedirDatos(){
        try {
            Scanner entrada = new Scanner(System.in);
            System.out.println("Introduzca los datos");
            String frase = entrada.nextLine();
            String[] fraseDividida = frase.split(" ");
            if (fraseDividida[0].equals("simula") && fraseDividida.length==4){
                File file = new File(fraseDividida[1]);
                Scanner scanner = new Scanner(file);
                fel = new FEL();
                while (scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    String[] lineSplit = line.split(" ");
                    fel.addEvent(new Event(true, Double.parseDouble(lineSplit[0]), Double.parseDouble(lineSplit[1]), false));
                }
                scanner.close();
                try{
                    int numProcesadores = Integer.parseInt(fraseDividida[2]);
                    int numCola = Integer.parseInt(fraseDividida[3]);
                    cpd = new CPD(numProcesadores, numCola, fel);

                } catch (NumberFormatException e){
                    showError();
                }
                //Aqui empieza a procesar
                cpd.process();
            } else {
                showError();
            }
        } catch (FileNotFoundException e){
            showError();
            e.printStackTrace();
        }
    }

}
