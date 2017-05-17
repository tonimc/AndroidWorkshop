package xyz.tonimartinez.workshop.domain.model;

import java.util.Date;


public class Android {
    private int id;
    private String codeName;
    private String version;
    private int logo;
    private String description;

    public Android(int id, String codeName, String version, int logo, String description) {
        this.id = id;
        this.codeName = codeName;
        this.version = version;
        this.logo = logo;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getCodeName() {
        return codeName;
    }

    public String getVersion() {
        return version;
    }

    public int getLogo() {
        return logo;
    }

    public String getDescription() {
        return description;
    }

}
