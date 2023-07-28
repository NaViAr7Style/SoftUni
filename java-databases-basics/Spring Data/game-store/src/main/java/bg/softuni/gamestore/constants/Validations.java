package bg.softuni.gamestore.constants;

public class Validations {
    public final static String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public final static String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
    public final static String GAME_TITLE_PATTERN = "^[A-Z][A-Za-z]{2,99}$";
    public final static String YOUTUBE_URL_PATTERN = "v=([^&?\\/]+)";




}
