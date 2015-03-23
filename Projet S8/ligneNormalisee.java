
/**
 * Write a description of class ligneNormalisee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ligneNormalisee
{
    public static void main(String[] args)
    {
        String test1 = "papa a vu le fifi de lolo .";
        char[]test=new char[test1.length()];
        for(int i = 0; i < test1.length();i++){
            test[i]=test1.charAt(i);
        }
        display(test);
        char[] result = ligneNormalisee(test,28);
        if(result != null)
        {
            display(result);
        }
    }

    public static char[] ligneNormalisee(char[] ligne, int l)
    {
        int nombreChar = numChar(ligne);
        if(nombreChar>l)
        {
            System.out.println("More char than space.");
            return null;
        }
        int nombreMot = numWord(ligne);
        int nombreEspaceParMot = (l-nombreChar)/(nombreMot-1);
        int moreEspace = l-nombreChar-nombreEspaceParMot*(nombreMot-1);
        char[] newTab = new char[l];
        int j = 0;
        boolean insertSpace=false;
        for(int i = 0; i < ligne.length;i++) {
            if(ligne[i] != ' ') {
                newTab[j] = ligne[i];
                insertSpace = false;
                j++;
            }
            else if(insertSpace!=true) {
                for(int p = 0;p < nombreEspaceParMot;p++) {
                    newTab[j] = ' ';
                    j++;
                }
                if(moreEspace > 0) {
                    newTab[j] = ' ';
                    moreEspace--;
                    j++;
                }
                j--;
                insertSpace = true;
                j++;
            }
        }
        return newTab;
    }
    
    public static int numChar(char[] ligne)
    {
        int numChar = 0;
        for(int i = 0; i < ligne.length;i++)
        {
            if(ligne[i] != ' ')
            {
                numChar++;
            }
        }
        return numChar;
    }
    
    public static int numWord(char[] ligne)
    {
        int numWord = 0;
        if(ligne[0] != ' ')
        {
            numWord++;
        }
        for(int i = 0; i < ligne.length-1;i++)
        {
            if(ligne[i] == ' ' && ligne[i+1] != ' ')
            {
                numWord++;
            }
        }
        
        return numWord;
    }
    
    public static void display(char[] ligne)
    {
        for(int i = 0; i < ligne.length;i++)
        {
            System.out.print(ligne[i]);         
        }
        System.out.println();
    }
}
