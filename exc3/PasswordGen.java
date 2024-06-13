package io.github.ndimovt.exc3;

import java.util.Scanner;

public class PasswordGen {
    private static final Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = inn.nextInt();
        int i = inn.nextInt();
        String pass = null;
        for (int j = 1; j <= n ; j++) {
            for (int k = 1; k <= n ; k++) {
                for (char l = 'a'; l < 'a'+i ; l++) {
                    for (char m = 'a'; m < 'a' + i; m++) {
                        if(j > k){
                            for (int o = j+1; o <= n ; o++) {
                                pass = ""+j+k+l+m+o;
                                System.out.println(pass);
                            }
                        }else{
                            for (int o = k+1; o <= n ; o++) {
                                pass = ""+j+k+l+m+o;
                                System.out.println(pass);
                            }
                        }
                    }
                }
            }
        }
    }
}
