#include <stdio.h>
#include <stdlib.h>

char * ConcatenaStringhe(char [], char []);

int main(int argc, char *argv[])
{
    char *cmd;
    char *nSample;

    //printf("%s\n",*argv);
    if (argc==1)
    {
       printf("ERRORE");
    }
    else 
    {
       *argv++;   
       cmd = ConcatenaStringhe("%SYNAPSE_HOME%\\bin\\synapse.bat -sample ",*argv);
       system(cmd);
    }
    
    printf("\n\n");
    system("Pause");
}


char * ConcatenaStringhe(char str1[], char str2[])
{
     char *strConcatPTR;
     int i,j;
         
     if ( strConcatPTR = malloc ( ( strlen(str1)+ strlen(str2) + 1 ) * sizeof(char) ) )
     {
          for (i=0; str1[i]!='\0'; i++) *(strConcatPTR + i) = str1[i];
          for (j=0; str2[j]!='\0'; i++, j++) *(strConcatPTR + i) = str2[j];
     
          *(strConcatPTR + i) = '\0';
     }
     else printf("\n\nMemoria esaurita!"); 
     
     return strConcatPTR;
}
