public class Faculty {
    private String name;
    private String title;

    public Faculty(){}

    public Faculty(String name){
        this.name = name;
    }

    public Faculty(String name,String title) {
        this.name = name;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
