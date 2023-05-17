package com.example.xtypee.metodos;

import androidx.core.util.PatternsCompat;

import com.example.xtypee.json.MyInfo;
import com.example.xtypee.registro;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Metodos {
    public static final String TAG = "Hola";
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    //Metodos Sha1
    public static byte[] createSha1( String text )
    {
        MessageDigest messageDigest = null;
        byte[] bytes = null;
        byte[] bytesResult = null;
        try
        {
            messageDigest = MessageDigest.getInstance("SHA-1");
            bytes = text.getBytes("iso-8859-1");
            messageDigest.update(bytes, 0, bytes.length);
            bytesResult = messageDigest.digest();
            return bytesResult;
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static String bytesToHex(byte[] bytes)
    {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
    //Metodos validacion
    public static boolean validarEmail(String email){
        boolean bandera;
        if(email.isEmpty()){
            bandera=false;
        }else{
            if(PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()){
                bandera=true;
            }else{
                bandera=false;
            }
        }
        return bandera;
    }
    public static boolean usuarios(List<MyInfo> list, String usr, String correo){
        boolean bandera = false;
        for(MyInfo informacion : list){
            if(informacion.getUsuario().equals(usr) || informacion.getCorreo().equals(correo)){
                bandera=true;
            }
        }
        return bandera;
    }
    //Metodos JSON el getFile tiene bug
    //Metodo de llenado
    public static void fillInfo(MyInfo info){
        info.setUsuario(registro.usr);
        String pass = registro.password;
        info.setPassword(pass);
        info.setCel(registro.numero);
        info.setDate(registro.fecha);
        info.setCorreo(registro.email);
        info.setRegion(registro.region);
        info.setSexo(registro.activado);
        info.setNombre(registro.nom);
    }

}
