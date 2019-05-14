package me.luckyffa.system;

public class ChatUtil {

    public static String fixcolor(String s){
        return s.replace("&", "&").replace(">>", "&").replace("<<", "&");
    }
}
