import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws  Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter mathexpression:");
        String input = scanner.nextLine();
        System.out.println(decision(input));
    }

     static String decision(String input) throws Exception {
        int number1;
        int number2;
        String result;
        String oper;
        boolean roman;

        String[] operands = input.split("[+*-/]");
        if(operands.length != 2) throw new Exception("Must have two operands!!!");
        oper = checking(input);
        if(oper == null) throw new Exception("Somthing went wrong!!!");

        if(Roman.roman(operands[0]) && Roman.roman(operands[1])){
            number1 = Roman.convertToArabian(operands[0]);
            number2 = Roman.convertToArabian(operands[1]);
            roman = true;
        }
        else if(!Roman.roman(operands[0]) && !Roman.roman(operands[1])){
            number1 = Integer.parseInt(operands[0]);
            number2 = Integer.parseInt(operands[1]);
            roman = false;
        }
        else {throw new Exception("Somthing went wrong!!!");}


        if(number1 > 10 || number2 >10) {throw new Exception("Numbers must be from 1 to 10 !!!");}

        int arabian = calc(number1, number2, oper);

        if(roman){
            if(arabian <= 0) {throw new Exception("Roman numbers must be more 0!!!");}
            result = Roman.convertToRoman(arabian);
        }
        else {result = String.valueOf(arabian);}
        return result;
    }

     static String checking(String input){
        if(input.contains("+")) return "+";
        else if(input.contains("-")) return "-";
        else if(input.contains("*")) return "*";
        else if (input.contains("/")) return "/";
        else return null;
    }
    static int calc(int a, int b, String oper) {
        if (oper.equals("+")) return a + b;
        else if(oper.equals("-")) return a - b;
        else if(oper.equals("*")) return a * b;
        else return a / b;
    }
}