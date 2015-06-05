/*
 * (C) Copyright 2014 Académie de Rennes (http://www.ac-rennes.fr/), OSIVIA (http://www.osivia.com) and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 *
 * Contributors:
 *   mberhaut1
 *    
 */
package fr.toutatice.ecm.platform.file.naming.beans;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Install;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.nuxeo.ecm.core.api.DocumentModel;

import fr.toutatice.ecm.platform.file.naming.constants.ExtendedSeamPrecedence;
import fr.toutatice.ecm.platform.file.naming.constants.FileNamingConstants;
import fr.toutatice.ecm.platform.web.document.ToutaticeWebActionsBean;

@Name("webActions")
@Scope(ScopeType.CONVERSATION)
@Install(precedence = ExtendedSeamPrecedence.ADD_ON)
public class ToutaticeNamingWebActionsBean extends ToutaticeWebActionsBean {

	private static final long serialVersionUID = 1L;
    
    /**
     * 
     * @return true if title widget is required.
     */
    public boolean isTitleRequired(){
        DocumentModel document = this.navigationContext.getChangeableDocument();
        if(document == null){
            document = this.navigationContext.getCurrentDocument();
        }
        
        return !FileNamingConstants.supportedDocumentTypes.contains(document.getType());
    }
    
}
