public class MySecondJavaProgram{
    // This is a comment
   public static void main(String[] args) {
       String name = "Muhammad";
       System.out.println("Hello my name is " + name);
       printFavoriteNumber(32.1);
   }
   public static void printFavoriteNumber(double javaInteger) {
    float javaFloat = 32.1f;
    double numdouble = 32.1;
    long numlong = 32238723872482L;
    byte numbyte = 32;
    short numshort = 32000;
    char numchar = 'A';
    boolean numboolean = true;
       System.out.println("My favorite number is " + javaInteger);
       System.out.println("As a float, it's " + javaFloat);
       System.out.println("As a double, it's " + numdouble);
       System.out.println("As a long, it's " + numlong);
       System.out.println("As a byte, it's " + numbyte);
       System.out.println("As a short, it's " + numshort);
       System.out.println("As a char, it's " + numchar);
       System.out.println("As a boolean, it's " + numboolean);
   }
}