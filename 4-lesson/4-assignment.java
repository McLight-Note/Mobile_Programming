public class GachonUniversity {
    public static void main(String[] args) {
        /*
        int a = 30;
        int b = 20;

        // 1
        int c1 = (a < b) ? b : a;
        System.out.println("First exercise: c=" + c1);

        // 2
        int c2 = (a > b) ? a : b;
        System.out.println("Second exercise: c=" + c2);

        // 3
        int c3 = (a == b) ? b : b;
        System.out.println("Third exercise: c=" + c3);
            */
        int a = 20;
        int b = 35;

        // 4
        int c4 = (a > b) ? b : a;
        System.out.println("Fourth exercise: c=" + c4);

        // 5
        int c5 = (a % b == 0) ? a * b : a + b;
        System.out.println("Fifth exercise: c=" + c5);

        // second lesson of the week, exercises
        
        String str1 = "I am, a student of the  Gachon University!";
        String str2 = "and we are learning Java";
        
        // 1
        System.out.println("Original string: " + str1 + "");
        System.out.println("Length: " + str1.length());
        
        // with operator
        String concat1 = str1 + " " + str2;
        System.out.println("1- +operator:       " + concat1);
        
        // with concat
        String concat2 = str1.concat(" ").concat(str2);
        System.out.println("2- concat:  " + concat2);
        
        // with StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append(str1).append(" ").append(str2);
        String concat3 = sb.toString();
        System.out.println("3- StringBuilder:    " + concat3);
        
        
        // next exercises, trim methods
        
        String str3 = "Gachon     ";
        
        System.out.println("Original string: \"" + str3 + "\"");
        System.out.println();
        
        System.out.println("toLowerCase():  \"" + str3.toLowerCase() + "\"");
        System.out.println("toUpperCase():  \"" + str3.toUpperCase() + "\"");
        System.out.println("trim():         \"" + str3.trim() + "\"");
        
        
        // codePointAt, codePointBefore, contains, endsWith, isEmpty
        
        String str4 = "Java is name of coffee    ";
        
        System.out.println("Original string: \"" + str4 + "\"");
        System.out.println("Numbers:          0123456789...\n");
        
        // codePointAt
        int index1 = 5;
        System.out.println("codePointAt(" + index1 + "):    " + str4.codePointAt(index1)
            + "  char '" + str4.charAt(index1) + "' = unicpde " + str4.codePointAt(index1));
        
        // codePointBefore
        int index2 = 5;
        System.out.println("codePointBefore(" + index2 + "): " + str4.codePointBefore(index2)
                + "  char '" + str4.charAt(index2 - 1) + "' = unicode " + str4.codePointBefore(index2));
        
        // contains
        System.out.println("\ncontains(\"coffee\"): " + str4.contains("coffee")
                + "  \"coffee\" found in string");
        System.out.println("contains(\"Python\"): " + str4.contains("Python")
                + " \"Python\" not in string");
        
        // endsWith
        System.out.println("\nendsWith(\"coffee    \"): " + str4.endsWith("coffee    ")
                + "  ends with 'coffee    ' (with spaces)");
        System.out.println("endsWith(\"coffee\"):    " + str4.endsWith("coffee")
                + " doesn't end with 'coffee' (trailing spaces exist)");
        System.out.println("endsWith(\"    \"):      " + str4.endsWith("    ")
                + "  ends with 4 spaces");
        
        // isEmpty
        System.out.println("\nisDempty() on str4:        " + str4.isEmpty()
                + " has content");
        System.out.println("isEmpty() on \"\":           " + "".isEmpty()
                + "  empty string");
        System.out.println("isEmpty() on \"   \" (spaces): " + "   ".isEmpty()
                + " spaces are NOT empty");
    }
}