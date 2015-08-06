//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.buobao.utils;

import java.security.SecureRandom;
import java.util.UUID;

public class Identities {
    private static SecureRandom random = new SecureRandom();

    public Identities() {
    }

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String uuid2() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static long randomLong() {
        return Math.abs(random.nextLong());
    }

    public static String randomLongAsString() {
        return String.valueOf(Math.abs(random.nextLong()));
    }

    public static String randomBase62(int length) {
        byte[] randomBytes = new byte[length];
        random.nextBytes(randomBytes);
        return Encodes.encodeBase62(randomBytes);
    }

    public static long randomLong(int length) {
        String random = String.valueOf(randomLong()).substring(0, length);
        System.out.println(random + " " + random.length());
        return Long.valueOf(random).longValue();
    }

    public static void main(String[] args) {
        System.out.println(randomLong() + " " + String.valueOf(randomLong()).length());
        System.out.println(randomLong() + " " + String.valueOf(randomLong()).length());
        System.out.println(randomLong() + " " + String.valueOf(randomLong()).length());
        System.out.println(randomLong() + " " + String.valueOf(randomLong()).length());
        System.out.println(randomLong() + " " + String.valueOf(randomLong()).length());
        randomLong(12);
        randomLong(12);
    }
}
