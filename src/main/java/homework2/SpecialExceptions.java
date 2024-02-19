package homework2;

public class SpecialExceptions {
    public static void main(String[] args){

        int[] a=new int[3];

        System.out.println("Program Starts Work");
        try{
            a[4]=10;
        }catch (ArithmeticException ar){

            System.out.println("Error!");
            System.out.println(ar.getMessage());

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        System.out.println("The End!");
    }
}

