package com.ibm.cp4i;

import com.ibm.broker.plugin.MbException;
import com.ibm.broker.plugin.MbPolicy;

public class MyPolicyAccessClass {
	
	public static String getPolicyProperty(String policyName, String propertyName) {
		String retval = null;
		try {
			MbPolicy myPol = MbPolicy.getPolicy("UserDefined", policyName);
			if (myPol != null) {
				retval = myPol.getPropertyValueAsString(propertyName);
			}
			else {
				System.out.println("Failed to find policy "+policyName);
			}
		}
		catch ( MbException mbe ) {
			System.out.println("Exception looking for policy "+policyName+" "+mbe.toString());
		}
		return retval;
	}
}
