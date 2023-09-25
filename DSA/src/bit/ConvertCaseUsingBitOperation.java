package bit;

public class ConvertCaseUsingBitOperation {
    public static void main(String[] args) {
        char c='C';
        char m='m';
        char SPACE='_';
        char UNDERSCORE=' ';
        //convert to lower case
        System.out.println( (char)(c|UNDERSCORE));
        System.out.println((char)(m|UNDERSCORE));

        //convert to upper case
        System.out.println( (char)(c&SPACE));
        System.out.println((char)(m&SPACE));


        //toggle case
        System.out.println( (char)(c^UNDERSCORE));
        System.out.println((char)(m^UNDERSCORE));
    }
}
