package gov.uk.dvla.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * The Class XlsVehicleDataReader.
 */
public class XlsVehicleDataReader implements VehicleDataReader {

	private static final int NUMBER_OF_COLUMNS = 2;

	/* (non-Javadoc)
	 * @see gov.uk.dvla.util.VehicleDataReader#getVehicleData(java.lang.String)
	 */
	@Override
	public String[][] getVehicleData(String filePath) throws IOException {
		String[][] vehicleData = null;
			File file = new File(filePath);

			FileInputStream fileInputStream = new FileInputStream(file);
			try (XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream)) {
				XSSFSheet sheet1 = workBook.getSheetAt(0);

				int numberOfRows = sheet1.getPhysicalNumberOfRows();
				int numberOfColumns = NUMBER_OF_COLUMNS;
				vehicleData = new String[numberOfRows + 1][numberOfColumns + 1];
				for (int i = 0; i < numberOfRows; i++) {
					XSSFRow row = sheet1.getRow(i);
					for (int j = 0; j <= numberOfColumns; j++) {
						vehicleData[i][j] = row.getCell(j).getStringCellValue();
					}
				}

			}

		return vehicleData;
	}

}
