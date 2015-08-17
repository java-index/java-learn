/**
 * Created by rabota on 16.08.15.
 */
    class A {
        A() { print(); }
        void print() { System.out.println("A"); }
    }

    class Test extends A {
        int i = 5;
        static String s = null;

        public static void main(String[] args) {
            A a = new Test();
            a.print();
            System.out.println(s instanceof String);
            System.out.println(2.00 - 1.10);
            System.out.println(12345 + 5432l);
            System.out.println((int)(char)(byte) -2);

            System.out.println("2 + 2 = " + 2 + 2);
        }
        void print() { System.out.println(i); }
    }
