package reflection;

/**
 * Created by Ton on 2017/5/8.
 */
class C implements A {

    private   String a;
    public  Integer b;
    protected  float c;

    public C() {
        System.out.println("Construction DEFAILT");
    }

    public C(String b) {
        System.out.println("Constrution B");
    }

    public void f(String a) {
        System.out.println("public C.f()"+a);
    }

    public void g(String a) {
        System.out.println("public C.g()"+a);
    }

    protected void v() {
        System.out.println("protected C.v()");
    }

    void u() {
        System.out.println("package C.u()");
    }

    private void w() {
        System.out.println("private C.w()");
    }
}
