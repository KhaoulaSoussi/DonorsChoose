/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author hp
 */
public class Material{
    private double price;
    private int quantity;
    private String itemID;

    public Material(double price, int quantity, String ID) {
        this.price = price;
        this.quantity = quantity;
        this.itemID = ID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }
    
    @Override
    public String toString(){
        return "Item ID: " + itemID + "\nQuantity: " + quantity + "\nPrice: " + price;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj != null && obj instanceof Material){
            Material i = (Material) obj;
            return this.itemID.equals(i.itemID);
        }
        return false;
    }
}
