/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eCheque;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author morgan
 */
public class ReflectClass {
    private Class defaultClass;
    private Object defaultObject;
    
    protected void setDefaultClass(Class c) {
        defaultClass = c;
    }
    
    protected void setDefaultObject(Object o) {
        defaultObject = o;
    }
    
    protected Method getMethod(String name, Class ... cls) throws NoSuchMethodException {
        return getMethod(defaultClass, name, cls);
    }
    
    protected Method getMethod(Class c, String name, Class ... cls) throws NoSuchMethodException {   
        Method method = c.getDeclaredMethod(name, cls);
        method.setAccessible(true);
        return method;
    }
    
    protected Object runMethodDef(Method method, Object ... args) throws IllegalAccessException,InvocationTargetException {
        return runMethod(method, defaultObject, args);
    }
    
    protected Object runMethod(Method method, Object o, Object ... args) throws IllegalAccessException, InvocationTargetException {
        return method.invoke(o, args);
    }
    
    protected Object getAttrDef(String name) throws NoSuchFieldException, IllegalAccessException {
        return getAttr(defaultClass, name, defaultObject);
    }
    
    protected Object getAttr(String name, Object o) throws NoSuchFieldException, IllegalAccessException {
        return getAttr(defaultClass, name, o);
    }
    
    protected Object getAttr(Class c, String name, Object o) throws NoSuchFieldException, IllegalAccessException {
        Field f = c.getDeclaredField(name);
        f.setAccessible(true);
        return f.get(o);
    }
    
}
