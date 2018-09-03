


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;
import java.io.IOException;


public class TaxValidator {

	
	private static final String TAXID_REGEX_NEW = "^[A-Z&amp;N]{3,4}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]$";
	private static final String TAXID_REGEX_OLD = "^[A-Z,\\u00D1,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9][A-Z,0-9][0-9,A-Z]$";
	//Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String FILE_HEADER = "TAX_ID,old_pattern_result,new_pattern_result";

	

	public static void main(String[] args) {
		// static Pattern object, since pattern is fixed
	  Pattern pattern_new;
	  Pattern pattern_old;
	// non-static Matcher object because it's created from the input String
	 Matcher matcher_new;
	 Matcher matcher_old;
		pattern_new = Pattern.compile(TAXID_REGEX_NEW, Pattern.CASE_INSENSITIVE);
		pattern_old = Pattern.compile(TAXID_REGEX_OLD, Pattern.CASE_INSENSITIVE);
		FileWriter fileWriter = null;

	try {
		fileWriter = new FileWriter("/Users/i340887/Downloads/result.csv");
		//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());
			
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);

		
			Scanner scanner = new Scanner(new File("/Users/i340887/Downloads/MxTaxID4k.csv"));
			String taxid = "";
			while (scanner.hasNextLine()) {
				taxid = scanner.nextLine();
				System.out.println(taxid);
				matcher_new = pattern_new.matcher(taxid);
				matcher_old = pattern_old.matcher(taxid);

				matcher_new.matches();
				matcher_old.matches();	
				fileWriter.append(taxid);
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(matcher_old.matches()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(matcher_new.matches()));
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}
			
		}
	}

}
