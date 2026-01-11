package model;

public enum Category {
    PengetahuanUmum("pu.txt", "Pengetahuan Umum"),
    PilihanGanda("pg.txt", "Pilihan Ganda"),
    TekaTeki("tt.txt", "Teka-Teki"),
    MTK("mtk.txt", "Matematika");

    private final String file;
    private final String label;
    Category(String file, String label) {
        this.file = file;
        this.label = label;
    }

    public String getFile() {
        return file;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
