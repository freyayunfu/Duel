/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duel;

/**
 * 
 *This class create a duelist with their name, shoot accuracy, life status,
 *and include methods for getting name, getting accuracy, getting life status,
 *setting life status, shooting at one target.
 * @author FU, Yun
 * @version  1.0
 * @since 05/10/2014
 */
public class Duelist {

    private String name;
    private double accuracy;
    private boolean alive;
    int win;

    public Duelist() {
    }
    
    /**
     *
     * construct a Duelist;
     * @param n the name of dueler
     * @param a the shoot accuracy of dueler
     * @param l whether the dueler is alive, true for alive, false for dead
     *
     */
    public Duelist(String n, double a, boolean l) {
        this.name = n;
        this.accuracy = a;
        this.alive = l;
    }
    
    /**
     *
     * get the name of a dueler
     * @return name of a dueler
     */
    public String getName() {
        return name;
    }
    
    /**
     *
     * get the accuracy of a dueler
     * @return accuracy of a dueler
     */
    public double getAccuracy() {
        return accuracy;
    }
    
    /**
     *
     * get life status of a dueler
     * @return true if the duel is alive, otherwise false
     */
    public boolean getAlive() {
        return alive;
    }
    /**
     *
     * @param x life status of a dueler, true if the duel is alive, otherwise false
     * set life status of a dueler
     */
    public void setAlive(boolean x){
        this.alive = x;
    }
    
    

    /**
     *
     * validate a hit from a dueler on his target;
     * @param target target hit by the dueler
     * @return true if the dueler hit the target, otherwise false;
     *
     */
    
    public boolean ShootAtTarget(Duelist target) { 
        boolean a = this.getAccuracy() >= Math.random();
        if(a){           
            target.setAlive(false); 
        }
        return a;
    }
}
