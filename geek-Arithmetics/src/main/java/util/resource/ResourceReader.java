package util.resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import analyze.also.exp.NullPathException;

public class ResourceReader {
	private String _filePath;
	private String _charSet;
	private InputStream _inputStream = null;
	private InputStreamReader _inputStreamReader = null;
	private BufferedReader _bufferedReader = null;
	private java.io.File _f;

	public ResourceReader(String file) {
		_filePath = file;
		_charSet = CharSet.UTF8;
		_f = null;
	}
	public ResourceReader(File file) {
		_f = file;
		_charSet = CharSet.UTF8;
		_filePath = null;
	}
	
	public ResourceReader(String file, String cs) {
		_filePath = file;
		_charSet = cs;
		_f = null;
	}
	public void setCharSet(String cs) {
		_charSet = cs;
	}
	public void load() throws NullPathException, IOException {
		close();
		if(_f == null) {
			_inputStream = ResourceReader.class.getResourceAsStream(_filePath);
		} else {
			_inputStream = new FileInputStream(_f);
		}
		_inputStreamReader = new InputStreamReader(_inputStream, _charSet);
		_bufferedReader = new BufferedReader(_inputStreamReader, 512);
	}
	
	public void reset() throws NullPathException, IOException {
		load();
	}
	
	public String readLine() throws IOException {
		return _bufferedReader.readLine();
	}
	
	public List<String> readLines() throws IOException {
		String[] vals = readAsArray();
		if(vals == null) {
			return null;
		}
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < vals.length; i++) {
			result.add(vals[i].trim());
		}
		return result;
	}
	
	public String[] readAsArray() throws IOException {
		String line = _bufferedReader.readLine();
		if(line == null) {
			return null;
		}
		String[] rs = line.split(",");
		for(int i = 0; i < rs.length; i ++) {
			rs[i] = rs[i].trim();
		}
		return rs;
	}
	
	public void close() throws IOException {
		if(_inputStream != null) {
			_inputStream.close();
		}
		if(_inputStreamReader != null) {
			_inputStreamReader.close();
		}
		if(_bufferedReader != null) {
			_bufferedReader.close();
		}
	}

}
