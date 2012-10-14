package com.tikvah.repository;


import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;

import org.apache.avro.io.*;

import org.apache.avro.util.Utf8;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FactTester {

    public static void main(String[] args) throws IOException {
        new FactTester().runTest();


    }

    private void runTest() throws IOException {
        Schema schema = Schema.parse(getClass().getResourceAsStream("/ProductFact.avsc"));

        GenericRecord datum = new GenericData.Record(schema);
        datum.put("productid", new Utf8("123"));
        datum.put("facttype", new Utf8("new_product"));
        datum.put("value", new Utf8("samsung galaxy note"));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DatumWriter<GenericRecord> writer = new GenericDatumWriter<GenericRecord>(schema);

        DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(writer);
        dataFileWriter.create(schema, new File("productfacts.avro"));
        dataFileWriter.append(datum);
        dataFileWriter.flush();

        /*Encoder encoder = EncoderFactory.get().binaryEncoder(out, null);
        writer.write(datum, encoder);
        encoder.flush();
        out.close();


        DatumReader<GenericRecord> reader = new GenericDatumReader<GenericRecord>(schema);
        Decoder decoder = DecoderFactory.get().binaryDecoder(out.toByteArray(), null);
        GenericRecord result = reader.read(null, decoder);

        assertThat(result.get("productid").toString(), is("123"));*/
    }
}
