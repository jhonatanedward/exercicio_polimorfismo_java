package entities;

public class ImportedProduct extends Product{
	
	private Double customsFee;
	
	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}
	
	public Double getCustomsFee() {
		return this.customsFee;
	}
	
	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}

	public Double totalPrice() {
		return this.getPrice() + this.customsFee;
	}
	
	@Override
	public String priceTag() {
		// TODO Auto-generated method stub
		String customsText = 
				String.format(
						"%s $ %.2f (Customs fee: $ %.2f)", 
						this.getName(), 
						this.totalPrice(),
						this.customsFee);
		return  customsText;
	}
}
