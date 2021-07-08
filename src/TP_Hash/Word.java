package TP_Hash;

import TP_Hash.Util.Hashable;

public class Word implements Hashable {
    String word;

    public Word(String word) {
        this.word = word;
    }

    public int hashCode(int tablesize){
        return getGode(word)%tablesize;
    }

    public int getGode(String s) {
        char[] x = s.toUpperCase().toCharArray();
        char firstLetter = x[0];
        //RULE [ 2 ]
        //Convert letters to numeric code
        for (int i = 0; i < x.length; i++) {
            switch (x[i]) {
                case 'B':
                case 'F':
                case 'P':
                case 'V': {
                    x[i] = '1';
                    break;
                }

                case 'C':
                case 'G':
                case 'J':
                case 'K':
                case 'Q':
                case 'S':
                case 'X':
                case 'Z': {
                    x[i] = '2';
                    break;
                }

                case 'D':
                case 'T': {
                    x[i] = '3';
                    break;
                }

                case 'L': {
                    x[i] = '4';
                    break;
                }

                case 'M':
                case 'N': {
                    x[i] = '5';
                    break;
                }

                case 'R': {
                    x[i] = '6';
                    break;
                }

                default: {
                    x[i] = '0';
                    break;
                }
            }
        }
        int firstletterInt = (int)firstLetter;
        int sum = firstletterInt;

        for (int i = 1; i < x.length; i++)
            if (x[i] != x[i - 1] && x[i] != '0')
                sum += x[i];
        return sum;
    }

    public String getWord() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        Word word = (Word) o;
        if (this.word.equals(word.getWord()) ) return true;
        return false;
    }
}
