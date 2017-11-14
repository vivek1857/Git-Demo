package gov.uk.dvla.util;

import static org.junit.Assert.fail;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
public class CsvVehicheDataReaderTest {

	CsvVehicheDataReader csvVehicheDataReader = null;
	@Before
	public void init() {
		csvVehicheDataReader = new CsvVehicheDataReader();
	}
	
	@Test
	public final void testGetVehicleData()  {
		String[][] vehicleData;
	try {
		vehicleData = csvVehicheDataReader.getVehicleData("vehicle-data.csv");
		
		List<String> vehicleDeails = new ArrayList<String>();
		vehicleDeails.add("X666 EON");
		vehicleDeails.add("BLACK");
		vehicleDeails.add("Ford");
		vehicleDeails.add("YR12UMB");
        vehicleDeails.add("RED");
		vehicleDeails.add("PEUGEOT");
		vehicleDeails.add("KS08OSD");
		vehicleDeails.add("SILVER");
        vehicleDeails.add("KIA");
		vehicleDeails.add("LN51RTU");
		vehicleDeails.add("BLACK");
		vehicleDeails.add("VOLKSWAGEN");
		
		List<String> csvData = new ArrayList<String>();
		int length = vehicleData.length;
		
		for(int i = 0; i< length;i++) {
			int j = vehicleData[i].length;
			for(j = 0;j<vehicleData[i].length;j++)
				csvData.add(vehicleData[i][j]);
		}
		assertTrue(csvData.containsAll(vehicleDeails));
		
		} catch (IOException e) {
			fail("Failed to get vehicle-data.xlsx :Exception message: "+e.getMessage());
		}
	}

}
