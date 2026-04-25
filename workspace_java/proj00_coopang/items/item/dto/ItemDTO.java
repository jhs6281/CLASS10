package item.dto;

import java.sql.Date;

public class ItemDTO {
	
	int item_num;
	String item_img;
	String category;
	String item_id;
	String item_name;
	int price;
	String item_info;
	int score;
	Date setTime;
	int shipping_Level;

	
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	public String getItem_img() {
		return item_img;
	}
	public void setItem_img(String item_img) {
		this.item_img = item_img;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getItem_info() {
		return item_info;
	}
	public void setItem_info(String item_info) {
		this.item_info = item_info;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getSetTime() {
		return setTime;
	}
	public void setSetTime(Date setTime) {
		this.setTime = setTime;
	}
	public int getShipping_Level() {
		return shipping_Level;
	}
	public void setShipping_Level(int shipping_Level) {
		this.shipping_Level = shipping_Level;
	}

	
	@Override
	public String toString() {
		return "ItemDTO [item_num=" + item_num + ", item_img=" + item_img + ", category=" + category + ", item_id="
				+ item_id + ", item_name=" + item_name + ", price=" + price + ", item_info=" + item_info + ", score="
				+ score + ", setTime=" + setTime + ", shipping_Level=" + shipping_Level + "]";
	}
	
}
