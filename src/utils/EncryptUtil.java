package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class EncryptUtil {
    public static String getPasswordEncrypt(String plain_p, String salt) {
        String ret = "";

        if(plain_p != null && !plain_p.equals("")) {
            byte[] bytes;
            String password = plain_p + salt;
            try {
                bytes = MessageDigest.getInstance("SHA-256").digest(password.getBytes());
                ret = DatatypeConverter.printHexBinary(bytes);
            } catch(NoSuchAlgorithmException ex) {}
        }

        return ret;
    }
}

// 文字列を SHA256 で暗号化するクラス
//   このクラスの getPasswordEncrypt メソッドは、
//   引数で受け取った文字列にソルト文字列を連結させた
//   ものを SHA256 で暗号化します。引数の文字列が何
//   もなければ、空の文字列を返します。