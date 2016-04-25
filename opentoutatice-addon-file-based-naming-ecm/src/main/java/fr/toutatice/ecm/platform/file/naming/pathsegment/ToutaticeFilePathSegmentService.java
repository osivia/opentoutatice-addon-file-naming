/**
 * 
 */
package fr.toutatice.ecm.platform.file.naming.pathsegment;

import org.apache.commons.lang.StringUtils;
import org.nuxeo.common.utils.IdUtils;
import org.nuxeo.ecm.core.api.ClientException;
import org.nuxeo.ecm.core.api.DocumentModel;

import fr.toutatice.ecm.platform.core.pathsegment.ToutaticePathSegmentService;
import fr.toutatice.ecm.platform.file.naming.constants.FileNamingConstants;
import fr.toutatice.ecm.platform.file.naming.helper.ToutaticeFileNamingHelper;


/**
 * @author david
 *
 */
public class ToutaticeFilePathSegmentService extends ToutaticePathSegmentService {
    
    /**
     * Generate name of document based on its
     * principal attached blob.
     */
    @Override
    public String generatePathSegment(DocumentModel doc) throws ClientException {
        
        if(FileNamingConstants.SUPPORTED_DOC_TYPES.contains(doc.getType())
                && StringUtils.isBlank(doc.getTitle())){
            return IdUtils.generateId(ToutaticeFileNamingHelper.getDocFileName(doc), "-", true, 24);
        } else {
            return super.generatePathSegment(doc);
        }
    }
    
}
