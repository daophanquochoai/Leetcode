public class ZigzagConversion {
    public String convert(String s, int numRows) {
        int step = 2 * numRows - 2;
        if ( step == 0 ) {
            return s;
        }
        int originStep = step;
        int i= 0;
        int count = 1;
        StringBuilder result = new StringBuilder();
        while( count <= numRows ) {
            int pad = step;
            while( i < s.length()) {
                System.out.println("i: " + i + " step: " + pad + " count: " + count + " char: " + s.charAt(i));
                result.append(s.charAt(i));
                i += pad;
                if ( pad != originStep) {
                    pad = originStep - pad;
                }
            }

            step -= 2;
            if ( step == 0 ) {
                step = originStep;
            }
            count++;
            i = count - 1;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        System.out.println(zigzagConversion.convert("PAYPALISHIRING", 4));
    }
}
