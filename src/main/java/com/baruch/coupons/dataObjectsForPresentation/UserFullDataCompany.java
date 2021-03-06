package com.baruch.coupons.dataObjectsForPresentation;

import com.baruch.coupons.dataInterfaces.IUserDataObject;
import com.baruch.coupons.enums.UserTypes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserFullDataCompany implements IUserDataObject{
		
		//VARIABLES
		
		private long id, companyID;

		private String  userName, copmanyName, firstName, surName;
		
		private UserTypes  type;
		
}
