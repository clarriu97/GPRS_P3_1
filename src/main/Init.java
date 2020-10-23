package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Init {

    private static final String fileName = "entrada.txt";
    private List<Event> eventList;
    private CPD cpd;

    public Init(){
        eventList = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            eventList = new ArrayList();
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] lineSplit = line.split(" ");
                eventList.add(new Event("basic", Double.parseDouble(lineSplit[0]), Double.parseDouble(lineSplit[1]), false));
            }
            cpd = new CPD(1, 2, new FEL(eventList));
            for (Event event: eventList){event.print();}
            scanner.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

}
