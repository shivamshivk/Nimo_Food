package e.wolfsoft1.ModelClasses;

public class Home {

    private int img_1;
    private int img_2;
    private String tile_1_text;
    private String tile_2_text;
    private String tile_title;

    public Home(int img_1, int img_2, String tile_1_text, String tile_2_text, String tile_title) {
        this.img_1 = img_1;
        this.img_2 = img_2;
        this.tile_1_text = tile_1_text;
        this.tile_2_text = tile_2_text;
        this.tile_title = tile_title;
    }

    public int getImg_1() {
        return img_1;
    }

    public int getImg_2() {
        return img_2;
    }

    public String getTile_1_text() {
        return tile_1_text;
    }

    public String getTile_2_text() {
        return tile_2_text;
    }

    public String getTile_title() {
        return tile_title;
    }

}
