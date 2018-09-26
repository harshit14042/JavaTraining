package com.training.domains;

public class Product implements Comparable<Product> {

	
	private long productCode;
	private String productName;
	private String category;
	private double ratePerUnit;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(long productCode, String productName, String category, double ratePerUnit) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.category = category;
		this.ratePerUnit = ratePerUnit;
	}
	public long getProductCode() {
		return productCode;
	}
	public void setProductCode(long productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getratePerUnit() {
		return ratePerUnit;
	}
	public void setratePerUnit(double ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + (int) (productCode ^ (productCode >>> 32));
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(ratePerUnit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (productCode != other.productCode)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (Double.doubleToLongBits(ratePerUnit) != Double.doubleToLongBits(other.ratePerUnit))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", category=" + category
				+ ", ratePerUnit=" + ratePerUnit + "]";
	}
	@Override
	public int compareTo(Product o) {
		
		return productName.compareTo(o.productName);
	}
	
	
}
