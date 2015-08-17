class A {
    A() { print(); }
    void print() { System.out.println("A"); }
}
class B extends A {
    int i = 5;
    public static void main(String[] args) {
        A a = new B();
        a.print();
    }
    void print() { System.out.println(i); }
}