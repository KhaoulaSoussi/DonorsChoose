/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;


public class MaterialProject extends ProjectRequest{
 
    private String reference;
    private ArrayList<Material> materials;
    private String supplier;


    public MaterialProject(String title, String description, char student_grade, Category category, int deadYear, 
            int deadMonth, int deadDate, String institution, String reference, 
            int numberOfItems, String supplier){
        super(title, description, student_grade, category, deadYear, deadMonth, deadDate, institution);
        this.reference = reference;
        this.supplier = supplier;
        this.materials = new ArrayList<>(numberOfItems);
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
    public void estimateFundingGoal(){
        double total = 0;
        for(Material item: materials){
            total = total + item.getPrice()*item.getQuantity();
        }
        super.setFundingGoal(total);
    }
    
    public void addMaterial(Material item){
        materials.add(item);
    }
    
    public boolean removeMaterial(String id){
        for(Material item: materials){
            if(id.equalsIgnoreCase(item.getItemID())){
                return materials.remove(item);
            }
        }
        return false;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\tReference: " + reference + "\tSupplier: " + supplier + "\tList of items: " + materials + "]";
    }
}