import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        // val_ext보다 작은 값만 집어 넣음
        int extIndex = 0;
        if(ext.equals("code")) {
            extIndex = 0;
        }
        if(ext.equals("date")) {
            extIndex = 1;
        }
        if(ext.equals("maximum")) {
            extIndex = 2;
        }
        if(ext.equals("remain")) {
            extIndex = 3;
        }
        for(int i = 0; i < data.length; i++) {
            if(data[i][extIndex] < val_ext) {
                list.add(data[i]);
            }
        }
        
        int sortByIndex = 0;
        if(sort_by.equals("code")) {
            sortByIndex = 0;
        }
        if(sort_by.equals("date")) {
            sortByIndex = 1;
        }
        if(sort_by.equals("maximum")) {
            sortByIndex = 2;
        }
        if(sort_by.equals("remain")) {
            sortByIndex = 3;
        }
        final int sortIndex = sortByIndex;
        Collections.sort(list, (a, b) -> Integer.compare(a[sortIndex], b[sortIndex]));
        
        // list를 2차원 배열로 변환하여 반환
        int[][] answer = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}