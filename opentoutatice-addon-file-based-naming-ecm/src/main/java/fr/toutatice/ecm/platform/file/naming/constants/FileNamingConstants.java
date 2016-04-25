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
 *   dchevrier
 *    
 */
package fr.toutatice.ecm.platform.file.naming.constants;

import java.util.ArrayList;
import java.util.List;


/**
 * @author David Chevrier.
 *
 */
public interface FileNamingConstants {
    
    /**
     * Supported document types for file based naming.
     */
    List<String> SUPPORTED_DOC_TYPES = new ArrayList<String>(4){
        
        private static final long serialVersionUID = 3020126738932884167L;

        {
            add("File");
            add("Audio");
            add("Video");
            add("Picture");
        }
    };

}
