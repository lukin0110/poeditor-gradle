package be.lukin.poeditor.gradle

import be.lukin.poeditor.Config

class POEditorExtension {
    final String name;
    String apiKey;
    String terms;
    String projectId;
    String type;
    Map<String, String> translations;
    Map<String, String> filters;
    String[] tagsNew;
    
    POEditorExtension(){
        this("default");
    }

    POEditorExtension(String name){
        this.name = name;
        this.translations = new HashMap<>();
        this.filters = new HashMap<>();
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
        this.translations.put(language, path);
    }
    
    void filters(String language, String filters){
        this.filters.put(language, filters);
    }

    void tagsNew(String[] tagsNew) {
        this.tagsNew = tagsNew
    }

    public Config toConfig(){
        Config config = new Config(apiKey, projectId, type, terms, translations, filters, null, tagsNew, null, null);
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
                ", translations=" + translations +
                ", filters=" + filters +
                ", tagsNew=" + Arrays.toString(tagsNew) +
                '}';
    }
}
