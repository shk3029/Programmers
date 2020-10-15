package com.company.hackerrank;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Sherlock {

    public static void main(String[] args) throws IOException {
        String s = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
        System.out.println(isValid(s));
    }

    static String isValid(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.computeIfPresent(c, (k,v) -> v+1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : map.values()) list.add(i);

        Map<Integer, Integer> map2 = new HashMap<>();

        for (int c : list) {
            map2.putIfAbsent(c, 0);
            map2.computeIfPresent(c, (k,v) -> v+1);
        }

        List<Integer> keys = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        for (int i : map2.keySet()) keys.add(i);
        for (int i : map2.values()) values.add(i);

        if (values.size() == 1) return "YES";
        if (values.size() == 2) {
            int one_value_key = 0;
            for (int i=0; i< values.size(); i++) if (values.get(i) == 1)  one_value_key = keys.get(i);
            if (values.contains(1) && Math.abs(keys.get(0) - keys.get(1)) == 1) return "YES";
            if (values.contains(1) && one_value_key == 1) return "YES";

        }
        return "NO";
    }


}


