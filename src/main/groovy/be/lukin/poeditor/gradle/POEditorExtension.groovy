package be.lukin.poeditor.gradle

class POEditorExtension extends POEditorProject {
    String apiKey;
    
    POEditorExtension(){
        super("default");
    }
    
    void apikey(String apiKey){
        this.apiKey = apiKey
    }

    @Override
    public String toString() {
        return "POEditorExtension{" +
                "apiKey='" + apiKey + '\'' +
                '}';
    }
}
