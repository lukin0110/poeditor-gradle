package be.lukin.poeditor.gradle

import be.lukin.poeditor.Config

class POEditorExtension {
    final String name;
    String apiKey;
    String terms;
    String projectId;
    String type;
    Map<String, String> map;
    String[] tagsNew;
    
    POEditorExtension(){
        this("default");
    }

    POEditorExtension(String name){
        this.name = name;
        this.map = new HashMap<>();
    }
    
    void apikey(String apiKey){
        this.apiKey = apiKey
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

    void tagsNew(String[] tagsNew) {
        this.tagsNew = tagsNew
    }

    public Config toConfig(){
        Config config = new Config(apiKey, projectId, type, terms, map, null, tagsNew, null, null);
        return config;
    }

    @Override
    public String toString() {
        return "POEditorExtension{" +
                "name='" + name + '\'' +
                ", apiKey='" + apiKey + '\'' +
                ", terms='" + terms + '\'' +
                ", projectId='" + projectId + '\'' +
                ", type='" + type + '\'' +
                ", map=" + map +
                '}';
    }
}
