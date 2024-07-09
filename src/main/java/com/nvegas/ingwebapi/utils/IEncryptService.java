package com.nvegas.ingwebapi.utils;

public interface IEncryptService {
    String encrypt(String message);
    String decrypt(String data);
}
