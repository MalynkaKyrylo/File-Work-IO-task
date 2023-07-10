package app;

import utils.Constants;

import java.io.FileInputStream;
import java.io.IOException;

public class FileReadService {
    public String readFile(String fileName) {
        try (FileInputStream fin = new FileInputStream(Constants.BASE_PATH + fileName)) {
            StringBuilder builder = new StringBuilder();
            int i;
            while ((i = fin.read()) != -1) {
                builder.append((char) i);
            }
            return builder.toString();
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }
}
