package com.wjq.test;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 作业检查
 */
public class CheckHomeWork {
    /** 作业下载目录 **/
    private static String homeworkDir = "E:\\0504\\";
    /** 学生名单 **/
    private static String[] names = {"单贝贝","lipeng","刚鑫","胡清杰","高淙博","韩铂","李斌","李建","李建朋","胡兴达","冀佳鑫","李奇瑞","李雪成","李志超","姜家奇","李昂","林同凯","鲁腾龙","曲修佟","李戈","李嘉楠","刘浩","柴怡宁","芦于博","李鹏","刘安玉","温甲泉","李振芳","李涛","刘富宇","马靖基","王鑫龙","曲海铭","谢宏远","孟超","任科","王梦博","张磊","史智超","荣毅宣","申金帅","张恒伟","罗建武","裴树涓","刘重阳","宋雨兵","孙孟杰","万一兵","王浩","王加鑫","王锐","王子平","杨今敬","王珂","王伟","于浩","袁保旺","原翔","王亚涛","王永辉","张建元","张妍妍","张耀鑫","卫泽良","肖创","张宇浩","张泽宇","祝友鹏","尹士杰","郑奥斌"};
    /** 未提交名单 **/
    private static List<String> unSumbitNames = new ArrayList<>();
    /** 待检查名单信息 **/
    private static List<String> checkingNamesInfo = new ArrayList<>();
    /** mp4文件标准大小,8M **/
    private static long Mb = 1024*1024;
    private static long mp4FileSize = Mb*100000;
    /** 文件修改时间 **/
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMdd HH:mm");
    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        /** 作业目录 **/
        File dir = new File(homeworkDir);
        File[] files = dir.listFiles();
        /** 按名称检查作业 **/
        for(String name:names){
            boolean isSubmit = false;
            /** 检查是否提交了作业 **/
            for(File file:files){
                /** 找到作业提交的目录 **/
                if(file.getName().contains(name)){
                    /** 检查作业是否合格 **/
                    if(checkHomeWork(name,file)){
                        isSubmit = true;
                        break;
                    }
                }
            }
            /** 未提交作业 **/
            if(!isSubmit){
                unSumbitNames.add(name);
            }
        }
        /** 未提交作业名单 **/
        System.out.println("未提交作业名单:");
        System.out.println(unSumbitNames);
        System.out.println();

        System.out.println("待检查名单及上传Mp4文件大小："+checkingNamesInfo.size()+"人");
        Collections.sort(checkingNamesInfo);
        checkingNamesInfo.forEach(info->{
            System.out.println(info);
        });
    }

    /**
     * 检查学生的作业
     * @param name
     * @param homeWorkDir
     * @return
     */
    public static Boolean checkHomeWork(String name, File homeWorkDir){
        final File[] homeworkFiles = homeWorkDir.listFiles();
        //录屏文件大小，处理多个MP4文件
        float fileSize = 0;
        for (File homeworkFile : homeworkFiles) {
            /** 检查到MP4文件 **/
            if(homeworkFile.getName().endsWith(".mp4")){
                fileSize += (float) homeworkFile.length();
                /** 文件修改时间 **/
//                long lastModified = homeworkFile.lastModified();
//                Date lastModifiedDate = new Date(lastModified);
//                String isSummitTime = simpleDateFormat.format(lastModifiedDate);
//                System.out.println(isSummitTime);
//                return true;
            }
        }
        /** 如果文件小于8M，则打印信息，重点检查 **/
        if(fileSize<mp4FileSize){
            String fileSizeMb = String.format("%.1f MB", fileSize/Mb);
//                    System.out.println(name+":Mp4FileSize:"+fileSizeMb);
            checkingNamesInfo.add(fileSizeMb+":"+name);
        }
        if(fileSize>0){
            return true;
        }
        return false;
    }
}
