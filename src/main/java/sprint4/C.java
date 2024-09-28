package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

    public static void main(String args[]) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String subSeqString = reader.readLine();
            String mainString = reader.readLine();
            System.out.println(checkIfIsSubSequence(subSeqString, mainString));
        }
    }

    private static String checkIfIsSubSequence(String subSeqString, String mainString) {
        int subSeqSymbolNum = 0;
        for (int i = 0; i < mainString.length(); i++) {
            if (subSeqSymbolNum < subSeqString.length()) {
                char subSeqSymbolToSearch = subSeqString.charAt(subSeqSymbolNum);
                char mainSeqSymbol = mainString.charAt(i);
                if (mainSeqSymbol == subSeqSymbolToSearch) {
                    subSeqSymbolNum++;
                }
            } else {
                break;
            }
        }
        if (subSeqSymbolNum  == subSeqString.length()) {
            return "True";
        } else {
            return "False";
        }
    }
}