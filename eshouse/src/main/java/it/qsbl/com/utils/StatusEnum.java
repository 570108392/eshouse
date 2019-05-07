package it.qsbl.com.utils;

import com.sun.org.apache.regexp.internal.RESyntaxException;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import it.qsbl.com.EshouseApplication;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import sun.font.TrueTypeFont;

import javax.lang.model.type.ArrayType;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum  StatusEnum {
    SUCCESS(200,"操作成功",true),
    NOT_PAGE(404,"找不到页面",false),
    PARAMS_NOT_NULL(101,"参数不能为空",false),
    NOT_ENTITY(101,"查无数据",false),
    PERMISSION_DENIED(403,"没有权限",false),
    ERROR(500,"系统异常",false),
    UNKNOWN(10000,"未知状态码",false);

    private Integer status;
    private String message;
    private boolean success;

    private static final Map<Integer, StatusEnum> MAP = new HashMap<>();

    static {
        for (StatusEnum statusEnum : StatusEnum.values()) {
            MAP.put(statusEnum.status, statusEnum);
        }
    }


    StatusEnum(Integer status, String message,boolean success) {
        this.status = status;
        this.message = message;
        this.success = success;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "StatusEnum{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", success=" + success +
                '}';
    }

    public static StatusEnum getStatusEnumByStatus(Integer status) {
        return MAP.get(status) == null ? MAP.get(10000) : MAP.get(status);
    }
    public static void main(String[] args) throws Exception {

        String str = "afejhife";

        int aa[] ={12,12,4,5,6};

        System.out.println(reverse2(str));

        byte i = Byte.MAX_VALUE;
        byte j = ++i;
        System.out.println(j);

        String strr ="12ABC456ABCde";

        int abc = strr.indexOf("ABC");
        String substring = strr.substring(abc);
        int abc2 = strr.indexOf("ABC", abc + 3);
        int abc1 = substring.indexOf("ABC");

        String[] abcs = strr.split("ABC");
        System.out.println(abcs.toString());
        List list = suoyin(strr,"ABC",0,new ArrayList<>());
             int i1 = strr.indexOf(abcs[1]);
        System.out.println(i1);
        secondMax();
        test(101,-3);
    }


    public static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    public static String reverse5(String s) {
        return new StringBuffer(s).reverse().toString();
    }

    public static  String reverse2(String str){
        if(str.length() <= 1)
            return str;

        String left = str.substring(0,str.length()/2);

        String right = str.substring(str.length()/2);

        return reverse2(right)+reverse2(left);

    }
    public static  String reverse3(String str){
        if(str.length() <= 1)
            return str;

        String left = str.substring(0,str.length()/2);

        String right = str.substring(str.length()/2);

        return reverse2(right)+reverse2(left);

    }



    public static  void ss(int[] aa){
        /*Set<int[]> collect = Stream.of(aa).collect(Collectors.toSet());
        System.out.println(collect.toArray());*/

//        List<Integer> aaa = Arrays.asList(12,12,3,85,8);
//        List<int[]> distinct = Arrays.asList(aa).stream().distinct().collect(Collectors.toList());
////        List<Integer> distinct = aaa.stream().distinct().collect(Collectors.toList());
//        Object[] objects = distinct.toArray();
//        System.out.println(objects);

        Set<int[]> set = new TreeSet<>();
        boolean bhh = set.addAll(Arrays.asList(aa));
        System.out.println(set);
    }

    public static  void sssss(){

        int aa[] ={12,45,6,8,33};


    }

    @Test
    public static  List  suoyin(String str ,String strr,int i,List<Integer> list){
        int i1 = str.indexOf(strr,i);
        if(i1 == -1) {
            return list;
        }
        System.out.println("索引出现位置"+i1);
        list.add(i1);
        return suoyin(str,strr,i1+strr.length(),list);

    }


    @Test
    public static int secondMax(){

        int[] a = {12,454,4,8,2,6,4564};
        int max = 0;
        int min = 0;

        if(a[0] > a[1]){
            max = a[0];
            min = a[1];
        }else{
            max = a[1];
            min = a[0];
        }

        for(int i = 2;i <a.length;i++){
            if(a[i] > max){
                min = max;
                max = a[i];
            }else if (a[i] > min){
                min = a[i];
            }
        }
        return min;



    }

    public static void test(int aa ,int bb) throws Exception {
        if(bb == 0)
            throw new Exception("hfeif");

         int a = Math.abs(aa);
         int b = Math.abs(bb);

         int result = 0;

         while(a >= b){
             int count = 0;
             while (a >= (b << count)){
                 count++;
             }

             result += 1 << (count-1);

             a -= b << (count-1);
         }

         if((aa > 0 && bb > 0 ) || (bb <0  && aa <0))
             System.out.println(result);
         else
             System.out.println(-result);
    }






}
