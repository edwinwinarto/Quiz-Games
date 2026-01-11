package util;

import model.*;

import java.io.*;
import java.util.*;

public class FileLoader {

    public static List<Question> load(String file) {
        List<Question> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        FileLoader.class.getResourceAsStream("/data/" + file)
                )
        )) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] p = line.split("\\|");

                if (p.length == 2)
                    list.add(new TextQuestion(p[0], p[1]));

                else if (p.length == 6)
                    list.add(new ChoiceQuestion(
                            p[0], List.of(p[1], p[2], p[3], p[4]), p[5]
                    ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
