package com.tikvah.hdfs;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.net.URI;

public class SampleReader {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();

        String uri = "hdfs://localhost/tikvah/README.txt";

        FileSystem fs = FileSystem.get(URI.create(uri), conf);

        FSDataInputStream in = fs.open(new Path(uri));
        IOUtils.copyBytes(in, System.out, 4096, false);

        IOUtils.closeStream(in);

    }
}
