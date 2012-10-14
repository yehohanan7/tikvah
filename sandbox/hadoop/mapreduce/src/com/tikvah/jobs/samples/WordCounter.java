package com.tikvah.jobs.samples;


import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;

import java.io.IOException;


public class WordCounter {

    private static String inputFile = "/Users/yehohanan7/dev/tikvah/sandbox/hadoop/mapreduce/sampleinput.txt";
    private static String outputFile = "/Users/yehohanan7/dev/tikvah/sandbox/hadoop/mapreduce/wordcounts";

    public static void main(String[] args) throws IOException {

        JobConf conf = new JobConf(WordCounter.class);
        conf.setJobName("word conter");

        FileInputFormat.addInputPath(conf, new Path(inputFile));
        FileOutputFormat.setOutputPath(conf, new Path(outputFile));

        conf.setMapperClass(WordsMapper.class);
        conf.setReducerClass(WordCountReducer.class);

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);

        JobClient.runJob(conf);
    }
}
