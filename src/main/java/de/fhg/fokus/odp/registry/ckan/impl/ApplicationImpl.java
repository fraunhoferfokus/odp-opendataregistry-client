/**
 * Copyright (c) 2012, 2013 Fraunhofer Institute FOKUS
 *
 * This file is part of Open Data Platform.
 *
 * Open Data Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * Open Data Plaform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.

 * You should have received a copy of the GNU Affero General Public License
 * along with Open Data Platform.  If not, see <http://www.gnu.org/licenses/agpl-3.0>.
 */

package de.fhg.fokus.odp.registry.ckan.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.fhg.fokus.odp.registry.ODRClient;
import de.fhg.fokus.odp.registry.ckan.ODRClientImpl;
import de.fhg.fokus.odp.registry.ckan.json.MetadataBean;
import de.fhg.fokus.odp.registry.ckan.json.RelationshipBean;
import de.fhg.fokus.odp.registry.model.Application;
import de.fhg.fokus.odp.registry.model.Dataset;
import de.fhg.fokus.odp.registry.model.Metadata;
import de.fhg.fokus.odp.registry.model.MetadataEnumType;
import de.fhg.fokus.odp.registry.model.exception.OpenDataRegistryException;

public class ApplicationImpl extends MetadataImpl implements Application, Serializable {

    private static final Logger log = LoggerFactory.getLogger(ApplicationImpl.class);

    private List<Dataset> datasets;

    /**
     * 
     */
    private static final long serialVersionUID = -6044179402191051252L;

    public ApplicationImpl(MetadataBean metadata, ODRClient odr) {
        super(metadata, odr);
        metadata.setType(MetadataEnumType.APPLICATION.toField());
    }

    @Override
    public List<String> getUsedDatasets() {
        return super.getUsedDatasets();
    }

    @Override
    public List<Dataset> getRelatedDatasets() {
        if (datasets == null) {
            datasets = new ArrayList<Dataset>();
            List<RelationshipBean> relationships = ((ODRClientImpl) odr).listRelationships(metadata.getName(), "links_to");
            for (RelationshipBean bean : relationships) {
                try {
                    Metadata metadata = odr.getMetadata(null, bean.getObject());
                    if (metadata.getType() == MetadataEnumType.DATASET) {
                        datasets.add((Dataset) metadata);
                    }
                } catch (OpenDataRegistryException e) {
                    log.error("fetching relationship object", e.getMessage());
                }
            }
        }
        return datasets;
    }

}
