/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;
import modele.Permission;

/**
 *
 * @author Thibault
 */
public class PermissionTest {
    public static void main(String[] args) {
    
        Permission unePermission = new Permission("SEL","Select");
        System.out.println(unePermission.getCode() + " " + unePermission.getNom());

    }
}
