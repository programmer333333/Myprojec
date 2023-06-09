public class Roman {
    static String[] romanArray = new String[] {"0", "I", "II", "III", " IV", "V", "VI", "VII", "VIII", " IX", "X"};

    static boolean roman(String val) {
        for (int i = 0; i < romanArray.length; i++){
            if(val.equals(romanArray[i])){
                return true;
            }
        }
        return false;
    }
    static int convertToArabian(String rom){
        for (int i = 0; i < romanArray.length; i++){
            if(rom.equals(romanArray[i])){
                return i;
            }

        }
        return 0;
    }
    static String convertToRoman(int arabian) {return romanArray[arabian];}

    }

