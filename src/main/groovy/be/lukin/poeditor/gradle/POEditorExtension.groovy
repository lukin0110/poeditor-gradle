package be.lukin.poeditor.gradle

import be.lukin.poeditor.Config

class POEditorExtension {

    private static final String DEFAULT_VARIANT = ""

    static class POEditorConfiguration {
        String terms;
        String projectId;
        Map<String, String> translations = new HashMap<>()
        Map<String, String> filters = new HashMap<>()
    }

    final String name;
    String variant;
    String apiKey;
    String type;
    String[] tagsNew;

    Map<String, POEditorConfiguration> configurations;

    POEditorExtension(){
        this("default");
    }

    POEditorExtension(String name){
        this.configurations = new HashMap<>()
        this.configurations.put(
                DEFAULT_VARIANT,
                new POEditorConfiguration())
        this.name = name;
        this.variant = DEFAULT_VARIANT
    }

    void variant(String variant) {
        if (!configurations.containsKey(variant)) {
            configurations.put(variant, new POEditorConfiguration())
        }
        this.variant = variant
    }

    void apikey(String apiKey){
        this.apiKey = apiKey
    }

    void projectId(String projectId){
        configurations.get(variant).projectId = projectId;
    }

    void type(String type){
        this.type = type;
    }

    void terms(String terms){
        configurations.get(variant).terms = terms;
    }

    void trans(String language, String path) {
        configurations.get(variant).translations.put(language, path);
    }

    void filters(String language, String filters){
        configurations.get(variant).filters.put(language, filters);
    }

    void tagsNew(String[] tagsNew) {
        this.tagsNew = tagsNew
    }

    public Config toConfig(){
        def currentConfig = configurations.get(variant)
        return new Config(
                apiKey,
                currentConfig.projectId,
                type,
                currentConfig.terms,
                currentConfig.translations,
                currentConfig.filters,
                null, tagsNew, null, null);
    }

    @Override
    public String toString() {
        return "POEditorExtension{" +
                "name='" + name + '\'' +
                ", apiKey='" + apiKey + '\'' +
                ", terms='" + configurations.get(variant).terms + '\'' +
                ", projectId='" + configurations.get(variant).projectId + '\'' +
                ", type='" + type + '\'' +
                ", translations=" + configurations.get(variant).translations +
                ", filters=" + configurations.get(variant).filters +
                ", tagsNew=" + Arrays.toString(tagsNew) +
                '}';
    }
}
