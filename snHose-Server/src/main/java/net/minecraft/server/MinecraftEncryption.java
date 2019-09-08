package net.minecraft.server.v1_7_R4;

import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.spec.*;
import java.security.*;

public class MinecraftEncryption
{
    public static KeyPair b() {
        try {
            final KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
            instance.initialize(1024);
            return instance.generateKeyPair();
        }
        catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            System.err.println("Key pair generation failed!");
            return null;
        }
    }
    
    public static byte[] a(final String s, final PublicKey publicKey, final SecretKey secretKey) {
        try {
            return a("SHA-1", new byte[][] { s.getBytes("ISO_8859_1"), secretKey.getEncoded(), publicKey.getEncoded() });
        }
        catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static byte[] a(final String s, final byte[]... array) {
        try {
            final MessageDigest instance = MessageDigest.getInstance(s);
            for (int length = array.length, i = 0; i < length; ++i) {
                instance.update(array[i]);
            }
            return instance.digest();
        }
        catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static PublicKey a(final byte[] array) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(array));
        }
        catch (NoSuchAlgorithmException ex) {}
        catch (InvalidKeySpecException ex2) {}
        System.err.println("Public key reconstitute failed!");
        return null;
    }
    
    public static SecretKey a(final PrivateKey privateKey, final byte[] array) {
        return new SecretKeySpec(b(privateKey, array), "AES");
    }
    
    public static byte[] b(final Key key, final byte[] array) {
        return a(2, key, array);
    }
    
    private static byte[] a(final int n, final Key key, final byte[] array) {
        try {
            return a(n, key.getAlgorithm(), key).doFinal(array);
        }
        catch (IllegalBlockSizeException ex) {
            ex.printStackTrace();
        }
        catch (BadPaddingException ex2) {
            ex2.printStackTrace();
        }
        System.err.println("Cipher data failed!");
        return null;
    }
    
    private static Cipher a(final int n, final String s, final Key key) {
        try {
            final Cipher instance = Cipher.getInstance(s);
            instance.init(n, key);
            return instance;
        }
        catch (InvalidKeyException ex) {
            ex.printStackTrace();
        }
        catch (NoSuchAlgorithmException ex2) {
            ex2.printStackTrace();
        }
        catch (NoSuchPaddingException ex3) {
            ex3.printStackTrace();
        }
        System.err.println("Cipher creation failed!");
        return null;
    }
    
    public static Cipher a(final int n, final Key key) {
        try {
            final Cipher instance = Cipher.getInstance("AES/CFB8/NoPadding");
            instance.init(n, key, new IvParameterSpec(key.getEncoded()));
            return instance;
        }
        catch (GeneralSecurityException ex) {
            throw new RuntimeException(ex);
        }
    }
}
