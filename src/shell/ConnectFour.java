/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shell;

/**
 *
 * @author Kornel
 */
public class ConnectFour extends Shell{
    int[][] t = new int[6][7];
    boolean asd = true;
    boolean jatek = false;
    int comp = 0,masodikj = 0;
    
    public ConnectFour(){
        
        addCommand(new Command("new") {
            @Override
            public boolean execute(String... args) {
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 7; j++) {
                        t[i][j] = 0;
                    }
                }
                if(args.length != 1)
                    return false;
                if(args[0].equals("c") || args[0].equals("C")){
                   asd = false;
                    System.out.println("A computer kezdi a játékot!");
                }
                else
                    System.out.println("A felhasználó kezdi a játékot!");
                
               if(!args[0].equals("P") && !args[0].equals("p") && !args[0].equals("C") && !args[0].equals("c"))
                    return false;
                jatek = true;
                System.out.println("He");
                return true;
            }
        });
        addCommand(new Command("computer") {

            @Override
            public boolean execute(String... args) {
                if(args.length != 0)
                    return false;
                
                if(asd)
                    return false;
                
                boolean vege = false;
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 7; j++) {
                        if(t[i][j] == 0)
                            vege = true;
                    }
                }
                if(!vege)
                    return false;
                char c;
                c = computerMove();
                int lepes = 0;
                switch (c){
                    case 'A' : lepes = 0;
                        break;
                    case 'B' : lepes = 1;
                        break;
                    case 'C' : lepes = 2;
                        break;
                    case 'D' : lepes = 3;
                        break;
                    case 'E' : lepes = 4;
                        break;
                    case 'F' : lepes = 5;
                        break;
                    case 'G' : lepes = 6;
                        break;
                        
                }
                if(t[0][lepes] != 0)
                    return false;
                for (int i = 0; i < 6; i++) {
                    
                    if(t[i][lepes] != 0 && t[i - 1][lepes] == 0)
                        t[i-1][lepes] = 2;
                    if(i == 5 && t[i][lepes] == 0)
                        t[i][lepes] = 2;
                }
                comp+=1;
                asd = true;
                for (int i = 0; i < 6; i++) {
                  for (int j = 0; j < 7; j++) {
                          System.out.printf("%d ", t[i][j]);
                    }
                    System.out.println("");
                }
                return true;
            }
        });
    addCommand(new Command("column") {

            @Override
            public boolean execute(String... args) {
                if(args.length != 1)
                    return false;
                boolean vege = false;
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 7; j++) {
                        if(t[i][j] == 0)
                            vege = true;
                    }
                }
                if(!vege)
                    return false;
                /*if(!asd)
                    return false;*/
                if(!args[0].equals("A") && !args[0].equals("B") && !args[0].equals("C") && !args[0].equals("D") && !args[0].equals("E") && !args[0].equals("F") && !args[0].equals("G"))
                    return false;
                int lepes = 0;
                switch (args[0]){
                    case "A" : lepes = 0;
                        break;
                    case "B" : lepes = 1;
                        break;
                    case "C" : lepes = 2;
                        break;
                    case "D" : lepes = 3;
                        break;
                    case "E" : lepes = 4;
                        break;
                    case "F" : lepes = 5;
                        break;
                    case "G" : lepes = 6;
                        break;
                        
                }
                if(t[0][lepes] != 0)
                    return false;
                System.out.println("he");
                for (int i = 0; i < 6; i++) {
                    if(t[i][lepes] != 0 && t[i - 1][lepes] == 0)
                        t[i-1][lepes] = 1;
                    if(i == 5 && t[i][lepes] == 0)
                        t[i][lepes] = 1;
                }
                masodikj+=1;
                asd = false;
                for (int i = 0; i < 6; i++) {
                  for (int j = 0; j < 7; j++) {
                          System.out.printf("%d ", t[i][j]);
                    }
                    System.out.println("");
                }
                return true;
            }
        });
    addCommand(new Command("pring") {

            @Override
            public boolean execute(String... args) {
                if(!jatek)
                    return false;
                if(args.length != 0)
                    return false;
                boolean vege = true;
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.println(t[i][j] + " " + t[i][j + 1] + " " + t[i][j+2] + " " + t[i][j + 3]);
                        if(t[i][j] == 1 && t[i][j+1] == 1 && t[i][j + 2] == 1 && t[i][j+3] == 1){
                            System.out.println("Vege! A felhasználó nyert!");
                            return true;
                        }
                    }
                }
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 4; j++) {
                        System.out.println(t[i][j] + " " + t[i][j + 1] + " " + t[i][j+2] + " " + t[i][j + 3]);
                        if(t[i][j] == 2 && t[i][j+1] == 2 && t[i][j + 2] == 2 && t[i][j+3] == 2){
                            System.out.println("Vege! A computer nyert!");
                            return true;
                        }
                    }
                }
                for (int j = 0; j < 7; j++) {
                    for (int i = 0; i < 3; i++) {
                        System.out.println(t[i][j] + " " + t[i+1][j] + " " + t[i+2][j] + " " + t[i+3][j]);
                        if(t[i][j] == 2 && t[i+1][j] == 2 && t[i+2][j] == 2 && t[i+3][j] == 2){
                            System.out.println("Vege!A computer nyert!");
                            return true;
                        }
                    }
                }
                for (int j = 0; j < 7; j++) {
                    for (int i = 0; i < 3; i++) {
                        System.out.println(t[i][j] + " " + t[i+1][j] + " " + t[i+2][j] + " " + t[i+3][j]);
                        if(t[i][j] == 1 && t[i+1][j] == 1 && t[i+2][j] == 1 && t[i+3][j] == 1){
                            System.out.println("Vege! A felhasználó nyert!");
                            return true;
                        }
                    }
                }
              //          /\               
                //MEGVAN  ||
                for (int i = 0; i < 3; i++) { //⵬󳡮 jobbra , felhaszn⭳
                    for (int j = 0; j < 4; j++) {
                        if(t[i][j]==1 && t[i+1][j+1] == 1 && t[i+2][j+2]==1 && t[i+3][j+3]==1){
                            System.out.println("Vége! A felhasználó nyert!");
                            return true;
                        }
                    }
                }
                for (int i = 0; i < 3; i++) {//⵬󳡮 jobbra , computer
                    for (int j = 0; j < 4; j++) {
                        if(t[i][j]==2 && t[i+1][j+1] == 2 && t[i+2][j+2]==2 && t[i+3][j+3]==2){
                            System.out.println("Vége! A computer nyert!");
                            return true;
                        }
                    }
                }
                for (int i = 6; i > 2; i--) {
                    for (int j = 0; j < 4; j++) {
                        if(t[i][j]==1 && t[i-1][j+1] == 1 && t[i-2][j+2]==1 && t[i-3][j+3]==1){
                            System.out.println("Vége! A felhasználó nyert!");
                            return true;
                        }
                    }
                }
                for (int i = 6; i > 2; i--) {
                    for (int j = 0; j < 4; j++) {
                        if(t[i][j]==2 && t[i-1][j+1] == 2 && t[i-2][j+2]==2 && t[i-3][j+3]==2){
                            System.out.println("Vége! A felhasználó nyert!");
                            return true;
                        }
                    }
                }
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 7; j++) {
                        if(t[i][j] == 0)
                            vege = false;
                    }
                }
                if(vege){
                    System.out.println("Döntetlen");
                    return true;
                }
                System.out.println("A computer" + comp + " lepest hajtott végre eddig");
                System.out.println("A felhasználó" + masodikj + " lépést hajtott végre eddig");
                for (int i = 0; i < 6; i++) {
                  for (int j = 0; j < 7; j++) {
                          System.out.printf("%d ", t[i][j]);
                    }
                    System.out.println("");
                }
                if(asd)
                    System.out.println("A felhasználó következik");
                else
                    System.out.println("A computer következik");
                return true;
            }
        });
        
    
    }
}
