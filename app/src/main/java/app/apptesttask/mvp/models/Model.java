package app.apptesttask.mvp.models;

public interface Model {
    void saveTokenInPrefs(String token);
    String getTokenFromPrefs();
}
