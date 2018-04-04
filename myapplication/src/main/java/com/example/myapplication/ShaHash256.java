package com.example.myapplication;

/**
 * Created by root on 18-2-28.
 */

public class ShaHash256{


    public static native byte[] doLyraHash(byte[] input,int len);

    public static byte[] hashLyz2(byte[] input)
    {
        //doDefaultDevelopment();
       // System.out.println(System.getProperty("java.library.path"));
        System.loadLibrary("LyraZ");
        return doLyraHash(input, input.length);
    }


}