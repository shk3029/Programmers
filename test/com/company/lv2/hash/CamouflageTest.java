package com.company.lv2.hash;

import com.company.common.TestDescription;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;

// 프로그래머스 해시 - 위장(Level2)
    /*
        경우의수 : a,b,c 모두 (1, 2, 3) (4, 2, 3)
               : a,b (1,2), (4,2)
               : a,c (1,3), (4,3)
               : b,c (2,3)
               : a (1), (4)
               : b (2)
               : c (3)
               총 12개
               -> 각각 안입는 경우의 수 1을 더하고 a(3) x b(2) x c(2) = 12개 - 1(모두 안입는 경우)
     */
public class CamouflageTest {
    // param
    String[][] clothes = null;

    @Before
    public void setUp() {
        clothes = new String[][]{{"1", "a"}, {"2", "b"}, {"3", "c"}, {"4", "a"}};
    }

    @Test
    @TestDescription("통합 테스트 : (a, 1), (b,1) 이렇게 value의 수만큼 생성된 맵에서 경우의 수를 더함")
    public void all_Test() {
        System.out.println(">>>> Hash -위장 테스트 추가 ");
        int sum = 1;
        // var result = getCountSameValue(); // 내가 처음짠 코드
        var result = refactoringMap(); // 리팩토링 코드
        for(String key : result.keySet()) {
            sum *= (result.get(key)+1);
        }
        System.out.println(sum);
        // 모두 안입는 경우 제외
        Assert.assertEquals((long)11, sum -= 1);
    }

    @Test
    @TestDescription("리팩토링 : String[][]를 바로 HashMap<String, Integer>로 전환")
    public void refactoring() {
        var map = refactoringMap();
        Assert.assertEquals((long)2, (long)map.get("a"));
    }

    @Test
    @TestDescription("기능 테스트 1 : String[][] -> map으로 전환")
    public void functional_Test_1() {
        var map = fromStringToMap();
        System.out.println(">>> map : " + map);
        Assert.assertEquals("a", map.get("1"));
    }

    @Test
    @TestDescription("기능 테스트 2 : paramMap의 value를 키값으로 생성, value는 paramMap의 같은 value")
    public void functional_Test_2() {
        var result = getCountSameValue();
        System.out.println(">>>> result" + result);
        Assert.assertEquals((long)2, (long)result.get("a"));
        Assert.assertEquals((long)1, (long)result.get("b"));
    }

    private HashMap<String, Integer> getCountSameValue() {
        var paramMap = fromStringToMap();
        var result = new HashMap<String, Integer>();

        for(String key : paramMap.keySet()) {
            String value = paramMap.get(key);
            if(result.get(value) != null) {
                result.put(value, result.get(value)+1);
            } else {
                result.put(value, 1);
            }
        }
        return result;
    }

    private HashMap<String, String> fromStringToMap() {
        var map = new HashMap<String, String>();
        for(int i=0; i<clothes.length; i++) {
            String key = "";
            String value = "";
            for(int j=0; j<clothes[i].length; j++) {
                if(j==0) {
                    key = clothes[i][j];
                } else {
                    value = clothes[i][j];
                }
            }
            map.put(key, value);
        }
        return map;
    }

    private HashMap<String, Integer> refactoringMap() {
        var map = new HashMap<String, Integer>();
        for(String[] strs : clothes) {
            int count = 0;
            String key = strs[1]; // 각 배열의 두번째 원소를 키 값으로 저장
            if(map.containsKey(key)) {
                count = map.get(key);
            }
            map.put(key, count+1);
        }
        return map;
    }
}