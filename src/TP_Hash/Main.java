package TP_Hash;

import TP_Hash.Util.DynamicList;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/TP_Hash/dictionary");
        BufferedReader br = new BufferedReader(new FileReader(file));
        double sizeOfDictionary = 1000;
        HashTableOpen dictionary = new HashTableOpen((int)(sizeOfDictionary*1.2));
        String userInfo;
        while ((userInfo = br.readLine()) != null) {
            dictionary.insertar(new Word(userInfo));
        }
        File tester = new File("src/TP_Hash/tester");
        BufferedReader brTester = new BufferedReader(new FileReader(tester));
        String test;
        System.out.println("Words that aren't in the dictionary: ");
        while((test = brTester.readLine()) != null){
            Word testWord = new Word(test);
            if(!dictionary.exists(testWord)){
                System.out.println("\n\nWord: " + test);
                System.out.println("\nSuggestions\n");
                suggestions(testWord, dictionary);
            }
        }
    }

    private static void suggestions(Word test, HashTableOpen dictionary) {
        DynamicList<Word> list = dictionary.buscar(test);
        list.goFirst();
        for (int i = 0; i < list.size()-1; i++) {
            System.out.println(list.getActual().getWord());
            list.goNext();
        }
    }
}
