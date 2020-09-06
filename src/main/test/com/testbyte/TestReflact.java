package com.testbyte;

import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

/**
 * @author: liudeyu
 * @date: 2020/7/8
 */
public class TestReflact {


   static class Util {
        static <K, V> TypeToken<Map<K, V>> incorrectMapToken() {
            return new TypeToken<Map<K, V>>() {};
        }

       static <K, V> TypeToken<Map<K, V>> mapToken(TypeToken<K> keyToken, TypeToken<V> valueToken) {
           return new TypeToken<Map<K, V>>() {}
                   .where(new TypeParameter<K>() {}, keyToken)
                   .where(new TypeParameter<V>() {}, valueToken);
       }
    }

    public static <K, V> Comparator<Map.Entry<K, V>> comparingByKey(Comparator<? super K> cmp) {
        Objects.requireNonNull(cmp);
        return (Comparator<Map.Entry<K, V>> & Serializable)
                (c1, c2) -> cmp.compare(c1.getKey(), c2.getKey());
    }
    public static void main(String[] args) {
        System.out.println(Util.<String, BigInteger>incorrectMapToken());

        System.out.println(Util.mapToken(TypeToken.of(Integer.class), new TypeToken<BigInteger>() {
        }));


    }
}
