package gov.uk.dvla.util;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.CSVReader;

/**
 * The Class CsvVehicheDataReader.
 */
public class CsvVehicheDataReader implements VehicleDataReader {
	
	private static final int NUMBER_OF_COLUMNS = 3;
	private static final Logger log = LoggerFactory.getLogger(CsvVehicheDataReader.class);

	/* (non-Javadoc)
	 * @see gov.uk.dvla.util.VehicleDataReader#getVehicleData(java.lang.String)
	 */
	@Override
	public String[][] getVehicleData(String filePath) throws IOException{

		String[][] vehicleData = null;
		log.info("CsvVehicheDataReader:getVehicleData");
		
		try(CSVReader csvReader = new CSVReader(new FileReader(filePath), ',')) {
			List<String[]> records = csvReader.readAll();
			vehicleData = new String [records.size()][NUMBER_OF_COLUMNS];
			Iterator<String[]> iterator = records.iterator();
			
			int i = 0;
			while (iterator.hasNext()) {
				
				String[] record = iterator.next();
				vehicleData[i][0] = record[0];
				vehicleData[i][1] = record[1];
				vehicleData[i][2] = record[2];
				
				i++;
			}
		}
		return vehicleData;
	}

}
