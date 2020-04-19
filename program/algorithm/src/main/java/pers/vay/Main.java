package pers.vay;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

public class Main {

//    public static void main(String[] args) {
//        pers.vay.Main main = new pers.vay.Main();
////        System.out.println(main.method(4));
////        main.rotateString("abcdefg".toCharArray(), 3);
////        System.out.println(main.strStr("", ""));
////        System.out.println(main.firstUniqChar("zsoumdtkhbnbkvfvgbrfktpwwkvqflwfbrojayjvauyeudqdmirkjleatyjegvroswhhlakvmibsyivhonlmuicibrlixxcbxlxgrjnulhsnolwicneyartgaokksjwpdfdotsearcotmyqbudpswikxnujgbnrpxhnskugmfurkfwvtvobunbqxukouvfiglucxjkrukbrwkeqtxyqkkjlaasehjsmviodvwdpymqryifnqogyojiwigpsurbsgjgnclvobbexnjmbcotnvteoysvvyvasfvfcvgyghecojbusnmdbqnctvstyiulqfrvnmxftwljhqubjbfuobuxlvhecieueqyjjjlxxxtwglqpuyqrpthepraqhsvjcteqwinextvhxohharfixrtdopqlrjikkmlvrjvguwestsoiwfvyplypmssmxrkywvngwqnuwdswnwqirurdeihvwjwfinnktacajvrpgamqaonjnqpttrgvqftnpgwbgqdthofqvkqktcxnrvcurrlnuhmtypdktdrhcofdmddjxtjrhojijkcghytyeqhfhighmyidmgbfnijludryjaxgbnssamphgueoahpqfdvysyqfqhbfhwnwqjkdopshjkfwlpcughsbfgywiaxvukxgfgtenmxtljisvpljswuexryltpgqlixsnkwtiapuovcmttsahbwudaagwjoejurykqgwarilnckwomcfrhywmrfyrdfxjvvgjhfrmxnadaatubobxtqgdwoekmskateidgndgsbgmqagymfethmjvwlfkdgcqgsodfmljsqoicfagdflvamntxedqlrxhtbnkprwkavvtinkbjikxipcwbikxhaoudkdhrxlahsndqmfpcrxyushyfhrhkggiopvoaqgnwffpqwujjkhytsucslrvaqsqsrpvtguxfqrjqkrlgddkxxbcoauamhryrvoroqwwcnwyxwwkwrafdupwkgamdfotytclgyhsxfsut"));
////        System.out.println(main.isUnique(""));
////        System.out.println(main.count("hahaah. hahaHa. hahaha."));
////        System.out.println(main.isLegalIdentifier("123_abc"));
////        int[] a = new int[4];
////        a[0] = 1;
////        a[1] = 3;
////        a[2] = 5;
////        a[3] = 7;
//////        System.out.println(main.searchInsert(a,5));
////        System.out.println(main.binarySearch(a, 6));
//        int[] t = new int[]{4,1,8,2,6};
//        main.sxx(5,3,t);
//    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        int[] res = new int[2];
        Arrays.sort(temp);
        for(int i = 0, j = temp.length - 1; i < j;) {
            if(temp[i] + temp[j] == target) {
                res[0] = temp[i];
                res[1] = temp[j];
                break;
            }else if(temp[i] + temp[j] > target) {
                j--;
            }else{
                i++;
            }
        }
        int t = 0;
        for(int i = 0; i < nums.length; i++) {
            if(res[0] == nums[i]){
                res[0] = i;
                t++;
                continue;
            }
            if(res[1] == nums[i]){
                res[1] = i;
                t++;
            }
            if(t == 2){
                break;
            }
        }
        return res;
    }

    /**
     * 两数之和
     *
     * @param nums   给定数组
     * @param target 目标值
     * @return 给定数组的下标
     */
    public List<List<Integer>> twoSumWithHash(int[] nums, int target, int index) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = index; i < nums.length; i++) {
            map.put(nums[i], nums[i]);
        }
        for (int i = index; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[i]);
                temp.add(target - nums[i]);
                res.add(temp);
                map.remove(nums[i]);
                map.remove(target - nums[i]);
            }
        }
        return res;
    }

    /**
     * n个数的和
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> nSum(int[] nums, int target, int n) {
        List<List<Integer>> res = getRes(nums, target, 0, n);
        return res;
    }

    private List<List<Integer>> getRes(int[] nums, int target, int index, int length) {
        if (index >= nums.length) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (length == 2) {
            res.addAll(twoSumWithHash(nums, target, index));
        } else {
            for (int i = index; i < nums.length; i++) {
                List<List<Integer>> temp = getRes(nums, target - nums[i], i + 1, length - 1);
                if (temp != null && temp.size() > 0) {
                    for (List<Integer> p : temp) {
                        p.add(nums[i]);
                    }
                    res.addAll(temp);
                }
            }
        }
        return res;
    }

    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int target = 0 - nums[i];
            for(int p = i + 1, q = nums.length - 1; p < q;) {
                if(nums[p] + nums[q] == target) {
                    List<Integer> ress = new ArrayList<Integer>();
                    ress.add(nums[i]);
                    ress.add(nums[p]);
                    ress.add(nums[q]);
                    res.add(ress);
                    do{
                        p++;
                    }while(p > i + 1 && p < q && nums[p] == nums[p - 1]);
                    do{
                        q--;
                    }while(q < nums.length - 1 && p < q && nums[q] == nums[q + 1]);
                    continue;
                }else if(nums[p] + nums[q] > target) {
                    q--;
                }else{
                    p++;
                }
            }
        }
        return res;
    }

    public void sxx(int m, int n , int a[]){
        int jj;
        for(int ii = m-1;ii>0;ii--)
        {
            for(jj=0;jj<ii;jj++)
            {
                if(a[jj]>a[jj+1])
                {
                    int te = a[jj];
                    a[jj]= a[jj+1];
                    a[jj+1]=te;
                }
            }
        }

        int count = n-m/2+m%2;

        int max=0;
        for(int k=0;k<m-count;k++)
        {
            if (a[k]+a[m-count-1-k]>max) {
                max = a[k]+a[m-count-k];
            }
        }
        System.out.println(max);
    }

    /**
     * 整数排序
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {

    }

    /**
     * 二分搜索
     * @param nums 顺序数组
     * @param target 目标
     * @return 目标所在位置或应该插入位置
     */
    public int binarySearch(int[] nums, int target){
        int head = 0, tail = nums.length - 1;
        while(head <= tail){
            int mindle = (head + tail)/2;
            if(nums[mindle] == target){
                return mindle;
            }else if(nums[mindle] < target){
                head = mindle + 1;
            }else{
                tail = mindle - 1;
            }
        }
        return head;
    }

    /** 是否可以准时参加所以会议
     * @param intervals 会议时间
     * @return 是否可以
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() < 2){
            return true;
        }
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for(int i = 0, j = 1; j < intervals.size(); j++){
            if(intervals.get(i).end < intervals.get(j).start){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    /**
     * 会议时间
     */
    public class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
 }

    /**
     * 最多出现字母
     * @param str 字符串
     * @return 最多出现字母的次数
     */
    public int mostFrequentlyAppearingLetters(String str) {
        if(str.isEmpty()){
            return 0;
        }
        Map<Character, Integer> ss = new HashMap<>();
        char[] s = str.toCharArray();
        for(int i = 0; i < s.length; i++){
            if(ss.get(s[i]) == null){
                ss.put(s[i], 1);
            }else{
                ss.put(s[i], ss.get(s[i]) + 1);
            }
        }
        int max = -1;
        for(Map.Entry<Character, Integer> entry : ss.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
            }
        }
        return max;
    }

    /**
     * 是否符合规则
     * @param str: The identifier need to be judged.
     * @return: Return if str is a legal identifier.
     */
    public boolean isLegalIdentifier(String str) {
        if(str.isEmpty()){
            return false;
        }
        char[] s = str.toCharArray();
        int i = 0;
        if((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= 'A' && s[i] <= 'Z') || s[i] == '_'){

        }else{
            return false;
        }
        for(; i < s.length; i++){
            if((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= 'A' && s[i] <= 'Z') || s[i] == '_' || (s[i] >= '0' && s[i] <= '9')){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    /**
     * 不符合规则的次数
     * @param s: the article
     * @return: the number of letters that are illegal
     */
    public int count(String s) {
        int sum = 0;
        String[] jz = StringUtils.split(s, ".");
        for(String j : jz){
            sum += pdjz(j);
        }

        return sum;
    }

    /**
     * 判断句子
     * @param j
     * @return 句子中不符合规则的次数
     */
    private int pdjz(String j) {
        int sum = 0;
        if(j.isEmpty()){
            return 0;
        }
        char[] jj = j.toCharArray();
        int i = 0;
        while(i < jj.length){
            if(jj[i++] == ' '){
                continue;
            }
            if(jj[i] >= 'a' && jj[i] <= 'z'){
                sum++;
                i++;
                break;
            }
        }
        String[] dcs = StringUtils.split(j, " ");
        for(String dc : dcs){
            sum += pddc(dc);
        }

        return sum;
    }

    /**
     * 判断单词
     * @param dc 单词
     * @return 单词中不符合规则的次数
     */
    private int pddc(String dc) {
        int sum = 0;
        if(dc.length() == 1){
            return 0;
        }
        char[] dcc = dc.toCharArray();
        for(int i = 1; i < dcc.length; i++){
            if(dcc[i] >= 'A' && dcc[i] < 'Z'){
                sum++;
                continue;
            }else if(dcc[i] == ','){
                sum++;
                continue;
            }
        }
        return sum;
    }

    /**
     * 目标串是否是原串的子串
     * @param source: 原串
     * @param target: 目标串
     * @return: return the index
     */
    public int strStr(String source, String target) {
        if(target.isEmpty()){
            return 0;
        }
        if(source.isEmpty()){
            return -1;
        }
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        int[] next = getNext(target);
        int i = 0,j = 0;
        while(i < s.length && j < t.length){
            if(j == -1 || s[i] == t[j]){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if(j == t.length){
            return i - j;
        }
        return -1;
    }

    /**
     * 得到next数组
     * @param target 目标串
     * @return next数组
     */
    private int[] getNext(String target){
        char[] t = target.toCharArray();
        int[] next = new int[t.length];
        next[0] = -1;
        int i = 0;
        int k = 0;
        while(i < t.length - 1){
            if(i == -1||t[i] == t[k]){
                ++i;
                ++k;
                if(t[i]==t[k]){
                    next[i] = next[k];
                }else{
                    next[i] = k;
                }
            }else{
                k = next[k];
            }
        }
        return next;
    }

    /**
     * 第一个唯一的字母
     * @param str
     * @return
     */
    public char firstUniqChar(String str) {
        Map<Character, Integer> a = new HashMap();
        Map<Character, Integer> time = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            if(a.get(str.charAt(i)) == null){
                a.put(str.charAt(i), i);
                time.put(str.charAt(i), 1);
            }else{
                time.put(str.charAt(i), time.get(str.charAt(i)) + 1);
            }
        }
        List<Character> res = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : time.entrySet()){
            if(entry.getValue().equals(1)){
                res.add(entry.getKey());
            }
        }
        Character ress = null;
        int min = 1024 * 1024;
        for(Character e : res){
            if(a.get(e) < min){
                min = a.get(e);
                ress = e;
            }
        }
        return ress.charValue();
    }


    /**
     * 唯一的数字
     * @param A
     * @return
     */
    public int singleNumber(int[] A) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            if(set.add(A[i])){
                sum += A[i];
            }else{
                sum -= A[i];
            }
        }
        return sum;
    }

    /**
     * 数组中是否有两个数等于目标
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i + 1; j < numbers.length; j++){
                if(numbers[i] + numbers[j] == target){
                    res[0] = i;
                    res[1] = j;
                }
            }
        }

        return res;
    }

    /**
     * 旋转字符串
     * @param str 字符串
     * @param offset 偏移量
     */
    public void rotateString(char[] str, int offset) {
        if(str.length == 0 || offset % str.length == 0){
            return;
        }
        if(offset > str.length){
            offset %= str.length;
        }
        char[] head = new char[offset];
        char[] tail = new char[str.length - offset];
        for(int i = 0; i < offset; i++){
            head[i] = str[i + str.length - offset];
        }
        for(int i = 0; i < str.length - offset; i++){
            tail[i] = str[i];
        }
        for(int i = 0; i < head.length; i++){
            str[i] = head[i];
        }
        for(int i = 0; i < tail.length; i++){
            str[i + offset] = tail[i];
        }
        System.out.println(str);
    }

    /**
     * 水仙花数
     * @param n
     * @return
     */
    public List<Integer> method(int n){
        List<Integer> res = new ArrayList<>();

        int head = getHead(n);
        int tail = getTail(n);
        for(int i = head; i < tail; i++){
            if(isSXH(i)){
                res.add(i);
            }
        }
        return res;
    }

    /**
     * 最长不重复子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int subLength = 1, maxLength = 0;
        int head = 0, to = 1;
        String res = null;
        for (int i = 0; i < s.length(); i++) {
            int site = s.substring(head, to).indexOf(s.charAt(i));
            if (site != -1) {
                subLength = to - head;
                if (subLength > maxLength) {
                    res = s.substring(head, to);
                    maxLength = subLength;
                }
                head = to;
            }
            to++;
        }
        if (to - head > maxLength) {
            maxLength = to - head;
        }
        System.out.println(res);
        return maxLength;
    }

    private boolean isSXH(int t) {
        List<Integer> ss = new ArrayList<>();
        int p = t;
        while(p > 0){
            ss.add( t % 10);
            p /= 10;
        }
        int sum = 0;
        for(Integer k : ss){
            sum += mc(k, ss.size());
        }
        if(sum == t){
            return true;
        }else{
            return false;
        }
    }

    private int mc(Integer k, int size) {
        for(int i = 0; i < size - 1; i++){
            k *= k;
        }
        return k;
    }

    private int getTail(int n) {
        int begin = 1;
        for(int i = 0; i < n; i++){
            begin *= 10;
        }
        return begin;
    }

    private int getHead(int n) {
        if(n == 1){
            return 0;
        }
        int begin = 1;
        for(int i = 0; i < n - 1; i++){
            begin *= 10;
        }
        return begin;
    }

    private static Thread a1 = null;
    private static Thread a2 = null;
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.lengthOfLongestSubstring("abcabcbb"));
    }

}
