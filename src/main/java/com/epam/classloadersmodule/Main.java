package com.epam.classloadersmodule;

import javassist.CannotCompileException;
import javassist.ClassPool;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        try {
            urlClassLoaderExample();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private static void classLoadersInfo() {
        Example example = new Example();
        System.out.println(example.getClass().getClassLoader());
        System.out.println(example.getClass().getClassLoader().getParent());
        System.out.println(example.getClass().getClassLoader().getParent().getParent());
    }

    //при вызове Class.forName вызовется static блок
    private static void staticBlocksInitExample() throws ClassNotFoundException {
        ClassLoader.getSystemClassLoader().loadClass("com.epam.classloadersmodule.Example");
        Class.forName("com.epam.classloadersmodule.Example");
    }

    private static void metaspaceMemoryLeak() throws CannotCompileException {
        for (int i = 0; i < 1000000; i++) {
            generateClass("com.epam.classloadersmodule.classes.Test_" + i);
        }
    }

    private static void generateClass(String name) throws CannotCompileException {
        ClassPool pool = ClassPool.getDefault();
        pool.makeClass(name).toClass();
    }

    private static void urlClassLoaderExample() throws NoSuchMethodException, MalformedURLException, ClassNotFoundException,
            InvocationTargetException, IllegalAccessException, InstantiationException {
        URL[] urls = null;
        File file = new File("src\\main\\classes");
        urls = new URL[]{file.toURI().toURL()};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        Class c = urlClassLoader.loadClass("com.epam.ClassTwo");
        Object instance = c.newInstance();
        c.getMethod("print", null).invoke(instance, null);
        ClassLoader.getSystemClassLoader().loadClass("com.epam.ClassTwo");//системный класслоадер не видит наш класс
        System.out.println(c.getClassLoader());

    }

}
