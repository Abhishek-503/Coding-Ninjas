package com.ninja.practice;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;


class UniqueWordsSol {

    /*
     * Complete the 'deviceNamesSystem' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY devicenames as parameter.
     */

    public static List<String> deviceNamesSystem(List<String> devicenames) {
    // Write your code here
        List<String> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(String s:devicenames) {
            String r = s;
            if(!res.contains(s)) {
                res.add(r);
                map.put(r, 0);
                continue;
            }
            else{
                map.put(r,map.get(r)+1);
                r = r.concat(String.valueOf(map.get(r)));
                res.add(r);
            }
        }
        return res;
    }

}
public class UniqueWords {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int devicenamesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> devicenames = IntStream.range(0, devicenamesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = UniqueWordsSol.deviceNamesSystem(devicenames);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
