package util.resource;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ResourceWriter {
	private String _filePath;
	private FileOutputStream _fileOutputStream = null;
	private OutputStreamWriter _outputStreamWriter = null;
	private BufferedWriter _bufferedWriter = null;

	public ResourceWriter(String dis, String cs) {
		_filePath = dis;
		init(cs);
	}
	public ResourceWriter(String dis) {
		_filePath = dis;
		init(CharSet.UTF8);
	}

	public ResourceWriter(File f) {
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		init(f);
	}
	public void init(String cs) {
		try {
			_fileOutputStream = new FileOutputStream(new File(_filePath));
			_outputStreamWriter = new OutputStreamWriter(_fileOutputStream, cs);
			_bufferedWriter = new BufferedWriter(_outputStreamWriter, 512);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void init(File f) {
		try {
			_fileOutputStream = new FileOutputStream(f);
			_outputStreamWriter = new OutputStreamWriter(_fileOutputStream, CharSet.UTF8);
			_bufferedWriter = new BufferedWriter(_outputStreamWriter, 512);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void write(String line) {
		try {
			_bufferedWriter.write(line + "\n");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void write(long line) {
		try {
			_bufferedWriter.write(line + "\n");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void close() {
		try {
			_bufferedWriter.close();
			_outputStreamWriter.close();
			_fileOutputStream.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
