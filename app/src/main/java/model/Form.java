package model;

public class Form {
    private int id;
    private String road;
    private String link;
    private String sub_link;
    private String start;
    private String end;
    private String corridor;
    private String region;
    private String shoulder_type;

    public Form(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSub_link() {
        return sub_link;
    }

    public void setSub_link(String sub_link) {
        this.sub_link = sub_link;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getCorridor() {
        return corridor;
    }

    public void setCorridor(String corridor) {
        this.corridor = corridor;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getShoulder_type() {
        return shoulder_type;
    }

    public void setShoulder_type(String shoulder_type) {
        this.shoulder_type = shoulder_type;
    }

    public Form(String road, String link, String sub_link, String start, String end, String corridor, String region, String shoulder_type) {
        this.road = road;
        this.link = link;
        this.sub_link = sub_link;
        this.start = start;
        this.end = end;
        this.corridor = corridor;
        this.region = region;
        this.shoulder_type = shoulder_type;
    }
    public String toString(){
        return getRoad();
    }
}
