package cos301.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class NumericUtil {
	Locale locale = Locale.UK;

	public String getOnlyNumerics(String str) {
		StringBuffer strBuff = new StringBuffer();
		char minusChar = '-';
		try {
			if (str == null) {
				return null;
			}
			str = str.trim();
			char c;
			for (int i = 0; i < str.length(); i++) {
				c = str.charAt(i);
				if (Character.isDigit(c)) {
					strBuff.append(c);
				} else {
					if (str.trim().startsWith("-") && c == minusChar) {
						strBuff.append(c);
					}
				}
			}
			String s = strBuff.toString();
			if (s.trim().equals("-")) {
				return null;
			}
		}// try
		catch (Exception ex) {
			ex.printStackTrace();
			System.exit(0);
		}

		return strBuff.toString();
	}

	// ------------
	public boolean isNumeric(String str) {
		// StringBuffer strBuff = new StringBuffer();
		char minusChar = '-';
		boolean ret = true;
		try {
			if (str == null) {
				ret = false;
			}
			str = str.trim();
			char c;
			for (int i = 0; i < str.length(); i++) {
				c = str.charAt(i);
				if ((i == 0) && (c == minusChar)) {
					ret = true;
				} else {
					if (!Character.isDigit(c)) {
						ret = false;
					}
				}
			}// for
		}// try
		catch (Exception ex) {
			ex.printStackTrace();
			System.exit(0);
		}

		return ret;
	}

	// ------------
	public boolean isFloat(String str) {
		// StringBuffer strBuff = new StringBuffer();
		char minusChar = '-';
		char puntChar = '.';
		boolean ret = true;
		try {
			if (str == null) {
				ret = false;
			}
			str = str.trim();
			char c;
			for (int i = 0; i < str.length(); i++) {
				c = str.charAt(i);
				if ((i == 0) && (c == minusChar)) {
					ret = true;
				} else {
					if (c == puntChar) {
						ret = true;
					} else {
						if (!Character.isDigit(c)) {
							ret = false;
						}
					}
				}
			}// for
		}// try
		catch (Exception ex) {
			ex.printStackTrace();
			System.exit(0);
		}

		return ret;
	}

	// -----------
	public int str2Int(String str) {
		int i = 0;
		try {
			if (str == null) {
				str = "0";
			}
			String s = str.trim();
			if (s.equals("") || s.equals("null")) {
				s = "0";
			}
			if (!isNumeric(s)) {
				s = "0";
			}

			i = Integer.parseInt(s);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(0);
		}
		return i;
	}

	// -----------
	public float str2Float(String str) {
		float f = 0;
		try {
			String s = str.trim();
			if (s.equals("")) {
				s = "0";
			}
			//if (!isNumeric(s)) {
		//		s = "0";
		//	}
			if (isFloat(s)) {
				f = Float.parseFloat(s);
			}
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			f = 0;
		}
		return f;
	}

	// ---------------------------------------
	public BigDecimal str2BigDecimal(String pValue) {
		BigDecimal big = new BigDecimal("0");
		pValue = pValue.trim();
		if (pValue == null) {
			pValue = "0";
		}
		if (pValue.equals("null") || pValue.equals("nul")) {
			pValue = "0";
		}
		if (pValue.trim().equals("")) {
			pValue = "0";
		}
		//pValue = pValue.replaceAll("[^.\\d]", "");
		pValue = pValue.replaceAll(",","");
		pValue = pValue.replaceAll("R","");
		if (pValue.endsWith("-")) {
			pValue = pValue.replaceAll("-","");
		}
		try {
			big = new BigDecimal(pValue);
		} catch (NumberFormatException ex) {
			System.out.println("-----Error str2BigDecimal--->>"+pValue+"<<<");
			ex.printStackTrace();
			big = new BigDecimal("0");
		}

		return big;
	}
	// ---------------------------------------
	public String toMoney(BigDecimal pValue) {
		String val = "";
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
		symbols.setDecimalSeparator('.');
		DecimalFormat decimalFormat = new DecimalFormat("###,###.00", symbols);

		val = decimalFormat.format(pValue);

		return val;

	}
	// ---------------------------------------
	public String toMoney(String pValue) {

	BigDecimal big  = str2BigDecimal(pValue);

	return toMoney(big);

	}

	//------------------------------
	public BigDecimal addVat(BigDecimal pAmountBeforeTax) {
		BigDecimal total = new BigDecimal("0");

		try {
		BigDecimal salesTaxPercent = new BigDecimal("0.14");
	    BigDecimal salesTax = salesTaxPercent.multiply(pAmountBeforeTax);
	    salesTax = salesTax.setScale(2, RoundingMode.HALF_UP);
	    total = pAmountBeforeTax.add(salesTax);
	} catch (Exception ex) {
		System.out.println("-----Error addVat--->>" + pAmountBeforeTax.toString() + "<<<");
		ex.printStackTrace();
	}
	    return total;
	}


}