/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.util.EventListener;


interface  AvisaClient extends EventListener {
 


 //Metodos a  heredar en servidos
    public void avisaClient(String msg);
    

}
