/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;
import modele.Role;
import modele.Permission;

/**
 *
 * @author Thibault
 */
public class RoleTest {
    public static void main(String[] args) {
        Role unRole = new Role("ADM","Administrateur");
        Permission unePermission = new Permission("SEL","Select");
        Permission uneAutrePermission = new Permission("UPD","Update");
        unRole.addPermission(unePermission);
        unRole.addPermission(uneAutrePermission);
        System.out.println("Le role " + unRole.getNom() + " peut :");
        for(int i = 0; i < unRole.getLesPermissions().size(); i++){
            System.out.println(" - " + unRole.getLesPermissions().get(i).getNom());
        }

    }
}
