package com.cloudera.flume.source;

import org.apache.flume.sink.hbase.*;

public class SplittingSerializer implements HbaseEventSerializer {
    private byte[] table;
    private byte[] colFam;
    private Event currentEvent;
    private byte[][] columnNames;
    private final List<PutRequest> puts = new ArrayList<PutRequest>();
    private byte[] currentRowKey;
    
    @Override
    public void initialize(Event event, byte[] cf) {
	this.currentEvent = event;
	this.colFam = cf;
    }

    @Override
    public void configure(ComponentConfiguration conf) {
    }

    @Override
    public void configure(Context context) {
	String table_string = new String(context.getString("table"));
	table = table_string.getBytes(); 
	String cols = new String(context.getString("columns"));
	String[] names = cols.split(",");
	columnNames = new byte[names.length][];
	int i = 0;
	for(String name:names) {
	    columnNames[i++] = name.getBytes();
	}
    }
      
    @Override
    public List<PutRequest> getActions() {
	String eventString = new String(currentEvent.getBody());
	String[] cols = eventStr.split("\t");
	String rowKey = cols[0];
	puts.clear();
	for (int i=1; i<cols.length; i++) {
	    PutRequest req = new PutRequest(table,rowKey,colFam,columnNames[i],cols[i].getBytes());
	    puts.add(req);
	}
	return puts;
    }
}
