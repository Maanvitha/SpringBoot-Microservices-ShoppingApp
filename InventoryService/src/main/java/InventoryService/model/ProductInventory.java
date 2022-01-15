package InventoryService.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@XmlRootElement
@Entity
@Table(name="Inventory")
public class ProductInventory {
	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
	int inventoryId;
	int quantity;
	
	int productId;
	public int getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

}
