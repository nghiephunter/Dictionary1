public class DictionaryCommandLine extends DictionaryManagement{
    public void DictionaryBasic(){
        DictionaryManagement dnm = new DictionaryManagement();
        dnm.insertFromCommandline();
        dnm.insertFromFile();
        dnm.showAllWords();
    }
    public void DictionaryAdvanced(){
        DictionaryManagement dnm1 = new DictionaryManagement();
        dnm1.insertFromFile();
        dnm1.showAllWords();
        //dnm1.dictionaryLookup();
        //dnm1.DictionaryChange();
        //dnm1.dictionarySearch();
        //dnm1.showAllWords();
        dnm1.dictionaryExportToFile();

    }
    
}
