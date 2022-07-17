package Entity;

import java.sql.Date;

public class Vehicule {
 private int vehId ;
 private String makeName ;
 private String modelName ;
 private Date vehYear ;
 private String vehPrice ;
 private String vehColor ;
 private String vehVin ;
 
 public Vehicule (int vehId, String makeName, String modelName, Date vehYear, String vehPrice, String vehColor, String vehVin    ) {
	this.setVehId(vehId); 
	this.setMakeName(makeName);
	this.setModelName(modelName);
	this.setVehYear(vehYear);
	this.setVehPrice(vehPrice);
	this.setVehColor(vehColor);
	this.setVehVin(vehVin);
 }

public int getVehId() {
	return vehId;
}

public void setVehId(int vehId) {
	this.vehId = vehId;
}

public String getMakeName() {
	return makeName;
}

public void setMakeName(String makeName) {
	this.makeName = makeName;
}

public String getModelName() {
	return modelName;
}

public void setModelName(String modelName) {
	this.modelName = modelName;
}

public Date getVehYear() {
	return vehYear;
}

public void setVehYear(Date date) {
	this.vehYear = date;
}

public String getVehPrice() {
	return vehPrice;
}

public void setVehPrice(String vehPrice) {
	this.vehPrice = vehPrice;
}

public String getVehColor() {
	return vehColor;
}

public void setVehColor(String vehColor) {
	this.vehColor = vehColor;
}

public String getVehVin() {
	return vehVin;
}

public void setVehVin(String vehVin) {
	this.vehVin = vehVin;
}


}
