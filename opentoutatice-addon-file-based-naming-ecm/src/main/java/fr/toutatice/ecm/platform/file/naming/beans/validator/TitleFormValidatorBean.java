/**
 * 
 */
package fr.toutatice.ecm.platform.file.naming.beans.validator;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.apache.commons.lang.StringUtils;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Install;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.nuxeo.ecm.core.api.Blob;
import org.nuxeo.ecm.core.api.DocumentModel;

import fr.toutatice.ecm.platform.core.constants.ExtendedSeamPrecedence;
import fr.toutatice.ecm.platform.file.naming.constants.FileNamingConstants;
import fr.toutatice.ecm.platform.web.collaborative.space.CollaborativeSpaceFormValidatorBean;


/**
 * @author david
 *
 */
@Name("csFormValidator")
@Scope(ScopeType.SESSION)
@Install(precedence = ExtendedSeamPrecedence.INHERIT_TOUTATICE)
public class TitleFormValidatorBean extends CollaborativeSpaceFormValidatorBean {

    private static final long serialVersionUID = 4538354597657310474L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void validateTitle(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(StringUtils.isBlank((String) value)){
            DocumentModel changeableDocument = super.navigationContext.getChangeableDocument();
            if(changeableDocument != null){
                if(FileNamingConstants.SUPPORTED_DOC_TYPES.contains(changeableDocument.getType())){
                    UIInput inputFile = (UIInput) context.getViewRoot().findComponent("document_create:nxl_file:nxw_file:nxw_file_file:upload");
                    
                    if(inputFile != null){
                        Blob submittedValue = (Blob) inputFile.getSubmittedValue();
                        value = submittedValue.getFilename();
                    }
                }
            }
        }
        
       super.validateTitle(context, component, value);
        
    }
    
}
