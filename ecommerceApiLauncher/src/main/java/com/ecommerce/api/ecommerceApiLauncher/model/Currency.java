package com.ecommerce.api.ecommerceApiLauncher.model;

/*Entity Currency*/


public class Currency {
	  private String symbol;
	    private String code;
	    private int decimals;
	    
		public String getSymbol() {
			return symbol;
		}
		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public int getDecimals() {
			return decimals;
		}
		public void setDecimals(int decimals) {
			this.decimals = decimals;
		}
}
