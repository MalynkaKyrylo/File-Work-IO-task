package app;

import utils.Constants;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriteService {
    public String handleFile(String fileName, String text) {
        try (FileOutputStream fout = new FileOutputStream(Constants.BASE_PATH + fileName)) {
            byte[] byteArr = text.getBytes();
            fout.write(byteArr);
        } catch (IOException ex) {
            return ex.getMessage();
        }
        return "File created successfully!";
    }
}
