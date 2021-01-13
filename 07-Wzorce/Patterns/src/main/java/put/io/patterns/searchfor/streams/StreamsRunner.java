package put.io.patterns.searchfor.streams;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;

import put.io.patterns.searchfor.CustomRunner;

/**
 * Runner for streams reading and checksumming.
 * 
 * Required command line parameters: the name of file to be read
 */
public class StreamsRunner extends CustomRunner {
	public static void main(String[] args) {
		checkAndRun(args, 1, "fileName", new StreamsRunner());
	}

	@Override
	public void run(String[] params) throws IOException {
		System.out.println("Current directory: " + System.getProperty("user.dir"));

		String fname = params[0];
		InputStream fis = new FileInputStream(fname);
		
		Checksum chksum = new CRC32();
		CheckedInputStream chkIs = new CheckedInputStream(fis, chksum);
		
		long bytesCount = readWholeStream(chkIs);
		
		System.out.println("Statistics for file " + fname);
		System.out.println("Read " + bytesCount + " bytes.");
		System.out.println("CRC32 of the content: " + Long.toHexString(chksum.getValue()));
	}

	private long readWholeStream(InputStream is) throws IOException {
		long cnt = 0;
		while (is.read() != -1) {
			++cnt;
		}
		return cnt;
	}
}
