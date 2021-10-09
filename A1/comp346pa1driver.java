package COMP_346.A1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kerly Titus
 */
public class comp346pa1driver {

    /** 
     * main class
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	 /*******************************************************************************************************************************************
    	  * TODO : implement all the operations of main class   																					*
    	  ******************************************************************************************************************************************/
        
    	Network objNetwork = new Network("network");            /* Activate the network */
        //objNetwork.run();
        Server objServer = new Server();                        /* Start the server */ 
        //objServer.run();
        Client objClient1 = new Client("sending");              /* Start the sending client */
        //objClient1.run();
        Client objClient2 = new Client("receiving");            /* Start the receiving client */
        //objClient2.run();

        Thread t1 = new Thread(objNetwork);
        Thread t2 = new Thread(objServer);
        Thread t3 = new Thread(objClient1);
        Thread t4 = new Thread(objClient2);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
