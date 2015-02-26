package be.lukin.poeditor.gradle

class POEditorProject {
    final String name;
    String terms;
    String projectId;
    String type;
    Map<String, String> map;

    POEditorProject(String name){
        this.name = name;
        this.map = new HashMap<>();
    }

    void projectId(String projectId){
        this.projectId = projectId;
    }

    void type(String type){
        this.type = type;
    }

    void terms(String terms){
        this.terms = terms;
    }

    void trans(String language, String path){
        this.map.put(language, path);

    }

    @Override
    public String toString() {
        return "POEditorProject{" +
                "name='" + name + '\'' +
                ", terms='" + terms + '\'' +
                ", projectId='" + projectId + '\'' +
                ", type='" + type + '\'' +
                ", map=" + map +
                '}';
    }
}
