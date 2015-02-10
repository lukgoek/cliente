/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

/**
 *
 * @author fimaz
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Interface obj = new Interface();
        obj.setVisible(true);
        obj.conexion(5555, "192.10.11.14");
    }
    
}
