package PilasyColas;

public class Tester {
    public static void main(String[] args) {
        Stack stack = new Stack();
        //boolean orderIsConserved = true;

        for (int i = 0; i < 200; i++) {
            stack.stack(i);
        }
        System.out.println(stack.peek());
        //for (int i = 199; i >= 0 ; i--) {
        //    if(!stack.peek().equals(i)) orderIsConserved = false;
        //    stack.pop();
        //}

        //System.out.println(orderIsConserved);


    }
}
