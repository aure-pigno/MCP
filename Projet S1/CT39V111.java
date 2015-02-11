//Ce fichier est encodé en UTF8.

//Lambot Sue
//de Saint-Hubert Olivier
//Maas Dylan
//Pignolet Aurélien
public class CT39V111 {
  // Le paramètre t n'est pas null. 
  // De plus, il représente un vecteur non vide de n entiers relatifs.
  
  // Cette méthode ne modifie pas les éléments du tableau t.
  // Elle renvoie la somme de la sous-sequence non vide maximum de t.
  public static long maxSum(int[] t) {
      boolean previousIsPositif = true; //Nombre precedent est positif
      boolean beenPositif = false; //Boolean disant si un nombre positif a deja ete vu
      int first_positif = 0; //Premiere faction positive
      int negatif = 0; //Premiere faction negative
      int second_positif = 0; //Seconde faction positive
      //Notre programme est sensible aux changements de signes. 
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
  // Un programme correct est un programme qui donne une solution attendue pour chaque entree.
  //***********************************************************************************
  //Expliquez comment vous avez développé ce programme
  // Premiere etape: Raisonner sur papier avec  beaucoup de cas possible et de reflechir a un algorithme en pseudo-code/oralement pour les resoudre.
  // Deuxieme etape: Transcrire en java.
  //***********************************************************************************
  //Expliquez pourquoi vous pensez que votre méthode est correcte
  // Car on a pas fonctionner par essai erreur, et que ca a fonctionne directement pour tous les cas tester.
}
