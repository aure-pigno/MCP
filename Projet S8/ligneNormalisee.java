public class ligneNormalisee {
    public static void main(String[] args) {
        char[]test = "papa a vu le fifi de lolo .".toCharArray();;
        display(test);
        char[] result = ligneNormalisee(test,40);
        if(result != null) {
            display(result);
        }
    }

    public static char[] ligneNormalisee(char[] ligne, int l) {
        final int nombreChars = numChar(ligne);
        final int nombreMots = numWord(ligne);
        final int nombreEspacesParMot = checkPre(nombreChars, nombreMots, l);
        if(nombreEspacesParMot == -1) {
            return null;
        }
        int moreEspace = (l-nombreChars)%(nombreMots-1);
        System.out.println("("+l+"-"+nombreChars+")/("+nombreMots+"-1)="+nombreEspacesParMot);
        char[] newTab = new char[l];
        int j = 0;
        boolean insertSpace=false;
        int i = 0;
        while(i < ligne.length) {
            if(ligne[i] != ' ') {
                newTab[j] = ligne[i];
                insertSpace = false;
                j++;
            }
            else if(insertSpace!=true) {
                j = funInsertSpace(newTab, nombreEspacesParMot, j, moreEspace);
                moreEspace--;
                insertSpace = true;
            }
            i++;
        }
        return newTab;
    }
    
     public static int numChar(char[] ligne) {
        int numChar = 0;
        int i = 0;
        while (i < ligne.length) {
            if(ligne[i] != ' ') {
                numChar++;
            }
            i++;
        }
        return numChar;
    }
    
    public static int numWord(char[] ligne) {
        int numWord = 0;
        int i = 0;
        if(ligne[0] != ' ') {
            numWord++;
        }
        while( i < ligne.length-1) {
            if(ligne[i] == ' ' && ligne[i+1] != ' ') {
                numWord++;
            }
            i++;
        }   
        return numWord;
    }
    
    public static int checkPre(int nombreChars, int nombreMots, int l) {
        if(nombreChars > l) {
            System.out.println("More char than the length of the new word.");
            return -1;
        }   
        if(nombreMots == 1) {
            if(nombreChars != l) {
                System.out.println("Impossible, because we have to insert space at the end of the line");
                return -1;
            }
            else {
                return 0;
            }
        }
        else
        {
             return (l-nombreChars)/(nombreMots-1);
        }
    }
    
    public static int funInsertSpace(char[] newTab, int nombreEspaceParMot, int j, int moreEspace) {
        int jFinal=j+nombreEspaceParMot;
        while(j < jFinal) {
            newTab[j] = ' ';
            j++;
        }
        if(moreEspace > 0) {
            newTab[j] = ' ';
            moreEspace--;
            j++;
        }
        return j;
    }
    
    public static void display(char[] ligne) {
        int i = 0;
        while(i < ligne.length) {
            System.out.print(ligne[i]);   
            i++;
        }
        System.out.println();
    }
}
