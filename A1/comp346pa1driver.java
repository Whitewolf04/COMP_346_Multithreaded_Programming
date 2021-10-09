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

        objNetwork.run();
        objServer.run();
        objClient1.run();
        objClient2.run();
    }
}
