package com.baruch.coupons.dto;

import java.sql.Date;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PurchaseDto  {
	
	//VARIABLES
	
	private int   amount;
	
	private long  userID, couponID;
	
	private Date  timeStamp;

	private float totalPrice;

	private String couponTitle, companyName;
	
}
