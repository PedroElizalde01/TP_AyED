package PilasyColas;

public class Tester {
    public static void main(String[] args) throws IsEmptyException {
        Stack stack = new Stack();
        //boolean orderIsConserved = true;
        //for (int i = 0; i < 200; i++) {
        //    stack.stack(i);
        //}
        //System.out.println(stack.peek());
        //for (int i = 199; i >= 0 ; i--) {
        //    if(!stack.peek().equals(i)) orderIsConserved = false;
        //    stack.pop();
        //}
        //System.out.println(orderIsConserved);
        for (int i = 0; i < 50; i++) {
            stack.stack(i);
        }
        for (int i = 0; i < 20; i++) {
            stack.pop();
        }
        System.out.println(30== stack.size());
    }
}
