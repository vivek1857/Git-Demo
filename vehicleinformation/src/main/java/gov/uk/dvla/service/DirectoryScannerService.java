/**
 * 
 */
package gov.uk.dvla.service;

import java.io.IOException;
import java.util.List;

import gov.uk.dvla.dto.FileAttributes;

/**
 * @author Vivek.Khandagale
 * This interface scans the directory and retrieve the file information as FileAttributes. 
 */
public interface DirectoryScannerService {
	public List<FileAttributes> findFileInfo() throws IOException;
}
