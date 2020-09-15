public class DictionaryCommandLine extends DictionaryManagement{
    public void DictionaryBasic(){
        DictionaryManagement dnm = new DictionaryManagement();
        dnm.insertFromCommandline();
        dnm.showAllWords();
    }
    
}
