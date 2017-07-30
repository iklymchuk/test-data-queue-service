package userqueue.util;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class FileUtil {

    public static List<String> getUsersList(String filePath) {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
        try {
            return Arrays.asList(readString(is).split("\\s*,\\s*"));
        } catch (IOException e) {

        }
        return null;
    }

    static String readString(InputStream is) throws IOException {
        char[] buf = new char[2048];
        Reader r = new InputStreamReader(is, "UTF-8");
        StringBuilder s = new StringBuilder();
        while (true) {
            int n = r.read(buf);
            if (n < 0)
                break;
            s.append(buf, 0, n);
        }
        return s.toString();
    }
}
