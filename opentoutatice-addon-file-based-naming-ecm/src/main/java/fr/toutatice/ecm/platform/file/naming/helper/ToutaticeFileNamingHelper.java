/**
 * 
 */
package fr.toutatice.ecm.platform.file.naming.helper;

import org.apache.commons.lang.StringUtils;
import org.nuxeo.ecm.core.api.Blob;
import org.nuxeo.ecm.core.api.DocumentModel;

import fr.toutatice.ecm.platform.core.constants.ToutaticeNuxeoStudioConst;


/**
 * @author david
 *
 */
public class ToutaticeFileNamingHelper {
    
    /**
     * Utility class.
     */
    private ToutaticeFileNamingHelper(){};
    
    /**
     * 
     * @param document
     * @return attached file name of document 
     *         (principal file in file schema).
     */
    public static String getDocFileName(DocumentModel document){
        Blob blob = (Blob) document.getPropertyValue(ToutaticeNuxeoStudioConst.CST_DOC_XPATH_NUXEO_FILE_CONTENT);
        if(blob != null) {
            return blob.getFilename();
        }
        return StringUtils.EMPTY;
    }

}
