//Ce fichier est encodé en UTF8.

//Lambot Sue
//de Saint-Hubert Olivier
//Maas Dylan
//Pignolet Aurélien
public class CT39V111 {
  /*
  public static void main(String[] args)
  {
      int[] i = {100, -50, -50, 70, 80, -80, -200, 50}; 
      System.out.println(maxSum(i));
  }
  */
  // Le paramètre t n'est pas null. 
  // De plus, il représente un vecteur non vide de n entiers relatifs.
  
  // Cette méthode ne modifie pas les éléments du tableau t.
  // Elle renvoie la somme de la sous-sequence non vide maximum de t.
  public static long maxSum(int[] t) {
      boolean previousIsPositif = true;
      boolean beenPositif = false;
      int first_positif = 0;
      int negatif = 0;
      int second_positif = 0;
      int max = Integer.MIN_VALUE;
      for(int i = 0; i<t.length; i++)
      {
          if(!isPositif(t[i]))
          {
              if(previousIsPositif && second_positif != 0)
              {
                  if(first_positif > -negatif)
                  {
                      first_positif = first_positif + negatif + second_positif;
                  }
                  else
                  {
                      first_positif = second_positif;
                  }
                  negatif = t[i];
                  second_positif = 0;
              }
              else
              {
                  negatif = negatif + t[i];
              }
              max = max(max,max(negatif,t[i]));
              previousIsPositif = false;
          }
          else if(negatif == 0)
          {
              beenPositif = true;
              first_positif = first_positif + t[i];
              previousIsPositif = true;
          }
          else
          {
              beenPositif = true;
              second_positif = second_positif + t[i];
              previousIsPositif = true;
          }  
          if(beenPositif)
          {
              max = max(first_positif,max(second_positif,max(max,first_positif + negatif + second_positif)));
          }
      }
      return (long) max;
  }
  
  //Retourne true si l'argument est positif, false sinon
  public static boolean isPositif(int i)
  {
      return i>=0;
  }
  
  //Retourne le maximum entre les deux elements
  public static int max(int n, int m)
  {
      if(n > m)
      {
          return n;
      }
      return m;  
  }
  //***********************************************************************************
  //Expliquez la notion de "programme correct"
  // Un programme correct est un programme qui donne une solution correcte pour chaque entree.
  //***********************************************************************************
  //Expliquez comment vous avez développé ce programme
  
  //***********************************************************************************
  //Expliquez pourquoi vous pensez que votre méthode est correcte
}
