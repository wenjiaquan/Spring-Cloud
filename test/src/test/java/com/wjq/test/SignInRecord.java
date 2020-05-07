package com.wjq.test;

import java.io.*;
import java.util.*;

/**
 * 签到统计
 */
public class SignInRecord {

    /** 签到文件保存目录 **/
    private static String fileDir = "D:\\内网通文件\\点名表";
    /** 学生名单 **/
    private static String[] names = {"单贝贝","lipeng","刚鑫","胡清杰","高淙博","韩铂","李斌","李建","李建朋","胡兴达","冀佳鑫","李奇瑞","李雪成","李志超","姜家奇","李昂","林同凯","鲁腾龙","曲修佟","李戈","李嘉楠","刘浩","柴怡宁","芦于博","李鹏","刘安玉","温甲泉","李振芳","李涛","刘富宇","马靖基","王鑫龙","曲海铭","谢宏远","孟超","任科","王梦博","张磊","史智超","荣毅宣","申金帅","张恒伟","罗建武","裴树涓","刘重阳","宋雨兵","孙孟杰","万一兵","王浩","王加鑫","王锐","王子平","杨今敬","王珂","王伟","于浩","袁保旺","原翔","王亚涛","王永辉","张建元","张妍妍","张耀鑫","卫泽良","肖创","张宇浩","张泽宇","祝友鹏","尹士杰","郑奥斌"};
    /** 未签到次数 **/
    private static Map<String,Integer> noSignIn = new HashMap<>();
    /** 未签到明细 **/
    private static Map<String,Map<String,Integer>> noSignInDetail = new HashMap<>();

    public static void main(String[] args) throws IOException {
        /** 文件目录 **/
        File dir = new File(fileDir);
        File[] files = dir.listFiles();
        //循环读取签到文件
        for (File file : files){
            //签到日期
            String theDate = file.getName().substring(4,12);
//            System.out.println(file.getName());
//            System.out.println(theDate);
            //获取签到信息
            List<String[]> signInInfo = readCsvData(file.getAbsolutePath());
            //按姓名检查是否签到
            for (String name : names){
                //是否签到
                boolean signIn = isSignIn(name, signInInfo);
                //未签到，记录总次数和明细
                if(!signIn){
                    if(noSignIn.containsKey(name)){
                        noSignIn.put(name,noSignIn.get(name)+1);
                    }else {
                        noSignIn.put(name,1);
                    }
                    recordDetail(name,theDate);
                }
            }
        }
        //按未签到次数，对noSignIn排序
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(noSignIn.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        //打印未签到信息
        System.out.println("未签到明细：");
        Set<String> names = noSignIn.keySet();
        for (Map.Entry<String,Integer> namecount : list){
            //打印汇总
            System.out.println(namecount.getKey()+":"+namecount.getValue()+"次，未签到明细：");
            //打印明细
            Map<String, Integer> detail = noSignInDetail.get(namecount.getKey());
            Set<String> theDateSet = detail.keySet();
            StringBuffer detailBuffer = new StringBuffer();
            for (String thedate : theDateSet){
                detailBuffer.append(thedate+":"+detail.get(thedate)+"|");
            }
            System.out.println(detailBuffer.toString());
        }
    }

    public static void recordDetail(String name,String theDate){
        Map<String,Integer> detail = noSignInDetail.get(name);
        //初始化签到详情
        if(detail==null){
            detail  = new HashMap<>();
            detail.put(theDate,1);
            //保存明细
            noSignInDetail.put(name,detail);
            return;
        }
        //初始化日期
        if(detail.get(theDate)==null){
            detail.put(theDate,1);
            noSignInDetail.put(name,detail);
            return;
        }
        //日期，未签到次数+1
        detail.put(theDate,detail.get(theDate)+1);
        noSignInDetail.put(name,detail);

    }

    /**
     * 是否签到
     * @param name 学生姓名
     * @param signInInfo 签到信息
     * @return
     */
    public static boolean isSignIn(String name,List<String[]> signInInfo){
        for (String[] signIn:signInInfo){
            String signName = signIn[0];
            //名字包含问题，未处理
            if(signName.contains(name)){
                String isSign = signIn[1];
                if("已签到".equals(isSign)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 读取CSV文件的静态方法
     * @param fileName
     * @return
     * @throws IOException
     */
    public static List<String[]> readCsvData(String fileName) throws IOException {
        List<String[]> records = new ArrayList<String[]>();
        String record;
        // 设定UTF-8字符集，使用带缓冲区的字符输入流BufferedReader读取文件内容
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "GB2312"));
        // file.readLine(); //跳过表头所在的行

        // 遍历数据行并存储在名为records的ArrayList中，每一行records中存储的对象为一个String数组
        while ((record = file.readLine()) != null) {
//            System.out.println(record);
            String fields[] = record.split(",");
            records.add(fields);
        }
        // 关闭文件
        file.close();
        return records;
    }
}
