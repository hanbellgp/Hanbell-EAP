/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.jrs.model;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author C2082
 */
public class JSONObject implements Map<String, Object>, Cloneable, Serializable, InvocationHandler {

    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private final Map<String, Object> map;

    public JSONObject() {
        this(DEFAULT_INITIAL_CAPACITY, false);
    }

    public JSONObject(Map<String, Object> map) {
        this.map = map;
    }

    public JSONObject(boolean ordered) {
        this(DEFAULT_INITIAL_CAPACITY, ordered);
    }

    public JSONObject(int initialCapacity) {
        this(initialCapacity, false);
    }

    public JSONObject(int initialCapacity, boolean ordered) {
        if (ordered) {
            map = new LinkedHashMap<String, Object>(initialCapacity);
        } else {
            map = new HashMap<String, Object>(initialCapacity);
        }
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        if(this.map==null){
            return  true;
        }
        return map.isEmpty();
    }

    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    public Object get(Object key) {
        return map.get(key);
    }

//    public JSONObject getJSONObject(String key) {
//        Object value = map.get(key);
//
//        if (value instanceof JSONObject) {
//            return (JSONObject) value;
//        }
//
//        return (JSONObject) toJSON(value);
//    }
//    public JSONArray getJSONArray(String key) {
//        Object value = map.get(key);
//
//        if (value instanceof JSONArray) {
//            return (JSONArray) value;
//        }
//
//        return (JSONArray) toJSON(value);
//    }
//
//    public <T> T getObject(String key, Class<T> clazz) {
//        Object obj = map.get(key);
//        return TypeUtils.castToJavaBean(obj, clazz);
//    }
//    public Boolean getBoolean(String key) {
//        Object value = get(key);
//
//        if (value == null) {
//            return null;
//        }
//
//        return castToBoolean(value);
//    }
//
//    public byte[] getBytes(String key) {
//        Object value = get(key);
//
//        if (value == null) {
//            return null;
//        }
//
//        return castToBytes(value);
//    }
//
//    public boolean getBooleanValue(String key) {
//        Object value = get(key);
//
//        if (value == null) {
//            return false;
//        }
//
//        return castToBoolean(value).booleanValue();
//    }
//
//    public Byte getByte(String key) {
//        Object value = get(key);
//
//        return castToByte(value);
//    }
//
//    public byte getByteValue(String key) {
//        Object value = get(key);
//
//        if (value == null) {
//            return 0;
//        }
//
//        return castToByte(value).byteValue();
//    }
//
//    public Short getShort(String key) {
//        Object value = get(key);
//
//        return castToShort(value);
//    }
//
//    public short getShortValue(String key) {
//        Object value = get(key);
//
//        if (value == null) {
//            return 0;
//        }
//
//        return castToShort(value).shortValue();
//    }
//
//    public Integer getInteger(String key) {
//        Object value = get(key);
//
//        return castToInt(value);
//    }
//
//    public int getIntValue(String key) {
//        Object value = get(key);
//
//        if (value == null) {
//            return 0;
//        }
//
//        return castToInt(value).intValue();
//    }
//
//    public Long getLong(String key) {
//        Object value = get(key);
//
//        return castToLong(value);
//    }
//
//    public long getLongValue(String key) {
//        Object value = get(key);
//
//        if (value == null) {
//            return 0L;
//        }
//
//        return castToLong(value).longValue();
//    }
//
//    public Float getFloat(String key) {
//        Object value = get(key);
//
//        return castToFloat(value);
//    }
//
//    public float getFloatValue(String key) {
//        Object value = get(key);
//
//        if (value == null) {
//            return 0F;
//        }
//
//        return castToFloat(value).floatValue();
//    }
//
//    public Double getDouble(String key) {
//        Object value = get(key);
//
//        return castToDouble(value);
//    }
//
//    public double getDoubleValue(String key) {
//        Object value = get(key);
//
//        if (value == null) {
//            return 0D;
//        }
//
//        return castToDouble(value).floatValue();
//    }
//
//    public BigDecimal getBigDecimal(String key) {
//        Object value = get(key);
//
//        return castToBigDecimal(value);
//    }
//
//    public BigInteger getBigInteger(String key) {
//        Object value = get(key);
//
//        return castToBigInteger(value);
//    }
    public String getString(String key) {
        Object value = get(key);

        if (value == null) {
            return null;
        }

        return value.toString();
    }

//    public Date getDate(String key) {
//        Object value = get(key);
//
//        return castToDate(value);
//    }
//
//    public java.sql.Date getSqlDate(String key) {
//        Object value = get(key);
//
//        return castToSqlDate(value);
//    }
//
//    public java.sql.Timestamp getTimestamp(String key) {
//        Object value = get(key);
//
//        return castToTimestamp(value);
//    }
    public Object put(String key, Object value) {
        return map.put(key, value);
    }

    public void putAll(Map<? extends String, ? extends Object> m) {
        map.putAll(m);
    }

    public void clear() {
        map.clear();
    }

    public Object remove(Object key) {
        return map.remove(key);
    }

    public Set<String> keySet() {
        return map.keySet();
    }

    public Collection<Object> values() {
        return map.values();
    }

    public Set<Map.Entry<String, Object>> entrySet() {
        return map.entrySet();
    }

    @Override
    public Object clone() {
        return new JSONObject(new HashMap<String, Object>(map));
    }

    public boolean equals(Object obj) {
        return this.map.equals(obj);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
        return null;
    }
}
