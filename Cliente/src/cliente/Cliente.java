/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

/**
 *
 * @author humberto_lugo
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String dirIp="127.0.0.1";
                
        Interface obj = new Interface();
        obj.setVisible(true);
        obj.conexion(5555, dirIp);
        
        Interface llamar = new Interface();
        llamar.setVisible(true);
        llamar.conexion(5555, dirIp);
    }
    
}
