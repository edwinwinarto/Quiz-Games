package util;

import java.io.*;

public class ResultWriter {

    private static final String DIR = "util";
    private static final String FILE = "result.txt";

    public static void save(String nama, String kategori, int score) {

        try {
            // 1. Buat folder util (di luar src)
            File folder = new File(DIR);
            if (!folder.exists()) {
                folder.mkdir();
            }

            // 2. Buat file result.txt
            File file = new File(folder, FILE);

            // 🔎 DEBUG: CETAK LOKASI FILE SEBENARNYA
            System.out.println("Result disimpan di: "
                    + file.getAbsolutePath());

            // 3. Tulis ke file
            try (BufferedWriter bw =
                    new BufferedWriter(new FileWriter(file, true))) {

                bw.write(nama + ", " + kategori + ", " + score);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
