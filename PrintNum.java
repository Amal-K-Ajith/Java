// -----------------THIS  PRG PRINTS WORD FORMAT FOR THE NUMBER PASSED TO THE FUNC THE LIMIT FOR THE PRG IS -999999 TO 999999 AND NO -VE NUMBER AT THE MOMENT
public class PrintNum {

	public static void main(String[] args) {
        PrintNum p=new PrintNum();
		for (int i = 0; i <= 999999; i++)
			p.printOne(i);
	}

	public String printOne(int num)  {
		String[] pre = { "", "ONE ", "TWO ", "THREE ", "FOUR ", "FIVE ", "SIX ", "SEVEN ", "EIGHT ", "NINE ", "TEN " };
		String[] ele = { "", "ELEVEN ", "TWLEVE ", "THIRTEEN ", "FOURTEEN ", "FIFTEEN ", "SIXTEEN ", "SEVENTEEN ","EIGHTEEN ", "NINETEEN " };
		String[] pos = { "", "TWENETY ", "THIRTY ", "FORTY ", "FIFTY ", "SIXTY ", "SEVENTY ", "EIGHTY ", "NINETY " };
		if (num == 0) return "ZERO";
		int once, tens, huns, thou;
		thou = num / 1000;
		num = thou == 0 ? num : num % 1000;
		huns = num / 100;
		num = huns == 0 ? num : num % 100;
		tens = num / 10;
		num = tens == 0 ? num : num % 10;
		once = num;
		String msg;
		msg = thou > 0 ? (thou>10 ? thou>19? 
				thou>99? pre[thou/100] + "HUNDRED " + ( (thou%100<11) ?  "AND "+pre[thou%100] : (thou%100>19)  ? "AND "+pos[(thou%100)/10-1] + pre[thou%10] : "AND "+ele[thou%10] ): 
					pos[thou/10-1] + pre[thou%10] : ele[thou%10]: pre[thou]) + "THOUSAND " + 
				(huns == 0 && (tens > 0 || once > 0) ? "AND " : "") : "";
		msg += huns > 0 ? pre[huns] + "HUNDRED " + (once == 0 & tens == 0 ? "" : "AND ") : "";
		if (tens == 1 && once > 0)
			msg += ele[once];
		else
			msg += tens == 1 & once == 0 ? "TEN " : (tens == 0 ? "" : pos[tens - 1]) + pre[once];
		System.out.println(msg);//----OPTIONAL--- for viewing
		return msg;
	}
}
