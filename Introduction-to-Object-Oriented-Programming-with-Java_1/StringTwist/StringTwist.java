public class StringTwist {
    public static void main(String[] args) {
        String funnyStr = "Computer!Science,!long!walks!on!the!beach";
        String funnyStr1 = funnyStr.replace("!"," ");
        String funnyStr2 = funnyStr1.replace("the beach","");
        String funnyStr3 = funnyStr2.replace(", long","");
        String funnyStr4 = funnyStr3.replace("wal","roc");
        String funnyStr5 = funnyStr4.toUpperCase(); 
        System.out.println(funnyStr);
        System.out.println(funnyStr1);
        System.out.println(funnyStr2);
        System.out.println(funnyStr3);
        System.out.println(funnyStr4);
        System.out.println(funnyStr5);
    }
}