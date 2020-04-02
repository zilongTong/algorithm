package org.tzl.proxy.asm;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import org.tzl.proxy.custom.LProxy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import static sun.tools.java.RuntimeConstants.ACC_PUBLIC;

public class AsMain {

    public static void main(String[] args) {
        writeCLass();
        ClassVisitor visitor = new ClassVisitor(Opcodes.ASM5) {
            @Override
            public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
                super.visit(version, access, name, signature, superName, interfaces);
                //打印出父类name和本类name
                System.out.println(superName + " " + name);
            }

            @Override
            public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                //打印出方法名和类型签名
                System.out.println(name + " " + desc);
                return super.visitMethod(access, name, desc, signature, exceptions);
            }
        };
        //读取静态内部类
        ClassReader cr = null;
        try {
            cr = new ClassReader("org.tzl.proxy.asm.AsMain$Sam");
            cr.accept(visitor, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 然后我们可以往Sam类里面新增方法:
     * public void addedMethod(String str) {
     * }
     */
    public static void writeCLass() {

        try {
            ClassReader classReader = new ClassReader(Sam.class.getName());
            ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_MAXS);
            classReader.accept(classWriter, Opcodes.ASM5);
            MethodVisitor mv = classWriter.visitMethod(ACC_PUBLIC, "addedMethod", "(Ljava/lang/String;)V", null, null);
            mv.visitInsn(Opcodes.RETURN);
            mv.visitEnd();
            // 获取生成的class文件对应的二进制流Unicode
            byte[] code = classWriter.toByteArray();


            String res = new String(code, Charset.forName("Unicode"));
            System.out.println(res);
            //将二进制流写到目录下
            String filePath = Sam.class.getResource("").getPath();
            FileOutputStream fos = new FileOutputStream(filePath + "DSam.class");
            fos.write(code);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static class Sam {

        private String name;

        public Sam(String name) {
            this.name = name;
        }

        private long getAge() {
            return 25;
        }

        private void Say() {
            System.out.println("你是不是傻...");
        }

    }

}


