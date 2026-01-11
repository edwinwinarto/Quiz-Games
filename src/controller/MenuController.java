package controller;

import model.*;
import util.FileLoader;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class MenuController {

    private static final int TOTAL_SOAL = 10;

    public static void start(Category c) {

        // 1. Load semua soal (30–40)
        List<Question> all = FileLoader.load(c.getFile());

        // Safety check
        if (all.size() < TOTAL_SOAL) {
            throw new RuntimeException(
                "Jumlah soal di file " + c.getFile() + " kurang dari " + TOTAL_SOAL
            );
        }

        // 2. Acak soal
        Collections.shuffle(all);

        // 3. Ambil 10 soal pertama
        List<Question> selected = new ArrayList<>(
            all.subList(0, TOTAL_SOAL)
        );

        // 4. Buat quiz dari 10 soal
        Quiz quiz = new Quiz(selected);

        // ✅ SET KATEGORI (WAJIB)
        QuizController.setCategory(c.getLabel());

        // 5. Start quiz
        QuizController.start(quiz);
    }
}
