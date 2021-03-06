/**
 * Copyright (c) 2012, 2014 Fraunhofer Institute FOKUS
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

/**
 * 
 */
package de.fhg.fokus.odp.registry.ckan.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import de.fhg.fokus.odp.registry.model.Coordinate;
import de.fhg.fokus.odp.registry.model.SpatialEnumType;

/**
 * @author msg
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class SpatialDataBean implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = -4626804296948451352L;

	// private static final Logger log =
	// LoggerFactory.getLogger(SpatialDataBean.class);

	@JsonProperty
	private SpatialEnumType type;

	@JsonProperty
	private List<PolygonBean> coordinates;

	/**
	 * @return the type
	 */
	public SpatialEnumType getType() {
		return type;
	}

	/**
	 * @param fromField
	 *            the type to set
	 */
	public void setType(SpatialEnumType fromField) {
		this.type = fromField;
	}

	/**
	 * @return the coordinates
	 */
	public List<PolygonBean> getCoordinates() {
		if (coordinates == null) {
			coordinates = new ArrayList<PolygonBean>();
		}
		return coordinates;
	}

	/**
	 * @param coordinates
	 *            the coordinates to set
	 */
	public void setCoordinates(List<PolygonBean> coordinates) {
		this.coordinates = coordinates;
	}

	public int addPolygon(PolygonBean polygon) {
		if (coordinates == null) {
			coordinates = new ArrayList<PolygonBean>();
		}

		this.coordinates.add(polygon);
		return this.coordinates.size() - 1;

	}

	public void addCoordinate(int polygonIndex, Coordinate coordinate) {
		if (coordinates == null) {
			coordinates = new ArrayList<PolygonBean>();
		}
		try {
			coordinates.get(polygonIndex);
		} catch (IndexOutOfBoundsException e) {
			PolygonBean polygon = new PolygonBean();
			this.coordinates.add(polygonIndex, polygon);
		} finally {
			PolygonBean polygon = coordinates.get(polygonIndex);
			polygon.addCoordinate(coordinate);
			this.coordinates.set(polygonIndex, polygon);
		}

	}

}
