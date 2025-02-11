/**
 * Copyright French Prime minister Office/DINSIC/Vitam Program (2015-2019)
 * <p>
 * contact.vitam@programmevitam.fr
 * <p>
 * This software is developed as a validation helper tool, for constructing Submission Information Packages (archives
 * sets) in the Vitam program whose purpose is to implement a digital archiving back-office system managing high
 * volumetry securely and efficiently.
 * <p>
 * This software is governed by the CeCILL 2.1 license under French law and abiding by the rules of distribution of free
 * software. You can use, modify and/ or redistribute the software under the terms of the CeCILL 2.1 license as
 * circulated by CEA, CNRS and INRIA archiveTransfer the following URL "http://www.cecill.info".
 * <p>
 * As a counterpart to the access to the source code and rights to copy, modify and redistribute granted by the license,
 * users are provided only with a limited warranty and the software's author, the holder of the economic rights, and the
 * successive licensors have only limited liability.
 * <p>
 * In this respect, the user's attention is drawn to the risks associated with loading, using, modifying and/or
 * developing or reproducing the software by the user in light of its specific status of free software, that may mean
 * that it is complicated to manipulate, and that also therefore means that it is reserved for developers and
 * experienced professionals having in-depth computer knowledge. Users are therefore encouraged to load and test the
 * software's suitability as regards their requirements in conditions enabling the security of their systems and/or data
 * to be ensured and, more generally, to use and operate it in the same conditions as regards security.
 * <p>
 * The fact that you are presently reading this means that you have had knowledge of the CeCILL 2.1 license and that you
 * accept its terms.
 */
package fr.gouv.vitam.tools.sedalib.metadata.management;

import fr.gouv.vitam.tools.sedalib.metadata.namedtype.ComplexListMetadataKind;
import fr.gouv.vitam.tools.sedalib.metadata.namedtype.ComplexListMetadataMap;
import fr.gouv.vitam.tools.sedalib.metadata.namedtype.ComplexListType;
import fr.gouv.vitam.tools.sedalib.metadata.namedtype.StringType;
import fr.gouv.vitam.tools.sedalib.utils.SEDALibException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The Class UpdateOperation.
 * <p>
 * Class for SEDA element UpdateOperation.
 * <p>
 * A Management metadata.
 * <p>
 * Vitam quote: "Pointeur vers un ArchiveUnit existant dans le système."
 */
public class UpdateOperation extends ComplexListType {

    static final String SYSTEMID_TAG="SystemId";
    static final String ARCHIVEUNITIDENTIFIERKEY_TAG="ArchiveUnitIdentifierKey";

    /**
     * Init metadata map.
     */
    @ComplexListMetadataMap
    public static final Map<String, ComplexListMetadataKind> metadataMap;
    static {
        metadataMap = new LinkedHashMap<>();
        metadataMap.put(SYSTEMID_TAG, new ComplexListMetadataKind(StringType.class, false));
        metadataMap.put(ARCHIVEUNITIDENTIFIERKEY_TAG, new ComplexListMetadataKind(ArchiveUnitIdentifierKey.class, false));
    }

    /**
     * Instantiates a new validator type.
     */
    public UpdateOperation() {
        super("UpdateOperation");
    }

    /**
     * Instantiates a new update operation with a systemId link.
     *
     * @param systemId the system id
     * @throws SEDALibException if sub elements construction is not possible (not supposed to occur)
     */
    public UpdateOperation(String systemId) throws SEDALibException {
        this();
            addNewMetadata(SYSTEMID_TAG, systemId);
     }

    /**
     * Instantiates a new update operation with a metadata name and value link.
     *
     * @param metadataName  the metadata name
     * @param metadataValue the metadata value
     * @throws SEDALibException if sub elements construction is not possible (not supposed to occur)
     */
    public UpdateOperation(String metadataName, String metadataValue) throws SEDALibException {
        this();
            addNewMetadata(ARCHIVEUNITIDENTIFIERKEY_TAG, metadataName, metadataValue);
    }
}
