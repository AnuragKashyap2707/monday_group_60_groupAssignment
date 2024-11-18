/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.supplier;

import java.util.ArrayList;

/**
 *
 * @author group-11
 */
public class ProductDirectory {
    
    private ArrayList <Product> productDirectory;
    
    public ProductDirectory(){
        productDirectory = new ArrayList<>();
    }

    public ArrayList<Product> getProduct() {
        return productDirectory;
    }

    public void setProduct(ArrayList<Product> product) {
        this.productDirectory = product;
    }
    public Product addProduct(){
        Product product = new Product();
        productDirectory.add(product);
        return product;
    }


    public void deleteProduct(int productId)
    {
    productDirectory.remove(productId);
    }
    
    
    public Product getProductById(int id) {
        Product pro = new Product();
        for (Product p : productDirectory) {
            if (p.getProductId() == id) {
                pro = p;
            }
        }
        return pro;
    }


}
