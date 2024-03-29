package be.heh.app.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Enumeration;
import java.util.List;

public class Utils {

    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

    static final String AB = "0123456789";

    /**
     * 24 -> 32 char / 48 -> 60 char So for 24 bytes from the above example you get the 32 chars.
     * @return  random string in base64 encoding with 32 chars.
     * In Base64 encoding every char encodes 6 bits of the data.
     * https://stackoverflow.com/questions/13992972/how-to-create-a-authentication-token-using-java
     */
    public static String generateNewToken(int i) {
        byte[] randomBytes = new byte[i];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

    public static String randomNumber(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(secureRandom.nextInt(AB.length())));
        }
        return sb.toString();
    }

    public static List<Class> getClasses(String packageName)
            throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        List<Class> classes = new ArrayList<Class>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes;
    }

    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

    public static String lowerFirstChar(String str) {
        String retStr = str;
        try {
            retStr = str.substring(0, 1).toLowerCase() + str.substring(1);
        } catch (Exception ignored) { }
        return retStr;
    }

    public static String upperFirstChar(String str) {
        char[] array = str.toCharArray();
        array[0] = Character.toUpperCase(array[0]);
        return new String(array);
    }

    public static int StringToInt(String str) {
        int id = 0;
        try {
            id = Integer.parseInt(str);
        } catch (Exception ignored) { }
        return id;
    }

    public static int getRandom(int min, int max) {
        return (int) Math.floor(Math.random()*(max-min +1) + min);
    }

    public static List<Integer> getRandomIdListUnique(int listMinLength, int listMaxLength, int minRandom, int maxRandom) {
        ArrayList<Integer> list = new ArrayList<>();
        int random_int = (int) Math.floor(Math.random()*(listMaxLength - listMinLength +1) + listMinLength);
        while(list.size() != random_int){
            int random = (int) Math.floor(Math.random()*(maxRandom - minRandom +1) + minRandom);
            if (!list.contains(random)) {
                list.add(random);
            }
        }
        return list;
    }

    public static List<String> get3String(String str) {
        ArrayList<String> res = new ArrayList<>();
        String[] strList = str.split("");
        for (int i = 1; i < strList.length - 1; i++) {
            res.add(strList[i - 1] + strList[i] + strList[i + 1]);
        }
        return res;
    }
}
