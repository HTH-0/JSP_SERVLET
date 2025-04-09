package C09;

import java.time.LocalDate;

public class OrderDto {
	private String PRODUCT_ID;
	private String USERID;
	private String PRODUCT_NAME;
	private String CATEGORY;
	private Integer PRICE;
	private Integer QUANTITY;
	private LocalDate ORDER_DATE;
	private Integer SUM;
	private Integer AVG;
	private String ADDR;
	
	public OrderDto() {}

	public OrderDto(String pRODUCT_ID, String uSERID, String pRODUCT_NAME, String cATEGORY, Integer pRICE,
			Integer qUANTITY, LocalDate oRDER_DATE, Integer sUM, Integer aVG) {
		super();
		PRODUCT_ID = pRODUCT_ID;
		USERID = uSERID;
		PRODUCT_NAME = pRODUCT_NAME;
		CATEGORY = cATEGORY;
		PRICE = pRICE;
		QUANTITY = qUANTITY;
		ORDER_DATE = oRDER_DATE;
		SUM = sUM;
		AVG = aVG;
	}

	public String getADDR() {
		return ADDR;
	}

	public void setADDR(String aDDR) {
		ADDR = aDDR;
	}

	public OrderDto(String pRODUCT_ID, String uSERID, String pRODUCT_NAME, String cATEGORY, Integer pRICE,
			Integer qUANTITY, LocalDate oRDER_DATE, Integer sUM, Integer aVG, String aDDR) {
		super();
		PRODUCT_ID = pRODUCT_ID;
		USERID = uSERID;
		PRODUCT_NAME = pRODUCT_NAME;
		CATEGORY = cATEGORY;
		PRICE = pRICE;
		QUANTITY = qUANTITY;
		ORDER_DATE = oRDER_DATE;
		SUM = sUM;
		AVG = aVG;
		ADDR = aDDR;
	}

	public String getPRODUCT_ID() {
		return PRODUCT_ID;
	}

	public void setPRODUCT_ID(String pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}

	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}

	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

	public Integer getPRICE() {
		return PRICE;
	}

	public void setPRICE(Integer pRICE) {
		PRICE = pRICE;
	}

	public Integer getQUANTITY() {
		return QUANTITY;
	}

	public void setQUANTITY(Integer qUANTITY) {
		QUANTITY = qUANTITY;
	}

	public LocalDate getORDER_DATE() {
		return ORDER_DATE;
	}

	public void setORDER_DATE(LocalDate oRDER_DATE) {
		ORDER_DATE = oRDER_DATE;
	}

	public Integer getSUM() {
		return SUM;
	}

	public void setSUM(Integer sUM) {
		SUM = sUM;
	}

	public Integer getAVG() {
		return AVG;
	}

	public void setAVG(Integer aVG) {
		AVG = aVG;
	}

	@Override
	public String toString() {
		return "OrderDto [PRODUCT_ID=" + PRODUCT_ID + ", USERID=" + USERID + ", PRODUCT_NAME=" + PRODUCT_NAME
				+ ", CATEGORY=" + CATEGORY + ", PRICE=" + PRICE + ", QUANTITY=" + QUANTITY + ", ORDER_DATE="
				+ ORDER_DATE + ", SUM=" + SUM + ", AVG=" + AVG + ", ADDR=" + ADDR + "]";
	}
	
}
