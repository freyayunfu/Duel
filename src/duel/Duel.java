/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package duel;

/**
 *This class simulates 10,000 duels among Godzilla, Kingkong and Spiderman with 2 
 * strategy and calculates the probability of winning for each dueler.
 * @author FU, Yun
 * @version  1.0
 * @since 09/09/2014
 */

public class Duel {
    
    /**
    *
    * These two variables keep track the result of one shoot
    */
    private static boolean m;
    private static boolean s;

    /**
     * 
     * simulates 10,000 duels among Godzilla, Kingkong and Spiderman with 2 
     * strategy and calculates the probability of winning for each dueler.
     * @param args the command line arguments
     */
    public static void main(String[] args){

    /**
    *
    * This variable keeps track of the times of winning for each dueler
    */  
    int win = 0;
    Duelist[] dueler = new Duelist[3];
    dueler[0] = new Duelist("Godzilla", 1.0/3, true);
    dueler[1] = new Duelist("KingKong", 1.0/2, true);
    dueler[2] = new Duelist("Spiderman", 1.0, true);
    
    System.out.println("Strategy 1 : hit the best shooter");
    for(int i=0; i<10000; i++){            
        dueler[0].setAlive(true);
        dueler[1].setAlive(true);
        dueler[2].setAlive(true);
        
        
        if (dueler[0].ShootAtTarget(dueler[2])){           
           do{if (dueler[1].ShootAtTarget(dueler[0])){
               dueler[1].win++;
               m = true;
           }
           else{
                  m = dueler[0].ShootAtTarget(dueler[1]);
                 if (m){
                 dueler[0].win++;
                 }                 
           }
           }while(!m);
           
        }
        else{              
            if (dueler[1].ShootAtTarget(dueler[2])){
                 do{if (dueler[0].ShootAtTarget(dueler[1])){                       
                             dueler[0].win++;
                             s = true;
                    }
                 else{
                     s = dueler[1].ShootAtTarget(dueler[0]);
                    if (s){
                     dueler[1].win++;
                    }
                 }
                }while(!s);
           }
           else{
               if (dueler[0].ShootAtTarget(dueler[2])){
               dueler[0].win++;
               }
                else{
                dueler[2].win++;
                }
           }
        }
      
    }
   for(Duelist d:dueler)
   System.out.println(d.getName()+" won "+d.win+"/10,000 duels or "+d.win/100.00+"%");
   System.out.println("");
   
   System.out.println("Strategy 2 : Godzilla miss on his first shot");
        dueler[0].win = 0;
        dueler[1].win = 0;
        dueler[2].win = 0;
    for(int i=0; i<10000; i++){  
        
        dueler[0].setAlive(true);
        dueler[1].setAlive(true);
        dueler[2].setAlive(true);
               
            if (dueler[1].ShootAtTarget(dueler[2])){
                 do{if (dueler[0].ShootAtTarget(dueler[1])){                       
                             dueler[0].win++;
                             s = true;
                    }
                 else{
                     s = dueler[1].ShootAtTarget(dueler[0]);
                    if (s){
                     dueler[1].win++;
                    }
                 }
                }while(!s);
           }
           else{
               if (dueler[0].ShootAtTarget(dueler[2])){
               dueler[0].win++;
               }
                else{
                dueler[2].win++;
                }
           }
        }
    
      for(Duelist d:dueler)
      System.out.println(d.getName()+" won "+d.win+"/10,000 duels or "+d.win/100.00+"%");
    
   }    
}
       



